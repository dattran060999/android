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
                Okhoanchi sv = new Okhoanchi(tenkhoanchi,_id);
                kc.add(sv);
            } while (c.moveToNext());
        }
        return kc;
    }
}
