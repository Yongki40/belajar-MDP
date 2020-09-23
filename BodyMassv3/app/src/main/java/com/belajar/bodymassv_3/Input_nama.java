package com.belajar.bodymassv_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class Input_nama extends AppCompatActivity {

    ArrayList<User> lUser = new ArrayList<>();
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nama);

        intent = getIntent();
        lUser = getIntent().getParcelableArrayListExtra("lUser");
    }

    public void lanjutClick(View view) {
        EditText edNama = findViewById(R.id.edNama);
        EditText edTahun = findViewById(R.id.edTahun);

        int tahun = Integer.parseInt(edTahun.getText().toString());
        intent = new Intent(this,Calculator.class);
        intent.putExtra("nama",edNama.getText().toString());
        intent.putExtra("tahun",tahun);
        intent.putExtra("lUser",lUser);

        startActivity(intent);
        finish();
    }
}