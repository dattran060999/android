package com.example.tiendat.asmlayout.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tiendat.asmlayout.MainActivity;
import com.example.tiendat.asmlayout.Model.Oloaichi;
import com.example.tiendat.asmlayout.R;
import com.example.tiendat.asmlayout.SQLite.LoaichiDAO;

import java.util.ArrayList;

public class Adapter_spinner extends BaseAdapter {
    Context context;
    ArrayList<Oloaichi> lc = new ArrayList<>();

    public Adapter_spinner(Context context, ArrayList<Oloaichi> lc) {
        this.context = context;
        this.lc = lc;
    }

    @Override
    public int getCount() {
        return lc.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inf =((MainActivity)context).getLayoutInflater();
        convertView =inf.inflate(R.layout.spinner,null);
        TextView ten=convertView.findViewById(R.id.tenthuoctinh);
        Oloaichi oloaichi =lc.get(position);
        ten.setText(oloaichi.tenloaichi);
        return convertView;
    }
}
