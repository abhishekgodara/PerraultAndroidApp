package com.perraulthealth.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.perraulthealth.R;


public class ListViewFragment extends ListFragment {

    private ListView  listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(container==null)
            return null;
        View v = inflater.inflate(R.layout.fragment_listview, container, false);


        String[] values = new String[] { "Lab", "Pharmacy", "Doctor" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
        return v;
    }
}
