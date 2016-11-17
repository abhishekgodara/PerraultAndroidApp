package com.perraulthealth.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQuery;
import com.firebase.geofire.GeoQueryEventListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.perraulthealth.R;

import java.util.Map;






/**
 * Created by sutu on 11/2/2016.
 */

public  class MapsFragment  extends Fragment implements GeoQueryEventListener {


    private static final GeoLocation INITIAL_CENTER = new GeoLocation(28.566827, 77.208120);
    private static final GeoLocation MAX = new GeoLocation(28.528244, 77.211780);
    private static final GeoLocation AIIMS = new GeoLocation(28.566927, 77.208120);
    private static final GeoLocation APOLLO = new GeoLocation(28.563586, 77.205779);
    private static final GeoLocation SUFDARJANG = new GeoLocation(28.569586, 77.205279);
    private static final GeoLocation VARDHMAAN = new GeoLocation(28.704059, 77.103490);


        private static final int INITIAL_ZOOM_LEVEL = 14;
       // private static final String GEO_FIRE_DB = "https://perraulthealth-cfc33.firebaseio.com";
       // private static final String GEO_FIRE_REF = GEO_FIRE_DB + "/geofire";
        private static final String geofire = "geofire";
        private GoogleMap mMap;
        private MapView mMapView;
        private Circle searchCircle;
        private GeoFire geoFire;
        private GeoQuery geoQuery;
        private Map<String,Marker> markers;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

    }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


            if(container==null)
                return null;
            View v = inflater.inflate(R.layout.fragment_map, container, false);
            mMapView = (MapView) v.findViewById(R.id.map);
            mMapView.onCreate(savedInstanceState);
            MapsInitializer.initialize(getActivity().getApplicationContext());



            mMapView.getMapAsync(new OnMapReadyCallback() {


                @Override
                public void onMapReady(GoogleMap googleMap) {
                    mMap = googleMap;
                    System.out.println("googleMap" + mMap);

                    // Add a marker in Sydney and move the camera
                    // LatLng sydney = new LatLng(-34, 151);
                    LatLng latLngCenter = new LatLng(INITIAL_CENTER.latitude, INITIAL_CENTER.longitude);
                    LatLng llmax = new LatLng(MAX.latitude, MAX.longitude);
                    LatLng llaiims = new LatLng(AIIMS.latitude, AIIMS.longitude);
                    LatLng llapollo = new LatLng(APOLLO.latitude, APOLLO.longitude);
                    LatLng llsufdarjang = new LatLng(SUFDARJANG.latitude, SUFDARJANG.longitude);
                    LatLng llvardhmaan = new LatLng(VARDHMAAN.latitude, VARDHMAAN.longitude);
                    searchCircle = mMap.addCircle(new CircleOptions().center(latLngCenter).radius(1400));
                   // searchCircle.setFillColor(Color.argb(66, 255, 0, 255));
                    //searchCircle.setStrokeColor(Color.argb(66, 0, 0, 0));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngCenter, INITIAL_ZOOM_LEVEL));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngCenter));
                    LatLng sydney = new LatLng(-34, 151);
                    mMap.addMarker(new MarkerOptions().position(llmax).title("H"));
                    mMap.addMarker(new MarkerOptions().position(llaiims).title("L"));

                    mMap.addMarker(new MarkerOptions().position(llapollo).title("D"));
                    mMap.addMarker(new MarkerOptions().position(llsufdarjang).icon(BitmapDescriptorFactory.fromResource(R.drawable.pharmacy)).title("5.6"));

                   mMap.addMarker(new MarkerOptions().position(llvardhmaan).title("Homecare"));
                    // setup GeoFire
                    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
                    Log.d("GeoFire", "onMapReady:" + mRootRef);
                    geoFire = new GeoFire(mRootRef.child(geofire).getRef());
                    Log.d("GeoFire", "onMapReady:mRootRef.child(geofire).getRef()" + geoFire);
                    geoFire.setLocation("C", new GeoLocation(28.566827, 77.208120));
                    geoFire.setLocation("H", new GeoLocation(28.566827, 77.208120));
                    geoFire.setLocation("L", new GeoLocation(28.569586, 77.205279));
                    geoFire.setLocation("P", new GeoLocation(28.704059, 77.102490));
                    geoFire.setLocation("D", new GeoLocation(28.704053, 77.102492));


                   // mMap.addMarker(new MarkerOptions().position(latLngCenter).icon(BitmapDescriptorFactory.fromResource(R.drawable.body)).title("Consumer"));
                  //  mMap.addMarker(new MarkerOptions().position(llmax).icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)).title("MAX"));
                    //mMap.addMarker(new MarkerOptions().position(llaiims).icon(BitmapDescriptorFactory.fromResource(R.drawable.lab)).title("Focus"));
                   // mMap.addMarker(new MarkerOptions().position(llapollo).icon(BitmapDescriptorFactory.fromResource(R.drawable.pharmacy)).title("APOLLO"));
                    //mMap.addMarker(new MarkerOptions().position(llsufdarjang).icon(BitmapDescriptorFactory.fromResource(R.drawable.nurse)).title("Homecare"));
                    //mMap.addMarker(new MarkerOptions().position(llvardhmaan).icon(BitmapDescriptorFactory.fromResource(R.drawable.physiotherapyist)).title("Homecare"));

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngCenter));



                    mMap.addMarker(new MarkerOptions().position(latLngCenter).title("You are here"));








                    // radius in km
                    //geoQuery = geoFire.queryAtLocation(INITIAL_CENTER, 1);
                    // setup markers
                   // markers = new HashMap<String, Marker>();
                }
            });

            //v = inflater.inflate(R.layout.fragment_map, container, false);
        return v;
        }

    @Override
    public void onStop() {

        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }



    @Override
    public void onKeyEntered(String key, GeoLocation location) {
            // Add a new marker to the map
            Marker marker = this.mMap.addMarker(new MarkerOptions().position(new LatLng(location.latitude, location.longitude)));
            this.markers.put(key, marker);
        }

    @Override
        public void onKeyExited(String key) {

        }

    @Override
    public void onKeyMoved(String key, GeoLocation location) {
        // Move the marker
        Marker marker = this.markers.get(key);

    }

    @Override
        public void onGeoQueryReady() {
        }

    @Override
    public void onGeoQueryError(DatabaseError error) {

    }

    /**
     * Created by sutu on 11/13/2016.
     */



}

