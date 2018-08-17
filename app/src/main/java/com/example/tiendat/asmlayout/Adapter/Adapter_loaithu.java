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
import android.widget.TextView;

import com.example.tiendat.asmlayout.MainActivity;
import com.example.tiendat.asmlayout.Model.Oloaichi;
import com.example.tiendat.asmlayout.Model.Oloaithu;
import com.example.tiendat.asmlayout.R;
import com.example.tiendat.asmlayout.SQLite.LoaichiDAO;
import com.example.tiendat.asmlayout.SQLite.LoaithuDAO;
import com.example.tiendat.asmlayout.loaithu;

import java.util.ArrayList;

public class Adapter_loaithu extends BaseAdapter {
    Context context;
    ArrayList<Oloaithu> lt = new ArrayList<>();
loaithu fragment2;
    public Adapter_loaithu(Context context, ArrayList<Oloaithu> lt,loaithu fragment2) {
        this.context = context;
        this.lt = lt;
        this.fragment2=fragment2;
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
        ImageView del=convertView.findViewById(R.id.delete);
        ImageView edit =convertView.findViewById(R.id.edit);
        final Oloaithu oloaithu =lt.get(position);
        tvloaichi.setText(oloaithu.tenloaithu);
        //xoa
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id =oloaithu._id;
                LoaithuDAO loaichiDAO= new LoaithuDAO((MainActivity)context);
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
                        int _id = oloaithu._id;
                        String tenloaithu = text.getText().toString();
                        Oloaithu oloaithu = new Oloaithu(tenloaithu, _id);
                        LoaithuDAO loaithuDAO = new LoaithuDAO(context);
                        loaithuDAO.sua(oloaithu);
                        fragment2.capnhaths();
                        dialog.cancel();
                    }
                });
                dialog.show();
                //

            }
        });
        //
        return convertView;
    }
}
