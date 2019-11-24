package com.example.suhemi.gurungaji;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class UpdateProfileActivity extends AppCompatActivity {
    private EditText newName, newJk, newNohp, newAlamat, newEmail;
    private Button save;
    private ImageButton imageButton;
    private FirebaseStorage firebaseStorage;
    private static int PICK_IMAGE = 123;
    Uri imagePath;
    private ProgressDialog progressDialog;
    private StorageReference storageReference;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data.getData() != null) {
            imagePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
                imageButton.setImageBitmap(bitmap);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        progressDialog = new ProgressDialog(this);
        newName = findViewById(R.id.gantinama);
        newJk = findViewById(R.id.gantijk);
        newNohp = findViewById(R.id.gantinohp);
        newAlamat = findViewById(R.id.gantialamat);
        newEmail = findViewById(R.id.gantiemail);
        save = findViewById(R.id.btnsave);
        imageButton = findViewById(R.id.gambar);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

        storageReference = firebaseStorage.getReference();

        final DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                newName.setText(userProfile.UserNama);
                newJk.setText(userProfile.UserJk);
                newNohp.setText(userProfile.UserNohp);
                newAlamat.setText(userProfile.UserAlamat);
                newEmail.setText(userProfile.UserEmail);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateProfileActivity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = newName.getText().toString();
                String jk = newJk.getText().toString();
                String nohp = newNohp.getText().toString();
                String alamat = newAlamat.getText().toString();
                String email = newEmail.getText().toString();

                UserProfile userProfile = new UserProfile(nama, jk, nohp, alamat, email);
                databaseReference.setValue(userProfile);
                save = findViewById(R.id.btnsave);
                kirimgambar();
                finish();
                startActivity(new Intent(UpdateProfileActivity.this, ProfileActivity.class));
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Pilih Gambar"),PICK_IMAGE );
            }
        });

    }
    private void kirimgambar(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        StorageReference imageReference = storageReference.child(firebaseAuth.getUid()).child("*Image").child("Ubah Profile");
        UploadTask uploadTask = imageReference.putFile(imagePath);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

            }
        });
    }
}
