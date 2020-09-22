package com.belajar.bodymass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Result extends AppCompatActivity {

    TextView tvUserNow;
    ArrayList<User> lUser = new ArrayList<>();
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvUserNow = findViewById(R.id.tvUserNow);
        intent = getIntent();
        lUser = getIntent().getParcelableArrayListExtra("lUser");
        tvUserNow.setText(
                "Halo "+lUser.get(lUser.size()-1).getUsername()+", anda lahir pada tahun "+lUser.get(lUser.size()-1).getTahunKabisat()+" " +
                        "dengan tinggi badan "+lUser.get(lUser.size()-1).getTinggi()+" cm, berat badan "+lUser.get(lUser.size()-1).getBerat()+" " +
                        "kg dan BMI "+lUser.get(lUser.size()-1).getBmi() +lUser.get(lUser.size()-1).statusBmi()
        );


    }

    public void ulangClick(View view) {
        intent = new Intent(this,Calculator.class);
        intent.putExtra("nama",lUser.get(lUser.size()-1).getUsername());
        intent.putExtra("pass",lUser.get(lUser.size()-1).getPassword());
        intent.putExtra("tahun",lUser.get(lUser.size()-1).getTahun());

        lUser.remove(lUser.size()-1);
        intent.putExtra("lUser",lUser);
        startActivity(intent);
        finish();
    }

    public void logoutClick(View view) {
        intent = new Intent(this,MainActivity.class);
        intent.putExtra("lUser",lUser);
        startActivity(intent);
        finish();
    }
}