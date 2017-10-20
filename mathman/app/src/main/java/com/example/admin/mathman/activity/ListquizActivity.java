package com.example.admin.mathman.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.admin.mathman.helper.DBHelper;
import com.example.admin.mathman.model.Quiz;
import com.example.admin.mathman.adapter.QuizCustomAdapter;
import com.example.admin.mathman.R;

import java.util.ArrayList;
import java.util.List;

public class ListquizActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    List<Quiz> imgList = null;

    int img1 = R.drawable.quizzitem1;
    int img2 = R.drawable.quizzitem2;
    int img3 = R.drawable.quizzitem3;
    int img4 = R.drawable.quizzitem4;
    int img5 = R.drawable.quizzitem5;
    int img6 = R.drawable.quizzitem6;
    int img7 = R.drawable.quizzitem7;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_quiz);
        db = new DBHelper(this);
        ListView maListViewPerso = (ListView)findViewById(R.id.listArticle);

        imgList = new ArrayList<Quiz>();

       db.Score(4,"quizz");
        Quiz Q0;
        if(db.Score(0,"quizz")>0){
            Q0 = new Quiz(img1, "Basics","score = "+db.Score(0,"quizz"));
        }else{
            Q0 = new Quiz(img1, "Basics","not games played yet");
        }
        Quiz Q1;
        if(db.Score(1,"quizz")>0){
            Q1 = new Quiz(img2, "Linearty","score = "+db.Score(1,"quizz"));
        }else{
            Q1 = new Quiz(img2, "Linearty","not games played yet");
        }

        Quiz Q2;
        if(db.Score(2,"quizz")>0){
            Q2 = new Quiz(img4, "Multiplication","score = "+db.Score(2,"quizz"));
        }else{
            Q2 = new Quiz(img4, "Multiplication","not games played yet");
        }
        Quiz Q3;
        if(db.Score(3,"quizz")>0){
            Q3 = new Quiz(img5, "Power Ranger","score = "+db.Score(3,"quizz"));
        }else{
            Q3 = new Quiz(img5, "Power Ranger","not games played yet");
        }
        Quiz Q4;
        if(db.Score(4,"quizz")>0){
            Q4 = new Quiz(img6, "Division","score = "+db.Score(4,"quizz"));
        }else{
            Q4 = new Quiz(img6, "Division","not games played yet");
        }
        Quiz Q5;
        if(db.Score(5,"quizz")>0){
            Q5 = new Quiz(img7, "the Mentalist","score = "+db.Score(5,"quizz"));
        }else{
            Q5 = new Quiz(img7, "the Mentalist","not games played yet");
        }

        imgList.add(Q0);
        imgList.add(Q1);
        imgList.add(Q2);
        imgList.add(Q3);
        imgList.add(Q4);
        imgList.add(Q5);




        maListViewPerso.setAdapter(new QuizCustomAdapter(getBaseContext(), R.layout.one_quiz, imgList));
        maListViewPerso.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent ve=new Intent(getApplicationContext(),QuizGameActivity.class);
        ve.putExtra("position",+position);
        startActivity(ve);
        finish();
        System.exit(0);
    }


}
