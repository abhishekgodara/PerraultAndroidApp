package com.perraulthealth;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.R.attr.key;
import static android.R.attr.value;

public class Notifications extends AppCompatActivity {


    RecyclerView mRecyclerView;
    FirebaseRecyclerAdapter<String, MessageViewHolder> adapter;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mRef = mRootRef.child("notifications");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);


        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerViewNotifications);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    protected void onStart() {
        super.onStart();

         adapter = new FirebaseRecyclerAdapter<String, MessageViewHolder>(String.class,
                        android.R.layout.simple_list_item_1,
                        MessageViewHolder.class,
                        mRef) {
                    @Override
                    protected void populateViewHolder(MessageViewHolder viewHolder, String model, int position) {
                        viewHolder.mText.setText(model);
                    }
                };
        mRecyclerView.setAdapter(adapter);

    }


    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView mText;

        public MessageViewHolder(View v) {
            super(v);
            mText = (TextView) v.findViewById(android.R.id.text1);
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        adapter.cleanup();
    }
}







