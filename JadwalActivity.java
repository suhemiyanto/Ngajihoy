package com.example.suhemi.gurungaji;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class JadwalActivity extends AppCompatActivity {
    ArrayList<String> selection = new ArrayList<>();
    /* ArrayList<String> selection = new ArrayList<String>();
     TextView final_text;*/
  /* Button mOrder;
   TextView mItem;
    String[] listItem;
    boolean[] checkedItem;
    ArrayList<Integer> mUserItem = new ArrayList<>();*/
    private CheckBox editsenin, editselasa, editrabu, editkamis;
    private FirebaseAuth firebaseAuth;
    String name, senin, selasa, rabu, kamis;
    private DatabaseReference databaseReference;
    private Button smpbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);


        firebaseAuth = FirebaseAuth.getInstance();
        /* editTextName = (EditText) findViewById(R.id.edittextname);*/
        editsenin = (CheckBox) findViewById(R.id.edittextsenin);
        editselasa = (CheckBox) findViewById(R.id.edittextselasa);
        editrabu = (CheckBox) findViewById(R.id.edittextrabu);
        editkamis = (CheckBox) findViewById(R.id.edittextkamis);
        smpbtn = (Button) findViewById(R.id.simpanbtn);

        databaseReference = FirebaseDatabase.getInstance().getReference("jadwal");

        smpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedata();
                Toast.makeText(JadwalActivity.this, "Jadwal Tersimpan", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(JadwalActivity.this, TampilanAwalActivity.class));
            }
        });

    }

    public void savedata() {
        senin = editsenin.getText().toString().trim();
        selasa = editselasa.getText().toString().trim();
        rabu = editrabu.getText().toString().trim();
        kamis = editkamis.getText().toString().trim();

        /*String user_id = firebaseAuth.getCurrentUser().getUid();*/
        /*DatabaseReference current_user_db = databaseReference.child(firebaseAuth.getUid());*/

        SimpanJadwal simpanJadwal = new SimpanJadwal(senin,selasa,rabu,kamis);
     /*   if (editsenin.isChecked()){
            selection.add(simpanJadwal.senin);
        }
        if(editselasa.isChecked()){
            selection.add(simpanJadwal.selasa);
        }
        if(editrabu.isChecked()){
            selection.add(simpanJadwal.rabu);
        }
        if(editkamis.isChecked()){
            selection.add(simpanJadwal.kamis);
        }*/
        databaseReference.child(firebaseAuth.getUid()).setValue(simpanJadwal);
    }

    }
/*
       */
/* final_text = (TextView)findViewById(R.id.finalhasil);
        final_text.setEnabled(false);*//*

       */
/*mOrder = (Button) findViewById(R.id.btnPilih);
       mItem = (TextView) findViewById(R.id.tvItem);

        listItem = getResources().getStringArray(R.array.ngaji_item);
        checkedItem = new boolean[listItem.length];

        mOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(JadwalActivity.this);
                mBuilder.setTitle(R.string.dialog_title);
                mBuilder.setMultiChoiceItems(listItem, checkedItem, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        if (!mUserItem.contains(position)){
                            mUserItem.add(position);
                        }
                        else if (mUserItem.contains(position)){
                            mUserItem.remove(position);
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String item = "";
                        for (int i=0; i < mUserItem.size(); i++){
                            item = item + listItem[mUserItem.get(i)];
                            if (i != mUserItem.size() -satu){
                                item = item+ "\n";
                            }
                        }
                        mItem.setText(item);
                    }
                });
                mBuilder.setNegativeButton(R.string.dismiss_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                mBuilder.setNegativeButton(R.string.clear_all_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i=0; i<checkedItem.length; i++){
                            checkedItem[i] = false;
                            mUserItem.clear();
                            mItem.setText("");
                        }

                    }
                });

                AlertDialog mdialog = mBuilder.create();
                mdialog.show();
            }
        });

    }*//*


*/
/*
    public void  selecItem(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.senin:
                if (checked){
                    selection.add("Senin Jam 16.00 WIB");
                }
                else
                {
                    selection.remove("Senin Jam 16.00 WIB");
                }
                break;

            case R.id.selasa:
                if (checked){
                    selection.add("Selasa Jam 16.00 WIB");
                }
                else
                {
                    selection.remove("Selasa Jam 16.00 WIB");
                }
                break;

            case R.id.rabu:
                if (checked){
                    selection.add("Rabu Jam 16.00 WIB");
                }
                else
                {
                    selection.remove("Rabu Jam 16.00 WIB");
                }
                break;

            case R.id.kamis:
                if (checked){
                    selection.add("Kamis Jam 16.00 WIB");
                }
                else
                {
                    selection.remove("Kamis Jam 16.00 WIB");
                }
                break;
        }

    }


    public void finalSelection(View view) {
        String final_hari = "";

        for (String Selections : selection){
            final_hari = final_hari + Selections + "\n";
        }
        final_text.setText(final_hari);
        final_text.setEnabled(true);
    }*//*

}
*/
