package com.belajar.listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class adminActivity extends AppCompatActivity {

    ArrayList<User> users = new ArrayList<>();
    ArrayList<Music> musics = new ArrayList<>();
    ListView lvMusic;
    ArrayAdapter<Music> musicAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        users = getIntent().getParcelableArrayListExtra("users");
        musics = getIntent().getParcelableArrayListExtra("musics");

        lvMusic = findViewById(R.id.lvMusic);

        musicAdapter = new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,musics
        );
        lvMusic.setAdapter(musicAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_admin,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_logout:
                changeIntent(adminActivity.this,MainActivity.class);
                break;
            case R.id.item_newSong:
                Intent intent = new Intent(adminActivity.this,addNewSong.class);
                intent.putExtra("users",users);
                intent.putExtra("musics",musics);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    public void changeIntent(Context context, Class to){
        Intent intent = new Intent(context,to);
        intent.putExtra("users",users);
        intent.putExtra("musics",musics);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100){
//            musics.clear();
            musics = data.getParcelableArrayListExtra("musics");
            musicAdapter.notifyDataSetChanged();
            Toast.makeText(this, "musics: "+musics.size(), Toast.LENGTH_SHORT).show();
        }
    }
}