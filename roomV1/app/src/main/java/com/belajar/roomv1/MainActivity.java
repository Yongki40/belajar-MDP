package com.belajar.roomv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.NavigationMenu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<NilaiPrak> nilaiPraks = new ArrayList<>();
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getAppDatabase(this);
//        new removeTask().execute();

        nilaiPraks.add(new NilaiPrak("Minggu 1"));
        nilaiPraks.get(nilaiPraks.size()-1).setAbsen(20);
        new addNilaiPrakTask().execute(new NilaiPrak("Minggu 1"));

        nilaiPraks.add(new NilaiPrak("Minggu 2"));
        new addNilaiPrakTask().execute(new NilaiPrak("Minggu 2"));
        nilaiPraks.add(new NilaiPrak("Minggu 3"));
        new addNilaiPrakTask().execute(new NilaiPrak("Minggu 3"));
        nilaiPraks.add(new NilaiPrak("Minggu 4"));
        new addNilaiPrakTask().execute(new NilaiPrak("Minggu 4"));
        nilaiPraks.add(new NilaiPrak("Minggu 5"));
        new addNilaiPrakTask().execute(new NilaiPrak("Minggu 5"));
        nilaiPraks.add(new NilaiPrak("Minggu 6"));
        new addNilaiPrakTask().execute(new NilaiPrak("Minggu 6"));
        nilaiPraks.add(new NilaiPrak("Minggu 7"));
        new addNilaiPrakTask().execute(new NilaiPrak("Minggu 7"));


        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                if(item.getItemId() == R.id.item_input){
                    fragment = InputNilai.newInstance(nilaiPraks);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                }
                else if(item.getItemId() == R.id.item_nilai){
                    fragment = Nilai.newInstance(nilaiPraks);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                }
                return false;
            }
        });

        if(savedInstanceState == null){
            navigationView.setSelectedItemId(R.id.item_input);
        }
    }

    private class removeTask extends AsyncTask<NilaiPrak,Void,Void> {
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(NilaiPrak... nilaiPraks) {
            db.nilaiPrak().nukeTable();
            return null;
        }
    }

    private class addNilaiPrakTask extends AsyncTask<NilaiPrak,Void,Void> {
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(NilaiPrak... nilaiPraks) {
            db.nilaiPrak().insert(nilaiPraks[0]);
            return null;
        }
    }
}