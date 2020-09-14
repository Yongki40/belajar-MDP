package com.latihan.Pertemuan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Button> papan;
    TextView lbScore1;
    TextView lbScore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();
        gameplay();
    }

    ArrayList<Player> players;

    public void start(){
        lbScore1 = findViewById(R.id.lbScore1);
        lbScore2 = findViewById(R.id.lbScore2);

        players = new ArrayList<>();
        players.add(new Player("X","Player 1"));
        players.add(new Player("O","Player 2"));
        
        papan = new ArrayList<>();
        initPapan();
    }

    int turn = 0;
    int limit = 9;
    public void btn_reset_onclick(View view) {
        reset_papan();
    }

    public void initPapan(){
        papan.add((Button) findViewById(R.id.btnPapan1));
        papan.add((Button) findViewById(R.id.btnPapan2));
        papan.add((Button) findViewById(R.id.btnPapan3));
        papan.add((Button) findViewById(R.id.btnPapan4));
        papan.add((Button) findViewById(R.id.btnPapan5));
        papan.add((Button) findViewById(R.id.btnPapan6));
        papan.add((Button) findViewById(R.id.btnPapan7));
        papan.add((Button) findViewById(R.id.btnPapan8));
        papan.add((Button) findViewById(R.id.btnPapan9));
    }

    public void reset_papan(){
        papan.clear();
        initPapan();

        for (int i = 0; i < papan.size(); i++) {
            papan.get(i).setText("");
        }
        turn = 0;
    }

    public void gameplay(){
        for (Button btnTemp:
             papan) {
            btnTemp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button btn = (Button) view;
                    if(!btn.getText().equals("")){
                        Toast.makeText(MainActivity.this, "sudah terisi", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        btn.setText(players.get(turn).getSimbol());
                        limit--;
                        if(limit>0){
                            for (int i = 0; i < papan.size(); i++) {
                                Button b = papan.get(i);
                                if(!b.getText().toString().equals("")){
                                    if(i<3){
                                        Button b1 = papan.get(i+3);
                                        Button b2 = papan.get(i+6);
                                        if(b.getText().toString().equals(b1.getText().toString())&&b.getText().toString().equals(b2.getText().toString())){
                                            Toast.makeText(MainActivity.this, players.get(turn).getName()+" Wins!", Toast.LENGTH_SHORT).show();
                                            int score = players.get(turn).getScore();
                                            players.get(turn).setScore(score++);
                                            lbScore1.setText(players.get(0).getName()+": "+players.get(0).getScore());
                                            lbScore2.setText(players.get(1).getName()+": "+players.get(1).getScore());
                                            turn = 1;
                                        }
                                        else if(i==0){
                                            b1 = papan.get(i+4);
                                            b2 = papan.get(i+8);
                                            if(b.getText().toString().equals(b1.getText().toString())&&b.getText().toString().equals(b2.getText().toString())){
                                                Toast.makeText(MainActivity.this, players.get(turn).getName()+" Wins!", Toast.LENGTH_SHORT).show();
                                                int score = players.get(turn).getScore();
                                                players.get(turn).setScore(score++);
                                                lbScore1.setText(players.get(0).getName()+": "+players.get(0).getScore());
                                                lbScore2.setText(players.get(1).getName()+": "+players.get(1).getScore());
                                                turn = 1;
                                            }
                                        }
                                        else if(i==2){
                                            b1 = papan.get(i+2);
                                            b2 = papan.get(i+4);
                                            if(b.getText().toString().equals(b1.getText().toString())&&b.getText().toString().equals(b2.getText().toString())){
                                                Toast.makeText(MainActivity.this, players.get(turn).getName()+" Wins!", Toast.LENGTH_SHORT).show();
                                                int score = players.get(turn).getScore();
                                                players.get(turn).setScore(score++);
                                                lbScore1.setText(players.get(0).getName()+": "+players.get(0).getScore());
                                                lbScore2.setText(players.get(1).getName()+": "+players.get(1).getScore());
                                                turn = 1;
                                            }
                                        }
                                    }
                                    if(i%3==0){
                                        Button b1 = papan.get(i+1);
                                        Button b2 = papan.get(i+2);
                                        if(b.getText().toString().equals(b1.getText().toString())&&b.getText().toString().equals(b2.getText().toString())){
                                            Toast.makeText(MainActivity.this, players.get(turn).getName()+" Wins!", Toast.LENGTH_SHORT).show();
                                            int score = players.get(turn).getScore();
                                            score++;
                                            players.get(turn).setScore(score);
                                            lbScore1.setText(players.get(0).getName()+": "+players.get(0).getScore());
                                            lbScore2.setText(players.get(1).getName()+": "+players.get(1).getScore());
                                            Toast.makeText(MainActivity.this, players.get(turn).getScore()+"", Toast.LENGTH_SHORT).show();
                                            turn = 1;
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "draw", Toast.LENGTH_SHORT).show();
                            limit = 9;
                        }

                        if(turn == 0){
                            turn = 1;
                        }
                        else{
                            turn = 0;
                        }
                    }
                }
            });
        }

    }


//    public void papan_onclick(View view){
//        //cara lain ambil id
//        int btn = view.getId();
//        Button btnTemp = findViewById(btn);
//
//        if(!btnTemp.getText().equals("")){
//            Toast.makeText(this, "sudah terisi", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            btnTemp.setText(players.get(turn).getSimbol());
//
//            if(turn == 0){
//                turn = 1;
//            }
//            else{
//                turn = 0;
//            }
//        }
//    }
}