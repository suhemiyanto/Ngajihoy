package com.example.suhemi.gurungaji;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;
import java.util.TimerTask;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class TampilanAwalActivity extends AppCompatActivity{
    ViewPager viewPager;
    /*TextView text, tx, tx1, tx2;*/
     private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_awal);


        viewPager=(ViewPager)findViewById(R.id.viewPagerr);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new MytimerTask(),2000,4000);

        firebaseAuth = FirebaseAuth.getInstance();

       /* text = (TextView) findViewById(R.id.textView);
        tx = (TextView) findViewById(R.id.textView2);
        tx1 = (TextView) findViewById(R.id.textView3);
        tx2 = (TextView) findViewById(R.id.textView4);
        Typeface my=Typeface.createFromAsset(getAssets(), "fonts/NeoSans-Medium.otf");
        Typeface a=Typeface.createFromAsset(getAssets(), "fonts/NeoSansBold.otf");
        Typeface b=Typeface.createFromAsset(getAssets(), "fonts/NeoSans-Medium.otf");
        Typeface c=Typeface.createFromAsset(getAssets(), "fonts/NeoSans-Medium.otf");

        text.setTypeface(my);
        tx.setTypeface(a);
        tx1.setTypeface(b);
        tx2.setTypeface(c);*/
    }


    public void pindahatur(View view) {
        Intent intent = new Intent(TampilanAwalActivity.this, PengaturanActivity.class);
        startActivity(intent);
    }

    public void pencarian(View view) {
        Intent intent = new Intent(TampilanAwalActivity.this, PencarianActivity.class);
        startActivity(intent);
    }


    public void suara(View view) {
            Intent intent = new Intent(TampilanAwalActivity.this, TilawahActivity.class);
            startActivity(intent);


    }


    public void biodata(View view) {
        startActivity(new Intent(this, ProfileActivity.class));
    }

    public void jadwalmurid(View view) {
        startActivity(new Intent(this, TampilJAdwalActivity.class));
    }

    public class MytimerTask extends TimerTask {
        @Override
        public void run() {
            TampilanAwalActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);
                    }
                    else if (viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                    }
                    else
                    {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
