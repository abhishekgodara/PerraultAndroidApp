package com.perraulthealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.perraulthealth.fragment.ListViewFragment;

/**
 * Created by sutu on 11/9/2016.
 */

public class ConsumerListsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consumer_list_view);
        findViewById(R.id.imageViewMap).setOnClickListener(this);

        {
            Toast.makeText(this, "Welcome to List", Toast.LENGTH_SHORT).show();

            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new ListViewFragment()).commit();
            }

        }
    }

    @Override
    public void onClick(View v)
    {

        int i = v.getId();
        if (i == R.id.imageViewMap){

            finish();

                Intent j = new Intent(getApplicationContext(), ConsumerMapsActivity.class);
                startActivity(j);


            }
        else
        {
            Toast.makeText(this, "Do not work now", Toast.LENGTH_SHORT).show();
            //Intent j = new Intent(getApplicationContext(), ConsumerMapsActivity.class);
            //startActivity(j);
            //finish();
        }
        }
}
