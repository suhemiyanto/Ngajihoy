package com.example.suhemi.gurungaji;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class LupaPasswordActivity extends AppCompatActivity {
    private EditText editText;
    private Button resetpw;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);

        firebaseAuth = FirebaseAuth.getInstance();
        editText = (EditText) findViewById(R.id.reset);
        resetpw = (Button) findViewById(R.id.pwreset);

        resetpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editText.getText().toString().trim();
                if (username.equals("")) {
                    Toast.makeText(LupaPasswordActivity.this, "Silahkan Masukan Email yang Terdaftar", Toast.LENGTH_SHORT).show();
                } else {
                    firebaseAuth.sendPasswordResetEmail(username).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LupaPasswordActivity.this, "Password Telah dikirim Ke Email Anda", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(LupaPasswordActivity.this, MainActivity.class));
                            } else {
                                Toast.makeText(LupaPasswordActivity.this, "Terjadi Kesalahan Saat Mengirim Ke Email Anda", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }

            }
        });
    }

    public void reset(View view) {
        Intent intent = new Intent(LupaPasswordActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
