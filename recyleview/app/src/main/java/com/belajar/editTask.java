package com.belajar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class editTask extends AppCompatActivity {

    ArrayList<Task> tasks = new ArrayList<>();
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        tasks = getIntent().getParcelableArrayListExtra("tasks");
        index = getIntent().getIntExtra("index",0);
    }

    public void btnClick(View view) {
        EditText edNama = findViewById(R.id.edNama);

        tasks.get(index).nama = edNama.getText().toString();

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("tasksNormal",tasks);
        startActivity(intent);
        finish();
    }
}