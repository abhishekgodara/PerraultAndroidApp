package com.perraulthealth.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.perraulthealth.adapter.ListviewContactAdapter;
import com.perraulthealth.model.ListViewItem;

import java.util.ArrayList;


public class ListViewFragment extends ListFragment {

    private ListView  listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        System.out.println("container" + container);
        if (container == null)
            return null;
        View v  = inflater.inflate(R.layout.fragment_listview, container, false);
        ListView listView = (ListView) v.findViewById(R.id.listView);
        System.out.println("View" + v);
        System.out.println("listView" + listView);
        // ListView listView = (ListView)rootView.findViewById(R.id.listView);
        ArrayList<ListViewItem> listContact = GetlistContact();
        System.out.println("listContact" + listContact);

        listView.setAdapter(new ListviewContactAdapter(getActivity(), listContact));

        return v;
    }

    private ArrayList<ListViewItem> GetlistContact(){
        ArrayList<ListViewItem> contactlist = new ArrayList<ListViewItem>();

        ListViewItem contact = new ListViewItem();

        contact.setImgId(1);
        contact.setTitle("Item1");
        contactlist.add(contact);

        contact = new ListViewItem();
        contact.setImgId(2);
        contact.setTitle("Item2");
        contactlist.add(contact);

        contact = new ListViewItem();
        contact.setImgId(3);
        contact.setTitle("Item3");
        contactlist.add(contact);

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

        return contactlist;
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
