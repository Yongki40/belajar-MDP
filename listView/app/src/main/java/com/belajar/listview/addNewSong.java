package com.belajar.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class addNewSong extends AppCompatActivity {

    ArrayList<User> users = new ArrayList<>();
    ArrayList<Music> musics = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_song);

        users = getIntent().getParcelableArrayListExtra("users");
        musics = getIntent().getParcelableArrayListExtra("musics");
    }

    public void btnClick(View view) {
        if(view.getId() == R.id.btnBack){
            Intent intent = new Intent(addNewSong.this,adminActivity.class);
            intent.putExtra("users",users);
            intent.putExtra("musics",musics);
            startActivity(intent);
            finish();
        }
        else{
            EditText[] ed = {
                    findViewById(R.id.edTitle),
                    findViewById(R.id.edArtist),
                    findViewById(R.id.edGenre)
            };
            musics.add(new Music(musics.size()-1,ed[0].getText().toString(),ed[1].getText().toString(),ed[2].getText().toString()));
            Toast.makeText(this, "berhasil masukan data", Toast.LENGTH_SHORT).show();
        }
    }
}