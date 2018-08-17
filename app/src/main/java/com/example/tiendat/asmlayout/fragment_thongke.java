package com.example.tiendat.asmlayout;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_thongke extends Fragment {


    TabLayout tabvtk;
    ViewPager viewpgtk;
    public fragment_thongke() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_fragment_thongke,container,false);
        tabvtk=view.findViewById(R.id.tabs2);
        viewpgtk=view.findViewById(R.id.pager2);
Myadapter myadapter= new Myadapter(getActivity().getSupportFragmentManager());
        viewpgtk.setAdapter(myadapter);
        tabvtk.addTab(tabvtk.newTab().setText("Thong Ke Thu"));
        tabvtk.addTab(tabvtk.newTab().setText("Thong Ke Chi"));
        viewpgtk.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabvtk));
        tabvtk.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpgtk.setCurrentItem(tabvtk.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
class Myadapter extends FragmentStatePagerAdapter {
Fragment fragment;
    public Myadapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            fragment= new thongke_thu();
            Bundle bundle = new Bundle();
            fragment.setArguments(bundle);
        }
        if(position==1){
            fragment = new thongke_chi();
            Bundle bundle = new Bundle();
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
}
