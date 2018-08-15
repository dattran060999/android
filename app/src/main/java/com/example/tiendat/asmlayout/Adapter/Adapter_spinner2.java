package com.example.tiendat.asmlayout.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tiendat.asmlayout.MainActivity;
import com.example.tiendat.asmlayout.Model.Oloaichi;
import com.example.tiendat.asmlayout.Model.Oloaithu;
import com.example.tiendat.asmlayout.R;

import java.util.ArrayList;

public class Adapter_spinner2 extends BaseAdapter {
    Context context;
    ArrayList<Oloaithu> lt = new ArrayList<>();

    public Adapter_spinner2(Context context, ArrayList<Oloaithu> lt) {
        this.context = context;
        this.lt = lt;
    }

    @Override
    public int getCount() {
        return lt.size();
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
        Oloaithu oloaithu =lt.get(position);
        ten.setText(oloaithu.tenloaithu);
        return convertView;
    }
}
