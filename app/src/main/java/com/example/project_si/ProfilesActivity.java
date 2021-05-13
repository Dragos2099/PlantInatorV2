package com.example.project_si;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ProfilesActivity extends AppCompatActivity {

    private Button back;
    private Button plant1;
    private Button plant2;
    private Button plant3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);

        back= findViewById(R.id.backToMainActivity);
        back.setOnClickListener(v -> backToMainActivity());


        plant1= findViewById(R.id.plant1);
        plant1.setOnClickListener(v -> openPlant1Activity());


        plant2= findViewById(R.id.plant2);
        plant2.setOnClickListener(v -> openPlant2Activity());

        plant3= findViewById(R.id.plant3);
        plant3.setOnClickListener(v -> openPlant3Activity());

    }


    public void backToMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void openPlant1Activity(){
        Intent intent = new Intent(this, Plant1Activity.class);
        startActivity(intent);
    }

    public void openPlant2Activity(){
        Intent intent = new Intent(this, Plant2Activity.class);
        startActivity(intent);
    }

    public void openPlant3Activity(){
        Intent intent = new Intent(this, Plant3Activity.class);
        startActivity(intent);
    }

}