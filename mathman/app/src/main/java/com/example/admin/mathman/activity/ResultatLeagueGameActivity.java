package com.example.admin.mathman.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.mathman.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Timer;
import java.util.TimerTask;

public class ResultatLeagueGameActivity extends AppCompatActivity {

    String b,Iste9belmatch;
    int Score;
    String loginshared;
    SharedPreferences pref ;
    SharedPreferences.Editor editor;
   String resultat;

    TextView textViewResultat ;
    Button buttonReturn;

    int iClicks=7;
    int value;

    int scoreFirebase=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_league_game);
        Intent intent = getIntent();
        Iste9belmatch = intent.getStringExtra("Iste9belmatch");
        Score = Integer.parseInt(intent.getStringExtra("score"));
        b = intent.getStringExtra("b");
        loginshared = intent.getStringExtra("loginshared");

        textViewResultat = (TextView)findViewById(R.id.resultat);




        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (iClicks > 0) {

                            iClicks = iClicks - 1;
                        }else {
                            if(Iste9belmatch.equals("2")) {
                                textViewResultat.setText("");

                                DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference();
                                ref2.child("quizTournoi").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {

                                            value = (Integer.parseInt(String.valueOf(dsp.child("scoreplayer1").getValue())));


                                            if (Score > value) {
                                                resultat = "winner";


                                            } else if (Score < value) {
                                                resultat = "looser";
                                            } else if (Score == value) {
                                                resultat = "draw";
                                            }

                                        }
                                        textViewResultat.setText(resultat);

                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                    }
                                });

                            }else if (Iste9belmatch.equals("1")) {
                                textViewResultat.setText("");

                                DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference();
                                ref2.child("quizTournoi").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {


                                            value = (Integer.parseInt(String.valueOf(dsp.child("scoreplayer2").getValue())));
                                            //Toast.makeText(getApplicationContext(),((String.valueOf(dsp.child("scoreplayer2").getValue()))),Toast.LENGTH_LONG).show();

                                            if (Score > value) {
                                                resultat = "winner";

                                            } else if (Score < value) {
                                                resultat = "looser";
                                            } else if (Score == value) {
                                                resultat = "draw";
                                            }

                                        }
                                        textViewResultat.setText(resultat);

                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                    }
                                });

                            }



                        }
                    }
                });

            }
        }, 0, 1000);



        buttonReturn = (Button)findViewById(R.id.bResultat);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);

            }
        });










    }
}
