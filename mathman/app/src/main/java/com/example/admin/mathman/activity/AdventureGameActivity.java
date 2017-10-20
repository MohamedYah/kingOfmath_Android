package com.example.admin.mathman.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.mathman.R;
import com.example.admin.mathman.helper.DBHelper;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class AdventureGameActivity extends AppCompatActivity {
    String diff;String diff2; String operation;
    int score;  DBHelper db;
    int idoperation;
    private int positionOfAns;
    TextView timer1;
    int iClicks;
    int e1,e2,resultat;
    Button b1,b2,b3,b4;
    int min,max;
    TextView question;
    int life=0;
    ImageView life1,life2,life3;
    int percent=0;
    String opera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        db = new DBHelper(this);
        b1=(Button)findViewById(R.id.Button1);
        b2=(Button)findViewById(R.id.Button2);
        b3=(Button)findViewById(R.id.Button3);
        b4=(Button)findViewById(R.id.Button4);
        question=(TextView)findViewById(R.id.result);
        timer1=(TextView)findViewById(R.id.timer);
        life1=(ImageView)findViewById(R.id.life);  life2=(ImageView)findViewById(R.id.life1);
        life3=(ImageView)findViewById(R.id.life2);
        iClicks=100;
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

                            findViewById(R.id.Button1).setVisibility(View.INVISIBLE);
                            findViewById(R.id.Button2).setVisibility(View.INVISIBLE);
                            findViewById(R.id.Button3).setVisibility(View.INVISIBLE);
                            findViewById(R.id.Button4).setVisibility(View.INVISIBLE);

                            Intent ve = new Intent(getApplication(),AdventureActivity.class);
                            startActivity(ve);
                            finish();
                            System.exit(0);

                        }
                    }
                });

            }
        }, 0, 1000);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            diff=(extras.getString("diffuclity"));
            diff2=(extras.getString("diffuclity2"));
            idoperation=(extras.getInt("id"));
            operation=(extras.getString("operation"));
            System.out.println("idoperation" + idoperation);
            System.out.println("operation" + operation);
            if(operation.equals("Addition")){
                opera=" + ";
            }
            if(operation.equals("soustraction")){
                opera=" - ";
            }
            if(operation.equals("multiplication")){
                opera=" * ";
            }
            if(operation.equals("division")){
                opera=" / ";
            }
        }
        beginGame();




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percent=percent+1;
                if(percent==10){
                    score=score+iClicks;
                    if(score>db.Score(idoperation,operation)) {
                        db.UpdateCandidat(idoperation, operation, score);
                    }
                    Intent ve = new Intent(getApplication(),AdventureActivity.class);
                    startActivity(ve);
                    finish();
                    System.exit(0);
                }
                if (positionOfAns == 0) {
                    score=score+1;
                    beginGame();
                } else {
                    beginGame();
                    life=life+1;
                    if(life==1){
                        life3.setImageResource(R.drawable.life1);
                    }
                    if(life==2){
                        life3.setImageResource(R.drawable.life1);
                        life2.setImageResource(R.drawable.life1);
                    }
                    if(life==3){
                        life3.setImageResource(R.drawable.life1);
                        life2.setImageResource(R.drawable.life1);
                        life1.setImageResource(R.drawable.life1);
                        Intent ve = new Intent(getApplication(),MainActivity.class);
                        startActivity(ve);
                        finish();
                        System.exit(0);
                    }

                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percent=percent+1;

                if(percent==10){

                    score=score+iClicks;

                    if(score>db.Score(idoperation,operation)) {
                        db.UpdateCandidat(idoperation, operation, score);
                        System.out.println("score" + score);

                    }

                    Intent ve = new Intent(getApplication(),AdventureActivity.class);
                    startActivity(ve);
                    finish();
                    System.exit(0);
                }
                if (positionOfAns==1){
                    score=score+1;
                    beginGame();
                }else {
                    beginGame();
                    life=life+1;
                    if(life==1){
                        life3.setImageResource(R.drawable.life1);
                    }
                    if(life==2){
                        life3.setImageResource(R.drawable.life1);
                        life2.setImageResource(R.drawable.life1);
                    }
                    if(life==3){
                        life3.setImageResource(R.drawable.life1);
                        life2.setImageResource(R.drawable.life1);
                        life1.setImageResource(R.drawable.life1);
                        Intent ve = new Intent(getApplication(),MainActivity.class);
                        startActivity(ve);
                        finish();
                        System.exit(0);
                    }
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percent = percent + 1;
                if (percent == 10) {

                    score = score + iClicks;

                    if (score > db.Score(idoperation, operation)) {
                        db.UpdateCandidat(idoperation, operation, score);
                        System.out.println("score" + score);

                    }

                    Intent ve = new Intent(getApplication(),AdventureActivity.class);
                    startActivity(ve);
                    finish();
                    System.exit(0);
                }
                if (positionOfAns == 2) {
                    score = score + 1;
                    beginGame();
                } else {

                    beginGame();
                    life = life + 1;
                    if (life == 1) {
                        life3.setImageResource(R.drawable.life1);
                    }
                    if (life == 2) {
                        life3.setImageResource(R.drawable.life1);
                        life2.setImageResource(R.drawable.life1);
                    }
                    if (life == 3) {
                        life3.setImageResource(R.drawable.life1);
                        life2.setImageResource(R.drawable.life1);
                        life1.setImageResource(R.drawable.life1);
                        Intent ve = new Intent(getApplication(), MainActivity.class);
                        startActivity(ve);
                        finish();
                        System.exit(0);
                    }

                }

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percent = percent + 1;
                if (percent == 10) {
                    score = score + iClicks ;
                    if (score > db.Score(idoperation, operation)) {
                        db.UpdateCandidat(idoperation, operation, score);
                        System.out.println("score" + score);

                    }

                    Intent ve = new Intent(getApplication(),AdventureActivity.class);
                    startActivity(ve);
                    finish();
                    System.exit(0);
                }
                if (positionOfAns == 3) {
                    score = score + 1;
                    beginGame();
                } else {
                    beginGame();
                    life = life + 1;
                    if (life == 1) {
                        life3.setImageResource(R.drawable.life1);
                    }
                    if (life == 2) {
                        life3.setImageResource(R.drawable.life1);
                        life2.setImageResource(R.drawable.life1);
                    }
                    if (life == 3) {
                        life3.setImageResource(R.drawable.life1);
                        life2.setImageResource(R.drawable.life1);
                        life1.setImageResource(R.drawable.life1);
                        Intent ve = new Intent(getApplication(), MainActivity.class);
                        startActivity(ve);
                        finish();
                        System.exit(0);
                    }

                }

            }
        });

    }

    private void beginGame() {
        int min = 0;
        int max = 20;
        int min1 = 0;
        int max1 = 10;
        int intEq1;
        int intEq2;
        int intEq3=0;

        if (diff.equals("1")){min = 0; max = 10; }
        if (diff.equals("2")){min = 0; max = 20;}
        if (diff.equals("3")){min = 5; max = 25;}
        if (diff.equals("4")){min = 10; max = 30;}
        if (diff.equals("5")){min = 20; max = 40; min1 = -10; max1 = 20;}
        if (diff.equals("6")){min = 20; max = 45;  min1 = -10; max1 = 20;}
        if (diff.equals("7")){min = 25; max = 50;  min1 = -10; max1 = 20;}
        if (diff.equals("8")){min = 30; max = 55;  min1 = -10; max1 = 20;}
        if (diff.equals("9")){min = 35; max = 60;  min1 = -10; max1 = 20;}
        if (diff.equals("10")){min = 40; max = 65;  min1 = -10; max1 = 20;}
        Random r = new Random();
        int answer=0;
        intEq1 = r.nextInt(max - min + 1) + min;
        intEq2 = r.nextInt(max - min + 1) + min;
        if(operation.equals("division") ){
            max=max-5;
            intEq1=intEq2*r.nextInt(5)*r.nextInt(7);
        }
        if(operation.equals("multiplication")){
            intEq3=1;
        }
        if (diff.equals("7") && !operation.equals("division")){intEq3 = r.nextInt(max - min + 1) + min;}
        if (diff.equals("8") && !operation.equals("division")){intEq3 = r.nextInt(max - min + 1) + min;}
        if (diff.equals("9") && !operation.equals("division")){intEq3 = r.nextInt(max - min + 1) + min;}
        if (diff.equals("10") && !operation.equals("division")){intEq3 = r.nextInt(max - min + 1) + min;}

        if(operation.equals("Addition")) {
            answer = intEq1 + intEq2 + intEq3;
        }
        if(operation.equals("soustraction")) {
            answer = intEq1 - intEq2 - intEq3;
        }
        if(operation.equals("multiplication")) {
            answer = intEq1 * intEq2 * intEq3;
        }
        if(operation.equals("division")) {
            answer = intEq1 / intEq2 ;
        }
        question.setText(intEq1 + opera + intEq2+ opera +intEq3);
        if (intEq3==0){
            question.setText(intEq1 + opera + intEq2);
        }
        setAnswers(max, min,min1,max1, answer);


    }

    private void setAnswers(int max, int min,int min1,int max1, int answer) {

        Random r = new Random();
        positionOfAns = r.nextInt(3 - 0 + 1) + 0;
        int[] excluded = new int[4];
        excluded[0] = answer;

        int fakeAnsOne = getRandomWithExclusion(r,answer+min1,answer+max1,excluded);
        excluded[1] = fakeAnsOne;
        int fakeAnsTwo = getRandomWithExclusion(r,answer+min1,answer+max1,excluded);
        excluded[2] = fakeAnsTwo;
        int fakeAnsThree = getRandomWithExclusion(r,answer+min1,answer+max1,excluded);
        excluded[3] = fakeAnsThree;
        if(positionOfAns == 0)  {
            b1.setText("" + answer);
            b2.setText("" + fakeAnsOne);
            b3.setText("" + fakeAnsTwo);
            b4.setText("" + fakeAnsThree);
        } else if (positionOfAns == 1) {
            b2.setText(""+answer);
            b1.setText("" + fakeAnsOne);
            b3.setText("" + fakeAnsTwo);
            b4.setText("" + fakeAnsThree);
        } else if (positionOfAns == 2) {
            b3.setText(""+answer);
            b1.setText("" + fakeAnsOne);
            b2.setText("" + fakeAnsTwo);
            b4.setText("" + fakeAnsThree);
        } else if (positionOfAns == 3) {
            b4.setText(""+answer);
            b1.setText("" + fakeAnsOne);
            b2.setText("" + fakeAnsTwo);
            b3.setText(""+fakeAnsThree);
        }
    }
    private int getRandomWithExclusion(Random rnd, int start, int end, int... exclude) {
        int random = start + rnd.nextInt(end - start + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
     /*   if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent ve = new Intent(getApplication(),AdventureActivity.class);
        startActivity(ve);
        finish();
        System.exit(0);

    }
}