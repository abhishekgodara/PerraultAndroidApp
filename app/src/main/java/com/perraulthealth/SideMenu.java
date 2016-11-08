package com.perraulthealth;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.perraulthealth.adapter.SlidingMenuAdapter;
import com.perraulthealth.fragment.Myactivities;
import com.perraulthealth.fragment.Mydocuments;
import com.perraulthealth.fragment.Mysettings;
import com.perraulthealth.fragment.SignoutFragment;
import com.perraulthealth.model.ItemSlideMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sutu on 11/8/2016.
 */

public class SideMenu extends AppCompatActivity{
    private List<ItemSlideMenu> listSliding;
    private SlidingMenuAdapter adapter;
    private ListView listViewSliding;
    private DrawerLayout drawerLayout;
    private RelativeLayout mainContent;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_menu);



        //initialization
        listViewSliding = (ListView)findViewById(R.id.lv_sliding_menu);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_Layout);
        mainContent = (RelativeLayout)findViewById(R.id.match_parent);
        listSliding = new ArrayList<>();

        //add items for sliding list
        listSliding.add(new ItemSlideMenu(R.drawable.mysettings,"Mysettings"));
        //listSliding.add(new ItemSlideMenu(R.drawable.mysettings),"My settings");
        //listSliding.add(new ItemSlideMenu(R.drawable.mysettings),"My settings");
        adapter = new SlidingMenuAdapter(this,listSliding);
        listViewSliding.setAdapter(adapter);



        //display icon to open /close sliding list
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //set title
        setTitle(listSliding.get(0).getTitle());

        //item slected
        listViewSliding.setItemChecked(0,true);
        //close menu
        drawerLayout.closeDrawer(listViewSliding);


        //handle on item click
        listViewSliding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //set tittle
                setTitle(listSliding.get(position).getTitle());

                //item selected
                listViewSliding.setItemChecked(position,true);

                //close menu
                drawerLayout.closeDrawer(listViewSliding);

            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.drawer_opened,R.string.drawer_closed){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };
        //drawerLayout.setDrawerLockMode(actionBarDrawerToggle);

        }

    //create method replace fragment

    private void fragment(int pos)
    {
        Fragment fragment = null;
        switch (pos) {
            case 0:
                fragment = new Mysettings();
                break;
            case 1:
                fragment = new Myactivities();
                break;
            case 2:
                fragment = new Mydocuments();
                break;
            default:
                fragment = new SignoutFragment();
        }
        if(null!=fragment)
        {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.main_content,fragment);
            ft.addToBackStack(null);
            ft.commit();


        }




    }



}
