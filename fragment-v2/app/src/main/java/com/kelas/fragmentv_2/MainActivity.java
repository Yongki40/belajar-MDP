package com.kelas.fragmentv_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<cart> lCart=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView btnNav = findViewById(R.id.navbar);
        btnNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment f;
                if(item.getItemId() == R.id.menuCart){
                    f=addFragment.newInstance(lCart);
                    getSupportFragmentManager().beginTransaction().replace(R.id.containers,f).commit();
                    return true;
                }else if(item.getItemId()==R.id.menuPemasukan){

                    f=pemasukanFragment.newInstance(lCart);
                    getSupportFragmentManager().beginTransaction().replace(R.id.containers,f).commit();
                    return true;
                }else if(item.getItemId()==R.id.menuPengeluaran){

                    f=pengeluaranFragment.newInstance(lCart);
                    getSupportFragmentManager().beginTransaction().replace(R.id.containers,f).commit();
                    return true;
                }
                return false;
            }
        });

        if(savedInstanceState == null){
            btnNav.setSelectedItemId(R.id.menuCart);
        }
    }
}