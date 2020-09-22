package com.belajar.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mahasiswa> lMhs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lMhs = new ArrayList<>();
//        Mahasiswa mhs = new Mahasiswa("123","yongki","123");
//        lMhs.add(mhs);
    }

    private void loginClick(){
        TextView nrp = findViewById(R.id.tvNrp);
        nrp.getText().toString();
        TextView pass = findViewById(R.id.tvPass);
        pass.getText().toString();
        if( nrp.getText().toString().equals("dosen") && pass.getText().toString().equals("dosen")){
            Intent intent = new Intent(MainActivity.this,Dashboard.class);
            intent.putExtra("lMhs",lMhs);
            startActivity(intent);
        }
        else{
            if(check( nrp.getText().toString(),pass.getText().toString())){
                Intent intent = new Intent(MainActivity.this,welcome.class);
                Mahasiswa mhs = lMhs.get(index);
                intent.putExtra("mhs",mhs);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "mahasiswa tidak terdaftar", Toast.LENGTH_SHORT).show();
            }
        }
    }

    int index = -1;
    private boolean check(String nrp,String password){
        for (int i = 0; i < lMhs.size(); i++) {
            Mahasiswa m = lMhs.get(i);
            if(m.getNrp().equals(nrp) && m.getPassword().equals(password)){
                index = i;
                return true;
            }
        }
        return false;
    }

    public void loginClick(View view) {
        loginClick();
    }
}