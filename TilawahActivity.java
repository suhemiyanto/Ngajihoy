package com.example.suhemi.gurungaji;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TilawahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tilawah);

        //a
        final MediaPlayer aa = MediaPlayer.create(this, R.raw.a);
        Button a = (Button) this.findViewById(R.id.satu);
        a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                aa.start();
            }
        });

        //b
        final MediaPlayer ab = MediaPlayer.create(this, R.raw.b);
        Button b = (Button) this.findViewById(R.id.dua);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ab.start();
            }
        });

        //c
        final MediaPlayer ac = MediaPlayer.create(this, R.raw.c);
        Button c = (Button) this.findViewById(R.id.tiga);
        c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ac.start();
            }
        });

        //d
        final MediaPlayer ad = MediaPlayer.create(this, R.raw.d);
        Button d = (Button) this.findViewById(R.id.empat);
        d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ad.start();
            }
        });

        //e
        final MediaPlayer ae = MediaPlayer.create(this, R.raw.e);
        Button e = (Button) this.findViewById(R.id.lima);
        e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ae.start();
            }
        });

        //f
        final MediaPlayer af = MediaPlayer.create(this, R.raw.f);
        Button f = (Button) this.findViewById(R.id.enam);
        f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                af.start();
            }
        });

        //g
        final MediaPlayer ag = MediaPlayer.create(this, R.raw.g);
        Button g = (Button) this.findViewById(R.id.g);
        g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ag.start();
            }
        });

        //h
        final MediaPlayer ah = MediaPlayer.create(this, R.raw.huu);
        Button h = (Button) this.findViewById(R.id.h);
        h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ah.start();
            }
        });

        //i
        final MediaPlayer ai = MediaPlayer.create(this, R.raw.i);
        Button i = (Button) this.findViewById(R.id.i);
        i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ai.start();
            }
        });

        //j

        final MediaPlayer aj = MediaPlayer.create(this, R.raw.j);
        Button j = (Button) this.findViewById(R.id.j);
        j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                aj.start();
            }
        });

        //k

        final MediaPlayer ak = MediaPlayer.create(this, R.raw.k);
        Button k = (Button) this.findViewById(R.id.k);
        k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ak.start();
            }
        });

        //l
        final MediaPlayer al = MediaPlayer.create(this, R.raw.l);
        Button l = (Button) this.findViewById(R.id.l);
        l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                al.start();
            }
        });

        //M
        final MediaPlayer am = MediaPlayer.create(this, R.raw.m);
        Button m = (Button) this.findViewById(R.id.m);
        m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                am.start();
            }
        });

        //N
        final MediaPlayer an = MediaPlayer.create(this, R.raw.n);
        Button n = (Button) this.findViewById(R.id.n);
        n.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                an.start();
            }
        });
        //o
        final MediaPlayer ao = MediaPlayer.create(this, R.raw.o);
        Button o = (Button) this.findViewById(R.id.o);
        o.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ao.start();
            }
        });
        //p
        final MediaPlayer ap = MediaPlayer.create(this, R.raw.p);
        Button p = (Button) this.findViewById(R.id.p);
        p.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ap.start();
            }
        });

        //q
        final MediaPlayer aq = MediaPlayer.create(this, R.raw.qie);
        Button q = (Button) this.findViewById(R.id.q);
        q.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                aq.start();
            }
        });

        //R
        final MediaPlayer ar = MediaPlayer.create(this, R.raw.r);
        Button r = (Button) this.findViewById(R.id.r);
        r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ar.start();
            }
        });

        //S
        final MediaPlayer as = MediaPlayer.create(this, R.raw.s);
        Button s = (Button) this.findViewById(R.id.s);
        s.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                as.start();
            }
        });

        //T
        final MediaPlayer at = MediaPlayer.create(this, R.raw.t);
        Button t = (Button) this.findViewById(R.id.t);
        t.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                at.start();
            }
        });

        //U
        final MediaPlayer au = MediaPlayer.create(this, R.raw.u);
        Button u = (Button) this.findViewById(R.id.u);
        u.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                au.start();
            }
        });
        //V
        final MediaPlayer av = MediaPlayer.create(this, R.raw.v);
        Button v = (Button) this.findViewById(R.id.v);
        v.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                av.start();
            }
        });

        //W
        final MediaPlayer aw = MediaPlayer.create(this, R.raw.w);
        Button w = (Button) this.findViewById(R.id.w);
        w.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                aw.start();
            }
        });

        //X
        final MediaPlayer ax = MediaPlayer.create(this, R.raw.x);
        Button x = (Button) this.findViewById(R.id.x);
        x.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ax.start();
            }
        });
        //y
        final MediaPlayer ay = MediaPlayer.create(this, R.raw.yo);
        Button y = (Button) this.findViewById(R.id.y);
        y.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ay.start();
            }
        });
        //Z
        final MediaPlayer az = MediaPlayer.create(this, R.raw.z);
        Button z = (Button) this.findViewById(R.id.z);
        z.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                az.start();
            }
        });

        //zz
        final MediaPlayer azz = MediaPlayer.create(this, R.raw.zz);
        Button zz = (Button) this.findViewById(R.id.zz);
        zz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                azz.start();
            }
        });
        final MediaPlayer azzz = MediaPlayer.create(this, R.raw.zzz);
        Button zzz = (Button) this.findViewById(R.id.zzz);
        zzz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                azzz.start();
            }
        });
        final MediaPlayer azzzz = MediaPlayer.create(this, R.raw.zzz);
        Button zzzz = (Button) this.findViewById(R.id.zzzz);
        zzzz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                azzzz.start();
            }
        });
    }
}
