package com.example.suhemi.gurungaji;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CobaActivity extends AppCompatActivity {

    private TextView profileName, profileJk, profileHp, profileAlamat, profileEmail;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba);

        profileName = findViewById(R.id.nameprofile);
        profileJk = findViewById(R.id.jkprofile);
        profileHp = findViewById(R.id.hpprofile);
        profileAlamat = findViewById(R.id.alamatprofile);
        profileEmail = findViewById(R.id.emailprofile);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

       /* databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                profileName.setText("Nama Lengkap : " + userProfile.getUserNama());
                profileJk.setText("Jenis Kelamin : " + userProfile.getUserJk());
                profileHp.setText("No Handphone : " + userProfile.getUserNohp());
                profileAlamat.setText("Alamat : " + userProfile.getUserAlamat());
                profileEmail.setText("Email: " +userProfile.getUserEmail());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CobaActivity.this,databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
