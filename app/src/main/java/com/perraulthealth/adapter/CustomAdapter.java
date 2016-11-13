package com.perraulthealth.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.perraulthealth.Doctor;
import com.perraulthealth.R;



/**
 * Created by sutu on 11/13/2016.
 */


class CustomAdapter extends ArrayAdapter <String> {

    private Doctor mDoctor = new Doctor();
    private String name;
    private String regnum;
    private String degree;

    CustomAdapter(Context context, String[] resstring) {
        super(context, R.layout.custom_row, resstring);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflator = LayoutInflater.from(getContext());

        View customView = mInflator.inflate(R.layout.item_doctor, parent, false);
        TextView doctor_name = (TextView) customView.findViewById(R.id.name);
        TextView doctor_regnum = (TextView) customView.findViewById(R.id.regnum);
        TextView doctor_degree = (TextView) customView.findViewById(R.id.degree);
        ImageView doctor_photo = (ImageView) customView.findViewById(R.id.doctorphoto);


        String singleItem = getItem(position);
        //Doctor mDoctor = new Doctor();

        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        mRootRef.child("Doctor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                mDoctor = dataSnapshot.getValue(Doctor.class);
                name = mDoctor.getName();
                regnum = mDoctor.getRegnum();
                degree = mDoctor.getDegree();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });
        doctor_name.setText(mDoctor.getName());
        doctor_photo.setImageResource(R.drawable.doctor_photo);
        doctor_regnum.setText(mDoctor.getRegnum());
        doctor_degree.setText(mDoctor.getDegree());
        return customView;
    }
}
