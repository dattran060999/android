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
import com.example.tiendat.asmlayout.loaichi;

import java.util.ArrayList;

public class Adapter_loaichi extends BaseAdapter {
    Context context;
    ArrayList<Oloaichi> lc = new ArrayList<>();
loaichi fragment2;
    public Adapter_loaichi(Context context, ArrayList<Oloaichi> lc,loaichi fragment2) {
        this.context = context;
        this.lc = lc;
        this.fragment2=fragment2;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inf = ((MainActivity)context).getLayoutInflater();
        convertView =inf.inflate(R.layout.item_loaichi,null);
        TextView tvloaichi=convertView.findViewById(R.id.tvloaichi);
        ImageView del=convertView.findViewById(R.id.delete);
        ImageView edit =convertView.findViewById(R.id.edit);
        final Oloaichi oloaichi =lc.get(position);
        tvloaichi.setText(oloaichi.tenloaichi);
//        fragment2.capnhaths();

        //xoa
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int id =oloaichi._id;
               LoaichiDAO loaichiDAO= new LoaichiDAO((MainActivity)context);
                loaichiDAO.xoa(id);
                fragment2.capnhaths();
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
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int _id = oloaichi._id;
                        String tenloaichi = text.getText().toString();
                        Oloaichi oloaichi = new Oloaichi(tenloaichi, _id);
                        LoaichiDAO loaichiDAO = new LoaichiDAO(context);
                        loaichiDAO.sua(oloaichi);
                        fragment2.capnhaths();
                        dialog.cancel();
                    }
                });
                dialog.show();
                //

            }
        });
        return convertView;
    }
}