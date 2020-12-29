package com.belajar.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class tambahProp extends AppCompatActivity {

    public static int REQUEST_PROP = 100;
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Property> properties = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_prop);

        users = getIntent().getParcelableArrayListExtra("users");
        properties = getIntent().getParcelableArrayListExtra("properties");
    }


    public void tambahClick(View view) {
        EditText edAlamat = findViewById(R.id.edAlamat);
        EditText edHarga = findViewById(R.id.edHarga);
        EditText edLuas = findViewById(R.id.edLuas);

        if(edHarga.getText().toString().equals("") || edAlamat.getText().toString().equals("") || edLuas.getText().toString().equals("")){
            Toast.makeText(this, "ada yang kosong", Toast.LENGTH_SHORT).show();
        }
        else{
            if(properties.size() >= 3){
                Toast.makeText(this, "sudah penuh", Toast.LENGTH_SHORT).show();
                Intent intent = getIntent();
                intent.putExtra("users",users);
                intent.putExtra("properties",properties);
                setResult(REQUEST_PROP,intent);
                finish();
            }

            int harga = Integer.parseInt(edHarga.getText().toString());
            int luas = Integer.parseInt(edHarga.getText().toString());

            Intent intent = getIntent();
            properties.add(new Property(edAlamat.getText().toString(),harga,luas));
            intent.putExtra("users",users);
            intent.putExtra("properties",properties);
            setResult(REQUEST_PROP,intent);
            finish();
        }
    }
}