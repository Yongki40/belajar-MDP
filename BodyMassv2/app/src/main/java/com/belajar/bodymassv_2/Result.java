package com.belajar.bodymassv_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Result extends AppCompatActivity {

    ArrayList<User> lUser = new ArrayList<>();
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        intent = getIntent();
        lUser = getIntent().getParcelableArrayListExtra("lUser");

        TextView tv1 = findViewById(R.id.tvRes);
        User user = lUser.get(lUser.size()-1);
        String data = String.format("Halo %s, anda lahir pada tahun %s dengan tinggi badan %s cm berat badan %s kg dan BMI %s %s"
                                    ,user.getNama(),user.tahunKabisatCheck(),user.getTinggi(),user.getBerat(),user.BMI(),user.statusBmi());

        tv1.setText(data);
    }

    public void ulangClick(View view) {
        intent = new Intent(this,Calculator.class);
        User user = lUser.get(lUser.size()-1);
        intent.putExtra("nama",user.getNama());
        intent.putExtra("tahun",user.getTahun());
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