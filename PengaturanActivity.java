package com.example.suhemi.gurungaji;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class PengaturanActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);

        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void pindahutama(View view) {
        Intent intent = new Intent(PengaturanActivity.this, PengaturanActivity.class);
        startActivity(intent);
    }

    public void pindahutam(View view) {
        Intent intent = new Intent(PengaturanActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    public void pindahbranda(View view) {
        Intent intent = new Intent(PengaturanActivity.this, TampilanAwalActivity.class);
        startActivity(intent);
    }

    public void logout(View view) {
        firebaseAuth.signOut();

        finish();
        startActivity(new Intent(this, MainActivity.class));
    }
}