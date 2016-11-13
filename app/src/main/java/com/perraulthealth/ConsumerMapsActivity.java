package com.perraulthealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

import static com.perraulthealth.R.drawable.ic_action_siddemenuv;
import static com.perraulthealth.R.id.sidemenu;


public class ConsumerMapsActivity extends AppCompatActivity implements View.OnClickListener {

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
        setContentView(R.layout.activity_consumer_home);

        findViewById(R.id.body).setOnClickListener(this);
        findViewById(R.id.imageViewList).setOnClickListener(this);
        findViewById(R.id.sidemenu).setOnClickListener(this);

        img_view = (ImageView) findViewById(R.id.imageViewList);
        img_sidemenu = (ImageView) findViewById(sidemenu);

        listViewFragment = new ListViewFragment();
        mapsFragment = new MapsFragment();
        sideMenu = new Sidemenu();


        if (viewboolean == false) {
            //img_view.setImageResource(R.drawable.list_view_icon);

            ft.remove(listViewFragment);
            ft.remove(mapsFragment);
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            ft.add(R.id.containermap, mapsFragment);
            ft.commit();
            viewboolean = true;
        }



    }


    @Override
    public void onStart() {
        super.onStart();
        //setContentView(R.layout.fragment_map);
    }

    @Override
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

                ft.remove(mapsFragment);
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
        else if (i == sidemenu)
        {

            if (false == sidemenuboolean) {
                //img_sidemenu.setImageResource(ic_action_sidebar);
                sidemenuboolean = true;
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.add(R.id.containersidemenu, sideMenu);
                ft.commit();
                Toast.makeText(this, "Open sidemenu", Toast.LENGTH_SHORT).show();
            }
            if (true == sidemenuboolean)
            {
                img_sidemenu.setImageResource(ic_action_siddemenuv);
                sidemenuboolean = true;
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.remove(sideMenu);
                ft.commit();
                Toast.makeText(this, "Close sidemenu", Toast.LENGTH_SHORT).show();
            }


        }

    }
    private void removeFragments() {
        ft.remove(mapsFragment);
        ft.remove(listViewFragment);
        //ft.remove(sidemenu);
    }
}