package com.belajar.menu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;

public class broker extends AppCompatActivity {

    ArrayList<User> users = new ArrayList<>();
    ArrayList<Property> properties = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broker);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.broker_option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item_proper){
            Intent intent = new Intent(broker.this,MainActivity.class);
            intent.putExtra("users",users);
            intent.putExtra("properties",properties);

            startActivityForResult(intent,100);
        }
        else if(item.getItemId() == R.id.item_logout){
            Intent intent = new Intent(broker.this,MainActivity.class);
            intent.putExtra("users",users);

            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && requestCode == tambahProp.REQUEST_PROP){
            properties = data.getParcelableArrayListExtra("properties");
            users = data.getParcelableArrayListExtra("users");

            loadProp();
        }
    }

    public void loadProp(){
        Button btn1 = findViewById(R.id.btnBarang1);
        Button btn2 = findViewById(R.id.btnBarang2);
        Button btn3 = findViewById(R.id.btnBarang3);
        if(properties.size() == 1){
            btn1.setText(properties.get(0).toString());
            btn2.setText("TIDAK ADA");
            btn3.setText("TIDAK ADA");
        }
        else if(properties.size() == 2){
            btn1.setText(properties.get(0).toString());
            btn2.setText(properties.get(1).toString());
            btn3.setText("TIDAK ADA");
        }
        else if(properties.size() == 3){
            btn1.setText(properties.get(0).toString());
            btn2.setText(properties.get(1).toString());
            btn3.setText(properties.get(2).toString());
        }

    }
}