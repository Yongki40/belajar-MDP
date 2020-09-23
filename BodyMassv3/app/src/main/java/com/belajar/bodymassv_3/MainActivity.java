package com.belajar.bodymassv_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> lUser = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginClick(View view) {
        EditText edUsername = findViewById(R.id.edUser);
        EditText edPass = findViewById(R.id.edPass);

        if(edUsername.getText().toString().equals("user") && edPass.getText().toString().equals("user")){
            if(getIntent().getExtras()!=null){
                lUser = getIntent().getParcelableArrayListExtra("lUser");
            }

            Intent intent = new Intent(this,Input_nama.class);
            intent.putExtra("lUser",lUser);
            startActivity(intent);
            finish();
        }
        else if(edUsername.getText().toString().equals("admin") && edPass.getText().toString().equals("admin")){
            if(getIntent().getExtras()!=null){
                lUser = getIntent().getParcelableArrayListExtra("lUser");
            }

            Intent intent = new Intent(this,Admin.class);
            intent.putExtra("lUser",lUser);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "gagal login", Toast.LENGTH_SHORT).show();
        }
    }
}