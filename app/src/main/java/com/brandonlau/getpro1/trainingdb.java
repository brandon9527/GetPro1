package com.brandonlau.getpro1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Brandon Lau on 2/19/2017.
 */

public class trainingdb extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Training.db";

    //table for smash
    public static final String TABLE_NAME = "Smash";
    public static final String col1 = "SmashID"; // col = column
    public static final String col2 = "Halfcourtsmash";
    public static final String col3 = "Baselinesmash";

    //table for Net
    public static final String TABLE_NAME1 = "Net";
    public static final String col4 = "NetID";
    public static final String col5 = "Nettoright";
    public static final String col6 = "Nettoleft";
    public static final String col7 = "Cross_netright";
    public static final String col8 = "Cross_netleft";

    //table for Drop shot training
    public static final String TABLE_NAME2 = "DropShot";
    public static final String col9 = "DropshotID";
    public static final String col10 = "Droptoright";
    public static final String col11 = "Droptoleft";
    public static final String col12 = "Cross_dropright";
    public static final String col13 = "Cross_dropleft";

    //table for Clear shot training
    public static final String TABLE_NAME3 = "ClearShot";
    public static final String col14 = "ClearshotID";
    public static final String col15 = "Cleartoright";
    public static final String col16 = "Cleartoleft";
    public static final String col17 = "Cross_clearright";
    public static final String col18 = "Cross_clearleft";

    public trainingdb(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create TABLE_NAME(Smash) table in database
        db.execSQL("CREATE TABLE " +TABLE_NAME+ " (SmashID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Halfcourtsmash INTEGER, Baselinesmash INTEGER)");

        //create TABLE_NAME1(Net) table in database
        db.execSQL("CREATE TABLE " +TABLE_NAME1+ " (NetID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Nettoright INTEGER, Nettoleft INTEGER, Cross_netright INTEGER, " +
                "Cross_netleft INTEGER)");

        //create TABLE_NAME2(DropShot) table in database
        db.execSQL("CREATE TABLE " +TABLE_NAME2+ " (DropshotID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "Droptoright INTEGER, Droptoleft INTEGER, Cross_dropright INTEGER, " +
                "Cross_dropleft INTEGER)");

        //create TABLE_NAME3(ClearShot) table in database
        db.execSQL("CREATE TABLE " +TABLE_NAME3+ " (ClearshotID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "Cleartoright INTEGER, Cleartoleft INTEGER, Cross_clearright INTEGER, " +
                "Cross_clearleft INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //table will be drop when create table
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME3);
        onCreate(db);

    }


    //insert function for smash table
    public boolean insert(String halfcourtsmash, String baselinesmash){
        SQLiteDatabase db = this.getWritableDatabase() ;
        ContentValues addData = new ContentValues();
        addData.put(col2, halfcourtsmash);
        addData.put(col3, baselinesmash);
        long result = db.insert(TABLE_NAME, null, addData);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    //insert function for net table
    public boolean insert2(String nettoright, String nettoleft, String cross_netright,
                           String cross_netleft){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues addData2 = new ContentValues();
        addData2.put(col5, nettoright);
        addData2.put(col6, nettoleft);
        addData2.put(col7, cross_netright);
        addData2.put(col8, cross_netleft);
        long result = db.insert(TABLE_NAME1, null, addData2);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    //insert function for drop shot table
    public boolean insert3(String droptoright, String droptoleft, String cross_dropright,
                           String cross_dropleft){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues addData3 = new ContentValues();
        addData3.put(col10, droptoright);
        addData3.put(col11, droptoleft);
        addData3.put(col12, cross_dropright);
        addData3.put(col13, cross_dropleft);
        long result = db.insert(TABLE_NAME2, null, addData3);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    //insert function for clear shot table
    public boolean insert4(String cleartoright, String cleartoleft, String cross_clearright,
                           String cross_clearleft){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues addData4 = new ContentValues();
        addData4.put(col15, cleartoright);
        addData4.put(col16, cleartoleft);
        addData4.put(col17, cross_clearright);
        addData4.put(col18, cross_clearleft);
        long result = db.insert(TABLE_NAME3, null, addData4);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    //value will be selected and display on cursor for smash table
    public Cursor his(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor r = db.rawQuery("SELECT * FROM "+TABLE_NAME , null);
        return r;
    }

    //value will be selected and display on cursor for net table
    public Cursor his2(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor r2 = db.rawQuery("SELECT * FROM "+TABLE_NAME1, null);
        return r2;
    }

    //value will be selected and display on cursor for drop shot table
    public Cursor his3(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor r3 = db.rawQuery("SELECT * FROM " +TABLE_NAME2, null);
        return r3;
    }

    //value will be selected and display on cursor for clear shot table
    public Cursor his4(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor r4 = db.rawQuery("SELECT * FROM " +TABLE_NAME3, null);
        return r4;
    }

    //when  the function is called all value in the table will be delete
    public void Clear(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.delete(TABLE_NAME1, null, null);
        db.delete(TABLE_NAME2, null, null);
        db.delete(TABLE_NAME3, null, null);
        db.close();
    }

}

