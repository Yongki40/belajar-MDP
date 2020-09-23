package com.belajar.bodymassv_2;

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
    EditText edTinggi,edBerat;
    String gender,nama;
    int tahun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        intent = getIntent();
        lUser = getIntent().getParcelableArrayListExtra("lUser");
        nama = getIntent().getStringExtra("nama");
        tahun = getIntent().getIntExtra("tahun",0);

        edTinggi = findViewById(R.id.edTinggi);
        edBerat = findViewById(R.id.edBerat);

        RadioButton rdgender = findViewById(R.id.rdLaki);
        gender = rdgender.isChecked() ? "L" : "P";

    }

    public void hitungClick(View view) {

        float tinggi = Float.parseFloat(edTinggi.getText().toString());
        float berat = Float.parseFloat(edBerat.getText().toString());
        if(berat <10 || berat > 400 || tinggi < 100 || tinggi > 300){
            Toast.makeText(this, "kamu manusia apa bukan ?", Toast.LENGTH_SHORT).show();
        }
        else{
            User user = new User(nama,gender,tahun,tinggi,berat);

            if(lUser.size() == 3){
                lUser.remove(0);
            }

            lUser.add(user);

            intent = new Intent(this,Result.class);
            intent.putExtra("lUser",lUser);
            startActivity(intent);
            finish();
        }

        
    }
}