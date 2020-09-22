package com.belajar.bodymass;

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
    EditText edTinggi, edBerat;
    Intent intent;
    String nama,username,pass;
    int tahun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        edTinggi = findViewById(R.id.edTinggi);
        edBerat = findViewById(R.id.edBerat);
        intent = getIntent();

        lUser = getIntent().getParcelableArrayListExtra("lUser");
        nama = getIntent().getStringExtra("nama");

        username = getIntent().getStringExtra("username");
        pass = getIntent().getStringExtra("pass");
        tahun = getIntent().getIntExtra("tahun",0);
    }

    public void hitungClick(View view) {

        float tinggi = Integer.parseInt(edTinggi.getText().toString());
        float berat = Integer.parseInt(edBerat.getText().toString());
        RadioButton rdLaki = findViewById(R.id.rdLaki);
        String genre = rdLaki.isChecked() ? "L" : "P";

        float bmi = berat / (tinggi * tinggi);
        Toast.makeText(this, "user bmi: "+bmi, Toast.LENGTH_SHORT).show();
//        String username, String password, String gender, String tahunKabisat, int tahun, int tinggi, int berat, int bmi) {
        User user = new User(
                nama,pass,genre,"tidak",tahun,tinggi,berat,bmi
        );


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