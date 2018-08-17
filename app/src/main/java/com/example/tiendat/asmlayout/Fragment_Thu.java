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
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Thu extends Fragment {

    TabLayout tabv2;
    ViewPager viewpg2;
    public Fragment_Thu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view =inflater.inflate(R.layout.fragment_fragment__thu,container,false);
        tabv2=view.findViewById(R.id.tabs2);
        viewpg2=view.findViewById(R.id.pager2);
        Myadapter myadapter= new Myadapter(getActivity().getSupportFragmentManager());
        viewpg2.setAdapter(myadapter);
        tabv2.addTab(tabv2.newTab().setText("Khoan Thu"));
        tabv2.addTab(tabv2.newTab().setText("Loai Thu"));
        viewpg2.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabv2));
        tabv2.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpg2.setCurrentItem(tabv2.getSelectedTabPosition());
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
    public Myadapter(FragmentManager fm) {
        super(fm);
    }
Fragment fragment;
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            fragment = new khoanthu();
            Bundle bundle= new Bundle();

            fragment.setArguments(bundle);
        }
        if(position==1){
            fragment = new loaithu();
            Bundle bundle= new Bundle();

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
