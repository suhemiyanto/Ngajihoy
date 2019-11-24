package com.example.suhemi.gurungaji;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TampilJAdwalActivity extends AppCompatActivity {
    private TextView jadwalsenin, jadwalselasa, jadwalrabu, jadwalkamis, jadwalnama;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private SimpanJadwal simpanJadwal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_jadwal);

        jadwalsenin = findViewById(R.id.seninjadwal);
        jadwalselasa = findViewById(R.id.selasajadwal);
        jadwalrabu = findViewById(R.id.rabujadwal);
        jadwalkamis = findViewById(R.id.kamisjadwal);
        /*jadwalnama = findViewById(R.id.namajadwal);*/

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference("jadwal").child(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                SimpanJadwal simpanJadwal = dataSnapshot.getValue(SimpanJadwal.class);

                jadwalsenin.setText("Senin      : " + simpanJadwal.senin);
                jadwalselasa.setText("Selasa    : " + simpanJadwal.selasa);
                jadwalrabu.setText("Rabu        : " + simpanJadwal.rabu);
                jadwalkamis.setText("Kamis      : " + simpanJadwal.kamis);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(TampilJAdwalActivity.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
