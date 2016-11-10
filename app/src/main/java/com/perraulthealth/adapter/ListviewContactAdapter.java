package com.perraulthealth.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.perraulthealth.R;
import com.perraulthealth.model.ListViewItem;

import java.util.ArrayList;

/**
 * Created by sutu on 11/10/2016.
 */

public class ListviewContactAdapter extends BaseAdapter {
    private static ArrayList<ListViewItem> contactlist;

    private LayoutInflater mInflater;

    public ListviewContactAdapter(Context listviewFragment, ArrayList<ListViewItem> results){
        contactlist = results;
        mInflater = LayoutInflater.from(listviewFragment);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return contactlist.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return contactlist.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.item_list, null);
            holder = new ViewHolder();
            holder.txtname = (TextView) convertView.findViewById(R.id.name);
            holder.txtphone = (TextView) convertView.findViewById(R.id.phone);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtname.setText(contactlist.get(position).getTitle());
        holder.txtphone.setText(contactlist.get(position).getImgId());

        return convertView;
    }

    static class ViewHolder{
        TextView txtname, txtphone;
    }
}
