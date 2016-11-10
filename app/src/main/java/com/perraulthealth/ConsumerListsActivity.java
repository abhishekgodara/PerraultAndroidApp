package com.perraulthealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.perraulthealth.adapter.Group;
import com.perraulthealth.adapter.MyExpandableListAdapter;

/**
 * Created by sutu on 11/9/2016.
 */

public class ConsumerListsActivity extends AppCompatActivity implements View.OnClickListener {

    ExpandableListView listview;
    SparseArray<Group> groups = new SparseArray<Group>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consumer_list_view);
        createData();
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.listViewontainer);
        MyExpandableListAdapter adapter = new MyExpandableListAdapter(this,
                groups);
        listView.setAdapter(adapter);
    }

    public void createData() {
        for (int j = 0; j < 5; j++) {
            Group group = new Group("Test " + j);
            for (int i = 0; i < 5; i++) {
                group.children.add("Sub Item" + i);
            }
            groups.append(j, group);
        }
    }
/*

    {
            Toast.makeText(this, "Welcome to List", Toast.LENGTH_SHORT).show();

            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.listViewContainer, new ListViewFragment()).commit();
            }

        }
    }
*/
    @Override
    public void onClick(View v)
    {

        int i = v.getId();
        {
            Toast.makeText(this, "Do not work now", Toast.LENGTH_SHORT).show();
            //Intent j = new Intent(getApplicationContext(), ConsumerMapsActivity.class);
            //startActivity(j);
            //finish();
        }
        }
}
