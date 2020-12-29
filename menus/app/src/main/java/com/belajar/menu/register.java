package com.belajar.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class register extends AppCompatActivity {

    ArrayList<User> users = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        users = getIntent().getParcelableArrayListExtra("users");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item_login){
            Intent intent = new Intent(register.this,MainActivity.class);
            intent.putExtra("users",users);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void registerClick(View view) {
        EditText edNomor = findViewById(R.id.edNo);
        EditText edNama = findViewById(R.id.edNama);
        EditText edPass = findViewById(R.id.edPassword);

        RadioButton rdBroker = findViewById(R.id.rdBroker);
        String jenis = rdBroker.isChecked() ? "broker" : "customer";
        if(edNomor.getText().toString().equals("") || edNama.getText().toString().equals("") || edPass.getText().toString().equals("")){
            Toast.makeText(this, "masih ada field yang kosong", Toast.LENGTH_SHORT).show();
        }
        else if (edNomor.getText().toString().length()<8){
            Toast.makeText(this, "nomor tidak valid", Toast.LENGTH_SHORT).show();
        }
        else{
            boolean found = false;
            long nomor = Long.parseLong(edNomor.getText().toString());
            for (int i = 0; i < users.size(); i++) {
                if(users.get(i).getNomor() == nomor){
                    found = true;
                }
            }

            if(found){
                Toast.makeText(this, "nomor sudah dipakai user lain", Toast.LENGTH_SHORT).show();
            }
            else{
                users.add(new User(edNama.getText().toString(),edPass.getText().toString(),jenis,nomor));
                Toast.makeText(this, "berhasil tambah user", Toast.LENGTH_SHORT).show();
            }
        }
    }


}