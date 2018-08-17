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

import com.example.tiendat.asmlayout.Adapter.Adapter_khoanchi;
import com.example.tiendat.asmlayout.Adapter.Adapter_loaichi;
import com.example.tiendat.asmlayout.Model.Okhoanchi;
import com.example.tiendat.asmlayout.Model.Oloaichi;
import com.example.tiendat.asmlayout.SQLite.Dbhelper;
import com.example.tiendat.asmlayout.SQLite.KhoanchiDAO;
import com.example.tiendat.asmlayout.SQLite.LoaichiDAO;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class loaichi extends Fragment {
    FloatingActionButton btn2;
    ListView lview2;
    Dbhelper dbhelper;
    ArrayList<Okhoanchi> kc = new ArrayList<>();
    ArrayList<Oloaichi> lc = new ArrayList<>();
    public loaichi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_loaichi,container,false);
        btn2=view.findViewById(R.id.fab2);
        lview2=view.findViewById(R.id.lv2);
        capnhaths();
btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_add_loaithu);
        Button dialogButton = (Button) dialog.findViewById(R.id.button3);
        final TextInputEditText text = dialog.findViewById(R.id.loaithu);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenloaichi=text.getText().toString();
                Oloaichi oloaichi = new Oloaichi(tenloaichi);
                LoaichiDAO loaichiDAO = new LoaichiDAO(getActivity());
                loaichiDAO.themkhoanchi(oloaichi);
                capnhaths();
                dialog.cancel();
            }
        });dialog.show();
    }

});
        return view;
    }
    public void capnhaths(){
       LoaichiDAO loaichiDAO = new LoaichiDAO(getActivity());
        lc=loaichiDAO.xemloaichi();
        Adapter_loaichi adapter_loaichi = new Adapter_loaichi(getActivity(),lc,loaichi.this);
        lview2.setAdapter(adapter_loaichi);
    }

}
