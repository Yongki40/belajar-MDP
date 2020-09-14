package com.latihan.tugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Button> papans;
    Pin pin;
    boolean start;
    ArrayList<Button> steps;
    int winCtr = 25-17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = false;
        papans = new ArrayList<>();
        steps = new ArrayList<>();
        pin = new Pin("def","def", -1);

        LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1);
        init(layout1);
        LinearLayout layout2 = (LinearLayout) findViewById(R.id.layout2);
        init(layout2);
        LinearLayout layout3 = (LinearLayout) findViewById(R.id.layout3);
        init(layout3);
        LinearLayout layout4 = (LinearLayout) findViewById(R.id.layout4);
        init(layout4);
        LinearLayout layout5 = (LinearLayout) findViewById(R.id.layout5);
        init(layout5);

        for (final Button btn:
             papans) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button btnActive = (Button) view;
                    if(!start){
                        start = true;
                        startGame();
                    }
                    else{
                        if(winCtr == 0){
                            Toast.makeText(MainActivity.this, "YOU WIN", Toast.LENGTH_LONG).show();
                            Button b = findViewById(R.id.btnRestart);
                            b.setText("Play Again");
                            start = false;
                        }
                        int index_active =-1;
                        index_active =papans.indexOf(btnActive);
                        if(!btnActive.getText().toString().equals("") && pin.getSimbol().equals("def")){
                            setPin(btnActive);
                        }
                        else if(btnActive.getText().toString().equals(pin.getSimbol())){
                            pin = new Pin("def","def",-1);
                        }
                        else if(!btnActive.getText().toString().equals("") && !pin.getSimbol().equals("def")){
                            for (Button value :
                                    steps) {
                                value.setBackgroundColor(Color.parseColor("#D6D6D6"));
                            }
                            steps.clear();
                            setPin(btnActive);
                        }
                        else if(btnActive.getText().toString().equals("") && !pin.getSimbol().equals("def")){
                            int last_visit = pin.getLast_visit();
                            if(last_visit <5){
                                if(index_active == 0){
                                    if(index_active== last_visit+1 || index_active== last_visit+5){
                                        createNewStep(btnActive);
                                    }
                                    else{
                                        Toast.makeText(MainActivity.this, "Hanya boleh sebelah terakhir", Toast.LENGTH_LONG).show();
                                    }
                                }
                                else if(index_active >0){
                                    if(index_active == last_visit+5 || index_active == last_visit+1 || index_active == last_visit-1){
                                        createNewStep(btnActive);
                                    }
                                    else{
                                        Toast.makeText(MainActivity.this, "Hanya boleh sebelah terakhir", Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                            else if(last_visit >19){
                                if(index_active == 24){
                                    if(index_active== last_visit-1 || index_active== last_visit-5){
                                        createNewStep(btnActive);
                                    }
                                    else{
                                        Toast.makeText(MainActivity.this, "Hanya boleh sebelah terakhir", Toast.LENGTH_LONG).show();
                                    }
                                }
                                else if(index_active <24){
                                    if(index_active == last_visit-5 || index_active == last_visit+1 || index_active == last_visit-1){
                                        createNewStep(btnActive);
                                    }
                                    else{
                                        Toast.makeText(MainActivity.this, "Hanya boleh sebelah terakhir", Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                            else{
                                if(index_active == last_visit+5||index_active == last_visit-5 || index_active == last_visit+1 || index_active == last_visit-1){
                                    createNewStep(btnActive);
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "Hanya boleh sebelah terakhir", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    }

                }
            });
        }
    }

    public void createNewStep(Button btnActive){
        steps.add(btnActive);
        int index =papans.indexOf(btnActive);
        pin.setLast_visit(index);
        btnActive.setBackgroundColor(Color.parseColor(pin.getColor()));
    }

    public void setPin(Button btnActive){
        int index = papans.indexOf(btnActive);
        if(btnActive.getText().toString().equals("Y")){
            pin = new Pin("Y","#FDFF03",index);
        }
        else if(btnActive.getText().toString().equals("G")){
            pin = new Pin("G","#0AF806",index);
        }
        else if(btnActive.getText().toString().equals("R")){
            pin = new Pin("R","#F90200",index);
        }
        else if(btnActive.getText().toString().equals("B")){
            pin = new Pin("B","#02FEFF",index);
        }

        winCtr--;
    }

    int type;
    public void startGame(){
        Random rand = new Random();
        type = rand.nextInt(3)+1;
        if(type == 1){
            int[] indexs = {0,12,1,4,6,17,7,24};
            loadPapan(indexs);
        }
        else if(type == 2){
            //y,g,r,b
            int[] indexs = {2,21,12,16,3,22,6,17};
            loadPapan(indexs);
        }
        else{
            int[] indexs = {1,12,16,24,0,23,8,11};
            loadPapan(indexs);
        }
    }

    public void init(LinearLayout layout){
        for (int i = 0; i < layout.getChildCount(); i++) {
            View v = layout.getChildAt(i);
            if(v instanceof Button){
                if(v.getId() != R.id.btnRestart){
                    papans.add((Button) v);
                }
            }
        }
    }

    public void loadPapan(int[] indexs){
        papans.get(indexs[0]).setText("Y");
        papans.get(indexs[0]).setBackgroundColor(Color.parseColor("#FDFF03"));
        papans.get(indexs[1]).setText("Y");
        papans.get(indexs[1]).setBackgroundColor(Color.parseColor("#FDFF03"));

        papans.get(indexs[2]).setText("G");
        papans.get(indexs[2]).setBackgroundColor(Color.parseColor("#0AF806"));
        papans.get(indexs[3]).setText("G");
        papans.get(indexs[3]).setBackgroundColor(Color.parseColor("#0AF806"));

        papans.get(indexs[4]).setText("R");
        papans.get(indexs[4]).setBackgroundColor(Color.parseColor("#F90200"));
        papans.get(indexs[5]).setText("R");
        papans.get(indexs[5]).setBackgroundColor(Color.parseColor("#F90200"));

        papans.get(indexs[6]).setText("B");
        papans.get(indexs[6]).setBackgroundColor(Color.parseColor("#02FEFF"));
        papans.get(indexs[7]).setText("B");
        papans.get(indexs[7]).setBackgroundColor(Color.parseColor("#02FEFF"));
    }


    public void restart_onClik(View view) {
        for (Button value :
                papans) {
            value.setText("");
            value.setBackgroundColor(Color.parseColor("#D7D7D7"));
        }
        start = true;
        papans = new ArrayList<>();
        steps = new ArrayList<>();
        pin = new Pin("def","def",-1);

        LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1);
        init(layout1);
        LinearLayout layout2 = (LinearLayout) findViewById(R.id.layout2);
        init(layout2);
        LinearLayout layout3 = (LinearLayout) findViewById(R.id.layout3);
        init(layout3);
        LinearLayout layout4 = (LinearLayout) findViewById(R.id.layout4);
        init(layout4);
        LinearLayout layout5 = (LinearLayout) findViewById(R.id.layout5);
        init(layout5);

        startGame();
    }
}