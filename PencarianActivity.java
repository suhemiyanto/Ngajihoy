package com.example.suhemi.gurungaji;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class PencarianActivity extends AppCompatActivity {

    TextView za;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian);
        za = (TextView) findViewById(R.id.textV);
        Typeface z = Typeface.createFromAsset(getAssets(), "fonts/NeoSans-Medium.otf");
        za.setTypeface(z);
    }

    public void cariguru(View view) {
        Intent intent = new Intent(PencarianActivity.this, GuruActivity.class);
        startActivity(intent);
    }
}
