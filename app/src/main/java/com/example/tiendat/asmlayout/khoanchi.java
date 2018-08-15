package com.example.tiendat.asmlayout;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiendat.asmlayout.Adapter.Adapter_khoanchi;
import com.example.tiendat.asmlayout.Adapter.Adapter_spinner;
import com.example.tiendat.asmlayout.Model.Okhoanchi;
import com.example.tiendat.asmlayout.Model.Oloaichi;
import com.example.tiendat.asmlayout.SQLite.Dbhelper;
import com.example.tiendat.asmlayout.SQLite.KhoanchiDAO;
import com.example.tiendat.asmlayout.SQLite.LoaichiDAO;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class khoanchi extends Fragment {
Dbhelper dbhelper;
ArrayList<Okhoanchi> kc = new ArrayList<>();
ArrayList<Oloaichi> lc = new ArrayList<>();
FloatingActionButton btn;
ListView listView;
    public khoanchi() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_khoanchi, container, false);
        btn = view.findViewById(R.id.fab);
        listView = view.findViewById(R.id.lv);
        capnhaths();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_add_loaithu);
                Button dialogButton = (Button) dialog.findViewById(R.id.button3);
                final TextInputEditText text = dialog.findViewById(R.id.loaithu);
                final Spinner sp2 =dialog.findViewById(R.id.sp);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String tenkhoanchi = text.getText().toString();
                        Okhoanchi okhoanchi = new Okhoanchi(tenkhoanchi);
                        KhoanchiDAO khoanchidao = new KhoanchiDAO(getActivity());
                        khoanchidao.themkhoanchi(okhoanchi);
                        LoaichiDAO loaichiDAO = new LoaichiDAO(getActivity());
                        lc=loaichiDAO.xemloaichi();
                        Adapter_spinner adapter_spinner = new Adapter_spinner(getActivity(),lc);
                        sp2.setAdapter(adapter_spinner);
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
        KhoanchiDAO kcdao = new KhoanchiDAO(getActivity());
        kc=kcdao.xemkhoanchi();
        LoaichiDAO lcdao = new LoaichiDAO(getActivity());
        lc=lcdao.xemloaichi();
        Adapter_khoanchi adapter_khoanchi = new Adapter_khoanchi(getActivity(),kc,lc);
        listView.setAdapter(adapter_khoanchi);
    }
}