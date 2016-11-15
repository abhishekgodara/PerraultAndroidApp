package com.perraulthealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.perraulthealth.model.Constants.FIRST_COLUMN;
import static com.perraulthealth.model.Constants.FOURTH_COLUMN;
import static com.perraulthealth.model.Constants.SECOND_COLUMN;
import static com.perraulthealth.model.Constants.THIRD_COLUMN;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.perraulthealth.adapter.ListViewAdapters;

public class MydocumentsActivity extends AppCompatActivity {

    private ArrayList<HashMap<String, String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydocuments);

        ListView listView=(ListView)findViewById(R.id.listView1);

        list=new ArrayList<HashMap<String,String>>();

        HashMap<String,String> temp=new HashMap<String, String>();
        temp.put(FIRST_COLUMN, "Ankit Karia");
        temp.put(SECOND_COLUMN, "Male");
        temp.put(THIRD_COLUMN, "22");
        temp.put(FOURTH_COLUMN, "Unmarried");
        list.add(temp);

        HashMap<String,String> temp2=new HashMap<String, String>();
        temp2.put(FIRST_COLUMN, "Rajat Ghai");
        temp2.put(SECOND_COLUMN, "Male");
        temp2.put(THIRD_COLUMN, "25");
        temp2.put(FOURTH_COLUMN, "Unmarried");
        list.add(temp2);

        HashMap<String,String> temp3=new HashMap<String, String>();
        temp3.put(FIRST_COLUMN, "Karina Kaif");
        temp3.put(SECOND_COLUMN, "Female");
        temp3.put(THIRD_COLUMN, "31");
        temp3.put(FOURTH_COLUMN, "Unmarried");
        list.add(temp3);

        ListViewAdapters adapter=new ListViewAdapters(this, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id)
            {
                int pos=position+1;
                Toast.makeText(MydocumentsActivity.this, Integer.toString(pos)+" Clicked", Toast.LENGTH_SHORT).show();
            }

        });

    }
}

