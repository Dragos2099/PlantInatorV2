package com.example.project_si;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView a,b,c,d,e,f,g;

    DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a=(TextView)findViewById(R.id.tempView);
        b=(TextView)findViewById(R.id.humView);
        c=(TextView)findViewById(R.id.soil1View);
        d=(TextView)findViewById(R.id.soil2View);
        e=(TextView)findViewById(R.id.soil3View);
        f=(TextView)findViewById(R.id.lightView);
        g=(TextView)findViewById(R.id.waterlvView);
       // btn=(Button)findViewById(R.id.btn);

        reff= FirebaseDatabase.getInstance().getReference();
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String temp=dataSnapshot.child("Temperatura").getValue().toString();
                a.setText(temp);

                String hum=dataSnapshot.child("Umiditate").getValue().toString();
                b.setText(hum);

                String soil1=dataSnapshot.child("UmiditateSolPlanta1").getValue().toString();
                c.setText(soil1);

                String soil2=dataSnapshot.child("UmiditateSolPlanta2").getValue().toString();
                d.setText(soil2);

                String soil3=dataSnapshot.child("UmiditateSolPlanta3").getValue().toString();
                e.setText(soil3);

                String light=dataSnapshot.child("Lumina").getValue().toString();
                f.setText(light);

                String waterlv=dataSnapshot.child("NivelApaRezervor").getValue().toString();
                g.setText(waterlv);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}