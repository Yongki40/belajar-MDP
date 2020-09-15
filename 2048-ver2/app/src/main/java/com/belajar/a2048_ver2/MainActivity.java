package com.belajar.a2048_ver2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Button> listPapan;
    Player player;
    Random rand;
    TextView txtScore;
    Button btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listPapan = new ArrayList<>();
        rand = new Random();
        init();

        txtScore = findViewById(R.id.txtScore);
        btnReset = findViewById(R.id.btnReset);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset_onclick();
            }
        });
    }

    public void init(){
        LinearLayout linear1 = findViewById(R.id.layout1);
        LinearLayout linear2 = findViewById(R.id.layout2);
        LinearLayout linear3 = findViewById(R.id.layout3);
        LinearLayout linear4 = findViewById(R.id.layout4);

        loadButton(linear1);
        loadButton(linear2);
        loadButton(linear3);
        loadButton(linear4);

        int arrRand[] = {2,4};

        for (int i = 0; i < listPapan.size(); i++) {
            int txtBtn = arrRand[rand.nextInt(2)];
            listPapan.get(i).setText(txtBtn+"");

            listPapan.get(i).setOnClickListener(this);
        }

        player = new Player();


    }

    public void loadButton(LinearLayout layout){
        for (int i = 0; i < layout.getChildCount(); i++) {
            View v = layout.getChildAt(i);
            if(v instanceof Button){
                listPapan.add((Button) v);
            }
        }

    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        int index = listPapan.indexOf(btn);
        int angBtn = Integer.parseInt(btn.getText().toString());
        if(player.getStart() == -1){
            player.setStart(index);
            player.setAngka(angBtn);
        }
        else if(index+1 == player.getStart()||index-1 == player.getStart()||index+4 == player.getStart()||index-4 == player.getStart()
                ||index == player.getStart()){
            if(index != player.getStart()){
                if(angBtn == player.getAngka()){
                    int jumlah = player.getAngka() + angBtn;
                    int getScore = player.getScore();
                    player.setScore(getScore+jumlah);

                    listPapan.get(player.getStart()).setText(randIsi()+"");

                    txtScore.setText("Score: "+player.getScore());
                    btn.setText(jumlah+"");
                    player.setStart(-1);
                }
                else{
                    Toast.makeText(this, "Angka harus sama", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(this, "reset start", Toast.LENGTH_SHORT).show();
                player.setStart(-1);
            }
        }
        else{
            Toast.makeText(this, "hanya bisa 4 arah", Toast.LENGTH_SHORT).show();
        }

    }

    public int randIsi(){
        int arrRand[] = {2,4};
        return arrRand[rand.nextInt(2)];
    }

    public void reset_onclick(){
        listPapan.clear();
        init();
        txtScore.setText("Score: "+player.getScore());
    }
}