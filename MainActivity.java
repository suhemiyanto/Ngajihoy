package com.example.suhemi.gurungaji;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {
    private EditText emaillogin;
    private EditText passwordlogin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        emaillogin = (EditText) findViewById(R.id.emaillogin);
        passwordlogin = (EditText) findViewById(R.id.passwordlogin);

    }


    public void pindahkelupapwd(View view) {
        Intent intent = new Intent(MainActivity.this, LupaPasswordActivity.class);
        startActivity(intent);
    }


    public void cekvarifikasiemail() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        firebaseUser.isEmailVerified();
    }
    /* Boolean mailflag = */
    /*if(mailflag){
        finish();
        startActivity(new Intent(MainActivity.this, TampilanAwalActivity.class ));
    }else {
        Toast.makeText(this, "Verifikasi Email Anda", Toast.LENGTH_SHORT).show();
        firebaseAuth.signOut();
    }*/


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void pendaftaran(View view) {
        startActivity(new Intent(this, FormulirDaftarActivity.class));
    }

    public void Login(View view) {
        String maiil = emaillogin.getText().toString();
        String pww = passwordlogin.getText().toString().trim();


        if (TextUtils.isEmpty(maiil)) {
            Toast.makeText(this, "Silahkan Masukan Email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(pww)) {
            Toast.makeText(this, "Silahkan Masukan Password", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Mohon Menunggu");
        progressDialog.show();


        firebaseAuth.signInWithEmailAndPassword(maiil, pww)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            cekvarifikasiemail();
                            Toast.makeText(MainActivity.this, "Login Berhasil dan Verifikasi", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(MainActivity.this, TampilanAwalActivity.class));
                        } else {
                            Toast.makeText(MainActivity.this, "Login Tidak Berhasil, Coba Lagi....", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();

                    }
                });
    }
}