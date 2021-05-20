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


    int tempInt;
    int humInt;
    int soil1Int;
    int soil2Int;
    int soil3Int;
    int lightInt;
    int waterlvInt;

    String tempMessage;
    String humMessage;
    String soil1Message;
    String soil2Message;
    String soil3Message;
    String lightMessage;
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

                tempInt=Integer.parseInt(temp);

                if(tempInt>35)
                {
                    tempMessage=temp+" (TOO HIGH)";

                }else if(tempInt > 18){

                    tempMessage=temp+" (Normal)";

                }else {

                    tempMessage=temp+" (TOO LOW)";
                }

                a.setText(tempMessage);

                String hum= Objects.requireNonNull(dataSnapshot.child("Umiditate").getValue()).toString();

                humInt=Integer.parseInt(hum);

                if(humInt>90)
                {
                    humMessage=hum+" (TOO HIGH)";

                }else if(humInt > 35){

                    humMessage=hum+" (Normal)";

                }else{

                    humMessage=hum+" (TOO LOW)";
                }

                b.setText(humMessage);

                String soil1= Objects.requireNonNull(dataSnapshot.child("UmiditateSolPlanta1").getValue()).toString();

                soil1Int=Integer.parseInt(soil1);

                soil1Int/=10;

                soil1Int=70-soil1Int;

                soil1Message=soil1Int+" % (Normal)";

                c.setText(soil1Message);

                String soil2= Objects.requireNonNull(dataSnapshot.child("UmiditateSolPlanta2").getValue()).toString();

                soil2Int=Integer.parseInt(soil2);

                soil2Int/=10;

                soil2Int=70-soil2Int;

                soil2Message=soil2Int+" % (Normal)";

                d.setText(soil2Message);

                String soil3= Objects.requireNonNull(dataSnapshot.child("UmiditateSolPlanta3").getValue()).toString();

                soil3Int=Integer.parseInt(soil3);

                soil3Int/=10;

                soil3Int=70-soil3Int;

                soil3Message=soil3Int+" % (Normal)";

                e.setText(soil3Message);

                String light= Objects.requireNonNull(dataSnapshot.child("Lumina").getValue()).toString();
                f.setText(light);

                String waterlv= Objects.requireNonNull(dataSnapshot.child("NivelApaRezervor").getValue()).toString();

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