package com.example.tiendat.asmlayout.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tiendat.asmlayout.MainActivity;
import com.example.tiendat.asmlayout.Model.Okhoanchi;
import com.example.tiendat.asmlayout.Model.Oloaichi;
import com.example.tiendat.asmlayout.R;

import java.util.ArrayList;

public class Adapter_loaichi extends BaseAdapter {
    Context context;
    ArrayList<Oloaichi> lc = new ArrayList<>();

    public Adapter_loaichi(Context context, ArrayList<Oloaichi> lc) {
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
        LayoutInflater inf = ((MainActivity)context).getLayoutInflater();
        convertView =inf.inflate(R.layout.item_loaichi,null);
        TextView tvloaichi=convertView.findViewById(R.id.tvloaichi);
        Oloaichi oloaichi =lc.get(position);
        tvloaichi.setText(oloaichi.tenloaichi);
        return convertView;
    }
}
