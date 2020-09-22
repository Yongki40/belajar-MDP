package com.belajar.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    EditText edMhs1,edMhs2;
    ArrayList<Mahasiswa> lMhs;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        lMhs = new ArrayList<>();
        edMhs1 = findViewById(R.id.edMhs1);
        edMhs2 = findViewById(R.id.edMhs2);

        intent = getIntent();

        lMhs = getIntent().getParcelableArrayListExtra("lMhs");

        edMhs1.setVisibility(View.INVISIBLE);
        edMhs2.setVisibility(View.INVISIBLE);

        Button btn1 = findViewById(R.id.btnAdd);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addClick(view);
            }
        });

        Button btn2 = findViewById(R.id.btnEdit);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editClick(view);
            }
        });

        showMhs();
    }

    private void showMhs(){
        if(lMhs.size() == 1){
            edMhs1.setVisibility(View.VISIBLE);
            edMhs1.setText(lMhs.get(0).getNrp()+"-"+lMhs.get(0).getPassword());
        }
        else if(lMhs.size() == 2){
            edMhs1.setVisibility(View.VISIBLE);
            edMhs1.setText(lMhs.get(0).getNrp()+"-"+lMhs.get(0).getPassword());
            edMhs2.setVisibility(View.VISIBLE);
            edMhs2.setText(lMhs.get(1).getNrp()+"-"+lMhs.get(1).getPassword());
        }
    }

    private void addClick(View v){
        intent = new Intent(Dashboard.this,Mhs.class);
        intent.putExtra("lMhs",lMhs);
        startActivityForResult(intent,100);

        //showMhs();
    }
    private void editClick(View v){
        intent = new Intent(Dashboard.this,Mhs.class);
        intent.putExtra("lMhs",lMhs);
        Mahasiswa mhs = lMhs.get(0);
        intent.putExtra("mhs",mhs);
        startActivityForResult(intent,100);
        //showMhs();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && requestCode == Mhs.ADD_MHS){
            lMhs = data.getParcelableArrayListExtra("lMhs");
        }
    }
}