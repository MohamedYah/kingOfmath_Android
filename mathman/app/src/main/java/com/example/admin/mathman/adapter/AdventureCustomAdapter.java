package com.example.admin.mathman.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.admin.mathman.R;
import com.example.admin.mathman.activity.AdventureGameActivity;
import com.example.admin.mathman.helper.DBHelper;
import com.example.admin.mathman.model.Adventure;

import java.util.List;

public class AdventureCustomAdapter extends ArrayAdapter<Adventure> {

	  private final static String TAG = "ArticleAdapter";
	  private int resourceId = 0;
	  public Context mContext;
	 private LayoutInflater inflater;
	DBHelper db;



	  public AdventureCustomAdapter(Context context, int resourceId, List<Adventure> mediaItems) {
	    super(context, 0, mediaItems);
	    this.resourceId = resourceId;
		this.mContext = context;
	    inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	  }
	  
	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
		  db = new DBHelper(mContext.getApplicationContext());
		  final View view;
		  final ImageView image;
		  ImageView button1,button2,button3,button4,button5,button6,button7,button8,button9,button10;
		  view = inflater.inflate(resourceId, parent, false);
		  try {
			  image = (ImageView)view.findViewById(R.id.imgArticle);
			  button1=(ImageView)view.findViewById(R.id.imageButton1);button2=(ImageView)view.findViewById(R.id.imageButton2);
			  button3=(ImageView)view.findViewById(R.id.imageButton3);button4=(ImageView)view.findViewById(R.id.imageButton4);
			  button5=(ImageView)view.findViewById(R.id.imageButton5);button6=(ImageView)view.findViewById(R.id.imageButton6);
			  button7=(ImageView)view.findViewById(R.id.imageButton7);button8=(ImageView)view.findViewById(R.id.imageButton8);
			  button9=(ImageView)view.findViewById(R.id.imageButton9);button10=(ImageView)view.findViewById(R.id.imageButton10);
	    } catch( ClassCastException e ) {
	      Log.e(TAG, "Your layout must provide an image and a text view.", e);
	      throw e;
	    }
		  System.out.println(getItem(1));

		  image.setBackgroundResource(getItem(position).getImage());

		  DisplayMetrics metrics = new DisplayMetrics();
		  WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
		  windowManager.getDefaultDisplay().getMetrics(metrics);

		  int h = metrics.heightPixels;
		  int w = metrics.widthPixels;

