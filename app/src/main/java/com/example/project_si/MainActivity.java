package com.example.project_si;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView a,b,c,d,e,f,g;

    DatabaseReference reff;

    private Button profiles;

    int waterlvInt;

    String waterlvMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a= findViewById(R.id.tempView);
        b= findViewById(R.id.humView);
        c= findViewById(R.id.soil1View);
        d= findViewById(R.id.soil2View);
        e= findViewById(R.id.soil3View);
        f= findViewById(R.id.lightView);
        g= findViewById(R.id.waterlvView);

        profiles= findViewById(R.id.profiles);
        profiles.setOnClickListener(v -> openProfilesActivity());

        reff= FirebaseDatabase.getInstance().getReference();
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String temp= Objects.requireNonNull(dataSnapshot.child("Temperatura").getValue()).toString();
                a.setText(temp);

                String hum= Objects.requireNonNull(dataSnapshot.child("Umiditate").getValue()).toString();
                b.setText(hum);

                String soil1= Objects.requireNonNull(dataSnapshot.child("UmiditateSolPlanta1").getValue()).toString();
                c.setText(soil1);

                String soil2= Objects.requireNonNull(dataSnapshot.child("UmiditateSolPlanta2").getValue()).toString();
                d.setText(soil2);

                String soil3= Objects.requireNonNull(dataSnapshot.child("UmiditateSolPlanta3").getValue()).toString();
                e.setText(soil3);

                String light= Objects.requireNonNull(dataSnapshot.child("Lumina").getValue()).toString();
                f.setText(light);

                String waterlv= Objects.requireNonNull(dataSnapshot.child("NivelApaRezervor").getValue()).toString();
               /* g.setText(waterlv);*/

                waterlvInt= Integer.parseInt(waterlv);

                if(waterlvInt<690){
                    waterlvMessage="TOO LOW";
                }
                else {
                    waterlvMessage="Normal";
                }

                g.setText(waterlvMessage);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public void openProfilesActivity(){
        Intent intent = new Intent(this,ProfilesActivity.class);
        startActivity(intent);
    }

}