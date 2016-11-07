package com.perraulthealth;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


/**
 * Created by sutu on 11/6/2016.
 */

public class Body extends AppCompatActivity implements View.OnClickListener{


@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.body);



        }

@Override
public void onClick(View v)
        {
                int i = v.getId();
                if(i ==R.id.bodyfull) {

                        Toast.makeText(this, "Do not click on bodyy now", Toast.LENGTH_SHORT).show();
                        Intent j = new Intent(getApplicationContext(), ConsumerMapsActivity.class);
                        startActivity(j);
                        finish();

                        }
return;
        }
        }