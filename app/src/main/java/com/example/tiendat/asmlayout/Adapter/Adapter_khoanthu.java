package com.example.tiendat.asmlayout.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiendat.asmlayout.MainActivity;
import com.example.tiendat.asmlayout.Model.Okhoanchi;
import com.example.tiendat.asmlayout.Model.Okhoanthu;
import com.example.tiendat.asmlayout.Model.Oloaichi;
import com.example.tiendat.asmlayout.R;

import java.util.ArrayList;

public class Adapter_khoanthu extends BaseAdapter {
    Context context;
   ArrayList<Okhoanthu> kt= new ArrayList<>();

    public Adapter_khoanthu(Context context, ArrayList<Okhoanthu> kt) {
        this.context = context;
        this.kt = kt;
    }

    @Override
    public int getCount() {
        return kt.size();
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
        ImageView del=convertView.findViewById(R.id.delete);
        ImageView edit =convertView.findViewById(R.id.edit);
        final Okhoanthu okhoanthu = kt.get(position);
        tex.setText(okhoanthu.tenkhoanthu);
        tex2.setText(okhoanthu.loaithu);
        return convertView;
    }
}
