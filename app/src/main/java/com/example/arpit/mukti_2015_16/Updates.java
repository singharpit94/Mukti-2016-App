package com.example.arpit.mukti_2015_16;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Updates extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<String> limits = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setLogo(R.drawable.home3);
        toolbar.setTitle("MUKTI 2016");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        new PollTask().execute();


    }

    private class PollTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... args) {
            // do stuff!
            String title = null;


            try {
                // Create a URL for the desired page
                URL updateURL = new URL("http://172.16.41.132:8000/notif");

                // Read all the text returned by the server
                BufferedReader in = new BufferedReader(new InputStreamReader(updateURL.openStream()));
                StringBuilder total = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    total.append(line).append("\n");
                }
                title = total.toString();


                in.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


            return title;

        }


        @Override
        protected void onPostExecute(String title) {
            JSONArray jarray=null;
            JSONObject g1=null;
            JSONObject f=null;
            String update=null;
            if (title == null) {

                limits.add("Unable to Fetch Updates! Please check Internet Connection ");
                //Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
                ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list, limits);

                ListView listView = (ListView) findViewById(R.id.mobile_list);
                listView.setAdapter(adapter);


            } else {


                try {
                    jarray = new JSONArray(title);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for(int i=0;i<jarray.length();i++)
                {
                    try {
                        g1=jarray.getJSONObject(i);
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        f=g1.getJSONObject("fields");
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        update=f.getString("text");
                    } catch (JSONException h) {
                        h.printStackTrace();
                    }

                    limits.add(update);
                }

               /* for(int j=0;j<;j++)
                {
                    Toast.makeText(getApplicationContext(),post[j],Toast.LENGTH_LONG).show();
                }*/
                ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list, limits);

                ListView listView = (ListView) findViewById(R.id.mobile_list);
                listView.setAdapter(adapter);


            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent myintent = new Intent(Updates.this, MainActivity.class);
        startActivity(myintent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent myintent = new Intent(Updates.this, MainActivity.class);
            startActivity(myintent);
            finish();
            // Handle the camera action
        } else if (id == R.id.nav_Sponsers) {
            Intent myintent = new Intent(Updates.this, Sponsers.class);
            startActivity(myintent);
            finish();

        } else if (id == R.id.nav_onevents) {
            Intent myintent = new Intent(Updates.this, Online.class);
            startActivity(myintent);
            finish();

        } else if (id == R.id.nav_offevents) {
            Intent myintent = new Intent(Updates.this, Offline.class);
            startActivity(myintent);
            finish();

        } else if (id == R.id.nav_workshops) {
            Intent myintent = new Intent(Updates.this, Workshop.class);
            startActivity(myintent);
            finish();

        } else if (id == R.id.nav_lectures) {
            Intent myintent = new Intent(Updates.this, GuestSpeaker.class);
            startActivity(myintent);
            finish();

        }
        else if (id == R.id.Contacts) {
            Intent myintent = new Intent(Updates.this, Contact.class);
            startActivity(myintent);
            finish();


        }
        else if (id == R.id.nav_updates) {
            Intent myintent = new Intent(Updates.this, Updates.class);
            startActivity(myintent);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
