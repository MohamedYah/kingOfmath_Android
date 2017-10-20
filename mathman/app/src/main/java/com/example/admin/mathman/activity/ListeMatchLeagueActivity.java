package com.example.admin.mathman.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.mathman.R;
import com.example.admin.mathman.RoundImage;
import com.example.admin.mathman.model.InscriptionLeague;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

public class ListeMatchLeagueActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    SharedPreferences pref ;
    SharedPreferences.Editor editor;
    String numeroplayer;

    TextView testConnected;

    String vs1,vs2,vs3,vs4;

    String b1,b2,b3;

    String Iste9belmatch1,Iste9belmatch2,Iste9belmatch3;
    Button match1,match2,match3;
    String loginshared;

    public ListeMatchLeagueActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_match_league);

        match1 = (Button)findViewById(R.id.match1);
        match2 = (Button)findViewById(R.id.match2);
        match3 = (Button)findViewById(R.id.match3);

        testConnected = (TextView)findViewById(R.id.textConnected);

        pref = getApplicationContext().getSharedPreferences("login", MODE_PRIVATE);
        editor = pref.edit();
        loginshared=pref.getString("loginShared", null);



        DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref2,ref3,ref4;
        ref2 = ref1.child("InscriptionLeagues");
        ref2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               int i =0;
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {

                    if(loginshared.equals(String.valueOf(dsp.child("login").getValue()))) {

                        i=1;
                        numeroplayer = String.valueOf(dsp.child("numero").getValue());
                        dsp.getRef().child("Connected").setValue("0");
                        Toast.makeText(getApplicationContext(), numeroplayer, Toast.LENGTH_SHORT).show();
                    }


                    if(String.valueOf(dsp.child("numero").getValue()).equals("1")){
                        vs1 =  (String.valueOf(dsp.child("login").getValue()));
                    }
                    if(String.valueOf(dsp.child("numero").getValue()).equals("2")){
                        vs2 = (String.valueOf(dsp.child("login").getValue()));

                    }if(String.valueOf(dsp.child("numero").getValue()).equals("3")){
                        vs3 = (String.valueOf(dsp.child("login").getValue()));
                    }
                    if(String.valueOf(dsp.child("numero").getValue()).equals("4")){
                        vs4 = (String.valueOf(dsp.child("login").getValue()));
                    }
                }


                if(i==0){


                    Toast.makeText(getApplicationContext(),"you are not registred",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);

                } else if(numeroplayer.equals("1")){

                    Iste9belmatch1 = "1";
                    Iste9belmatch2 = "2";
                    Iste9belmatch3 = "1";

                    b1=vs2;
                    b2=vs4;
                    b3=vs3;

                    match1.setText("match 1 vs "+vs2);
                    match2.setText("match 2 vs "+vs4);
                    match3.setText("match 3 vs "+vs3);


                }else if (numeroplayer.equals("2")){
                    Iste9belmatch1 = "2";
                    Iste9belmatch2 = "1";
                    Iste9belmatch3 = "2";

                    b1=vs1;
                    b2=vs3;
                    b3=vs4;


                    match1.setText("match 1 vs "+vs1);
                    match2.setText("match 2 vs "+vs3);
                    match3.setText("match 3 vs "+vs4);

                }else if (numeroplayer.equals("3")){
                    Iste9belmatch1 = "1";
                    Iste9belmatch2 = "2";
                    Iste9belmatch3 = "2";

                    b1=vs4;
                    b2=vs2;
                    b3=vs1;


                    match1.setText("match 1 vs "+vs4);
                    match2.setText("match 2 vs  "+vs2);
                    match3.setText("match 3 vs  "+vs1);

                }else if (numeroplayer.equals("4")){
                    Iste9belmatch1 = "2";
                    Iste9belmatch2 = "1";
                    Iste9belmatch3 = "2";

                    b1=vs3;
                    b2=vs1;
                    b3=vs2;


                    match1.setText("match 1 vs  "+vs3);
                    match2.setText("match 2 vs "+vs1);
                    match3.setText("match 3 vs  "+vs2);

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });



    }

    public void onClick(View v){
        switch (v.getId()){

            case R.id.match1:
                DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
                DatabaseReference ref2,ref3,ref4;
                ref2 = ref1.child("InscriptionLeagues");
                ref2.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                         if(loginshared.equals(String.valueOf(dsp.child("login").getValue()))){

                             dsp.getRef().child("Connected").setValue("1");
                             Intent i=new Intent(getApplicationContext(),TournoiGameActivity.class);
                             i.putExtra("Iste9belmatch", Iste9belmatch1);
                             i.putExtra("b",b1+"");
                             startActivity(i);

                         }

                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });



                break;
            case R.id.match2:
                DatabaseReference ref1ref= FirebaseDatabase.getInstance().getReference();
                DatabaseReference ref2ref,ref3ref,ref4ref;
                ref2ref = ref1ref.child("InscriptionLeagues");
                ref2ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                            if(loginshared.equals(String.valueOf(dsp.child("login").getValue()))){

                                dsp.getRef().child("Connected").setValue("1");
                                Intent i1=new Intent(getApplicationContext(),TournoiGameActivity.class);
                                i1.putExtra("Iste9belmatch", Iste9belmatch2);
                                i1.putExtra("b",b2+"");
                                startActivity(i1);

                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });


                break;
            case R.id.match3:
               DatabaseReference ref1refref= FirebaseDatabase.getInstance().getReference();
                DatabaseReference ref2refref,ref3refref,ref4refref;
                ref2refref = ref1refref.child("InscriptionLeagues");
                ref2refref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                            if(loginshared.equals(String.valueOf(dsp.child("login").getValue()))){

                                dsp.getRef().child("Connected").setValue("1");

                                Intent i3=new Intent(getApplicationContext(),TournoiGameActivity.class);
                                i3.putExtra("Iste9belmatch", Iste9belmatch3);
                                i3.putExtra("b",b3+"");
                                startActivity(i3);


                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });


                break;
            default:
                break;

        }


    }







}
