package com.example.admin.mathman.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.mathman.R;
import com.example.admin.mathman.model.Leader;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ADMIN on 02/01/2016.
 */
public class LeaderBoardAdapter extends ArrayAdapter<Leader> {
    private final static String TAG = "ledarBoard";
    private int resourceId = 0;
    public Context mContext;
    private LayoutInflater inflater;

    SharedPreferences pref ;
    SharedPreferences.Editor editor;

    String login;


    ImageView amine;

    public LeaderBoardAdapter(Context context, int resourceId, List<Leader> mediaItems) {
        super(context, 0, mediaItems);
        this.resourceId = resourceId;
        this.mContext = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        pref = context.getSharedPreferences("login", context.MODE_PRIVATE);
        login = pref.getString("loginShared", null);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        TextView score, name,rang;
        LinearLayout linearLayout;
        ProgressDialog progressDialog = null;
        ImageView image;


        view = inflater.inflate(resourceId, parent, false);

        try {
            score = (TextView)view.findViewById(R.id.scoreL);
            name = (TextView)view.findViewById(R.id.nameL);
            rang = (TextView)view.findViewById(R.id.rangL);
            linearLayout =(LinearLayout)view.findViewById(R.id.linearLeader);



        } catch( ClassCastException e ) {
            Log.e(TAG, "Your layout must provide an image and a text view.", e);
            throw e;
        }



        if(getItem(position).getName().equals(login)){
         linearLayout.setBackgroundResource(R.drawable.backgroudleader);
        }

        score.setText(getItem(position).getScore());
        name.setText(getItem(position).getName());
        rang.setText(""+getItem(position).getRang());




        return view;
    }

}
