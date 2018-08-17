package com.example.tiendat.asmlayout.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tiendat.asmlayout.Model.Oloaichi;
import com.example.tiendat.asmlayout.Model.Oloaithu;

import java.util.ArrayList;

public class LoaithuDAO  {
    Dbhelper dbhelper;
    SQLiteDatabase db;

    public LoaithuDAO(Context context){
        dbhelper=new Dbhelper(context);
    }
    public void themloaithu(Oloaithu oloaithu) {
        db = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("loaithu",oloaithu.tenloaithu);
        db.insert("loaithu", null, values);
    }
    public ArrayList<Oloaithu> xemloaithu(){
        ArrayList<Oloaithu> lt = new ArrayList<>();
        db=dbhelper.getReadableDatabase();
        Cursor c = db.query("loaithu", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                int _id = c.getInt(0);
                String tenloaithu = c.getString(1);
                Oloaithu sv = new Oloaithu(tenloaithu,_id);
                lt.add(sv);
            } while (c.moveToNext());
        }
        return lt;
    }
    public void xoa(int _id){
        db=dbhelper.getWritableDatabase();
        db.delete("loaithu","_id=?",new String[]{_id+""});
    }
    public void sua(Oloaithu oloaithu){
        db=dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("loaithu",oloaithu.tenloaithu);
        db.update("loaithu",values,"_id=?",new String []{oloaithu._id+""});

    }
}
