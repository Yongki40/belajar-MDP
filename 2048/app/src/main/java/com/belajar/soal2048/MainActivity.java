package com.belajar.soal2048;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Button> papan;
    Random rand;
    Player player;
    TextView txtScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        papan = new ArrayList<>();
        rand = new Random();
        txtScore = findViewById(R.id.txtScore);
        init();
        papan_onclick();
    }


    public void init(){
        LinearLayout layout1 = findViewById(R.id.linear1);
        LinearLayout layout2 = findViewById(R.id.linear2);
        LinearLayout layout3 = findViewById(R.id.linear3);
        LinearLayout layout4 = findViewById(R.id.linear4);

        loadButton(layout1);
        loadButton(layout2);
        loadButton(layout3);
        loadButton(layout4);

        int arr[] ={2,4};

        for (int i = 0; i < papan.size(); i++) {
            int index = rand.nextInt(2);
            papan.get(i).setText(arr[index]+"");
        }
        player = new Player();

    }

    public void papan_onclick(){
        for (int i = 0; i < papan.size(); i++) {
            Button btn = papan.get(i);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button btnClick = (Button) view;
                    int angBtn = Integer.parseInt(btnClick.getText().toString());
                    int indexBtn = papan.indexOf(btnClick);
                    if(player.getStart() == -1){
                        int start = papan.indexOf(btnClick);
                        player.setStart(start);
                        int angka1 = Integer.parseInt(btnClick.getText().toString());
                        player.setAngka1(angka1);
                    }
                    else if(indexBtn+4 == player.getStart() || indexBtn-4 == player.getStart() || indexBtn+1 == player.getStart() || indexBtn-1 == player.getStart()|| indexBtn == player.getStart()){
                        if(player.getStart() != -1 && player.getStart() != indexBtn){
                            if(player.getAngka1() == angBtn){
                                int jumlah = angBtn + player.getAngka1();
                                player.setScore(jumlah);
                                btnClick.setText(jumlah+"");
                                papan.get(player.getStart()).setText(randomPin()+"");
                                txtScore.setText("Score: "+player.getScore());
                                player.setStart(-1);
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Angka tidak sama", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            player.setStart(-1);
                        }
                    }

                }
            });
        }
    }

    public int randomPin(){
        int arr[] ={2,4};
        return arr[rand.nextInt(2)];
    }

    public void loadButton(LinearLayout layout){

        for (int i = 0; i < layout.getChildCount(); i++) {
            View v = layout.getChildAt(i);
            if(v instanceof Button){
                papan.add((Button) v);
            }
        }
    }

    public void reset_onclick(View view) {
        papan.clear();
        init();
        txtScore.setText("Score: "+player.getScore());
    }
}