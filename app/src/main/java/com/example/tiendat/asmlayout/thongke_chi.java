package com.example.tiendat.asmlayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tiendat.asmlayout.Adapter.Adapter_thongkechi;
import com.example.tiendat.asmlayout.Model.Okhoanchi;
import com.example.tiendat.asmlayout.SQLite.KhoanchiDAO;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class thongke_chi extends Fragment {
ListView lisst;ArrayList<Okhoanchi> kc = new ArrayList<>();

    public thongke_chi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_thongke_chi, container, false);
        lisst=view.findViewById(R.id.list);
        KhoanchiDAO khoanchiDAO= new KhoanchiDAO(getActivity());
        kc=khoanchiDAO.xemkhoanchi();
        Adapter_thongkechi adapter_thongkechi= new Adapter_thongkechi(getActivity(),kc);
        lisst.setAdapter(adapter_thongkechi);
        return view;
    }

}
