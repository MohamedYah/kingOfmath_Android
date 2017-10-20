package com.example.admin.mathman.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.mathman.R;
import com.example.admin.mathman.model.Quiz;

import java.util.List;

public class QuizCustomAdapter extends ArrayAdapter<Quiz> {
	
	  private final static String TAG = "QuizAdapter";
	  private int resourceId = 0;
	  public Context mContext;
	  private LayoutInflater inflater;


	  public QuizCustomAdapter(Context context, int resourceId, List<Quiz> mediaItems) {
	    super(context, 0, mediaItems);
	    this.resourceId = resourceId;
		this.mContext = context;
	    inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	  }
	  
	  @Override
		public View getView(int position, View convertView, ViewGroup parent) {

		View view;
		TextView textTitle, DescText;
		final ImageView image;
		view = inflater.inflate(resourceId, parent, false);

		try {
			textTitle = (TextView)view.findViewById(R.id.titreArticle);
			DescText = (TextView)view.findViewById(R.id.descArticle);
			image = (ImageView)view.findViewById(R.id.imgArticle);

		} catch( ClassCastException e ) {
			Log.e(TAG, "Your layout must provide an image and a text view.", e);
			throw e;
		}
		textTitle.setText(getItem(position).getTitre());
		DescText.setText(getItem(position).getDesc());
		image.setImageResource(getItem(position).getImage());

		return view;
	}




}