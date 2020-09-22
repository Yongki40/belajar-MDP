package com.belajar.bodymass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class Input_nama extends AppCompatActivity {

    ArrayList<User> lUser = new ArrayList<>();
    EditText edNama,edTahun;
    Intent intent;
    String username,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nama);

        edNama = findViewById(R.id.edNama);
        edTahun = findViewById(R.id.edTahun);
        intent = getIntent();
        lUser = getIntent().getParcelableArrayListExtra("lUser");
        username = getIntent().getStringExtra("username");
        pass = getIntent().getStringExtra("pass");
    }

    public void lanjutClick(View view) {
        intent = new Intent(this,Calculator.class);
        intent.putExtra("lUser",lUser);
        intent.putExtra("username",username);
        intent.putExtra("pass",pass);
        intent.putExtra("nama",edNama.getText().toString());
        int tahun = Integer.parseInt(edTahun.getText().toString());
        intent.putExtra("tahun",tahun);
        startActivity(intent);
        finish();
    }
}