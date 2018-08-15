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

public class Adapter_khoanchi extends BaseAdapter {
    Context context;
    ArrayList<Okhoanchi> kc = new ArrayList<>();
    ArrayList<Oloaichi> lc = new ArrayList<>();
    public Adapter_khoanchi(Context context, ArrayList<Okhoanchi> kc,ArrayList<Oloaichi> lc) {
        this.context = context;
        this.kc = kc;
        this.lc=lc;
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
        convertView =inf.inflate(R.layout.one_item,null);
        TextView tex =convertView.findViewById(R.id.tv);
        TextView tex2 =convertView.findViewById(R.id.tv2);
        //hien khoan chi
        Okhoanchi okhoanchi =kc.get(position);
        tex.setText(okhoanchi.tenkhoanchi);
        // hien loai chi
//        Oloaichi oloaichi = lc.get(position);
//        tex2.setText(oloaichi.tenloaichi);
        return convertView;
    }
}
