package com.belajar.bodymass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> lUser = new ArrayList<>();;
    EditText edUser,edPassword;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edUser = findViewById(R.id.edTinggi);
        edPassword = findViewById(R.id.edBerat);

    }

    public void loginClick(View view) {

        if(edUser.getText().toString().equals("user") && edPassword.getText().toString().equals("user")){
            intent = new Intent(this,Input_nama.class);
            intent.putExtra("lUser",lUser);
            startActivity(intent);
            finish();
        }
        else if(edUser.getText().toString().equals("admin") && edPassword.getText().toString().equals("admin")){
            intent = getIntent();
            lUser = getIntent().getParcelableArrayListExtra("lUser");
            Toast.makeText(this, "panjang: "+lUser.size(), Toast.LENGTH_SHORT).show();

            intent = new Intent(this,Admin.class);
            intent.putExtra("lUser",lUser);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "gagal login", Toast.LENGTH_SHORT).show();
        }
    }


}