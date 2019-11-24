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
import com.google.firebase.auth.FirebaseUser;

public class UpdatePasswordActivity extends AppCompatActivity {

    private Button update;
    private EditText newPw;
    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);

        update = findViewById(R.id.btnupdatepw);
        newPw = findViewById(R.id.newpassword);


        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

          update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userPasswordNew = newPw.getText().toString();

                firebaseUser.updatePassword(userPasswordNew).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(UpdatePasswordActivity.this, "Berhasil Mengubah Password", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(UpdatePasswordActivity.this, ProfileActivity.class));
                        }
                        else{
                            Toast.makeText(UpdatePasswordActivity.this, "Tidak Berhasil Mengubah Password", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
    }
}
