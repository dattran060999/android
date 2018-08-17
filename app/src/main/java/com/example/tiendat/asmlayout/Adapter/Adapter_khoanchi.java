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
import com.example.tiendat.asmlayout.Model.Oloaichi;
import com.example.tiendat.asmlayout.R;
import com.example.tiendat.asmlayout.SQLite.KhoanchiDAO;
import com.example.tiendat.asmlayout.SQLite.LoaichiDAO;
import com.example.tiendat.asmlayout.khoanchi;

import java.util.ArrayList;

public class Adapter_khoanchi extends BaseAdapter {
    Context context;
    ArrayList<Okhoanchi> kc = new ArrayList<>();
    ArrayList<Oloaichi> lc = new ArrayList<>();
    khoanchi fragment;
    public Adapter_khoanchi(Context context, ArrayList<Okhoanchi> kc, khoanchi fragment) {
        this.context = context;
        this.kc = kc;
        this.fragment=fragment;
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
        ImageView del=convertView.findViewById(R.id.delete);
        ImageView edit =convertView.findViewById(R.id.edit);
        final Okhoanchi okhoanchi =kc.get(position);
        tex.setText(okhoanchi.tenkhoanchi);
        tex2.setText(okhoanchi.loaichi);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               final int id =okhoanchi._id;
                KhoanchiDAO khoanchiDAO = new KhoanchiDAO((MainActivity)context);
                khoanchiDAO.xoa(id);
                fragment.capnhaths();
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_add_loaithu);
                Button dialogButton = (Button) dialog.findViewById(R.id.button3);
                final TextInputEditText text = dialog.findViewById(R.id.loaithu);
                final Spinner sp2 =dialog.findViewById(R.id.sp);
                LoaichiDAO loaichiDAO = new LoaichiDAO(context);
                lc=loaichiDAO.xemloaichi();
                Adapter_spinner adapter_spinner = new Adapter_spinner(context,lc);
                sp2.setAdapter(adapter_spinner);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id =okhoanchi._id;
                        int s=sp2.getSelectedItemPosition();
                        String tenkhoanchi = text.getText().toString();
                        String loaichi=lc.get(s).tenloaichi;
                        Okhoanchi okhoanchi = new Okhoanchi(tenkhoanchi,loaichi,id);
                        KhoanchiDAO khoanchidao = new KhoanchiDAO(context);
                        khoanchidao.suakhoanchi(okhoanchi);
                        fragment.capnhaths();
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        //hien khoan chi

        return convertView;
    }
}
