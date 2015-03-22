package com.mobile.cricpoker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class Profile extends ActionBarActivity {

    ImageView profile_pic;
    TextView username;
    TextView name;
    TextView score;
    TextView team;
    ListView profileListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mProfileList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_pic = (ImageView) findViewById(R.id.profile_pic);
        profile_pic.setImageResource(R.mipmap.ic_launcher);

        profileListView = (ListView) findViewById(R.id.profile_listview);
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mProfileList);
        profileListView.setAdapter(mArrayAdapter);
        populateListView();
    }

    private void populateListView(){
        mProfileList.add("Username: gkhedekar");
        mProfileList.add("Name: Gaurav Khedekar");
        mProfileList.add("Score: 2000");
        mProfileList.add("Team: Mumbai Indians");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
