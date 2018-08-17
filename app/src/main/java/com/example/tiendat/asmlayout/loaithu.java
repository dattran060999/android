package com.example.tiendat.asmlayout;


import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.tiendat.asmlayout.Adapter.Adapter_loaichi;
import com.example.tiendat.asmlayout.Adapter.Adapter_loaithu;
import com.example.tiendat.asmlayout.Model.Okhoanchi;
import com.example.tiendat.asmlayout.Model.Okhoanthu;
import com.example.tiendat.asmlayout.Model.Oloaichi;
import com.example.tiendat.asmlayout.Model.Oloaithu;
import com.example.tiendat.asmlayout.SQLite.Dbhelper;
import com.example.tiendat.asmlayout.SQLite.LoaichiDAO;
import com.example.tiendat.asmlayout.SQLite.LoaithuDAO;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class loaithu extends Fragment {
    FloatingActionButton btn3;
    ListView lview3;
    Dbhelper dbhelper;
    ArrayList<Okhoanthu> kt = new ArrayList<>();
    ArrayList<Oloaithu> lt = new ArrayList<>();

    public loaithu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loaithu,container,false);
        btn3=view.findViewById(R.id.fab3);
        lview3=view.findViewById(R.id.lv3);
        capnhaths();
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_add_loaithu);
                Button dialogButton = (Button) dialog.findViewById(R.id.button3);
                final TextInputEditText text = dialog.findViewById(R.id.loaithu);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String tenloaithu=text.getText().toString();
                        Oloaithu oloaithu = new Oloaithu(tenloaithu);
                        LoaithuDAO loaithuDAO = new LoaithuDAO(getActivity());
                        loaithuDAO.themloaithu(oloaithu);
                        capnhaths();
                        dialog.cancel();
                    }
                });dialog.show();
            }

        });
        return view;
    }
    public void capnhaths(){
            LoaithuDAO loaichiDAO = new LoaithuDAO(getActivity());
            lt=loaichiDAO.xemloaithu();
            Adapter_loaithu adapter_loaichi = new Adapter_loaithu(getActivity(),lt,loaithu.this);
            lview3.setAdapter(adapter_loaichi);
        }
    }

