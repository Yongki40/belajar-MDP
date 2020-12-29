package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<User> listuser = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_Nav);

        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;

                switch (item.getItemId()){
                    case R.id.item_shop:
                        fragment = AddFragment.newInstance(listuser);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_Container,fragment).commit();
                        return true;
                    case R.id.item_pemasukan:
                        fragment = PemasukanFragment.newInstance(listuser);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_Container,fragment).commit();
                        return true;
                    case R.id.item_pengeluaran:
                        fragment = PengeluaranFragment.newInstance(listuser);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_Container,fragment).commit();
                        return true;
                }
                return false;
            }
        });
        if (savedInstanceState == null){
            bottomNavView.setSelectedItemId(R.id.item_shop);
        }
    }
    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof AddFragment){
            AddFragment addFragment = (AddFragment) fragment;
            addFragment.setOnMhsAddedListener(new AddFragment.OnMhsAddedListener() {
                @Override
                public void onMhsAdded(User user) {
                    listuser.add(user);
                }
            });
        }
    }
}