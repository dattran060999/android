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
import com.example.tiendat.asmlayout.khoanchi;
import com.example.tiendat.asmlayout.thongke_chi;

import java.util.ArrayList;

public class Adapter_thongkechi extends BaseAdapter {
    Context context;
    ArrayList<Okhoanchi> kc = new ArrayList<>();
//    thongke_chi fragment;

    public Adapter_thongkechi(Context context, ArrayList<Okhoanchi> kc) {
        this.context = context;
        this.kc = kc;
    }

    @Override
    public int getCount() {
        return kc.size();
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
        convertView=inf.inflate(R.layout.item_thongke_chi,null);
        TextView tex =convertView.findViewById(R.id.tvthongke1);
        TextView tex2 =convertView.findViewById(R.id.tvthongke2);
        final Okhoanchi okhoanchi =kc.get(position);
        tex.setText(okhoanchi.tenkhoanchi);
        tex2.setText(okhoanchi.loaichi);
        return convertView;
    }
}
