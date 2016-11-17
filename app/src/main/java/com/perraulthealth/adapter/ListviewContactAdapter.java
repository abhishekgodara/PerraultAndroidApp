package com.perraulthealth.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.perraulthealth.R;

/**
 * Created by sutu on 11/10/2016.
 */

public class ListviewContactAdapter extends RecyclerView.Adapter<ListviewContactAdapter.RecyclerViewHolder> {
    private String[] name= null;
    private LayoutInflater layoutInflater =null;
    //List<Information> data = Collections.emptyList();


    public ListviewContactAdapter(String[] name)
    {
        this.name = name;
        //layoutInflater.from(context);
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.item_doctor,parent,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.name.setText(name[position]);


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView name;

        public RecyclerViewHolder(View itemView)
        {
            super(itemView);


            name = (TextView)itemView.findViewById(R.id.doctorname);


        }
    }
}
