package com.example.suhemi.gurungaji;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    private TextView profileName, profileJk, profileHp, profileAlamat, profileEmail;
    private Button editProfill, editPw;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private ImageButton imageButton;

    private FirebaseStorage firebaseStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileName = findViewById(R.id.nameprofile);
        profileJk = findViewById(R.id.jkprofile);
        profileHp = findViewById(R.id.hpprofile);
        profileAlamat = findViewById(R.id.alamatprofile);
        profileEmail = findViewById(R.id.emailprofile);
        editProfill = findViewById(R.id.profileedit);
        editPw = findViewById(R.id.pwedit);

        imageButton = findViewById(R.id.gambardiubah);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

       DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        StorageReference storageReference = firebaseStorage.getReference();
        storageReference.child(firebaseAuth.getUid()).child("*Image/Ubah Profile").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).fit().centerCrop().into(imageButton);
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                profileName.setText("Nama Lengkap  : " + userProfile.UserNama);
                profileJk.setText("Jenis Kelamin    : " + userProfile.UserJk);
                profileHp.setText("No Handphone   : " + userProfile.UserNohp);
                profileAlamat.setText("Alamat                  : " + userProfile.UserAlamat);
                profileEmail.setText("Email                    : " +userProfile.UserEmail);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ProfileActivity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }
        });
        editProfill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(ProfileActivity.this, UpdateProfileActivity.class));
            }
        });





        editPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, UpdatePasswordActivity.class));
            }
        });
    }
}
