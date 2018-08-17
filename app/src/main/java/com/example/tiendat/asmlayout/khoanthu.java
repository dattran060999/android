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
import android.widget.Spinner;

import com.example.tiendat.asmlayout.Adapter.Adapter_khoanchi;
import com.example.tiendat.asmlayout.Adapter.Adapter_khoanthu;
import com.example.tiendat.asmlayout.Adapter.Adapter_spinner;
import com.example.tiendat.asmlayout.Adapter.Adapter_spinner2;
import com.example.tiendat.asmlayout.Model.Okhoanchi;
import com.example.tiendat.asmlayout.Model.Okhoanthu;
import com.example.tiendat.asmlayout.Model.Oloaichi;
import com.example.tiendat.asmlayout.Model.Oloaithu;
import com.example.tiendat.asmlayout.SQLite.Dbhelper;
import com.example.tiendat.asmlayout.SQLite.KhoanchiDAO;
import com.example.tiendat.asmlayout.SQLite.KhoanthuDAO;
import com.example.tiendat.asmlayout.SQLite.LoaithuDAO;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class khoanthu extends Fragment {
    Dbhelper dbhelper;
    ArrayList<Okhoanthu> kt = new ArrayList<>();
    ArrayList<Oloaithu> lt = new ArrayList<>();
    FloatingActionButton btn4;
    ListView listView4;

    public khoanthu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_khoanthu, container, false);
        btn4 = view.findViewById(R.id.fab4);
        listView4 = view.findViewById(R.id.lv4);
        capnhaths();
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_add_loaithu);
                Button dialogButton = (Button) dialog.findViewById(R.id.button3);
                final TextInputEditText text = dialog.findViewById(R.id.loaithu);
                final Spinner sp2 =dialog.findViewById(R.id.sp);
                LoaithuDAO loaithuDAO= new LoaithuDAO(getActivity());
                lt=loaithuDAO.xemloaithu();
                Adapter_spinner2 adapter_spinner = new Adapter_spinner2(getActivity(),lt);
                sp2.setAdapter(adapter_spinner);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int s=sp2.getSelectedItemPosition();
                        String tenkhoanthu = text.getText().toString();
                        String loaithu=lt.get(s).tenloaithu;
                        Okhoanthu okhoanthu= new Okhoanthu(tenkhoanthu,loaithu);
                        KhoanthuDAO khoanthuDAO= new KhoanthuDAO(getActivity());
                        khoanthuDAO.themkhoanthu(okhoanthu);
                        capnhaths();
                        dialog.cancel();
                    }

                });
                dialog.show();
            }
        });
        return view;

    }
    public void capnhaths(){
        KhoanthuDAO khoanthuDAO = new KhoanthuDAO(getActivity());
        kt=khoanthuDAO.xemkhoanthu();
        Adapter_khoanthu adapter_khoanchi = new Adapter_khoanthu(getActivity(),kt,khoanthu.this);
        listView4.setAdapter(adapter_khoanchi);
    }

}
