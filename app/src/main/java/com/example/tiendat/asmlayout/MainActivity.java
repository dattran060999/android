package com.example.tiendat.asmlayout;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
Toolbar toolbar;
NavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawer_layout);
        toolbar=findViewById(R.id.toolbar);
        nav=findViewById(R.id.nvView);
        //toolbar
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               xuly(item);
                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.thu){
            return  true;
        }
        if(item.getItemId()==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
    void xuly(MenuItem menuItem) {
        int id = menuItem.getItemId();
        Fragment fragment = null;
        Class classfragment = null;
        if (id == R.id.thu)
            classfragment = Fragment_Thu.class;
        if (id == R.id.chi)
            classfragment = fragment_chi.class;
        if (id == R.id.thongke)
            classfragment = fragment_thongke.class;
//        ....tao cac fragment cho tung muc

        try {
            fragment = (Fragment) classfragment.newInstance();

            FragmentManager fmanager = getSupportFragmentManager();
            fmanager.beginTransaction()
                    .replace(R.id.flContent, fragment)//id cua fragment ben activity
                    .commit();

            menuItem.setChecked(true);
            setTitle(menuItem.getTitle());
            drawerLayout.closeDrawer(GravityCompat.START);
        } catch (Exception e) {

        }
}
}
