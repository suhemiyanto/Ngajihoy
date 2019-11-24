package com.example.suhemi.gurungaji;

import android.app.ProgressDialog;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormulirDaftarActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    /*private Button buttondaftar;*/
    private EditText emaildaftar;
    private EditText passworddaftar;
    private  EditText daftarnama, daftarjk, daftarhp, daftaralamat;
    String nama,jk,hp,alamat,mail,pw;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulir_daftar);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        emaildaftar = (EditText) findViewById(R.id.emaildaftar);
        passworddaftar = (EditText) findViewById(R.id.passworddaftar);
        daftarnama = (EditText) findViewById(R.id.namadaftar);
        daftarjk = (EditText) findViewById(R.id.jkdaftar);
        daftarhp = (EditText) findViewById(R.id.nohpdaftar);
        daftaralamat = (EditText) findViewById(R.id.alamatdaftar);


       /* if (firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent (getApplicationContext(),MainActivity.class));
        }*/


    }



    public void registrasi(View view) {

        mail = emaildaftar.getText().toString().trim();
        pw = passworddaftar.getText().toString().trim();
        nama = daftarnama.getText().toString().trim();
        jk = daftarjk.getText().toString().trim();
        hp = daftarhp.getText().toString().trim();
        alamat = daftaralamat.getText().toString().trim();



        if(TextUtils.isEmpty(nama)){
            Toast.makeText(this, "Silahkan Masukan Nama", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(jk)){
            Toast.makeText(this, "Silahkan Masukan Jenis Kelamin", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(hp)){
            Toast.makeText(this, "Silahkan Masukan No Hp", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(alamat)){
            Toast.makeText(this, "Silahkan Masukan Alamat", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(mail)){
            Toast.makeText(this, "Silahkan Masukan Email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(pw)){
            Toast.makeText(this, "Silahkan Masukan Password", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Mohon Menunggu");
        progressDialog.show();


        firebaseAuth.createUserWithEmailAndPassword(mail,pw)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            kirimVerifikasi();
                            kirimdata();
                            firebaseAuth.signOut();
                            Toast.makeText(FormulirDaftarActivity.this,"Berhasil Daftar dan Verifikasi Email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(FormulirDaftarActivity.this, MainActivity.class));
                        }
                        else {
                            Toast.makeText(FormulirDaftarActivity.this, "Daftar dan Verifikasi Email Tidak Berhasil, Coba Lagi...." ,Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();


                    }
                });

    }

    private void kirimVerifikasi(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                       /* kirimdata();*/
                    }
                    else {
                        Toast.makeText(FormulirDaftarActivity.this,"Verifikasi Email Tidak Berhasil", Toast.LENGTH_SHORT).show();

                    }
                }
            });
            }
    }

    public void kirimdata(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        UserProfile userProfile = new UserProfile(nama,jk,hp,alamat,mail);
        myRef.setValue(userProfile);

    }


    @Override
    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
    }
}
