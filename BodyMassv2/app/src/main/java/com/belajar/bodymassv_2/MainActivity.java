package com.belajar.bodymassv_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> lUser = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginClick(View view) {
        EditText edUser,edPass;
        edUser = findViewById(R.id.edUsername);
        edPass = findViewById(R.id.edPass);

        if(edUser.getText().toString().equals("user") && edPass.getText().toString().equals("user")){
            Intent intent = new Intent(this,Input_nama.class);
            intent.putExtra("lUser",lUser);
            startActivity(intent);
            finish();
        }
        else if(edUser.getText().toString().equals("admin") && edPass.getText().toString().equals("admin")){
            if(getIntent().getExtras()!=null){
                lUser = getIntent().getParcelableArrayListExtra("lUser");
            }

            Intent intent = new Intent(this,Admin.class);
            intent.putExtra("lUser",lUser);
            startActivity(intent);
        }
    }
}