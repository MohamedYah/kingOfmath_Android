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

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MultiplayerLocalActivity extends AppCompatActivity {
    TextView timer1,timer2,scoreA,scoreB;
    int iClicks;
    private int positionOfAns;
    int e1,e2,resultat,resultat2;
    Button b1,b2,b3,b4,b11,b21,b31,b41;
    TextView question,question2;
    int score1,score2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_local);
        timer1=(TextView)findViewById(R.id.timer);
        timer2=(TextView)findViewById(R.id.timer2);
        b1=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button4);
        b3=(Button)findViewById(R.id.button5);
        b4=(Button)findViewById(R.id.button6);

        b11=(Button)findViewById(R.id.button7);
        b21=(Button)findViewById(R.id.button8);
        b31=(Button)findViewById(R.id.button9);
        b41=(Button)findViewById(R.id.button10);

        scoreA=(TextView)findViewById(R.id.score);
        scoreB=(TextView)findViewById(R.id.score2);
        question=(TextView)findViewById(R.id.result);
        question2=(TextView)findViewById(R.id.result2);
        scoreA.setText("score = 0");scoreB.setText("score = 0");
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
                            timer2.setText(String.valueOf(iClicks));
                        } else {
                            if(score1>score2){
                                scoreA.setText("winner");
                                scoreB.setText("looser");
                            }else if(score1<score2){
                                scoreB.setText("winner");
                                scoreA.setText("looser");
                            }else if(score1==score2){
                            scoreB.setText("draw");
                            scoreA.setText("draw");
                        }}
                    }
                });

            }
        }, 0, 1000);

        beginGame();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (positionOfAns == 0) {
                    score1 = score1 + 1;
                    scoreA.setText("score = "+score1);
                    beginGame();
                } else {
                    score1 = score1 - 1;
                    scoreA.setText("score = "+score1);
                    beginGame();
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (positionOfAns == 1) {
                    score1 = score1 + 1;
                    scoreA.setText("score = "+score1);

                    beginGame();
                } else {
                    score1 = score1 - 1;
                    scoreA.setText("score = "+score1);
                    beginGame();
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (positionOfAns == 2) {
                    score1 = score1 + 1;
                    scoreA.setText("score = " + score1);

                    beginGame();
                } else {
                    score1 = score1 - 1;
                    scoreA.setText("score = "+score1);
                    beginGame();
                }

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (positionOfAns == 3) {
                    score1 = score1 + 1;
                    scoreA.setText("score = " + score1);

                    beginGame();
                } else {
                    score1 = score1 - 1;
                    scoreA.setText("score = "+score1);
                    beginGame();
                }

            }
        });

        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (positionOfAns == 0) {
                    score2 = score2 + 1;
                    scoreB.setText("score = "+score2);
                    beginGame();
                } else {
                    score2 = score2 - 1;
                    scoreB.setText("score = "+score2);
                    beginGame();
                }

            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (positionOfAns == 1) {
                    score2 = score2 + 1;
                    scoreB.setText("score = "+score2);

                    beginGame();
                } else {
                    score2 = score2 - 1;
                    scoreB.setText("score = "+score2);
                    beginGame();
                }

            }
        });
        b41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (positionOfAns == 2) {
                    score2 = score2 + 1;
                    scoreB.setText("score = "+score2);

                    beginGame();
                } else {
                    score2 = score2 - 1;
                    scoreB.setText("score = "+score2);
                    beginGame();
                }

            }
        });
        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (positionOfAns == 3) {
                    score2 = score2 + 1;
                    scoreB.setText("score = "+score2);

                    beginGame();
                } else {
                    score2 = score2 - 1;
                    scoreB.setText("score = "+score2);
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
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
    private void beginGame() {

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
            question2.setText(intEq1 + " + " + intEq2);


            setAnswers(max, min, min1, max1, answer);
        }
        if(operation==1){
            answer=intEq1-intEq2;
            question.setText(intEq1 + " - " + intEq2);
            question2.setText(intEq1 + " - " + intEq2);
            setAnswers(max, min, min1, max1, answer);

        }

    }
    private void setAnswers(int max, int min,int min1,int max1, int answer) {

        Random r = new Random();
        positionOfAns = r.nextInt(4);
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

            b21.setText("" + answer);
            b11.setText("" + fakeAnsOne);
            b41.setText("" + fakeAnsTwo);
            b31.setText("" + fakeAnsThree);
        } else if (positionOfAns == 1) {
            b2.setText(""+answer);
            b1.setText("" + fakeAnsOne);
            b3.setText("" + fakeAnsTwo);
            b4.setText("" + fakeAnsThree);

            b11.setText(""+answer);
            b21.setText("" + fakeAnsOne);
            b41.setText("" + fakeAnsTwo);
            b31.setText("" + fakeAnsThree);
        } else if (positionOfAns == 2) {
            b3.setText(""+answer);
            b1.setText("" + fakeAnsOne);
            b2.setText("" + fakeAnsTwo);
            b4.setText("" + fakeAnsThree);

            b41.setText(""+answer);
            b21.setText("" + fakeAnsOne);
            b11.setText("" + fakeAnsTwo);
            b31.setText("" + fakeAnsThree);
        } else if (positionOfAns == 3) {
            b4.setText(""+answer);
            b1.setText("" + fakeAnsOne);
            b2.setText("" + fakeAnsTwo);
            b3.setText(""+fakeAnsThree);

            b31.setText(""+answer);
            b21.setText("" + fakeAnsOne);
            b11.setText("" + fakeAnsTwo);
            b41.setText(""+fakeAnsThree);
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
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
