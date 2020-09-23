package com.belajar.bodymassv_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Admin extends AppCompatActivity {

    ArrayList<User> lUser = new ArrayList<>();
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        intent = getIntent();
        lUser = getIntent().getParcelableArrayListExtra("lUser");
        Toast.makeText(this, "panjang: "+lUser.size(), Toast.LENGTH_SHORT).show();
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView tv3 = findViewById(R.id.tv3);

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
}