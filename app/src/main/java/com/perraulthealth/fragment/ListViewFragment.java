package com.perraulthealth.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.perraulthealth.Doctor;
import com.perraulthealth.Hospital;
import com.perraulthealth.Lab;
import com.perraulthealth.Pharmacy;
import com.perraulthealth.R;


public class ListViewFragment extends ListFragment {

    private ListView  listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(container==null)
            return null;
        View v = inflater.inflate(R.layout.fragment_listview, container, false);


        String[] values = new String[] { "Lab", "Pharmacy", "Doctor" };
        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();



        Doctor objDoctor = new Doctor();
        objDoctor.setName("A K Sharma");
        objDoctor.setDegree("MBBS");
        objDoctor.setRegnum("AQTPM23ertu6789u");
        mRootRef.child("Doctor").child(uid).setValue(objDoctor);

        Pharmacy objPharmacy = new Pharmacy();
        objPharmacy.setName("Apollo pharmacy");
        objPharmacy.setRegnum("AQWERTYU");
        objPharmacy.setRating("4.3");
        mRootRef.child("Pharmacy").child(uid).setValue(objPharmacy);


        Lab objLab = new Lab();
        objLab.setName("Focus Imagine");
        mRootRef.child("Lab").child(uid).setValue(objLab);

        Hospital objHospital = new Hospital();
        objHospital.setName("MAX hospital");
        objHospital.setRating("5.1");
        objHospital.setNumofbeds(600);
        objHospital.setAddress("Saket New Delhi, India");
        mRootRef.child("Hospital").child(uid).setValue(objLab);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
        return v;
    }





    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onStart() {
        super.onStart();
    }

}
