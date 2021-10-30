package com.example.taskreminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
public class DBHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    private static final String DATABASE_NAME = "Alarm3";
    private static final String TABLE_NAME = "Alarms";


    String CREATE_TABLE = "Create Table IF NOT EXISTS " + TABLE_NAME + " ( " +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " alaram_id INTEGER," +
            " title TEXT," +
            " enabled INTEGER," +
            " hour INTEGER," +
            " minute INTEGER," +
            " date INTEGER," +
            " month String ," +
            " day TEXT)";
    public DBHelper(Context applicationcontext) {
        super(applicationcontext, DATABASE_NAME, null,1);
    }



    public void insertStudent(String s)
    {
        db = this.getWritableDatabase();
        db.execSQL(s);
    }

    public void toggle_enable(int id,int enable_status)
    {
        db = this.getWritableDatabase();
        enable_status = 1 - enable_status;
        String query = "UPDATE "+TABLE_NAME +" SET enabled = "+enable_status+" WHERE alaram_id = "+id;
        db.execSQL(query);
    }

    public void updateAlarm(Alarm alarm){
        db =this.getWritableDatabase();
        String q = "UPDATE "+ TABLE_NAME+" SET title='"+alarm.getTitle()+ "', enabled = '"
                +alarm.isEnabled()+"', " +
                "hour='"+alarm.getHour()+ "', minute = '"+alarm.getMinute()+"', date = '"
                +alarm.getDate()+"' , month='"+alarm.getMonth()+ "', day = '"+alarm.getDay()+"'," +
                 "' WHERE _id="+alarm.getId();


        Log.d("update",q);
        db.execSQL(q);
        Log.d("all data","started");
        getAllData();
        db.close();
    }
    public List<Alarm> getAlarmbyID(int id)
    {

        List<Alarm> list =new  ArrayList< >() ;
        db =this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE _id = "+id;
        Cursor result = db.rawQuery(query,null);
        if (result.moveToFirst()){
            for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext())
            {
                int _id = result.getInt(0);
                int alarm_id = result.getInt(1);
                String title = result.getString(2);
                int enabled=result.getInt(3);
                int hour = result.getInt(5);
                int minute = result.getInt(6);
                int date = result.getInt(7);
                String month = result.getString(8);
                String day = result.getString(9);
                Alarm alarm = new Alarm(_id, alarm_id,title,enabled,hour,minute,date,month,day);
                list.add(alarm);
            }
        }
        db.close();
        return list;
    }

    public  void addAlarm(Alarm alarm){
        Log.d("BookHelper","Inserting a record");
        db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();

        cv.put("alaram_id",alarm.getAlarmId());
        cv.put("title",alarm.getTitle());
        cv.put("enabled",alarm.isEnabled());
        cv.put("hour",alarm.getHour());
        cv.put("minute",alarm.getMinute());

        cv.put("date",alarm.getDate());

        cv.put("month",alarm.getMonth());
        cv.put("day",alarm.getDay());

        db.insert(TABLE_NAME,null,cv);

    }

    public ArrayList<Alarm> getAllData()
    {
        ArrayList<Alarm> list =new  ArrayList< >() ;
        SQLiteDatabase db2 =this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor result = db2.rawQuery(query,null);
        if (result.moveToFirst()){
            for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext())
            {
                int _id = result.getInt(0);
                int alarm_id = result.getInt(1);
                String title = result.getString(2);
                int enabled=result.getInt(3);
                int hour = result.getInt(5);
                int minute = result.getInt(6);
                int date = result.getInt(7);
                String month = result.getString(8);
                String day = result.getString(9);
                Alarm alarm = new Alarm(_id, alarm_id,title,enabled,hour,minute,date,month,day);

                list.add(alarm);

            }
        }
        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()) {
            Log.d("s","----------------------------");
            Log.d("id",result.getInt(0)+"");
            Log.d("alarm_id",result.getInt(1)+"");
            Log.d("title",result.getString(2)+"");
            Log.d("enabled",result.getInt(3)+"");
            Log.d("hour",result.getInt(5)+"");
            Log.d("minute",result.getInt(6)+"");
            Log.d("date",result.getInt(7)+"");
            Log.d("month",result.getString(8)+"");
            Log.d("day",result.getString(9)+"");
        }

        db2.close();
        return list;
    }




    public void DeleteAllData(String tbl)
    {
        db =this.getReadableDatabase();
        String query = "delete FROM "+tbl;
        db.execSQL(query);
        db.close();
    }

    public void delete(int id)
    {
        db =this.getWritableDatabase();
        String query = "DELETE FROM "+TABLE_NAME+" WHERE alaram_id = "+id;
        db.execSQL(query);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("Alarm","Alarm table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}