package com.belajar.bodymassv_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity {

    ArrayList<User> lUser = new ArrayList<>();
    Intent intent;
    String nama;
    int tahun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        intent = getIntent();
        lUser = getIntent().getParcelableArrayListExtra("lUser");
        nama = getIntent().getStringExtra("nama");
        tahun = getIntent().getIntExtra("tahun",0);
    }

    public void hitungClick(View view) {
        RadioButton rdLaki = findViewById(R.id.rdLaki);
        String gender = rdLaki.isChecked() ? "L" : "P";

        EditText edTinggi = findViewById(R.id.edTinggi);
        EditText edBerat= findViewById(R.id.edBerat);

        float tinggi = Float.parseFloat(edTinggi.getText().toString());
        float berat = Float.parseFloat(edBerat.getText().toString());

        if(tinggi > 400 || tinggi < 10 || berat < 10 || berat > 300 ){
            Toast.makeText(this, "manusia apa bukan bang ?", Toast.LENGTH_SHORT).show();
        }
        else{
            User user = new User(nama,gender,tahun,tinggi,berat);

            if(lUser.size() == 3){
                lUser.remove(0);
                Toast.makeText(this, "masuk", Toast.LENGTH_SHORT).show();
            }

            lUser.add(user);

            intent = new Intent(this,Result.class);
            intent.putExtra("nama",nama);
            intent.putExtra("tahun",tahun);
            intent.putExtra("lUser",lUser);

            startActivity(intent);
            finish();
        }


    }
}