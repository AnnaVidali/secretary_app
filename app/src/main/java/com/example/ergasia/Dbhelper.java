package com.example.ergasia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;

public class Dbhelper extends SQLiteOpenHelper implements BaseColumns {
    private static final String dbname = "STUDENTS";
    private static final int dbversion = 1;
    private static final String dbfname = "FNAME";
    private static final String dblname = "LNAME";
    private static final String dbage = "AGE";

    public Dbhelper(Context context){
        super(context, dbname, null, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + dbname + "(" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + dbfname + " VARCHAR(50), " + dblname + " VARCHAR(50), " + dbage + " INT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long insert(Info info){
        SQLiteDatabase sqldb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        long i = 0;
        values.put(Dbhelper.dbfname, info.getFname());
        values.put(Dbhelper.dblname, info.getLname());
        values.put(Dbhelper.dbage, info.getAge());
        i = sqldb.insert(Dbhelper.dbname, null, values);
        return i;
    }

    public ArrayList<Info> search(String fname){
        SQLiteDatabase sqldb = this.getReadableDatabase();
        Cursor cursor = sqldb.query(dbname, new String[]{BaseColumns._ID, dbfname, dblname, dbage}, "FNAME=?", new String[]{fname}, null, null, null);
        ArrayList<Info> info = new ArrayList<>();
        if(cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()){
                Info inf = new Info();
                inf.setId(cursor.getInt(0));
                inf.setFname(cursor.getString(1));
                inf.setLname(cursor.getString(2));
                inf.setAge(cursor.getInt(3));
                info.add(inf);
            }
        }
        return info;
    }
}
