package com.belajar.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class welcome extends AppCompatActivity {

    Intent intent;
    TextView tvWel;
    Mahasiswa mhs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        intent = getIntent();

        mhs = intent.getParcelableExtra("mhs");
        tvWel = findViewById(R.id.tvWel);
        tvWel.setText("Welcome, "+mhs.getNama()+"!");
    }
}