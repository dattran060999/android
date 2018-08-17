package com.example.tiendat.asmlayout.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tiendat.asmlayout.Model.Okhoanchi;
import com.example.tiendat.asmlayout.Model.Okhoanthu;

import java.util.ArrayList;

public class KhoanthuDAO {
    Dbhelper dbhelper;
    SQLiteDatabase db;

    public KhoanthuDAO(Context context){
        dbhelper = new Dbhelper(context);
    }
    public void themkhoanthu(Okhoanthu okhoanthu) {
        db = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("khoanthu",okhoanthu.tenkhoanthu);
        values.put("loaithu",okhoanthu.loaithu);
        db.insert("khoanthu", null, values);
    }
    public ArrayList<Okhoanthu> xemkhoanthu(){
        ArrayList<Okhoanthu> kt = new ArrayList<>();
        db=dbhelper.getReadableDatabase();
        Cursor c = db.query("khoanthu", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                int _id = c.getInt(0);
                String tenkhoanthu = c.getString(1);
                String loaithu=c.getString(2);
                Okhoanthu okhoanthu = new Okhoanthu(tenkhoanthu,_id,loaithu);
                kt.add(okhoanthu);
            } while (c.moveToNext());
        }
        return kt;
    }
    public void xoa(int _id){
        db=dbhelper.getWritableDatabase();
        db.delete("khoanthu","_id=?",new String[]{_id+""});
    }
    public void suakhoanthu(Okhoanthu okhoanthu){
        db=dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("khoanthu",okhoanthu.tenkhoanthu);
        values.put("loaithu",okhoanthu.loaithu);
        values.put("_id",okhoanthu._id);
        db.update("khoanthu",values,"_id=?",new String []{okhoanthu._id+""});
    }
}

