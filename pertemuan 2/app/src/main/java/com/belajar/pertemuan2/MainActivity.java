package com.belajar.pertemuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Mahasiswa> mhss;
    String namaMhs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mhss = new ArrayList<>();
    }

    public void btnLogin_click(View view) {
        EditText edtNrp = findViewById(R.id.edtNrp);
        EditText edtPassword = findViewById(R.id.edtPassword);

        if(edtNrp.getText().toString().equals("default") && edtPassword.getText().toString().equals("default")){
            Intent intent = new Intent(MainActivity.this,Activity_dashboard.class);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("listMhs", (ArrayList<? extends Parcelable>) mhss);
            startActivity(intent);
        }
        else{
            if(checkLogin(edtNrp.getText().toString(),edtPassword.getText().toString())){
                Intent intent = new Intent(this,Activity_welcome.class);
                intent.putExtra("nama",namaMhs);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "user tidak terdaftar", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean checkLogin(String nrp,String pass){
        for (Mahasiswa mhs:
             mhss) {
            if(mhs.getNrp().equals(nrp) && mhs.getPassword().equals(pass)){
                namaMhs = mhs.getNama();
                return true;
            }
        }

        return false;
    }
}