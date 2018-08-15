package com.example.tiendat.asmlayout.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbhelper extends SQLiteOpenHelper {
    public Dbhelper(Context context) {
        super(context, "QLTC", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql= "create table khoanthu " +
                "(" +
                "_id integer primary key autoincrement, " +
                "khoanthu text, " +
                "loaithu text " +
                ")";
        db.execSQL(sql);
        String sql2= "create table loaithu " +
                "( " +
                "_id integer primary key autoincrement, " +
                "loaithu text " +
                ")";
        db.execSQL(sql2);
        String sql3= "create table loaichi " +
                "( " +
                "_id integer primary key autoincrement, " +
                "loaichi text " +
                ")";
        db.execSQL(sql3);
        String sql4= "create table khoanchi " +
                "( " +
                "_id integer primary key autoincrement, " +
                "khoanchi text, " +
                "loaichi text " +
                ")";
        db.execSQL(sql4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
