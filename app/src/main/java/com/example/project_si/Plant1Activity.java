package com.example.project_si;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Plant1Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant1);

        back= findViewById(R.id.backToProfiles1);
        back.setOnClickListener(v -> backToProfiles());

        Spinner spinner = findViewById(R.id.spinner1);


        List<String> categories = new ArrayList<>();

        categories.add(0,"Choose your plant here");
        categories.add("Cactus");
        categories.add("Orchid");
        categories.add("Carnivorous Plant");


        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void backToProfiles(){
        Intent intent = new Intent(this,ProfilesActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getItemAtPosition(position).equals("Choose your plant here")){
            //nothing
        }
        else{

            String text = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}