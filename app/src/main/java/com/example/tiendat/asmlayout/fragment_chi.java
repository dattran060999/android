package com.example.tiendat.asmlayout;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_chi extends Fragment {
TabLayout tabv;
ViewPager viewpg;
    public fragment_chi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_fragment_chi,container,false);
        tabv=view.findViewById(R.id.tabs);
        viewpg=view.findViewById(R.id.pager);
        Myadapter myadapter = new Myadapter(getActivity().getSupportFragmentManager());
        viewpg.setAdapter(myadapter);
        tabv.addTab(tabv.newTab().setText("Khoan Chi"));
        tabv.addTab(tabv.newTab().setText("Loai Chi"));
        viewpg.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabv));
        tabv.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpg.setCurrentItem(tab.getPosition());
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
    class Myadapter extends FragmentStatePagerAdapter{
Fragment fragment;

        public Myadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if(position==0){
                fragment= new khoanchi();
                Bundle bundle = new Bundle();
                fragment.setArguments(bundle);
            }
            if(position==1){
                fragment = new loaichi();
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
