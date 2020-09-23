package com.belajar.bodymassv_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Result extends AppCompatActivity {

    ArrayList<User> lUser = new ArrayList<>();
    Intent intent;
    String nama;
    int tahun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView hasil = findViewById(R.id.tvHasil);

        intent = getIntent();
        lUser = getIntent().getParcelableArrayListExtra("lUser");
        nama = getIntent().getStringExtra("nama");
        tahun = getIntent().getIntExtra("tahun",0);

        User user = lUser.get(lUser.size()-1);
        String data = String.format("Halo %s, anda lahir pada tahun %s, dengan tinggi badang %s cm, berat badan %s kg dan BMI %s %n %s",
                                    user.getNama(),user.tahunKabisat(),user.getTinggi(),user.getBerat(),user.countBMI(),user.statusBmi());

        hasil.setText(data);
    }

    public void ulangClick(View view) {
        intent = new Intent(this,Calculator.class);
        lUser.remove(lUser.size()-1);
        intent.putExtra("lUser",lUser);
        intent.putExtra("nama",nama);
        intent.putExtra("tahun",tahun);

        startActivity(intent);
        finish();
    }

    public void logoutClick(View view) {
        intent = new Intent(this,MainActivity.class);
        intent.putExtra("lUser",lUser);
        Toast.makeText(this, "panjang: "+lUser.size(), Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();
    }
}