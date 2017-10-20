package com.example.admin.mathman.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.mathman.R;
import com.example.admin.mathman.adapter.LeaderBoardAdapter;
import com.example.admin.mathman.model.InscriptionLeague;
import com.example.admin.mathman.model.Leader;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaderBoardActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    List<Leader> leaderBoard = null;
    ListView maListViewLeader;

    private FirebaseDatabase database;
    private DatabaseReference myRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        maListViewLeader = (ListView) findViewById(R.id.leaderboardList);


        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        myRef = database.getInstance().getReference();

        leaderBoard = new ArrayList<Leader>();


        if(executeCmd("ping -c 1 -w 1 google.com", false).equals("")){
            Toast.makeText(getApplicationContext(),"check your internet connection!",Toast.LENGTH_LONG).show();
        }else {


            DatabaseReference ref1 = FirebaseDatabase.getInstance().getReference();
            DatabaseReference ref2, ref3, ref4;
            ref2 = ref1.child("registres");

            ref2.orderByChild("score").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    try {

                        int i = 1;

                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                            int j= (int) dataSnapshot.getChildrenCount();
                            i = i -1;
                            leaderBoard.add(new Leader(String.valueOf(dsp.child("login").getValue()), String.valueOf(dsp.child("score").getValue()), j+i));
                        }
                        Collections.reverse(leaderBoard);
                        maListViewLeader.setAdapter(new LeaderBoardAdapter(getBaseContext(), R.layout.oneleader, leaderBoard));
                    } catch (Exception ex) {
                        Toast.makeText(getApplicationContext(), "Exception", Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        }

        }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
