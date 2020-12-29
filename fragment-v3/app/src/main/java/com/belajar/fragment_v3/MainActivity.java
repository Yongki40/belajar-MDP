package com.belajar.fragment_v3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<DataTrans> dataTrans = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.btnNav);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                if(item.getItemId() == R.id.item_trans){
                    fragment = transaksi.newInstance(dataTrans);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                    return  true;
                }
                else if(item.getItemId() == R.id.item_pemasukan){
                    fragment = Pemasukan.newInstance(dataTrans);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                    return  true;
                }
                else if(item.getItemId() == R.id.item_pengeluaran){
                    fragment = Pengeluaran.newInstance(dataTrans);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                    return  true;
                }
                return false;
            }
        });

        if(savedInstanceState == null){
            navigationView.setSelectedItemId(R.id.item_trans);
        }
    }


}