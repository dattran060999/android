package com.example.tiendat.asmlayout.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tiendat.asmlayout.Model.Okhoanchi;

import java.util.ArrayList;

public class KhoanchiDAO {
    Dbhelper dbhelper;
    SQLiteDatabase db;
    public KhoanchiDAO(Context context){
        dbhelper = new Dbhelper(context);
    }
    public void themkhoanchi(Okhoanchi okhoanchi) {
        db = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("khoanchi",okhoanchi.tenkhoanchi);
        values.put("loaichi",okhoanchi.loaichi);
        db.insert("khoanchi", null, values);
    }
    public ArrayList<Okhoanchi>  xemkhoanchi(){
        ArrayList<Okhoanchi> kc = new ArrayList<>();
        db=dbhelper.getReadableDatabase();
        Cursor c = db.query("khoanchi", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                int _id = c.getInt(0);
                String tenkhoanchi = c.getString(1);
                String loaichi=c.getString(2);
                Okhoanchi sv = new Okhoanchi(tenkhoanchi,loaichi,_id);
                kc.add(sv);
            } while (c.moveToNext());
        }
        return kc;
    }
    public void xoa(int _id){
        db=dbhelper.getWritableDatabase();
        db.delete("khoanchi","_id=?",new String[]{_id+""});
    }
//    public void sualophoc(Okhoanchi okhoanchi){
//        db=dbhelper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("tenlop",okhoanchi.tenkhoanchi);
//        db.update("lophoc",values,"_id=?",new String []{okhoanchi._id+""});
//
//    }
}
