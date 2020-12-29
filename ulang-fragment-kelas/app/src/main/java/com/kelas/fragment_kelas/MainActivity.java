package com.kelas.fragment_kelas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mahasiswa> listMhs = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                if(item.getItemId() == R.id.item_add){
                    fragment = new AddFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                    Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if (item.getItemId() == R.id.item_list){
                    fragment = new ListFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                    return true;
                }
                return false;
            }
        });

        if(savedInstanceState == null){
            navigationView.setSelectedItemId(R.id.item_add);
            Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if(fragment instanceof AddFragment){
            AddFragment addFragment = (AddFragment) fragment;
            addFragment.setOnMhsAddedListener(new AddFragment.OnMhsAddedListener() {
                @Override
                public void onMhsAdded(Mahasiswa mhs) {
                    listMhs.add(mhs);
                }
            });
        }
    }
}