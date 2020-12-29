package com.belajar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvNormal;

    ArrayList<Task> tasksNormal = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getIntent().getExtras()!= null){
            tasksNormal = getIntent().getParcelableArrayListExtra("tasksNormal");
//            taskPenting = getIntent().getParcelableArrayListExtra("taskPenting");
        }

        rvNormal = findViewById(R.id.rvNormal);

        showGridView("normal");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_main,menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item_add){
            Intent intent = new Intent(getApplicationContext(),addTask.class);
            intent.putExtra("tasksNormal", tasksNormal);
//            intent.putExtra("taskPenting", taskPenting);
            startActivityForResult(intent,100);
        }
        return super.onOptionsItemSelected(item);
    }

    public void btnClick(View view) {
        if(view.getId() == R.id.btnSelesai){
//            for (int i = 0; i < tasksNormal.size(); i++) {
//                if(tasksNormal.get(i).isDone){
//                    taskDone.add(tasksNormal.get(i));
//                    tasksNormal.remove(i);
//                }
//            }
            showGridView("selesai");
        }
        else if(view.getId() == R.id.btnPenting){
            showGridView("penting");
        }
        else{
            showGridView("normal");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            tasksNormal = data.getParcelableArrayListExtra("tasksNormal");
//            taskPenting = data.getParcelableArrayListExtra("taskPenting");
            showGridView("normal");
        }
    }

    public void showGridView(String mode){
        rvNormal.setLayoutManager(new LinearLayoutManager(this));
        TaskAdapter taskAdapter = new TaskAdapter(tasksNormal,this,mode);


        rvNormal.setAdapter(taskAdapter);
    }
}