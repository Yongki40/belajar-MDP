package com.belajar.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> users = new ArrayList<>();
    ArrayList<Music> musics = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getIntent().getExtras() != null){
            users = getIntent().getParcelableArrayListExtra("users");
            musics = getIntent().getParcelableArrayListExtra("musics");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_Register:
               changeIntent(MainActivity.this,Register.class);
        }
        return super.onOptionsItemSelected(item);
    }

    public void loginClick(View view) {
        EditText[] ed = {
                findViewById(R.id.edUsername),
                findViewById(R.id.edPassword)
        };

        if(ed[0].getText().toString().equals("") || ed[1].getText().toString().equals("")){
            Toast.makeText(this, "ada yang kosong", Toast.LENGTH_SHORT).show();
        }
        else{
            if(ed[0].getText().toString().equalsIgnoreCase("admin") && ed[1].getText().toString().equals("admin")){
                changeIntent(MainActivity.this,adminActivity.class);
            }
            else{
                boolean found = false;
                for (int i = 0; i < users.size(); i++) {
                    if(users.get(i).getUsername().equalsIgnoreCase(ed[0].getText().toString()) && users.get(i).getPassword().equalsIgnoreCase(ed[1].getText().toString())){
                        found = true;
                        Intent intent = new Intent(MainActivity.this,UserActivity.class);
                        intent.putExtra("users",users);
                        intent.putExtra("musics",musics);
                        intent.putExtra("isLogin",i);
                        startActivity(intent);
                        finish();
                    }
                }

                if(!found){
                    Toast.makeText(this, "user tidak ada", Toast.LENGTH_SHORT).show();
                }
            }

        }
    }

    public void changeIntent(Context context,Class to){
        Intent intent = new Intent(context,to);
        intent.putExtra("users",users);
        intent.putExtra("musics",musics);
        startActivity(intent);
        finish();
    }

}