package com.perraulthealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQuery;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.Marker;
import com.perraulthealth.fragment.ListViewFragment;
import com.perraulthealth.fragment.MapsFragment;
import com.perraulthealth.fragment.Sidemenu;

import java.util.Map;

import static com.perraulthealth.R.id.sidemenu;



public class abcd extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {



    private GoogleMap mMap;
    private SupportMapFragment mapFragment;
    private static final GeoLocation INITIAL_CENTER = new GeoLocation(37.7789, -122.4017);
    private static final int INITIAL_ZOOM_LEVEL = 14;
    private static final String geofire = "geofire";
    private Circle searchCircle;
    private GeoFire geoFire;
    private GeoQuery geoQuery;
    private Map<String, Marker> markers;
    ImageView img_view, img_sidemenu;
    ListView listView;
    boolean viewboolean = false;
    boolean sidemenuboolean = false;
    private MapsFragment mapsFragment = null;
    private ListViewFragment listViewFragment = null;
    private Sidemenu sideMenu = null;

    android.support.v4.app.FragmentManager fm;
    android.support.v4.app.FragmentTransaction ft;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abcd);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.body).setOnClickListener(this);
        findViewById(R.id.imageViewList).setOnClickListener(this);



        img_view = (ImageView) findViewById(R.id.imageViewList);
        //img_sidemenu = (ImageView) findViewById(sidemenu);

        mapsFragment = new MapsFragment();
          listViewFragment = new ListViewFragment();
      //  sideMenu = new Sidemenu();


        if (viewboolean == false) {
            img_view.setImageResource(R.drawable.list_view_icon);

            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();

            ft.remove(listViewFragment);
            ft.add(R.id.containermap, mapsFragment);
            ft.commit();
            viewboolean = true;
        }



    }


    @Override
    public void onStart() {
        super.onStart();
       // setContentView(R.layout.fragment_map);
    }

    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.imageViewList)
        {
            if (false == viewboolean)
            {
                viewboolean = true;
                img_view.setImageResource(R.drawable.list_view_icon);



                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();

             //   ft.remove(mapsFragment);
                ft.remove(listViewFragment);
                ft.add(R.id.containermap, mapsFragment);

                ft.commit();
                Toast.makeText(this, "Welcome to Map", Toast.LENGTH_SHORT).show();
            }
            else if (true == viewboolean)
            {

                img_view.setImageResource(R.drawable.ic_action_map);
                viewboolean = false;

                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
               // ft.remove(listViewFragment);
                ft.remove(mapsFragment);

                ft.add(R.id.containerlist, listViewFragment);
                ft.commit();
                Toast.makeText(this, "Welcome to list", Toast.LENGTH_SHORT).show();

            }

        }
        else if (i == R.id.body)
        {
            Toast.makeText(this, "Welcome body ...tarun", Toast.LENGTH_SHORT).show();
            // finish();
            startActivity(new Intent(getApplicationContext(), Body.class));
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,  R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.abcd, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();





        //noinspection SimplifiableIfStatement
     //   if (id == R.id.action_settings) {
       //     return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.myprofile) {

        } else if (id == R.id.mysettings) {

        } else if (id == R.id.myactivity) {

        } else if (id == R.id.mydocuments) {

        } else if (id == R.id.recent) {

        } else if (id == R.id.myrecommendations) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
