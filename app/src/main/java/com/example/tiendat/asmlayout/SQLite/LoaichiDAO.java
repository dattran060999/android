package com.example.tiendat.asmlayout.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tiendat.asmlayout.Model.Okhoanchi;
import com.example.tiendat.asmlayout.Model.Oloaichi;

import java.util.ArrayList;

public class LoaichiDAO {
    Dbhelper dbhelper;
    SQLiteDatabase db;
    public LoaichiDAO(Context context){
        dbhelper=new Dbhelper(context);
    }
    public void themkhoanchi(Oloaichi oloaichi) {
        db = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("loaichi",oloaichi.tenloaichi);
        db.insert("loaichi", null, values);
    }
    public ArrayList<Oloaichi> xemloaichi(){
        ArrayList<Oloaichi> lc = new ArrayList<>();
        db=dbhelper.getReadableDatabase();
        Cursor c = db.query("loaichi", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                int _id = c.getInt(0);
                String tenloaichi = c.getString(1);
                Oloaichi sv = new Oloaichi(tenloaichi,_id);
                lc.add(sv);
            } while (c.moveToNext());
        }
        return lc;
    }
    public void xoa(int _id){
        db=dbhelper.getWritableDatabase();
        db.delete("loaichi","_id=?",new String[]{_id+""});
    }
    public void sua(Oloaichi oloaichi){
        db=dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("loaichi",oloaichi.tenloaichi);
        db.update("loaichi",values,"_id=?",new String []{oloaichi._id+""});

    }
}
