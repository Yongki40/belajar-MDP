package com.belajar.pertemuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Activity_dashboard extends AppCompatActivity {

    Intent intent;
    List<Mahasiswa> mhss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mhss = new ArrayList<>();
        intent = getIntent();
        if(intent.getExtras()!=null){
            mhss = intent.getParcelableArrayListExtra("listMhs");
            EditText edtMaha1 = findViewById(R.id.edtMaha1);
            EditText edtMaha2 = findViewById(R.id.edtMaha2);

            if(mhss.size() == 2){
                edtMaha1.setText(mhss.get(0).toString());
                edtMaha2.setText(mhss.get(1).toString());
                edtMaha1.setVisibility(View.VISIBLE);
                edtMaha2.setVisibility(View.VISIBLE);
            }
            else if(mhss.size() == 1){
                edtMaha1.setText(mhss.get(0).toString());
                edtMaha1.setVisibility(View.VISIBLE);
            }
        }
    }

    public void btnAdd_click(View view) {
        Intent intent = new Intent(this,Activity_mhs.class);
        startActivity(intent);
    }
}