package com.example.admin.mathman.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.mathman.R;
import com.example.admin.mathman.RoundImage;
import com.example.admin.mathman.helper.DBHelper;
import com.example.admin.mathman.model.InscriptionLeague;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    ImageView imgProfil;
    Bitmap bm;
    RoundImage roundedImage;
    TextView NomProfil,ScoreTotal;

    int scorevalue;
    DBHelper db;

    SharedPreferences pref ;
    SharedPreferences.Editor editor;

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);


        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        myRef = database.getInstance().getReference();




        scorevalue = db.Score(1, "Addition") + db.Score(2, "Addition") + db.Score(3, "Addition")
                + db.Score(4, "Addition") + db.Score(5, "Addition") + db.Score(6, "Addition")
                + db.Score(7, "Addition") + db.Score(8, "Addition") + db.Score(9, "Addition") + db.Score(10, "Addition")
                + db.Score(1, "soustraction") + db.Score(2, "soustraction") + db.Score(3, "soustraction")
                + db.Score(4, "soustraction") + db.Score(5, "soustraction") + db.Score(6, "soustraction")
                + db.Score(7, "soustraction") + db.Score(8, "soustraction") + db.Score(9, "soustraction") + db.Score(10, "soustraction")
                + db.Score(1, "multiplication") + db.Score(2, "multiplication") + db.Score(3, "multiplication")
                + db.Score(4, "multiplication") + db.Score(5, "multiplication") + db.Score(6, "multiplication")
                + db.Score(7, "multiplication") + db.Score(8, "multiplication") + db.Score(9, "multiplication") + db.Score(10, "multiplication")
                + db.Score(1, "division") + db.Score(2, "division") + db.Score(3, "division")
                + db.Score(4, "division") + db.Score(5, "division") + db.Score(6, "division")
                + db.Score(7, "division") + db.Score(8, "division") + db.Score(9, "division")
                + db.Score(10, "division") + db.Score(0, "quizz") + db.Score(1, "quizz") + db.Score(2, "quizz") + db.Score(3, "quizz")
                + db.Score(4, "quizz") + db.Score(5, "quizz") + db.Score(6, "quizz");


        pref = getApplicationContext().getSharedPreferences("login", MODE_PRIVATE);
        editor = pref.edit();

        NomProfil =(TextView) findViewById(R.id.NomProfil);
        ScoreTotal =(TextView) findViewById(R.id.ScoreTotal);
        imgProfil = (ImageView) findViewById(R.id.imgProfil);

        String loginshared=pref.getString("loginShared", null);

        if(loginshared != null){
            NomProfil.setText(loginshared);

        }

        DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref2,ref3,ref4;
        ref2 = ref1.child("registres");
        ref2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    //String s = String.valueOf(dsp.getValue());
                    String s = String.valueOf(dsp.child("login").getValue());
                    if(NomProfil.getText().toString().equals(s)){


                       if(scorevalue >Integer.parseInt(String.valueOf(dsp.child("score").getValue())) ) {
                           dsp.getRef().child("score").setValue(scorevalue);


                        }

                        ScoreTotal.setText(String.valueOf(dsp.child("score").getValue())+"pts");

                        if(String.valueOf(dsp.child("hero").getValue()).equals("1")){
                            bm = BitmapFactory.decodeResource(getResources(), R.drawable.player1);

                            roundedImage = new RoundImage(bm);
                            imgProfil.setImageDrawable(roundedImage);
                        }
                        else if(String.valueOf(dsp.child("hero").getValue()).equals("2")){
                            bm = BitmapFactory.decodeResource(getResources(), R.drawable.player2);

                            roundedImage = new RoundImage(bm);
                            imgProfil.setImageDrawable(roundedImage);
                        }
                        else if(String.valueOf(dsp.child("hero").getValue()).equals("3")){
                            bm = BitmapFactory.decodeResource(getResources(), R.drawable.player3);

                            roundedImage = new RoundImage(bm);
                            imgProfil.setImageDrawable(roundedImage);
                        }
                        else if(String.valueOf(dsp.child("hero").getValue()).equals("4")){
                            bm = BitmapFactory.decodeResource(getResources(), R.drawable.player4);

                            roundedImage = new RoundImage(bm);
                            imgProfil.setImageDrawable(roundedImage);
                        }



                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
 public void onClick(View v){
     switch (v.getId()){
            case R.id.tutorial:
               final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.customtutorial);
                dialog.setTitle("Training");
                Button dialogButton = (Button) dialog.findViewById(R.id.exit);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                Button dialogButtonTutorial = (Button) dialog.findViewById(R.id.tutorial);
                dialogButtonTutorial.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Tutorial_Activity.class);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
                Button dialogButtonQuiz = (Button) dialog.findViewById(R.id.quiz);
                dialogButtonQuiz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent(MainActivity.this, ListquizActivity.class);
                        startActivity(intent2);
                        dialog.dismiss();
                    }
                });

                Button dialogButtonAdventure = (Button) dialog.findViewById(R.id.adventure);
                dialogButtonAdventure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentAventure = new Intent(MainActivity.this, AdventureActivity.class);
                        startActivity(intentAventure);
                        finish();
                        System.exit(0);
                        dialog.dismiss();
                    }
                });
                Button dialoglocal = (Button) dialog.findViewById(R.id.local);
                dialoglocal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentAventure = new Intent(MainActivity.this, MultiplayerLocalActivity.class);
                        startActivity(intentAventure);
                        finish();
                        System.exit(0);
                        dialog.dismiss();
                    }
                });

                dialog.show();
                break;

            case R.id.adventure:

                final Dialog dialogAdventure = new Dialog(this);
                dialogAdventure.setContentView(R.layout.customleague);
                dialogAdventure.setTitle("league");
                Button dialogButtonExitAdventure = (Button) dialogAdventure.findViewById(R.id.exit);
                dialogButtonExitAdventure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogAdventure.dismiss();
                    }
                });
                Button dialogButtonRegistrationAdventure = (Button) dialogAdventure.findViewById(R.id.REGISTRATION);
                dialogButtonRegistrationAdventure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(executeCmd("ping -c 1 -w 1 google.com", false).equals("")){
                            Toast.makeText(getApplicationContext(),"check your internet connection!",Toast.LENGTH_LONG).show();
                        }else {

                            DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
                            DatabaseReference ref2,ref3,ref4;
                            ref2 = ref1.child("InscriptionLeagues");


                            ref2.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    int Test= 0;
                                    int count= 0;
                                    for (DataSnapshot dsp : dataSnapshot.getChildren()) {

                                        count = count +1;

                                        String s = String.valueOf(dsp.child("login").getValue());
                                        if(NomProfil.getText().toString().equals(s)){
                                            Test = 1;
                                        }
                                    }

                                    if(Test == 1){
                                        Toast.makeText(getApplicationContext(),"You are already registered",Toast.LENGTH_SHORT).show();
                                    }else if(count == 4){
                                        Toast.makeText(getApplicationContext(),"not available",Toast.LENGTH_SHORT).show();
                                    }else{

                                        InscriptionLeague inscriptionLeague = new InscriptionLeague(NomProfil.getText().toString(),(count+1)+"","0","0");
                                        myRef.child("InscriptionLeagues").child(NomProfil.getText().toString()).setValue(inscriptionLeague);
                                        Toast.makeText(getApplicationContext(),"inscription success",Toast.LENGTH_SHORT).show();
                                    }

                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });

                        }

                    }
                });
                Button dialogButtonMatchAdventure = (Button) dialogAdventure.findViewById(R.id.MATCH);
                dialogButtonMatchAdventure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intentListematch = new Intent(MainActivity.this, ListeMatchLeagueActivity.class);
                        startActivity(intentListematch);

                    }
                });
                Button dialogButtonRankingAdventure = (Button) dialogAdventure.findViewById(R.id.RANKING);
                dialogButtonRankingAdventure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                Button dialogButtonCalenderAdventure = (Button) dialogAdventure.findViewById(R.id.CALENDAR);
                dialogButtonCalenderAdventure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                dialogAdventure.show();

                break;

            case R.id.tournoi:

                final Dialog dialogTournoi = new Dialog(this);
                dialogTournoi.setContentView(R.layout.customtournoi);
                dialogTournoi.setTitle("tournament");
                Button dialogButtontournoiexit = (Button) dialogTournoi.findViewById(R.id.exit);
                dialogButtontournoiexit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogTournoi.dismiss();
                    }
                });
                Button dialogButtoncreateroom = (Button) dialogTournoi.findViewById(R.id.play);
                dialogButtoncreateroom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent(MainActivity.this, TournoiGroupActivity.class);
                        startActivity(intent2);
                        dialogTournoi.dismiss();
                    }
                });
                Button dialogButtonjoinroom = (Button) dialogTournoi.findViewById(R.id.registration);
                dialogButtonjoinroom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                dialogTournoi.show();
                break;
         case R.id.logout:

             editor.clear();
             editor.commit();
             Intent intentLougout = new Intent(MainActivity.this,LoginActivity.class);
             startActivity(intentLougout);

             break;
            case R.id.Leaderboard:
                    Intent intent = new Intent(MainActivity.this, LeaderBoardActivity.class);
                    startActivity(intent);
                break;
         case R.id.statistics:
             Intent intentStatistique = new Intent(MainActivity.this, StatisticActivity.class);
             startActivity(intentStatistique);
             break;
         default:
                break;

        }





    }


    public static String executeCmd(String cmd, boolean sudo){
        try {

            Process p;
            if(!sudo)
                p= Runtime.getRuntime().exec(cmd);
            else{
                p= Runtime.getRuntime().exec(new String[]{"su", "-c", cmd});
            }
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String s;
            String res = "";
            while ((s = stdInput.readLine()) != null) {
                res += s + "\n";
            }
            p.destroy();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }

}
