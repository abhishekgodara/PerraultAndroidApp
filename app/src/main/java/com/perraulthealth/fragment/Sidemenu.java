package com.perraulthealth.fragment;




import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.perraulthealth.R;


public class Sidemenu extends ListFragment {
    private ListView listView;
    String[] numbers_text = new String[] { "My settings", "My activity", "My documents", "Recent",
            "My recommmendations", "Offers/Promotions", "Customer Service", "Rate our app", "Legal and About", "Sign out"};
    String[] numbers_digits = new String[] { "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "11", "12", "13", "14", "15" };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        System.out.println("container" + container);
        if(container==null)
            return null;
        View v = inflater.inflate(R.layout.fragment_sidemenu, container, false);
        //listView = (ListView) v.findViewById(R.id.listViewSideMenu);
        //SlidingMenuAdapter slidingMenuAdapter = new SlidingMenuAdapter()''
       // SlidingMenuAdapter<ItemSlideMenu> adapter = SlidingMenuAdapter (inflater.getContext() ,ItemSlideMenu);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(), android.R.layout.simple_list_item_1,
                numbers_text);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);


    }
}
