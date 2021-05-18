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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Plant2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button back;

    private Button saveButton;

    private DatabaseReference databaseReference;

    private String choice;

    private Spinner spinner;

    Member member;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant2);

        back= findViewById(R.id.backToProfiles2);
        back.setOnClickListener(v -> backToProfiles());

        spinner = findViewById(R.id.spinner2);


        List<String> categories2 = new ArrayList<>();

        categories2.add(0,"Choose your plant here");
        categories2.add("Cactus");
        categories2.add("Orchid");
        categories2.add("Carnivorous Plant");

        saveButton=findViewById(R.id.saveButton2);

        FirebaseDatabase database=FirebaseDatabase.getInstance();

        databaseReference = database.getReference("Plant2_Type");

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,categories2);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        member=new Member();

        saveButton.setOnClickListener(v -> saveValue(choice));

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
            choice=spinner.getSelectedItem().toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


    void saveValue(String choice){
        if(choice.equals("Choose your plant here")){
            Toast.makeText(this,"Please select a plant type",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            member.setPlantType(choice);
            databaseReference.setValue(choice);
            Toast.makeText(this,"Value saved !",Toast.LENGTH_SHORT).show();
        }
    }

}

