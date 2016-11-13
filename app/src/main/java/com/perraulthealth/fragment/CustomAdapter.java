package com.perraulthealth.fragment;

import android.content.Context;
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

public  class CustomAdapter extends ArrayAdapter<String> {

    private Doctor mDoctor = new Doctor();
    private String name;
    private String regnum;
    private String degree;
    TextView doctor_name;
    TextView doctor_regnum;
    TextView doctor_degree;
    ImageView doctor_photo;



    CustomAdapter(Context context, String[] numbers_text) {
        super(context, R.layout.item_doctor, numbers_text);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflator = LayoutInflater.from(getContext());

        View customView = mInflator.inflate(R.layout.item_doctor, parent, false);
         doctor_name = (TextView) customView.findViewById(R.id.name);
         doctor_regnum = (TextView) customView.findViewById(R.id.regnum);
         doctor_degree = (TextView) customView.findViewById(R.id.degree);
         doctor_photo = (ImageView) customView.findViewById(R.id.doctorphoto);


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
                doctor_name.setText(mDoctor.getName());
                doctor_photo.setImageResource(R.drawable.doctor_photo);
                doctor_regnum.setText(mDoctor.getRegnum());
                doctor_degree.setText(mDoctor.getDegree());
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });
        return customView;

    }
}