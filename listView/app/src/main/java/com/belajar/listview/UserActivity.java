package com.belajar.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    ArrayList<User> users = new ArrayList<>();
    ArrayList<Music> musics = new ArrayList<>();
    int isLogin;
    ArrayList<Music> playList = new ArrayList<>();
    ListView lvMusic, lvPlay;
    ArrayAdapter<Music> musicAdapter,playAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        users = getIntent().getParcelableArrayListExtra("users");
        musics = getIntent().getParcelableArrayListExtra("musics");
        isLogin = getIntent().getIntExtra("isLogin",0);

        lvMusic = findViewById(R.id.lvMusic);
        lvPlay = findViewById(R.id.lvPlay);

        musicAdapter = new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,musics
        );

        playAdapter = new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,playList
        );

        lvMusic.setAdapter(musicAdapter);
        lvPlay.setAdapter(playAdapter);

        lvMusic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                playList.add(musics.get(i));
                users.get(isLogin).setPlayList(playList);
                playAdapter.notifyDataSetChanged();
            }
        });
    }

    public void changeIntent(Context context, Class to){
        Intent intent = new Intent(context,to);
        intent.putExtra("users",users);
        intent.putExtra("musics",musics);
        startActivity(intent);
        finish();
    }
}