		  if(position==0){
			  button1.setBackgroundResource(R.drawable.levellevel1); button2.setBackgroundResource(R.drawable.level2);
			  button3.setBackgroundResource(R.drawable.level3); button4.setBackgroundResource(R.drawable.level4);
			  button5.setBackgroundResource(R.drawable.level5); button6.setBackgroundResource(R.drawable.level6);
			  button7.setBackgroundResource(R.drawable.level7); button8.setBackgroundResource(R.drawable.level8);
			  button9.setBackgroundResource(R.drawable.level9); button10.setBackgroundResource(R.drawable.level10);


			  ((ViewGroup.MarginLayoutParams) button1.getLayoutParams()).leftMargin = ((w / 4) - 20);
			  ((ViewGroup.MarginLayoutParams) button1.getLayoutParams()).topMargin = h / 16;

			  ((ViewGroup.MarginLayoutParams) button2.getLayoutParams()).leftMargin = ((w / 3));
			  ((ViewGroup.MarginLayoutParams) button2.getLayoutParams()).topMargin = h / 6;

			  ((ViewGroup.MarginLayoutParams) button3.getLayoutParams()).leftMargin = 450;
			  ((ViewGroup.MarginLayoutParams) button3.getLayoutParams()).topMargin = h / 6;

			  ((ViewGroup.MarginLayoutParams) button4.getLayoutParams()).leftMargin = 630;
			  ((ViewGroup.MarginLayoutParams) button4.getLayoutParams()).topMargin = 300;

			  ((ViewGroup.MarginLayoutParams) button5.getLayoutParams()).leftMargin = 370;
			  ((ViewGroup.MarginLayoutParams) button5.getLayoutParams()).topMargin = 370;

			  ((ViewGroup.MarginLayoutParams) button6.getLayoutParams()).leftMargin = 130;
			  ((ViewGroup.MarginLayoutParams) button6.getLayoutParams()).topMargin = 400;

			  ((ViewGroup.MarginLayoutParams) button7.getLayoutParams()).leftMargin = 300;
			  ((ViewGroup.MarginLayoutParams) button7.getLayoutParams()).topMargin = 510;


			  ((ViewGroup.MarginLayoutParams) button8.getLayoutParams()).leftMargin = 640;
			  ((ViewGroup.MarginLayoutParams) button8.getLayoutParams()).topMargin = 600;

			  ((ViewGroup.MarginLayoutParams) button9.getLayoutParams()).leftMargin = 280;
			  ((ViewGroup.MarginLayoutParams) button9.getLayoutParams()).topMargin = 750;

			  ((ViewGroup.MarginLayoutParams) button10.getLayoutParams()).leftMargin = 530;
			  ((ViewGroup.MarginLayoutParams) button10.getLayoutParams()).topMargin = 870;

			  button1.setOnClickListener(new View.OnClickListener() {
				  @Override
				  public void onClick(View v) {


					  Intent ve=new Intent(mContext.getApplicationContext(),AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					  ve.putExtra("diffuclity2", "");
					  ve.putExtra("diffuclity", "1");
					  ve.putExtra("id", 1);
					  ve.putExtra("operation", "Addition");
					  mContext.getApplicationContext().startActivity(ve);
					  System.exit(0);

				  }
			  });
			  if(db.Score(1,"Addition")>0){

				  button2.setBackgroundResource(R.drawable.levellevel2);
				  button2.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve=new Intent(mContext.getApplicationContext(),AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "1");
						  ve.putExtra("diffuclity", "2");
						  ve.putExtra("id",2);
						  ve.putExtra("operation","Addition");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);



					  }
				  });
			  }

			  if(db.Score(2,"Addition")>0){

				  button3.setBackgroundResource(R.drawable.levellevel3);
				  button3.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve=new Intent(mContext.getApplicationContext(),AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "2");
						  ve.putExtra("diffuclity", "3");
						  ve.putExtra("id",3);
						  ve.putExtra("operation","Addition");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);



					  }
				  });
			  }
			  if(db.Score(3,"Addition")>0){

				  button4.setBackgroundResource(R.drawable.levellevel4);
				  button4.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve=new Intent(mContext.getApplicationContext(),AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "3");
						  ve.putExtra("diffuclity", "4");
						  ve.putExtra("id",4);
						  ve.putExtra("operation","Addition");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);



					  }
				  });
				  if(db.Score(4,"Addition")>0){

					  button5.setBackgroundResource(R.drawable.levellevel5);
					  button5.setOnClickListener(new View.OnClickListener() {
						  @Override
						  public void onClick(View v) {
							  Intent ve=new Intent(mContext.getApplicationContext(),AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

							  ve.putExtra("diffuclity2", "4");
							  ve.putExtra("diffuclity", "5");
							  ve.putExtra("id",5);
							  ve.putExtra("operation","Addition");
							  mContext.getApplicationContext().startActivity(ve);
							  System.exit(0);



						  }
					  });}
				  if(db.Score(5,"Addition")>0){

					  button6.setBackgroundResource(R.drawable.levellevel6);
					  button6.setOnClickListener(new View.OnClickListener() {
						  @Override
						  public void onClick(View v) {
							  Intent ve=new Intent(mContext.getApplicationContext(),AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

							  ve.putExtra("diffuclity2", "5");
							  ve.putExtra("diffuclity", "6");
							  ve.putExtra("id",6);
							  ve.putExtra("operation","Addition");
							  mContext.getApplicationContext().startActivity(ve);
							  System.exit(0);



						  }
					  });}
				  if(db.Score(6,"Addition")>0){

					  button7.setBackgroundResource(R.drawable.levellevel7);
					  button7.setOnClickListener(new View.OnClickListener() {
						  @Override
						  public void onClick(View v) {
							  Intent ve=new Intent(mContext.getApplicationContext(),AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

							  ve.putExtra("diffuclity2", "6");
							  ve.putExtra("diffuclity", "7");
							  ve.putExtra("id",7);
							  ve.putExtra("operation","Addition");
							  mContext.getApplicationContext().startActivity(ve);
							  System.exit(0);



						  }
					  });}
				  if(db.Score(7,"Addition")>0){

					  button8.setBackgroundResource(R.drawable.levellevel8);
					  button8.setOnClickListener(new View.OnClickListener() {
						  @Override
						  public void onClick(View v) {
							  Intent ve=new Intent(mContext.getApplicationContext(),AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

							  ve.putExtra("diffuclity2", "7");
							  ve.putExtra("diffuclity", "8");
							  ve.putExtra("id",8);
							  ve.putExtra("operation","Addition");
							  mContext.getApplicationContext().startActivity(ve);
							  System.exit(0);



						  }
					  });}

				  if(db.Score(8,"Addition")>0){

					  button9.setBackgroundResource(R.drawable.levellevel9);
					  button9.setOnClickListener(new View.OnClickListener() {
						  @Override
						  public void onClick(View v) {
							  Intent ve=new Intent(mContext.getApplicationContext(),AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

							  ve.putExtra("diffuclity2", "8");
							  ve.putExtra("diffuclity", "9");
							  ve.putExtra("id",9);
							  ve.putExtra("operation","Addition");
							  mContext.getApplicationContext().startActivity(ve);
							  System.exit(0);



						  }
					  });}
				  if(db.Score(9,"Addition")>0){

					  button10.setBackgroundResource(R.drawable.levellevel10);
					  button10.setOnClickListener(new View.OnClickListener() {
						  @Override
						  public void onClick(View v) {
							  Intent ve=new Intent(mContext.getApplicationContext(),AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

							  ve.putExtra("diffuclity2", "9");
							  ve.putExtra("diffuclity", "10");
							  ve.putExtra("id",10);
							  ve.putExtra("operation","Addition");
							  mContext.getApplicationContext().startActivity(ve);
							  System.exit(0);
						  }
					  });}








			  }



		  }
		      if(position==1){
				  button1.setBackgroundResource(R.drawable.level11); button2.setBackgroundResource(R.drawable.level12);
				  button3.setBackgroundResource(R.drawable.level13); button4.setBackgroundResource(R.drawable.level14);
				  button5.setBackgroundResource(R.drawable.level15); button6.setBackgroundResource(R.drawable.level16);
				  button7.setBackgroundResource(R.drawable.level17); button8.setBackgroundResource(R.drawable.level18);
				  button9.setBackgroundResource(R.drawable.level19); button10.setBackgroundResource(R.drawable.level20);



				  ((ViewGroup.MarginLayoutParams) button1.getLayoutParams()).leftMargin = 110;

				  ((ViewGroup.MarginLayoutParams) button2.getLayoutParams()).leftMargin = 80;
				  ((ViewGroup.MarginLayoutParams) button2.getLayoutParams()).topMargin = 170;


				  ((ViewGroup.MarginLayoutParams) button3.getLayoutParams()).leftMargin = 250;
				  ((ViewGroup.MarginLayoutParams) button3.getLayoutParams()).topMargin = 250;

				  ((ViewGroup.MarginLayoutParams) button4.getLayoutParams()).leftMargin = 530;
				  ((ViewGroup.MarginLayoutParams) button4.getLayoutParams()).topMargin = 180;

				  ((ViewGroup.MarginLayoutParams) button5.getLayoutParams()).leftMargin = 560;
				  ((ViewGroup.MarginLayoutParams) button5.getLayoutParams()).topMargin = 350;

				  ((ViewGroup.MarginLayoutParams) button6.getLayoutParams()).leftMargin = 380;
				  ((ViewGroup.MarginLayoutParams) button6.getLayoutParams()).topMargin = 450;

				  ((ViewGroup.MarginLayoutParams) button7.getLayoutParams()).leftMargin = 520;
				  ((ViewGroup.MarginLayoutParams) button7.getLayoutParams()).topMargin = 550;


				  ((ViewGroup.MarginLayoutParams) button8.getLayoutParams()).leftMargin = 210;
				  ((ViewGroup.MarginLayoutParams) button8.getLayoutParams()).topMargin = 670;


				  ((ViewGroup.MarginLayoutParams) button9.getLayoutParams()).leftMargin = 600;
				  ((ViewGroup.MarginLayoutParams) button9.getLayoutParams()).topMargin = 700;


				  ((ViewGroup.MarginLayoutParams) button10.getLayoutParams()).leftMargin = 600;
				  ((ViewGroup.MarginLayoutParams) button10.getLayoutParams()).topMargin = 870;

				  if(db.Score(10,"Addition")>0){

					  button1.setBackgroundResource(R.drawable.levellevel11);
					  button1.setOnClickListener(new View.OnClickListener() {
						  @Override
						  public void onClick(View v) {
							  Intent ve=new Intent(mContext.getApplicationContext(),AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

							  ve.putExtra("diffuclity2", "0");
							  ve.putExtra("diffuclity", "1");
							  ve.putExtra("id",1);
							  ve.putExtra("operation","soustraction");
							  mContext.getApplicationContext().startActivity(ve);
							  System.exit(0);



						  }
					  });
				  }

				  if(db.Score(1,"soustraction")>0){

					  button2.setBackgroundResource(R.drawable.levellevel12);
					  button2.setOnClickListener(new View.OnClickListener() {
						  @Override
						  public void onClick(View v) {
							  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

							  ve.putExtra("diffuclity2", "1");
							  ve.putExtra("diffuclity", "2");
							  ve.putExtra("id", 2);
							  ve.putExtra("operation", "soustraction");
							  mContext.getApplicationContext().startActivity(ve);
							  System.exit(0);


						  }
					  });
				  }

				  if(db.Score(2,"soustraction")>0){

					  button3.setBackgroundResource(R.drawable.levellevel13);
					  button3.setOnClickListener(new View.OnClickListener() {
						  @Override
						  public void onClick(View v) {
							  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

							  ve.putExtra("diffuclity2", "2");
							  ve.putExtra("diffuclity", "3");
							  ve.putExtra("id", 3);
							  ve.putExtra("operation", "soustraction");
							  mContext.getApplicationContext().startActivity(ve);
							  System.exit(0);


						  }
					  });
				  }

				  if(db.Score(3,"soustraction")>0){

					  button4.setBackgroundResource(R.drawable.levellevel14);
					  button4.setOnClickListener(new View.OnClickListener() {
						  @Override
						  public void onClick(View v) {
							  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

							  ve.putExtra("diffuclity2", "3");
							  ve.putExtra("diffuclity", "4");
							  ve.putExtra("id", 4);
							  ve.putExtra("operation", "soustraction");
							  mContext.getApplicationContext().startActivity(ve);
							  System.exit(0);


						  }
					  });
				  }

				  if(db.Score(4,"soustraction")>0){

					  button5.setBackgroundResource(R.drawable.levellevel15);
					  button5.setOnClickListener(new View.OnClickListener() {
						  @Override
						  public void onClick(View v) {
							  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

							  ve.putExtra("diffuclity2", "4");
							  ve.putExtra("diffuclity", "5");
							  ve.putExtra("id", 5);
							  ve.putExtra("operation", "soustraction");
							  mContext.getApplicationContext().startActivity(ve);
							  System.exit(0);


						  }
					  });
				  }

				  if(db.Score(5,"soustraction")>0){

					  button6.setBackgroundResource(R.drawable.levellevel16);
					  button6.setOnClickListener(new View.OnClickListener() {
						  @Override
						  public void onClick(View v) {
							  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

							  ve.putExtra("diffuclity2", "5");
							  ve.putExtra("diffuclity", "6");
							  ve.putExtra("id", 6);
							  ve.putExtra("operation", "soustraction");
							  mContext.getApplicationContext().startActivity(ve);
							  System.exit(0);


						  }
					  });
				  }
				  if(db.Score(6,"soustraction")>0){

					  button7.setBackgroundResource(R.drawable.levellevel17);
					  button7.setOnClickListener(new View.OnClickListener() {
						  @Override
						  public void onClick(View v) {
							  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

							  ve.putExtra("diffuclity2", "6");
							  ve.putExtra("diffuclity", "7");
							  ve.putExtra("id", 7);
							  ve.putExtra("operation", "soustraction");
							  mContext.getApplicationContext().startActivity(ve);
							  System.exit(0);


						  }
					  });
				  }
				  if(db.Score(7,"soustraction")>0){

					  button8.setBackgroundResource(R.drawable.levellevel18);
					  button8.setOnClickListener(new View.OnClickListener() {
						  @Override
						  public void onClick(View v) {
							  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

							  ve.putExtra("diffuclity2", "7");
							  ve.putExtra("diffuclity", "8");
							  ve.putExtra("id", 8);
							  ve.putExtra("operation", "soustraction");
							  mContext.getApplicationContext().startActivity(ve);
							  System.exit(0);


						  }
					  });
				  }
				  if(db.Score(8,"soustraction")>0){

					  button9.setBackgroundResource(R.drawable.levellevel19);
					  button9.setOnClickListener(new View.OnClickListener() {
						  @Override
						  public void onClick(View v) {
							  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

							  ve.putExtra("diffuclity2", "8");
							  ve.putExtra("diffuclity", "9");
							  ve.putExtra("id", 9);
							  ve.putExtra("operation", "soustraction");
							  mContext.getApplicationContext().startActivity(ve);
							  System.exit(0);


						  }
					  });
				  }
				  if(db.Score(9,"soustraction")>0){

					  button10.setBackgroundResource(R.drawable.levellevel20);
					  button10.setOnClickListener(new View.OnClickListener() {
						  @Override
						  public void onClick(View v) {
							  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

							  ve.putExtra("diffuclity2", "9");
							  ve.putExtra("diffuclity", "10");
							  ve.putExtra("id", 10);
							  ve.putExtra("operation", "soustraction");
							  mContext.getApplicationContext().startActivity(ve);
							  System.exit(0);


						  }
					  });
				  }


		  }
		  if(position==2){
			  button1.setBackgroundResource(R.drawable.level21); button2.setBackgroundResource(R.drawable.level22);
			  button3.setBackgroundResource(R.drawable.level23); button4.setBackgroundResource(R.drawable.level24);
			  button5.setBackgroundResource(R.drawable.level25); button6.setBackgroundResource(R.drawable.level26);
			  button7.setBackgroundResource(R.drawable.level27); button8.setBackgroundResource(R.drawable.level28);
			  button9.setBackgroundResource(R.drawable.level29); button10.setBackgroundResource(R.drawable.level30);


			  ((ViewGroup.MarginLayoutParams) button1.getLayoutParams()).leftMargin = 180;
			  //  ((ViewGroup.MarginLayoutParams) button1.getLayoutParams()).topMargin = 110;

			  ((ViewGroup.MarginLayoutParams) button2.getLayoutParams()).leftMargin = 80;
			  ((ViewGroup.MarginLayoutParams) button2.getLayoutParams()).topMargin = 170;


			  ((ViewGroup.MarginLayoutParams) button3.getLayoutParams()).leftMargin = 250;
			  ((ViewGroup.MarginLayoutParams) button3.getLayoutParams()).topMargin = 250;

			  ((ViewGroup.MarginLayoutParams) button4.getLayoutParams()).leftMargin = 530;
			  ((ViewGroup.MarginLayoutParams) button4.getLayoutParams()).topMargin = 180;

			  ((ViewGroup.MarginLayoutParams) button5.getLayoutParams()).leftMargin = 560;
			  ((ViewGroup.MarginLayoutParams) button5.getLayoutParams()).topMargin = 350;

			  ((ViewGroup.MarginLayoutParams) button6.getLayoutParams()).leftMargin = 490;
			  ((ViewGroup.MarginLayoutParams) button6.getLayoutParams()).topMargin = 450;

			  ((ViewGroup.MarginLayoutParams) button7.getLayoutParams()).leftMargin = 270;
			  ((ViewGroup.MarginLayoutParams) button7.getLayoutParams()).topMargin = 500;


			  ((ViewGroup.MarginLayoutParams) button8.getLayoutParams()).leftMargin = 210;
			  ((ViewGroup.MarginLayoutParams) button8.getLayoutParams()).topMargin = 670;


			  ((ViewGroup.MarginLayoutParams) button9.getLayoutParams()).leftMargin = 500;
			  ((ViewGroup.MarginLayoutParams) button9.getLayoutParams()).topMargin = 700;


			  ((ViewGroup.MarginLayoutParams) button10.getLayoutParams()).leftMargin = 570;
			  ((ViewGroup.MarginLayoutParams) button10.getLayoutParams()).topMargin = 870;



			  if(db.Score(10,"soustraction")>0){

				  button1.setBackgroundResource(R.drawable.levellevel21);
				  button1.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "0");
						  ve.putExtra("diffuclity", "1");
						  ve.putExtra("id", 1);
						  ve.putExtra("operation", "multiplication");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }

			  if(db.Score(1,"multiplication")>0){

				  button2.setBackgroundResource(R.drawable.levellevel22);
				  button2.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "1");
						  ve.putExtra("diffuclity", "2");
						  ve.putExtra("id", 2);
						  ve.putExtra("operation", "multiplication");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }

			  if(db.Score(2,"multiplication")>0){

				  button3.setBackgroundResource(R.drawable.levellevel23);
				  button3.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "2");
						  ve.putExtra("diffuclity", "3");
						  ve.putExtra("id", 3);
						  ve.putExtra("operation", "multiplication");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }

			  if(db.Score(3,"multiplication")>0){

				  button4.setBackgroundResource(R.drawable.levellevel24);
				  button4.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "3");
						  ve.putExtra("diffuclity", "4");
						  ve.putExtra("id", 4);
						  ve.putExtra("operation", "multiplication");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }
			  if(db.Score(4,"multiplication")>0){

				  button5.setBackgroundResource(R.drawable.levellevel25);
				  button5.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "4");
						  ve.putExtra("diffuclity", "5");
						  ve.putExtra("id", 5);
						  ve.putExtra("operation", "multiplication");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }

			  if(db.Score(5,"multiplication")>0){

				  button6.setBackgroundResource(R.drawable.levellevel26);
				  button6.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "5");
						  ve.putExtra("diffuclity", "6");
						  ve.putExtra("id", 6);
						  ve.putExtra("operation", "multiplication");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }

			  if(db.Score(6,"multiplication")>0){

				  button7.setBackgroundResource(R.drawable.levellevel27);
				  button7.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "6");
						  ve.putExtra("diffuclity", "7");
						  ve.putExtra("id", 7);
						  ve.putExtra("operation", "multiplication");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }

			  if(db.Score(7,"multiplication")>0){

				  button8.setBackgroundResource(R.drawable.levellevel28);
				  button8.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "7");
						  ve.putExtra("diffuclity", "8");
						  ve.putExtra("id", 8);
						  ve.putExtra("operation", "multiplication");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }

			  if(db.Score(8,"multiplication")>0){

				  button9.setBackgroundResource(R.drawable.levellevel29);
				  button9.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "8");
						  ve.putExtra("diffuclity", "9");
						  ve.putExtra("id", 9);
						  ve.putExtra("operation", "multiplication");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }

			  if(db.Score(9,"multiplication")>0){

				  button10.setBackgroundResource(R.drawable.levellevel30);
				  button10.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "9");
						  ve.putExtra("diffuclity", "10");
						  ve.putExtra("id", 10);
						  ve.putExtra("operation", "multiplication");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }

		  }
		  if(position==3){

			  button1.setBackgroundResource(R.drawable.level31); button2.setBackgroundResource(R.drawable.level32);
			  button3.setBackgroundResource(R.drawable.level33); button4.setBackgroundResource(R.drawable.level34);
			  button5.setBackgroundResource(R.drawable.level35); button6.setBackgroundResource(R.drawable.level36);
			  button7.setBackgroundResource(R.drawable.level37); button8.setBackgroundResource(R.drawable.level38);


			  ((ViewGroup.MarginLayoutParams) button1.getLayoutParams()).leftMargin = 180;
			  // ((ViewGroup.MarginLayoutParams) button1.getLayoutParams()).topMargin = 10;

			  ((ViewGroup.MarginLayoutParams) button2.getLayoutParams()).leftMargin = 160;
			  ((ViewGroup.MarginLayoutParams) button2.getLayoutParams()).topMargin = 170;

			  ((ViewGroup.MarginLayoutParams) button3.getLayoutParams()).leftMargin = 430;
			  ((ViewGroup.MarginLayoutParams) button3.getLayoutParams()).topMargin = 280;

			  ((ViewGroup.MarginLayoutParams) button4.getLayoutParams()).leftMargin = 630;
			  ((ViewGroup.MarginLayoutParams) button4.getLayoutParams()).topMargin = 400;

			  ((ViewGroup.MarginLayoutParams) button5.getLayoutParams()).leftMargin = 500;
			  ((ViewGroup.MarginLayoutParams) button5.getLayoutParams()).topMargin = 550;

			  ((ViewGroup.MarginLayoutParams) button6.getLayoutParams()).leftMargin = 300;
			  ((ViewGroup.MarginLayoutParams) button6.getLayoutParams()).topMargin = 530;

			  ((ViewGroup.MarginLayoutParams) button7.getLayoutParams()).leftMargin = 100;
			  ((ViewGroup.MarginLayoutParams) button7.getLayoutParams()).topMargin = 570;

			  ((ViewGroup.MarginLayoutParams) button8.getLayoutParams()).leftMargin = 270;
			  ((ViewGroup.MarginLayoutParams) button8.getLayoutParams()).topMargin = 750;


			  button9.setVisibility(View.GONE);
			  button10.setVisibility(View.GONE);




			  if(db.Score(10,"multiplication")>0){

				  button1.setBackgroundResource(R.drawable.levellevel31);
				  button1.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "0");
						  ve.putExtra("diffuclity", "1");
						  ve.putExtra("id", 1);
						  ve.putExtra("operation", "division");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }

			  if(db.Score(1,"division")>0){

				  button2.setBackgroundResource(R.drawable.levellevel32);
				  button2.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "1");
						  ve.putExtra("diffuclity", "2");
						  ve.putExtra("id", 2);
						  ve.putExtra("operation", "division");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }

			  if(db.Score(2,"division")>0){

				  button3.setBackgroundResource(R.drawable.levellevel33);
				  button3.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "2");
						  ve.putExtra("diffuclity", "3");
						  ve.putExtra("id", 3);
						  ve.putExtra("operation", "division");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }
			  if(db.Score(3,"division")>0){

				  button4.setBackgroundResource(R.drawable.levellevel34);
				  button4.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "3");
						  ve.putExtra("diffuclity", "4");
						  ve.putExtra("id", 4);
						  ve.putExtra("operation", "division");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }
			  if(db.Score(4,"division")>0){

				  button5.setBackgroundResource(R.drawable.levellevel35);
				  button5.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "4");
						  ve.putExtra("diffuclity", "5");
						  ve.putExtra("id", 5);
						  ve.putExtra("operation", "division");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }
			  if(db.Score(5,"division")>0){

				  button6.setBackgroundResource(R.drawable.levellevel36);
				  button6.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "5");
						  ve.putExtra("diffuclity", "6");
						  ve.putExtra("id", 6);
						  ve.putExtra("operation", "division");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }
			  if(db.Score(6,"division")>0) {

				  button7.setBackgroundResource(R.drawable.levellevel37);
				  button7.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "6");
						  ve.putExtra("diffuclity", "7");
						  ve.putExtra("id", 7);
						  ve.putExtra("operation", "division");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }
			  if(db.Score(7,"division")>0){

				  button8.setBackgroundResource(R.drawable.levellevel38);
				  button8.setOnClickListener(new View.OnClickListener() {
					  @Override
					  public void onClick(View v) {
						  Intent ve = new Intent(mContext.getApplicationContext(), AdventureGameActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

						  ve.putExtra("diffuclity2", "7");
						  ve.putExtra("diffuclity", "8");
						  ve.putExtra("id", 8);
						  ve.putExtra("operation", "division");
						  mContext.getApplicationContext().startActivity(ve);
						  System.exit(0);


					  }
				  });
			  }

		  }




		  return view;
	  }

	}