package com.example.admin.mathman.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.mathman.R;
import com.example.admin.mathman.activity.ListquizActivity;
import com.example.admin.mathman.helper.DBHelper;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class QuizGameActivity extends AppCompatActivity {
    private int positionOfAns;
    TextView timer1;
    int iClicks;
    int e1,e2,resultat;
    Button b1,b2,b3,b4;
    int score=0;
    int min,max;
    TextView question, scoreA,power;
    int position;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_game);
        db = new DBHelper(this);
        b1=(Button)findViewById(R.id.Button1);
        b2=(Button)findViewById(R.id.Button2);
        b3=(Button)findViewById(R.id.Button3);
        b4=(Button)findViewById(R.id.Button4);
        question=(TextView)findViewById(R.id.result);
        timer1=(TextView)findViewById(R.id.timer);
        scoreA = (TextView)findViewById(R.id.score);
        power=(TextView)findViewById(R.id.power);

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
                            if (score > db.Score(position,"quizz")) {
                                db.UpdateCandidat(position,"quizz", score);
                                System.out.println("score" + score);

                            }
                            Intent ve = new Intent(getApplication(),ListquizActivity.class);
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
            position=(extras.getInt("position"));

        }

        beginGame();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (positionOfAns == 0) {
                    iClicks = iClicks +2;
                    score = score + 1;
                    scoreA.setText("score = "+score);
                    beginGame();
                } else {
                    scoreA.setText("score = "+score);
                    iClicks = iClicks - 7;
                    beginGame();
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (positionOfAns == 1) {
                    iClicks = iClicks +2;
                    score = score + 1;
                    scoreA.setText("score = "+score);
                    beginGame();
                } else {
                    scoreA.setText("score = "+score);
                    iClicks = iClicks - 7;
                    beginGame();
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (positionOfAns == 2) {
                    iClicks = iClicks +2;
                    score = score + 1;
                    scoreA.setText("score = "+score);
                    beginGame();
                } else {
                    scoreA.setText("score = "+score);
                    iClicks = iClicks - 7;
                    beginGame();
                }

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (positionOfAns == 3) {
                    iClicks = iClicks +2;
                    score = score + 1;
                    scoreA.setText("score = "+score);
                    beginGame();
                } else {
                    scoreA.setText("score = "+score);
                    iClicks = iClicks - 7;
                    beginGame();
                }

            }
        });
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
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

      private  void beginGame(){
          if(position==0){
              power.setVisibility(View.GONE);
              beginGameBasics();

          }
          else if(position==1){
              power.setVisibility(View.GONE);
              beginGamelinerty();
          }
          else if(position==2){
              power.setVisibility(View.GONE);
              beginGameMultiplication();
          }
          else if(position==3){
              beginGamePower();

          }
          else if(position==4){
              power.setVisibility(View.GONE);
              beginGameDivision();

          }
          else if(position==5){
              int begin;
              Random r = new Random();
              begin = r.nextInt(4)+1;
              if(begin==0){
                  power.setVisibility(View.GONE);
                  beginGameBasics();
              }else  if (begin==1){
                  power.setVisibility(View.GONE);
                  beginGameDivision();
              }else  if (begin==2){
                  power.setVisibility(View.VISIBLE);
                  beginGamePower();
              }else  if (begin==3){
                  power.setVisibility(View.GONE);
                  beginGameMultiplication();
              }else  if (begin==4){
                  power.setVisibility(View.GONE);
                  beginGamelinerty();

              }}}


    private void beginGameBasics() {

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
        question.setText(intEq1 + " + " + intEq2);
        setAnswers(max, min, min1, max1, answer);
        }
        if(operation==1){
            answer=intEq1-intEq2;
            question.setText(intEq1 + " - " + intEq2);
            setAnswers(max, min, min1, max1, answer);

        }

    }

     private void beginGamelinerty(){
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
             question.setText(""+a1+"x +"+c+" = "+b);
         }else if (c<0){
             question.setText(""+a1+"x "+c+" = "+b);
         }

         answer=((b-c)/a1);
         setAnswers(min, max, min1, max1, answer);

     }

    private void beginGameDivision() {

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
        question.setText(intEq1 + " / " + intEq2);
        setAnswers(max, min, min1, max1, answer);
    }

    private void beginGameMultiplication() {

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
        question.setText(intEq1 + " * " + intEq2);
        setAnswers(max, min, min1, max1, answer);
    }

    private void beginGamePower() {
        int intEq2;
        Random r = new Random();
        int answer;
        intEq2 = r.nextInt(2) + 2;
        if(intEq2==2){
             int min = 0;
             int max = 20;
             int min1 = 0;
             int max1 = 10;
             int intEq1;
             intEq1 = r.nextInt(max - min + 1) + min;
             answer=intEq1*intEq1;
             question.setText(""+intEq1);
             power.setText(""+intEq2);
             setAnswers(max, min, min1, max1, answer);
         }
        else if(intEq2==3){
            int min = 0;
            int max = 10;
            int min1 = 0;
            int max1 = 10;
            int intEq1;
            intEq1 = r.nextInt(max - min + 1) + min;
            int answer1;
            answer1=intEq1*intEq1;
            answer=answer1*intEq1;
            question.setText(""+intEq1);
            power.setText(""+intEq2);
            setAnswers(max, min, min1, max1, answer);
        }
    }

    private void beginGameQuadratique() {
        int delta=0;int valeurdelta;
        int a,b,c = 0,entier1,entier2;
        Random r = new Random();
        a=r.nextInt(4)+1;
        entier1=r.nextInt(2);
        entier2=r.nextInt(2)+2;
        b=-(entier1+entier2)*a;
        delta=((entier2-entier1)*a);
        delta=delta*delta;
        c=((b*b)-delta)/(4*a);
        valeurdelta=r.nextInt(3)+1;
        positionOfAns = r.nextInt(3 - 0 + 1) + 0;
        if(c>=0){
            question.setText(""+a+"x²"+b+"x+"+c+" = 0");
        }
       if(c<0){
           question.setText(""+a+"x²+"+b+"x "+c+" = 0");
       }
        if(positionOfAns == 0)  {
            b1.setText("x = ["+entier1+","+entier2+"]");
            b2.setText("x = ["+entier1+1+","+entier2+2+"]");
            b3.setText("x = ["+entier1+5+","+entier2+3+"]");
            b4.setText("x = ["+entier1+2+","+entier2+1+"]");
        } else if (positionOfAns == 1) {
            b2.setText("x = ["+entier1+","+entier2+"]");
            b1.setText("x = ["+entier1+1+","+entier2+2+"]");
            b3.setText("x = ["+entier1+5+","+entier2+3+"]");
            b4.setText("x = ["+entier1+2+","+entier2+1+"]");
        } else if (positionOfAns == 2) {
            b3.setText("x = ["+entier1+","+entier2+"]");
            b1.setText("x = ["+entier1+2+","+entier2+1+"]");
            b2.setText("x = [" + entier1 + 5 + "," + entier2 + 3 + "]");
            b4.setText("x = [" + entier1 + 1 + "," + entier2 + 2 + "]");
        } else if (positionOfAns == 3) {
            b4.setText("x = ["+entier1+","+entier2+"]");
            b1.setText("x = ["+entier1+2+","+entier2+1+"]");
            b2.setText("x = [" + entier1 + 5 + "," + entier2 + 3 + "]");
            b3.setText("x = [" + entier1 + 1 + "," + entier2 + 2 + "]");
        }
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
        int fakeAnsThree = getRandomWithExclusion(r, answer + min1, answer + max1, excluded);
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
    public void onBackPressed() {
        Intent ve = new Intent(getApplication(),ListquizActivity.class);
        startActivity(ve);
        finish();
        System.exit(0);
    }
}
