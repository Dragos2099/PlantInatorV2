package com.example.project_si;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Plant2Activity extends AppCompatActivity {

    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant2);

        back= findViewById(R.id.backToProfiles2);
        back.setOnClickListener(v -> backToProfiles());
    }

    public void backToProfiles(){
        Intent intent = new Intent(this,ProfilesActivity.class);
        startActivity(intent);
    }

}