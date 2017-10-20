package com.example.admin.mathman.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.admin.mathman.model.Player;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_CANDIDAT = "candidat";

    public static final String ID_CANDIDAT = "id";
    public static final String TYPE = "type";
    public static final String SCORE = "score";

    private static final int DATABASE_VERSION = 1;




    private static final String CREATE_CANDIDAT = "CREATE TABLE " + TABLE_CANDIDAT + " (" +
            ID_CANDIDAT + " INTEGER, " +
            TYPE + " TEXT, " +
            SCORE + " INTEGER );";

    public DBHelper(Context context) {
        super(context, TABLE_CANDIDAT, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(CREATE_CANDIDAT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CANDIDAT + ";");
        onCreate(db);
    }

    public boolean insertCandidat(Player c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TYPE, c.getType());
        contentValues.put(ID_CANDIDAT, c.getId());
        contentValues.put(SCORE, c.getScore());
        db.insert(TABLE_CANDIDAT, null, contentValues);
        return true;
    }


    public ArrayList<Player> getAllCandidat() {
        ArrayList<Player> array_list = new ArrayList<Player>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from candidat", null);

        if (res.moveToFirst()) {
            do {
                Player player = new Player();
                player.setId(res.getInt(0));
                player.setType(res.getString(1));
                player.setScore(res.getInt(2));
                array_list.add(player);
            } while (res.moveToNext());
        }
        return array_list;
    }


    public int Score(int id ,String type) {
        int score = 0;
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select score from candidat where id="+id+" and type='"+type+"'", null);

        if (res.moveToFirst()) {
            do {
                score=res.getInt(0);
            } while (res.moveToNext());
        }
        //return array_list;
        return score;
    }

    public void  UpdateCandidat(int id, String Type, int score) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE candidat\n" +
                "SET score = '"+score+"'\n" +
                "where id= "+id+" and type='"+Type+"';");
    }








}
