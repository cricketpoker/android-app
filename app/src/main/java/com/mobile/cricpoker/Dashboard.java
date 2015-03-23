package com.mobile.cricpoker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class Dashboard extends ActionBarActivity implements AdapterView.OnItemClickListener {

    Class[] activityClass = {Match.class, Schedule.class, Play.class, Challenges.class, Rules.class, Profile.class, About.class};
    ListView dashboardListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mDashboardList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        String[] dashboard_items = getResources().getStringArray(R.array.dashboard_list);
//        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.dashboard_list, R.id.label, dashboard_items));

        for(String s: dashboard_items)
            mDashboardList.add(s);
        dashboardListView = (ListView) findViewById(R.id.dashboard_listview);
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mDashboardList);
        dashboardListView.setAdapter(mArrayAdapter);

        dashboardListView.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), activityClass[position]);
        startActivity(intent);
    }
}
