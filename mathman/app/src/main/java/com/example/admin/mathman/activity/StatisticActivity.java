package com.example.admin.mathman.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.mathman.CircleTransform;
import com.example.admin.mathman.R;
import com.example.admin.mathman.RoundImage;
import com.example.admin.mathman.helper.DBHelper;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class StatisticActivity extends AppCompatActivity {
    TextView nomProfil,scoreadventure,scorequiz,scoreTotale;
    ImageView imgProfil;

    RoundImage roundedImage;
    Bitmap bm;
    DBHelper db;

    int scoreQuiz,scoreAdventure,scoreLeaque,scoreTournoi;


    SharedPreferences pref ;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_statistic);
        nomProfil = (TextView)findViewById(R.id.NomProfil);
        scoreadventure = (TextView)findViewById(R.id.scoreAdventure);
        scorequiz = (TextView)findViewById(R.id.scoreQuiz);
        scoreTotale = (TextView)findViewById(R.id.scoreTotal);
        imgProfil = (ImageView)findViewById(R.id.ProfilPhoto);

        db = new DBHelper(this);



        scoreQuiz =  db.Score(0, "quizz") + db.Score(1, "quizz") + db.Score(2, "quizz") + db.Score(3, "quizz")
                + db.Score(4, "quizz") + db.Score(5, "quizz") + db.Score(6, "quizz");

        scoreAdventure = db.Score(1, "Addition") + db.Score(2, "Addition") + db.Score(3, "Addition")
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
                + db.Score(10, "division") ;

        scoreadventure.setText("Adventure score = "+scoreAdventure+" pts");
        scorequiz.setText("Quiz score = "+scoreQuiz+" pts");




        pref = getApplicationContext().getSharedPreferences("login", MODE_PRIVATE);
        editor = pref.edit();

        String loginshared=pref.getString("loginShared", null);

        if(loginshared != null){
            nomProfil.setText(loginshared);

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
                    if(nomProfil.getText().toString().equals(s)){

                        scoreTotale.setText("Total score = "+String.valueOf(dsp.child("score").getValue())+" pts");

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








}
