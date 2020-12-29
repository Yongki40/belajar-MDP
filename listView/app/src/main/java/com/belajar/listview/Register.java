package com.belajar.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Register extends AppCompatActivity {

    ArrayList<User> users = new ArrayList<>();
    ArrayList<Music> musics = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if(getIntent().getExtras() != null){
            users = getIntent().getParcelableArrayListExtra("users");
            musics = getIntent().getParcelableArrayListExtra("musics");
        }
    }

    public void RegisterClick(View view) {
        EditText[] ed = {
                findViewById(R.id.edUsername),
                findViewById(R.id.edName),
                findViewById(R.id.edPassword),
                findViewById(R.id.edCon)
        };

        boolean empty = false;
        for (int i = 0; i < ed.length; i++) {
            if(ed[i].getText().toString().equals("")){
                empty = true;
            }
        }

        if(empty){
            Toast.makeText(this, "ada inputan kosong", Toast.LENGTH_SHORT).show();
        }
        else{
            if(ed[0].getText().toString().equals("admin")){
                Toast.makeText(this, "admin tidak bisa dipakai", Toast.LENGTH_SHORT).show();
            }
            else{
                if(checkRegister(ed[0].getText().toString())){
                    if(ed[3].getText().toString().equals(ed[2].getText().toString())){
                        users.add(new User(ed[0].getText().toString(),ed[1].getText().toString(),ed[2].getText().toString()));
                        Toast.makeText(this, "berhasil daftarkan user", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "Konfirmasi tidak sama", Toast.LENGTH_SHORT).show();
                    }
                    
                }
                else{
                    Toast.makeText(this, "username sudah dipakai", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    
    public boolean checkRegister(String username){
        for (int i = 0; i < users.size(); i++) {
            if(username.equalsIgnoreCase(users.get(i).getUsername())){
                return false;
            }
        }
        
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.item_Login:
                intent = new Intent(Register.this,MainActivity.class);
                intent.putExtra("users",users);
                intent.putExtra("musics",musics);
                startActivity(intent);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}