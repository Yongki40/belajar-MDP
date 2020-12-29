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

public class MainActivity extends AppCompatActivity {

    ArrayList<User> users = new ArrayList<>();
    ArrayList<Property> properties = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getIntent().getExtras()!= null){
            users = getIntent().getParcelableArrayListExtra("users");
            properties = getIntent().getParcelableArrayListExtra("properties");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        if(item.getItemId() == R.id.item_register){
            intent = new Intent(MainActivity.this,register.class);
            intent.putExtra("users",users);
            intent.putExtra("properties",properties);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void loginClick(View view) {
        EditText edNomor = findViewById(R.id.edNo);
        EditText edPass = findViewById(R.id.edPassword);

        if(edNomor.getText().toString().equals("") || edPass.getText().toString().equals("")){
            Toast.makeText(this, "masih ada field yang kosong", Toast.LENGTH_SHORT).show();
        }
        else if (edNomor.getText().toString().length()<8){
            Toast.makeText(this, "nomor tidak valid", Toast.LENGTH_SHORT).show();
        }
        else{
            boolean found = false;
            long nomor = Long.parseLong(edNomor.getText().toString());
            for (int i = 0; i < users.size(); i++) {
                if(users.get(i).getNomor() == nomor && users.get(i).getPassword() == edPass.getText().toString()){
                    found = true;
                    if(users.get(i).getJenis().equals("broker")){
                        Intent intent = new Intent(MainActivity.this,broker.class);

                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(MainActivity.this,customer.class);

                        startActivity(intent);
                    }
                }
            }

            if(!found){
                Toast.makeText(this, "user tidak ditemukan", Toast.LENGTH_SHORT).show();
            }
        }
    }
}