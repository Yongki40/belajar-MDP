package com.belajar.intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Mhs extends AppCompatActivity {

    Intent intent;
    ArrayList<Mahasiswa> lMhs;
    ArrayList<String> listValue;
    ArrayList<EditText> listEd;
    Mahasiswa mhs;
    public static final int ADD_MHS = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mhs);

        lMhs = new ArrayList<>();
        listValue = new ArrayList<>();
        listEd = new ArrayList<>();
        intent = getIntent();

        lMhs = getIntent().getParcelableArrayListExtra("lMhs");

        if(getIntent().hasExtra("mhs")){
            mhs = getIntent().getParcelableExtra("mhs");

            ConstraintLayout layout = findViewById(R.id.layout1);
            for (int i = 0; i < layout.getChildCount(); i++) {
                View view = layout.getChildAt(i);
                if(view instanceof EditText){
                    EditText ed = (EditText) view;
                    listEd.add(ed);
                }
            }

            listEd.get(0).setText(mhs.getNrp());
            listEd.get(1).setText(mhs.getNama());
            listEd.get(2).setText(mhs.getAngkatan());
            listEd.get(3).setText(mhs.getEmail());
        }
    }
    String jurusan,kodeJur;
    public void addNewMhs(View v){

        String password = listValue.get(0).substring(0,2)+lMhs.size();
        Mahasiswa mhs = new Mahasiswa(
                nrp,
                listValue.get(0),
                listValue.get(1),
                listValue.get(2),
                password,jurusan
        );
        Toast.makeText(this, "password: "+mhs.getPassword(), Toast.LENGTH_SHORT).show();

        lMhs.add(mhs);
        intent.putExtra("lMhs",lMhs);
        setResult(100,intent);
        finish();
    }
    String nrp="";
    public void generateClick(View v) {
        ConstraintLayout layout = findViewById(R.id.layout1);
        listValue.clear();
        for (int i = 0; i < layout.getChildCount(); i++) {
            View view = layout.getChildAt(i);
            if(view instanceof TextView && view.getId() != R.id.edNrp){
                TextView tv = (TextView) view;
                listValue.add(tv.getText().toString());
            }
        }

        RadioButton rdInf = findViewById(R.id.rdInf);
        jurusan = rdInf.isChecked() ? "INF" : "SIB";
        kodeJur = rdInf.isChecked() ? "11" : "18";

        String nrp = listValue.get(1) + kodeJur + lMhs.size();
        EditText edNrp = findViewById(R.id.edNrp);
        edNrp.setText(nrp);
    }
}