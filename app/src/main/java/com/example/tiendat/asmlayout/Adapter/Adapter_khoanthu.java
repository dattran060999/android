package com.example.tiendat.asmlayout.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tiendat.asmlayout.MainActivity;
import com.example.tiendat.asmlayout.Model.Okhoanchi;
import com.example.tiendat.asmlayout.Model.Okhoanthu;
import com.example.tiendat.asmlayout.Model.Oloaichi;
import com.example.tiendat.asmlayout.Model.Oloaithu;
import com.example.tiendat.asmlayout.R;
import com.example.tiendat.asmlayout.SQLite.KhoanchiDAO;
import com.example.tiendat.asmlayout.SQLite.KhoanthuDAO;
import com.example.tiendat.asmlayout.SQLite.LoaichiDAO;
import com.example.tiendat.asmlayout.SQLite.LoaithuDAO;
import com.example.tiendat.asmlayout.khoanthu;

import java.util.ArrayList;

public class Adapter_khoanthu extends BaseAdapter {
    Context context;
   ArrayList<Okhoanthu> kt= new ArrayList<>();
   ArrayList<Oloaithu> lt = new ArrayList<>();
   khoanthu fragment;

    public Adapter_khoanthu(Context context, ArrayList<Okhoanthu> kt,khoanthu fragment) {
        this.context = context;
        this.kt = kt;
        this.fragment=fragment;
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
        //xoa
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int id =okhoanthu._id;
                KhoanthuDAO khoanthuDAO = new KhoanthuDAO((MainActivity)context);
                khoanthuDAO.xoa(id);
                fragment.capnhaths();
            }
        });
        //sua

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_add_loaithu);
                Button dialogButton = (Button) dialog.findViewById(R.id.button3);
                final TextInputEditText text = dialog.findViewById(R.id.loaithu);
                final Spinner sp2 =dialog.findViewById(R.id.sp);
                LoaithuDAO loaithuDAO = new LoaithuDAO(context);
                lt=loaithuDAO.xemloaithu();
                Adapter_spinner2 adapter_spinner = new Adapter_spinner2(context,lt);
                sp2.setAdapter(adapter_spinner);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id =okhoanthu._id;
                        int s=sp2.getSelectedItemPosition();
                        String tenkhoanchi = text.getText().toString();
                        String loaithu=lt.get(s).tenloaithu;
                        Okhoanthu okhoanthu = new Okhoanthu(tenkhoanchi,id,loaithu);
                        KhoanthuDAO khoanthudao = new KhoanthuDAO(context);
                        khoanthudao.suakhoanthu(okhoanthu);
                        fragment.capnhaths();
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

//
        return convertView;
    }
}
