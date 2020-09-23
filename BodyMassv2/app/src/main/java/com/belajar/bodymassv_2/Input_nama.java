package com.belajar.bodymassv_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class Input_nama extends AppCompatActivity {

    ArrayList<User> lUser = new ArrayList<>();
    Intent intent;
    EditText edNama,edTahun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nama);

        intent = getIntent();
        lUser = getIntent().getParcelableArrayListExtra("lUser");
        edNama = findViewById(R.id.edNama);
        edTahun= findViewById(R.id.edTahun);
    }

    public void lanjutClick(View view) {
        Intent intent = new Intent(this,Calculator.class);
        intent.putExtra("lUser",lUser);
        intent.putExtra("nama",edNama.getText().toString());
        int tahun = Integer.parseInt(edTahun.getText().toString());
        intent.putExtra("tahun",tahun);

        startActivity(intent);
        finish();
    }
}