package com.belajar.bodymassv_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Admin extends AppCompatActivity {

    ArrayList<User> lUser = new ArrayList<>();
    Intent intent;
    TextView tvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        intent = getIntent();
        lUser = getIntent().getParcelableArrayListExtra("lUser");

        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView tv3 = findViewById(R.id.tv3);
        tvHasil = findViewById(R.id.tvHasil);

        Toast.makeText(this, "panjang kedua: "+lUser, Toast.LENGTH_SHORT).show();
        if(lUser.size() == 1){
            tv1.setText(lUser.get(0).toString());
        }
        else if(lUser.size() == 2){
            tv1.setText(lUser.get(0).toString());
            tv2.setText(lUser.get(1).toString());
        }
        else if(lUser.size() == 3){
            tv1.setText(lUser.get(0).toString());
            tv2.setText(lUser.get(1).toString());
            tv3.setText(lUser.get(2).toString());
        }

    }

    public void tvClick(View view) {
        if(view.getId() == R.id.tv1){
            User user = lUser.get(0);
            showHasil(user);
        }
        else  if(view.getId() == R.id.tv2){
            User user = lUser.get(1);
            showHasil(user);
        }
        else  if(view.getId() == R.id.tv3){
            User user = lUser.get(2);
            showHasil(user);
        }

    }

    public void showHasil(User user){
        String gender = user.getGender().equals("L") ? "Laki - laki" : "Perempuan";
        String data = String.format("%s %s tinggi %s cm, berat %s kg lahir pada tahun %s dengan BMI %s",
                user.getNama(),gender,user.getTinggi(),user.getBerat(),user.getTahun(),user.countBMI());
        tvHasil.setText(data);
    }
}