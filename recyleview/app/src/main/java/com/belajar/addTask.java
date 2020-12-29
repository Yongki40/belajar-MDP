package com.belajar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class addTask extends AppCompatActivity {

    ArrayList<Task> tasksNormal = new ArrayList<>();
//    ArrayList<Task> taskPenting = new ArrayList<>();
    Spinner spJenis;
    String[] jenis = {
            "olahraga",
            "makanan",
            "belajar"
    };
    ArrayAdapter spinnerAdater;
    String jenisTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        tasksNormal = getIntent().getParcelableArrayListExtra("tasksNormal");
//        taskPenting = getIntent().getParcelableArrayListExtra("taskPenting");

        spJenis = findViewById(R.id.spKategori);
        spinnerAdater = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,jenis);
        spJenis.setAdapter(spinnerAdater);

        spJenis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                jenisTask = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }



    public void btnClick(View view) {

        EditText tvname = findViewById(R.id.edTask);
        Toast.makeText(this, "jenis: "+jenisTask, Toast.LENGTH_SHORT).show();
        RadioButton rd = findViewById(R.id.rdNormal);

        String status = rd.isChecked() ? "Normal" : "Penting";

//        if(status.equals("Normal")){
//
//        }
        tasksNormal.add(new Task(tvname.getText().toString(),status,jenisTask));
        Intent intent = new Intent();
        intent.putExtra("tasksNormal",tasksNormal);
//        intent.putExtra("taskPenting",taskPenting);
        setResult(100,intent);
        finish();
    }
}