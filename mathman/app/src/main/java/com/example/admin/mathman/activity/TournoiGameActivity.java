package com.example.admin.mathman.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.mathman.R;
import com.example.admin.mathman.model.InscriptionLeague;
import com.example.admin.mathman.model.QuizTournoi;
import com.example.admin.mathman.model.Registre;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.Inet4Address;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TournoiGameActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    private int positionOfAns;

    String resultat;

    String questionFirbase;
    TextView question, scoreA,timer1;
    SharedPreferences pref ;
    SharedPreferences.Editor editor;
    String loginshared;
    String b;
    String Iste9belmatch;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    String Anser1,Anser2,Anser3,Anser4,correctAnser,ques;
    int Score = 0;
    int iClicks;
    int marabark = 0;

    int numberQuestion =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournoi_game);

        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        myRef = database.getInstance().getReference();



        iClicks=40;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (iClicks > 0) {

                            iClicks = iClicks - 1;
                            timer1.setText(String.valueOf(iClicks));
                        }else {
                            DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
                            if(Iste9belmatch.equals("1")){

                                ref1.child("quizTournoi").child(loginshared+""+b).child("next"+Iste9belmatch).setValue("1");

                            }if(Iste9belmatch.equals("2")){
                                ref1.child("quizTournoi").child(b+""+loginshared).child("next"+Iste9belmatch).setValue("1");

                            }


                        }
                    }
                });

            }
        }, 0, 1000);

        b1=(Button)findViewById(R.id.Button1);
        b2=(Button)findViewById(R.id.Button2);
        b3=(Button)findViewById(R.id.Button3);
        b4=(Button)findViewById(R.id.Button4);
        question=(TextView)findViewById(R.id.result);
        timer1=(TextView)findViewById(R.id.timer);
        scoreA = (TextView)findViewById(R.id.score);
        scoreA.setText("score = "+Score);
        pref = getApplicationContext().getSharedPreferences("login", MODE_PRIVATE);
        editor = pref.edit();

        if(pref.getString("loginShared", null)!=null){
           loginshared=pref.getString("loginShared", null);
       }

        Intent intent = getIntent();
         Iste9belmatch = intent.getStringExtra("Iste9belmatch");
         b = intent.getStringExtra("b");

        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("wait...")
                .setMessage("wait player "+b+" connected").create();

        DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
        ref1.child("InscriptionLeagues").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                int i=0;
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    if(b.equals(String.valueOf(dsp.child("login").getValue()))){
                        if(String.valueOf(dsp.child("Connected").getValue()).equals("0")){
                            i=0;
                        }else{
                            i=1;
                        }
                }
                }

                if (i==0) {
                    try {
                        alertDialog.show();
                    }catch (Exception e){

                    }
                }else{
                    try {
                        iClicks=40;
                        alertDialog.dismiss();
                    }catch (Exception e){

                    }

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

       if((Iste9belmatch.equals("1")) && (marabark == 0)){
            marabark = 1;

            QuizTournoi quizTournoi = new QuizTournoi(loginshared,b,"","","",""
                    ,"","","0","0","","");
            myRef.child("quizTournoi").child(loginshared+""+b).setValue(quizTournoi);

            beginGame();


        }

        setquiz();
        setNextquestion();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b1.getText().toString().equals(correctAnser)){
                    Score = Score +iClicks;
                    scoreA.setText("score = "+Score);
                }
                iClicks=0;
                setNext();


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b2.getText().toString().equals(correctAnser)){
                    Score = Score + iClicks;
                    scoreA.setText("score = "+Score);
                }
                iClicks=0;
                setNext();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b3.getText().toString().equals(correctAnser)){
                    Score = Score +iClicks;
                    scoreA.setText("score = "+Score);
                }
                iClicks=0;
                setNext();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b4.getText().toString().equals(correctAnser)){
                    Score = Score +iClicks;
                    scoreA.setText("score = "+Score);
                }
                iClicks=0;
                setNext();

            }
        });



    }

    @Override
    protected void onStop() {
       DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref2,ref3,ref4;
        ref2 = ref1.child("InscriptionLeagues");
        ref2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    if(loginshared.equals(String.valueOf(dsp.child("login").getValue()))){

                        dsp.getRef().child("Connected").setValue("0");

                    }
                }


            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


        super.onStop();

    }
    @Override
    protected void onDestroy() {

      DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref2,ref3,ref4;
        ref2 = ref1.child("InscriptionLeagues");
        ref2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    if(loginshared.equals(String.valueOf(dsp.child("login").getValue()))){

                    }
                }


            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        super.onDestroy();
    }
    private  void beginGame(){



            questionFirbase = "";

            int begin;
            Random r = new Random();
            begin = r.nextInt(4);
            if(begin==0){
                beginGameBasics();
            }else  if (begin==1){

                beginGameDivision();
            }else  if (begin==2){

                beginGameMultiplication();
            }else  if (begin==3){

                beginGamelinerty();

            }}
    private  void beginGameBasics() {

        int min = 10;
        int max = 30;
        int min1 = 0;
        int max1 = 10;
        int intEq1;
        int intEq2;
        Random r = new Random();
        int answer;
        intEq1 = r.nextInt(max - min + 1) + min;
        intEq2 = r.nextInt(max - min + 1) + min;
        int operation;
        operation = r.nextInt(2);
        if(operation==0){
            answer=intEq1+intEq2;
            questionFirbase = intEq1 + " + " + intEq2;
            setAnswers(max, min, min1, max1, answer);
        }
        if(operation==1){
            answer=intEq1-intEq2;
            questionFirbase = intEq1 + " - " + intEq2;
            setAnswers(max, min, min1, max1, answer);

        }

    }
    private  void beginGamelinerty(){
        int min = 1;
        int max = 10;
        int min1 = 0;
        int max1 = 5;

        int bb,x;
        int a1,b,c;
        Random r = new Random();
        int answer;
        a1 = r.nextInt(9) +1;
        b = r.nextInt(20) +5;
        bb=a1*(r.nextInt(4) +1);
        c=b-bb;
        if(c>=0){
            questionFirbase = ""+a1+"x +"+c+" = "+b;


        }else if (c<0){
            questionFirbase = ""+a1+"x "+c+" = "+b;
        }

        answer=((b-c)/a1);
        setAnswers(min, max, min1, max1, answer);

    }
    private  void beginGameDivision() {

        int min = 10;
        int max = 30;
        int min1 = 0;
        int max1 = 10;
        int intEq1;
        int intEq2;
        Random r = new Random();
        int answer;

        intEq2 = r.nextInt(max - min + 1) + min;
        intEq1 = intEq2*(r.nextInt(4)+1);
        answer = intEq1 / intEq2 ;
        questionFirbase = intEq1 + " / " + intEq2;
        setAnswers(max, min, min1, max1, answer);
    }
    private  void beginGameMultiplication() {

        int min = 10;
        int max = 50;
        int min1 = 0;
        int max1 = 10;
        int intEq1;
        int intEq2;
        Random r = new Random();
        int answer;
        intEq1 = r.nextInt(max - min + 1) + min;
        intEq2 = r.nextInt(max - min + 1) + min;
        answer=intEq1*intEq2;
        questionFirbase = intEq1 + " * " + intEq2;
        setAnswers(max, min, min1, max1, answer);
    }
    private  void setAnswers(int max, int min, int min1, int max1, final int answer) {

        Random r = new Random();
        positionOfAns = r.nextInt(3 - 0 + 1) + 0;
        int[] excluded = new int[4];
        excluded[0] = answer;

        final int fakeAnsOne = getRandomWithExclusion(r,answer+min1,answer+max1,excluded);
        excluded[1] = fakeAnsOne;
        final int fakeAnsTwo = getRandomWithExclusion(r,answer+min1,answer+max1,excluded);
        excluded[2] = fakeAnsTwo;
        final int fakeAnsThree = getRandomWithExclusion(r, answer + min1, answer + max1, excluded);
        excluded[3] = fakeAnsThree;


        if(positionOfAns == 0)  {
            DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
            ref1.child("quizTournoi").child(loginshared+""+b).child("Anser1").setValue(""+answer);
            ref1.child("quizTournoi").child(loginshared+""+b).child("Anser2").setValue(""+fakeAnsOne);
            ref1.child("quizTournoi").child(loginshared+""+b).child("Anser3").setValue(""+fakeAnsTwo);
            ref1.child("quizTournoi").child(loginshared+""+b).child("Anser4").setValue(""+fakeAnsThree);
            ref1.child("quizTournoi").child(loginshared+""+b).child("question").setValue(questionFirbase);
            ref1.child("quizTournoi").child(loginshared+""+b).child("CorrectAnser").setValue(""+answer);

        } else if (positionOfAns == 1) {

            DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
            ref1.child("quizTournoi").child(loginshared+""+b).child("Anser1").setValue(""+fakeAnsOne);
            ref1.child("quizTournoi").child(loginshared+""+b).child("Anser2").setValue(""+answer);
            ref1.child("quizTournoi").child(loginshared+""+b).child("Anser3").setValue(""+fakeAnsTwo);
            ref1.child("quizTournoi").child(loginshared+""+b).child("Anser4").setValue(""+fakeAnsThree);
            ref1.child("quizTournoi").child(loginshared+""+b).child("question").setValue(questionFirbase);
            ref1.child("quizTournoi").child(loginshared+""+b).child("CorrectAnser").setValue(""+answer);

        } else if (positionOfAns == 2) {

            DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
            ref1.child("quizTournoi").child(loginshared+""+b).child("Anser1").setValue(""+fakeAnsOne);
            ref1.child("quizTournoi").child(loginshared+""+b).child("Anser2").setValue(""+fakeAnsTwo);
            ref1.child("quizTournoi").child(loginshared+""+b).child("Anser3").setValue(""+answer);
            ref1.child("quizTournoi").child(loginshared+""+b).child("Anser4").setValue(""+fakeAnsThree);
            ref1.child("quizTournoi").child(loginshared+""+b).child("question").setValue(questionFirbase);
            ref1.child("quizTournoi").child(loginshared+""+b).child("CorrectAnser").setValue(""+answer);
        } else if (positionOfAns == 3) {
            DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
            ref1.child("quizTournoi").child(loginshared+""+b).child("Anser1").setValue(""+fakeAnsOne);
            ref1.child("quizTournoi").child(loginshared+""+b).child("Anser2").setValue(""+fakeAnsTwo);
            ref1.child("quizTournoi").child(loginshared+""+b).child("Anser3").setValue(""+fakeAnsThree);
            ref1.child("quizTournoi").child(loginshared+""+b).child("Anser4").setValue(""+answer);
            ref1.child("quizTournoi").child(loginshared+""+b).child("question").setValue(questionFirbase);
            ref1.child("quizTournoi").child(loginshared+""+b).child("CorrectAnser").setValue(""+answer);
        }
    }
    private  int getRandomWithExclusion(Random rnd, int start, int end, int... exclude) {
        int random = start + rnd.nextInt(end - start + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }
    private  void setquiz(){

        numberQuestion =numberQuestion +1;
        DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();

        if(numberQuestion ==10 ){

            if(Iste9belmatch.equals("1")){
                ref1.child("quizTournoi").child(loginshared+""+b).child("scoreplayer1").setValue(Score);

                Intent i=new Intent(getApplicationContext(),ResultatLeagueGameActivity.class);
                i.putExtra("Iste9belmatch", Iste9belmatch);
                i.putExtra("score",Score+"");
                i.putExtra("b",b+"");
                i.putExtra("loginshared",loginshared);
                startActivity(i);
            }if(Iste9belmatch.equals("2")){
                ref1.child("quizTournoi").child(b+""+loginshared).child("scoreplayer2").setValue(Score);

                Intent i=new Intent(getApplicationContext(),ResultatLeagueGameActivity.class);
                i.putExtra("Iste9belmatch", Iste9belmatch);
                i.putExtra("score",Score+"");
                i.putExtra("b",b+"");
                i.putExtra("loginshared",loginshared);
                startActivity(i);
            }
        }
        DatabaseReference ref2= FirebaseDatabase.getInstance().getReference();
        ref2.child("quizTournoi").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot dsp : dataSnapshot.getChildren()) {


                    if(((b.equals((String.valueOf(dsp.child("id1").getValue()))))&&(loginshared.equals((String.valueOf(dsp.child("id2").getValue())))))
                    ||((loginshared.equals((String.valueOf(dsp.child("id1").getValue()))))&&(b.equals((String.valueOf(dsp.child("id2").getValue())))))) {
                        Anser1 = (String.valueOf(dsp.child("Anser1").getValue()));
                        Anser2 = (String.valueOf(dsp.child("Anser2").getValue()));
                        Anser3 = (String.valueOf(dsp.child("Anser3").getValue()));
                        Anser4 = (String.valueOf(dsp.child("Anser4").getValue()));
                        correctAnser = (String.valueOf(dsp.child("CorrectAnser").getValue()));
                        ques = (String.valueOf(dsp.child("question").getValue()));
                    }
                }
                b1.setText(Anser1);
                b2.setText(Anser2);
                b3.setText(Anser3);
                b4.setText(Anser4);
                question.setText(ques);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }
    private  void setNext(){
        DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
        if(Iste9belmatch.equals("1")){

            ref1.child("quizTournoi").child(loginshared+""+b).child("next"+Iste9belmatch).setValue("1");

        }if(Iste9belmatch.equals("2")){
            ref1.child("quizTournoi").child(b+""+loginshared).child("next"+Iste9belmatch).setValue("1");

        }




    }
    private void setNextquestion(){

        DatabaseReference ref2= FirebaseDatabase.getInstance().getReference();
        ref2.child("quizTournoi").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot dsp : dataSnapshot.getChildren()) {

                    if((("1".equals(String.valueOf(dsp.child("next2").getValue())))&&("1".equals(String.valueOf(dsp.child("next1").getValue()))))
                            ){
                        dsp.getRef().child("next2").setValue("0");
                        dsp.getRef().child("next1").setValue("0");
                        if((Iste9belmatch.equals("1"))){
                            beginGame();

                        }

                        setquiz();

                        iClicks=40;

                        return;
                    }
                }



            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


    }
}
