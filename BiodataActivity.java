package com.example.suhemi.gurungaji;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BiodataActivity extends AppCompatActivity {


    private EditText editTextName,editsenin,editselasa, editrabu, editkamis;
    private FirebaseAuth firebaseAuth;
    String name,senin,selasa,rabu,kamis;
    private DatabaseReference databaseReference;
    private Button smpbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);


        firebaseAuth = FirebaseAuth.getInstance();
       /* editTextName = (EditText) findViewById(R.id.edittextname);*/
        editsenin = (EditText) findViewById(R.id.edittextsenin);
        editselasa = (EditText) findViewById(R.id.edittextselasa);
        editrabu = (EditText) findViewById(R.id.edittextrabu);
        editkamis = (EditText) findViewById(R.id.edittextkamis);
        smpbtn = (Button) findViewById(R.id.simpanbtn);

        databaseReference = FirebaseDatabase.getInstance().getReference("jadwal");

        smpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            savedata();
            Toast.makeText(BiodataActivity.this, "Jadwal Tersimpan", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(BiodataActivity.this, TampilanAwalActivity.class));
            }
        });

    }

    public void savedata(){
        senin = editsenin.getText().toString().trim();
        selasa = editselasa.getText().toString().trim();
        rabu = editrabu.getText().toString().trim();
        kamis = editkamis.getText().toString().trim();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        SimpanJadwal simpanJadwal = new SimpanJadwal(senin,selasa,rabu,kamis);
        databaseReference.child(firebaseAuth.getUid()).setValue(simpanJadwal);
       /* DatabaseReference myRef = firebaseDatabase.getReference("jadwal");
        myRef.setValue(simpanJadwal);*/
    }
}
