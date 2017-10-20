package com.example.admin.mathman.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.mathman.R;

public class Tutorial_Activity extends AppCompatActivity {
    Button bAdd,bSous,bMulti,bDivi,bPrev,bNext;
    ImageView tutoimg;
    int choixTuto=0;int tutoIndice=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_);


        bAdd=(Button)findViewById(R.id.ButtonAdd);
        bSous=(Button)findViewById(R.id.ButtonSous);
        bMulti=(Button)findViewById(R.id.ButtonMulti);
        bDivi=(Button)findViewById(R.id.ButtonDivi);
        bPrev=(Button)findViewById(R.id.ButtonPrev);
        bNext=(Button)findViewById(R.id.ButtonNext);
        tutoimg=(ImageView)findViewById(R.id.ImgTuto);


        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixTuto=1;tutoIndice=1;
                tutoimg.setImageResource(R.drawable.tutoaddition1);
            }
        });
        bSous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixTuto=2;tutoIndice=1;
                tutoimg.setImageResource(R.drawable.tutosoustraction1);
            }
        });
        bMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixTuto=3;tutoIndice=1;
                tutoimg.setImageResource(R.drawable.tutomultiplication1);
            }
        });
        bDivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixTuto=4;tutoIndice=1;
                tutoimg.setImageResource(R.drawable.tutodivision1);
            }
        });

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(choixTuto==1){
                    if(tutoIndice==1){
                        tutoIndice++;
                        tutoimg.setImageResource(R.drawable.tutoaddition2);
                    }else if(tutoIndice==2){
                        tutoIndice++;
                        tutoimg.setImageResource(R.drawable.tutoaddition3);
                    }else if(tutoIndice==3){
                        tutoIndice++;
                        tutoimg.setImageResource(R.drawable.tutoaddition4);
                    }
                }


                if(choixTuto==2){
                    if(tutoIndice==1){
                        tutoIndice++;
                        tutoimg.setImageResource(R.drawable.tutosoustraction2);
                    }else if(tutoIndice==2){
                        tutoIndice++;
                        tutoimg.setImageResource(R.drawable.tutosoustraction3);
                    }
                }
                if(choixTuto==3){
                    if(tutoIndice==1){
                        tutoIndice++;
                        tutoimg.setImageResource(R.drawable.tutomultiplication2);
                    }else if(tutoIndice==2){
                        tutoIndice++;
                        tutoimg.setImageResource(R.drawable.tutomultiplication3);
                    }else if(tutoIndice==3){
                        tutoIndice++;
                        tutoimg.setImageResource(R.drawable.tutomultiplication4);
                    }else if(tutoIndice==4){
                        tutoIndice++;
                        tutoimg.setImageResource(R.drawable.tutomultiplication5);
                    }
                }


                if(choixTuto==4){
                    if(tutoIndice==1){
                        tutoIndice++;
                        tutoimg.setImageResource(R.drawable.tutodivision2);
                    }else if(tutoIndice==2){
                        tutoIndice++;
                        tutoimg.setImageResource(R.drawable.tutodivision3);
                    }
                }


            }
        });



        bPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(choixTuto==1){
                    if(tutoIndice==4){
                        tutoIndice--;
                        tutoimg.setImageResource(R.drawable.tutoaddition3);
                    }else if(tutoIndice==3){
                        tutoIndice--;
                        tutoimg.setImageResource(R.drawable.tutoaddition2);
                    }else if(tutoIndice==2){
                        tutoIndice--;
                        tutoimg.setImageResource(R.drawable.tutoaddition1);
                    }
                }

                if(choixTuto==2){
                    if(tutoIndice==3){
                        tutoIndice--;
                        tutoimg.setImageResource(R.drawable.tutosoustraction2);
                    }else if(tutoIndice==2){
                        tutoIndice--;
                        tutoimg.setImageResource(R.drawable.tutosoustraction1);
                    }
                }
                if(choixTuto==3){
                    if(tutoIndice==5){
                        tutoIndice--;
                        tutoimg.setImageResource(R.drawable.tutomultiplication4);
                    }else if(tutoIndice==4){
                        tutoIndice--;
                        tutoimg.setImageResource(R.drawable.tutomultiplication3);
                    }else if(tutoIndice==3){
                        tutoIndice--;
                        tutoimg.setImageResource(R.drawable.tutomultiplication2);
                    }else if(tutoIndice==2){
                        tutoIndice--;
                        tutoimg.setImageResource(R.drawable.tutomultiplication1);
                    }
                }


                if(choixTuto==4){
                    if(tutoIndice==3){
                        tutoIndice--;
                        tutoimg.setImageResource(R.drawable.tutodivision2);
                    }else if(tutoIndice==2){
                        tutoIndice--;
                        tutoimg.setImageResource(R.drawable.tutodivision1);
                    }
                }


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

       // getMenuInflater().inflate(R.menu.menu_tutorial_, menu);

        return true;    }

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
}