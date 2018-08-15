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

public class Adapter_loaithu extends BaseAdapter {
    Context context;
    ArrayList<Oloaithu> lt = new ArrayList<>();

    public Adapter_loaithu(Context context, ArrayList<Oloaithu> lt) {
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
        LayoutInflater inf = ((MainActivity)context).getLayoutInflater();
        convertView =inf.inflate(R.layout.item_loaichi,null);
        TextView tvloaichi=convertView.findViewById(R.id.tvloaichi);
        Oloaithu oloaithu =lt.get(position);
        tvloaichi.setText(oloaithu.tenloaithu);
        return convertView;
    }
}
