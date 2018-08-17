package com.example.tiendat.asmlayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tiendat.asmlayout.Adapter.Adapter_thongkethu;
import com.example.tiendat.asmlayout.Model.Okhoanthu;
import com.example.tiendat.asmlayout.SQLite.KhoanthuDAO;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class thongke_thu extends Fragment {

ArrayList<Okhoanthu> kt = new ArrayList<>();
ListView listt;
    public thongke_thu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_thongke_thu, container, false);
        listt=view.findViewById(R.id.listt);
        KhoanthuDAO khoanthuDAO = new KhoanthuDAO(getActivity());
        kt=khoanthuDAO.xemkhoanthu();
        Adapter_thongkethu adapter_thongkethu= new Adapter_thongkethu(getActivity(),kt);
        listt.setAdapter(adapter_thongkethu);
        return view;
    }

}
