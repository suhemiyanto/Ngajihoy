package com.example.suhemi.gurungaji;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GuruActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guru);
    }

    public void carijadwal(View view) {
        Intent intent = new Intent(GuruActivity.this, JadwalActivity.class);
        startActivity(intent);
    }
}
