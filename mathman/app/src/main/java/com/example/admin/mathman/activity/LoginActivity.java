package com.example.admin.mathman.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.mathman.R;
import com.example.admin.mathman.helper.DBHelper;
import com.example.admin.mathman.model.Player;
import com.example.admin.mathman.model.Registre;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LoginActivity extends AppCompatActivity {


    EditText login,password;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    SharedPreferences pref ;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pref = getApplicationContext().getSharedPreferences("login", MODE_PRIVATE);
         editor = pref.edit();

        Log.d("myTag", "This is my message");
        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        myRef = database.getInstance().getReference();

        login = (EditText)findViewById(R.id.login);
        password = (EditText)findViewById(R.id.password);

        String loginshared=pref.getString("loginShared", null);
        String passwordhared=pref.getString("loginShared", null);

        if((loginshared != null)&&(passwordhared != null)){
            login.setText(loginshared);
            login.setText(passwordhared);
        }

    }



    public void onClick(View v){


        switch (v.getId()){
            case R.id.registre:
                Intent intent = new Intent(LoginActivity.this, RegistreActivity.class);
                startActivity(intent);
                break;
            case R.id.signin:

                if(executeCmd("ping -c 1 -w 1 google.com", false).equals("")){

                    Toast.makeText(getApplicationContext(),"check your internet connection!",Toast.LENGTH_LONG).show();
                }else {

                    DatabaseReference ref1 = FirebaseDatabase.getInstance().getReference();
                    DatabaseReference ref2, ref3, ref4;
                    ref2 = ref1.child("registres");


                    ref2.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            int Test= 0;
                            for (DataSnapshot dsp : dataSnapshot.getChildren()) {

                                String loginFB = String.valueOf(dsp.child("login").getValue());
                                String passwordFB = String.valueOf(dsp.child("password").getValue());
                                if((login.getText().toString().equals(loginFB))&&(password.getText().toString().equals(passwordFB))){
                                    Test = 1;

                                    editor.putString("loginShared", String.valueOf(dsp.child("login").getValue()));
                                    editor.putString("passwordShared", String.valueOf(dsp.child("password").getValue()));
                                    editor.commit();

                                }
                            }

                            if(Test == 1){
                                Toast.makeText(getApplicationContext(),"Login success",Toast.LENGTH_SHORT).show();
                                Intent intent2 = new Intent(LoginActivity.this, MainActivity.class);
                                DBHelper db = new DBHelper(getApplication());
                                Player c = new Player(1, "Addition", 0);
                                Player c1 = new Player(2, "Addition", 0);
                                Player c2 = new Player(3, "Addition", 0);
                    Player c3 = new Player(4, "Addition", 0);
                    Player c4 = new Player(5, "Addition", 0);
                    Player c5 = new Player(6, "Addition", 0);
                    Player c6 = new Player(7, "Addition", 0);
                    Player c7 = new Player(8, "Addition", 0);
                    Player c8 = new Player(9, "Addition", 0);
                    Player c9 = new Player(10, "Addition", 0);

                    Player c10 = new Player(1, "soustraction", 0);
                    Player c11 = new Player(2, "soustraction", 0);
                    Player c12 = new Player(3, "soustraction", 0);
                    Player c13 = new Player(4, "soustraction", 0);
                    Player c14 = new Player(5, "soustraction", 0);
                    Player c15 = new Player(6, "soustraction", 0);
                    Player c16 = new Player(7, "soustraction", 0);
                    Player c17 = new Player(8, "soustraction", 0);
                    Player c18 = new Player(9, "soustraction", 0);
                    Player c19 = new Player(10, "soustraction", 0);

                    Player c20 = new Player(1, "multiplication", 0);
                    Player c21 = new Player(2, "multiplication", 0);
                    Player c22 = new Player(3, "multiplication", 0);
                    Player c23 = new Player(4, "multiplication", 0);
                    Player c24 = new Player(5, "multiplication", 0);
                    Player c25 = new Player(6, "multiplication", 0);
                    Player c26 = new Player(7, "multiplication", 0);
                    Player c27 = new Player(8, "multiplication", 0);
                    Player c28 = new Player(9, "multiplication", 0);
                    Player c29 = new Player(10, "multiplication", 0);

                    Player c30 = new Player(1, "division", 0);
                    Player c31 = new Player(2, "division", 0);
                    Player c32 = new Player(3, "division", 0);
                    Player c33 = new Player(4, "division", 0);
                    Player c34 = new Player(5, "division", 0);
                    Player c35 = new Player(6, "division", 0);
                    Player c36 = new Player(7, "division", 0);
                    Player c37 = new Player(8, "division", 0);
                    Player c38 = new Player(9, "division", 0);
                    Player c39 = new Player(10, "division", 0);

                    Player c40 = new Player(0, "quizz", 0);
                    Player c41 = new Player(1, "quizz", 0);
                    Player c42 = new Player(2, "quizz", 0);
                    Player c43 = new Player(3, "quizz", 0);
                    Player c44 = new Player(4, "quizz", 0);
                    Player c45 = new Player(5, "quizz", 0);


                    db.insertCandidat(c);
                    db.insertCandidat(c1);
                    db.insertCandidat(c2);
                    db.insertCandidat(c3);
                    db.insertCandidat(c4);
                    db.insertCandidat(c5);
                    db.insertCandidat(c6);
                    db.insertCandidat(c7);
                    db.insertCandidat(c8);
                    db.insertCandidat(c9);
                    db.insertCandidat(c10);
                    db.insertCandidat(c11);
                    db.insertCandidat(c12);
                    db.insertCandidat(c13);
                    db.insertCandidat(c14);
                    db.insertCandidat(c15);
                    db.insertCandidat(c16);
                    db.insertCandidat(c17);
                    db.insertCandidat(c18);
                    db.insertCandidat(c19);
                    db.insertCandidat(c20);
                    db.insertCandidat(c21);
                    db.insertCandidat(c22);
                    db.insertCandidat(c23);
                    db.insertCandidat(c24);
                    db.insertCandidat(c25);
                    db.insertCandidat(c26);
                    db.insertCandidat(c27);
                    db.insertCandidat(c28);
                    db.insertCandidat(c29);

                    db.insertCandidat(c30);
                    db.insertCandidat(c31);
                    db.insertCandidat(c32);
                    db.insertCandidat(c33);
                    db.insertCandidat(c34);
                    db.insertCandidat(c35);
                    db.insertCandidat(c36);
                    db.insertCandidat(c37);
                    db.insertCandidat(c38);
                    db.insertCandidat(c39);
                    db.insertCandidat(c40);
                    db.insertCandidat(c41);
                    db.insertCandidat(c42);
                    db.insertCandidat(c43);
                    db.insertCandidat(c44);
                    db.insertCandidat(c45);

                startActivity(intent2);
                            }else{
                                Toast.makeText(getApplicationContext(),"Login failed",Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }
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










