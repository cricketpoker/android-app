package com.mobile.cricpoker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.*;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

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
    // client used to call the REST Service
    AsyncHttpClient httpClient;
    RequestParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // This will be taken from the facebook api and be used to call the REST service
        // to get the user information form our database
        String username = "gkhedekar";

        profile_pic = (ImageView) findViewById(R.id.profile_pic);
        profile_pic.setImageResource(R.mipmap.ic_launcher);

        profileListView = (ListView) findViewById(R.id.profile_listview);
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mProfileList);
        profileListView.setAdapter(mArrayAdapter);
        populateListView();
        getUserInfo();
    }

    private void populateListView(){
        mProfileList.add("Username: gkhedekar");
        mProfileList.add("Name: Gaurav Khedekar");
        mProfileList.add("Score: 2000");
        mProfileList.add("Team: Mumbai Indians");
    }

    public void getUserInfo(){
        httpClient = new AsyncHttpClient();
        params = new RequestParams();
        params.put("integrationKey", "12345");
        params.put("email", "khedekar.gaurav@gmail.com");
        params.put("password", "12345");
        httpClient.post("https://wufoo.com/api/v3/login.json",params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//              JSONObject jsonObject = new JSONObject(response.toString());
                Toast.makeText(getApplicationContext(), "Successfully got json", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable error, JSONObject errorResponse) {
                if(statusCode == 404){
                    Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
                }
                // When Http response code is '500'
                else if(statusCode == 500){
                    Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
                }
                // When Http response code other than 404, 500
                else{
                    Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(getApplicationContext(), errorResponse.toString(), Toast.LENGTH_LONG).show();

            }
        });
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
