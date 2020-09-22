package com.belajar.bodymass;

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

        TextView tv1 = findViewById(R.id.tvUser1);
        TextView tv2 = findViewById(R.id.tvUser2);
        TextView tv3 = findViewById(R.id.tvUser3);
        Toast.makeText(this, "pada admin: "+lUser.size(), Toast.LENGTH_SHORT).show();
        if(lUser.size() == 1){
            User user = lUser.get(0);
            tv1.setText(user.toString());
        }
        else if(lUser.size() == 2){
            User user = lUser.get(0);
            tv1.setText(user.toString());
            User user1 = lUser.get(1);
            tv2.setText(user1.toString());
        }
        else if(lUser.size() == 3){
            User user = lUser.get(0);
            tv1.setText(user.toString());
            User user1 = lUser.get(1);
            tv2.setText(user1.toString());
            User user2 = lUser.get(2);
            tv3.setText(user2.toString());
        }

    }
}