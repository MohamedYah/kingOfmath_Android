package com.example.admin.mathman.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.admin.mathman.adapter.AdventureCustomAdapter;
import com.example.admin.mathman.model.Adventure;
import com.example.admin.mathman.R;

import java.util.ArrayList;
import java.util.List;

public class AdventureActivity extends AppCompatActivity {
    List<Adventure> imgList = null;
    ListView maListViewPerso;
    int img1 = R.drawable.template1;
    int img2 = R.drawable.template2;
    int img3 = R.drawable.template3;
    int imag4 = R.drawable.template4;
    ImageView button1,button2,button3,button4,button5,button6,button7,button8,button9,button10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure_map);
        maListViewPerso = (ListView)findViewById(R.id.listArticle);

        imgList = new ArrayList<Adventure>();
        Adventure A1 = new Adventure(img1);
        Adventure A2 = new Adventure(img2);
        Adventure A3 = new Adventure(img3);
        Adventure A4=new Adventure(imag4);
        imgList.add(A1);
        imgList.add(A2);
        imgList.add(A3);
        imgList.add(A4);
        maListViewPerso.setAdapter(new AdventureCustomAdapter(getBaseContext(), R.layout.one_adventure, imgList));
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

    @Override
    public void onBackPressed() {
        Intent ve=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(ve);
        finish();
        System.exit(0);

    }
}
