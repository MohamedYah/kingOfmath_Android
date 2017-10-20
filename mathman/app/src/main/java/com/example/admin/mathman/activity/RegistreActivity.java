package com.example.admin.mathman.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.mathman.R;
import com.example.admin.mathman.RoundImage;
import com.example.admin.mathman.model.Registre;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class RegistreActivity extends AppCompatActivity {

    EditText login ,password,confirmpassword,birthday;

    TextView loginIC ,passwordIC,confirmpasswordIC,birthdayIC,spinnerSchoolIC,playerIC;

    ImageButton player1, player2, player3, player4;

    int positionImage = 0;

    String schcoolSelection;

    RoundImage roundedImage1, roundedImage2, roundedImage3, roundedImage4;

    private static final String[]paths = {"nothing", "ecole 1", "ecole 2","ecole 3"};
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    Spinner spinnerSchool;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        Toast.makeText(this.getApplicationContext(),executeCmd("ping -c 1 -w 1 google.com", false),Toast.LENGTH_LONG).show();

        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        myRef = database.getInstance().getReference();


        login = (EditText) findViewById(R.id.login);
        loginIC = (TextView) findViewById(R.id.loginIC);

        password = (EditText) findViewById(R.id.password);
        passwordIC = (TextView) findViewById(R.id.passwordIC);

        confirmpassword = (EditText) findViewById(R.id.confirmPassword);
        confirmpasswordIC = (TextView) findViewById(R.id.confirmPasswordIC);

        birthday = (EditText) findViewById(R.id.birthday);
        birthdayIC = (TextView) findViewById(R.id.birthdayIC);


        player1 = (ImageButton) findViewById(R.id.player1);
        player2 = (ImageButton) findViewById(R.id.player2);
        player3 = (ImageButton) findViewById(R.id.player3);
        player4 = (ImageButton) findViewById(R.id.player4);

        playerIC = (TextView)findViewById(R.id.playerIC);

        spinnerSchool =(Spinner) findViewById(R.id.school);
        spinnerSchool.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {

                schcoolSelection=spinnerSchool.getSelectedItem().toString();

                Toast.makeText(getApplicationContext(), schcoolSelection ,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });





        spinnerSchoolIC =(TextView) findViewById(R.id.playerIC);

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(RegistreActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSchool.setAdapter(adapter);






        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.player1);
        roundedImage1 = new RoundImage(bm);
        player1.setImageDrawable(roundedImage1);

        Bitmap bm2 = BitmapFactory.decodeResource(getResources(), R.drawable.player2);
        roundedImage2 = new RoundImage(bm2);
        player2.setImageDrawable(roundedImage2);

        Bitmap bm3 = BitmapFactory.decodeResource(getResources(), R.drawable.player3);
        roundedImage3 = new RoundImage(bm3);
        player3.setImageDrawable(roundedImage3);

        Bitmap bm4 = BitmapFactory.decodeResource(getResources(), R.drawable.player4);
        roundedImage4 = new RoundImage(bm4);
        player4.setImageDrawable(roundedImage4);

        player1.setBackgroundDrawable(null);
        player2.setBackgroundDrawable(null);
        player3.setBackgroundDrawable(null);
        player4.setBackgroundDrawable(null);


        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player2.setBackgroundDrawable(null);
                player3.setBackgroundDrawable(null);
                player4.setBackgroundDrawable(null);
                player1.setBackgroundResource(R.drawable.some_selector_name);
                positionImage = 0;
                positionImage = positionImage + 1;
            }
        });

        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1.setBackgroundDrawable(null);
                player3.setBackgroundDrawable(null);
                player4.setBackgroundDrawable(null);
                player2.setBackgroundResource(R.drawable.some_selector_name);
                positionImage = 0;
                positionImage = positionImage + 2;
            }
        });

        player3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1.setBackgroundDrawable(null);
                player2.setBackgroundDrawable(null);
                player4.setBackgroundDrawable(null);
                player3.setBackgroundResource(R.drawable.some_selector_name);
                positionImage = 0;
                positionImage = positionImage + 3;
            }
        });

        player4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1.setBackgroundDrawable(null);
                player3.setBackgroundDrawable(null);
                player2.setBackgroundDrawable(null);
                player4.setBackgroundResource(R.drawable.some_selector_name);
                positionImage = 0;
                positionImage = positionImage + 4;
            }
        });


    }



            public void onClick(View v){
        switch (v.getId()){
            case R.id.registre:

             if(login.getText().toString().equals("")){
                 loginIC.setText("Login is empty");
                 passwordIC.setText("");
                 confirmpasswordIC.setText("");
                 birthdayIC.setText("");
                 playerIC.setText("");

             }else if(password.getText().toString().equals("")){
                 loginIC.setText("");
                 passwordIC.setText("password is empty");
                 confirmpasswordIC.setText("");
                 birthdayIC.setText("");
                 playerIC.setText("");
                }
                else if(!confirmpassword.getText().toString().equals(password.getText().toString())){
                 loginIC.setText("");
                 passwordIC.setText("");
                 confirmpasswordIC.setText("verifey password");
                 birthdayIC.setText("");
                 playerIC.setText("");
                }
                else if(birthday.getText().toString().equals("")){
                 loginIC.setText("");
                 passwordIC.setText("");
                 confirmpasswordIC.setText("");
                 birthdayIC.setText("birthday is empty");
                 playerIC.setText("");
                }else if(positionImage==0){
                 loginIC.setText("");
                 passwordIC.setText("");
                 confirmpasswordIC.setText("");
                 birthdayIC.setText("");
                 playerIC.setText("choose hero");
             }else{
                 if(executeCmd("ping -c 1 -w 1 google.com", false).equals("")){

                     Toast.makeText(getApplicationContext(),"check your internet connection!",Toast.LENGTH_LONG).show();
                 }else {

                 DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
                 DatabaseReference ref2,ref3,ref4;
                 ref2 = ref1.child("registres");


                 ref2.addListenerForSingleValueEvent(new ValueEventListener() {
                     @Override
                     public void onDataChange(DataSnapshot dataSnapshot) {
                          int Test= 0;
                         for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                             //String s = String.valueOf(dsp.getValue());
                             String s = String.valueOf(dsp.child("login").getValue());
                             if(login.getText().toString().equals(s)){
                                 Test = 1;
                             }
                         }

                         if(Test == 1){
                             Toast.makeText(getApplicationContext(),"Login exist",Toast.LENGTH_SHORT).show();
                         }else{

                             Registre registre = new Registre(login.getText().toString(),password.getText().toString(),birthday.getText().toString(),schcoolSelection,""+positionImage,0);
                             myRef.child("registres").child(login.getText().toString()).setValue(registre);
                             Toast.makeText(getApplicationContext(),"registre success",Toast.LENGTH_SHORT).show();
                             Intent intent = new Intent(getApplication(), LoginActivity.class);
                             startActivity(intent);


                         }

                     }

                     @Override
                     public void onCancelled(DatabaseError databaseError) {

                     }
                 });

             }}

                break;
            default:
                break;

        }

    }


    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();


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
