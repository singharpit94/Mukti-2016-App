package com.example.arpit.mukti_2015_16;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
       ImageButton online,offline,sponser,contact,workshop,guest;
    Button map,update;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String s1=null;
    int key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        online=(ImageButton)findViewById(R.id.imageButton1);
        offline=(ImageButton)findViewById(R.id.imageButton2);
        sponser=(ImageButton)findViewById(R.id.imageButton6);
        contact=(ImageButton)findViewById(R.id.imageButton5);
        workshop=(ImageButton)findViewById(R.id.imageButton3);
        guest=(ImageButton)findViewById(R.id.imageButton4);

        map=(Button)findViewById(R.id.button1);
        update=(Button)findViewById(R.id.button2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.home3);
        toolbar.setTitle("MUKTI 2016");



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor=preferences.edit();



        key=0;
        key=preferences.getInt("current", -1);
        s1=preferences.getString("cu",null);
        if(s1==null){
            Toast.makeText(getApplicationContext(), "Integer", Toast.LENGTH_LONG).show();
            editor.putInt("current", 0);
            editor.putString("cu","Arpit");
            editor.commit();
        }

        startService(new Intent(getBaseContext(), Notify.class));
        online.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, Online.class);
                startActivity(myintent);
            }
        });
        offline.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, Offline.class);
                startActivity(myintent);
            }
        });
        sponser.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, Sponsers.class);
                startActivity(myintent);
            }
        });
        map.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:23.5496364,87.2911007");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
        contact.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, Contact.class);
                startActivity(myintent);
            }
        });
        workshop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, Workshop.class);
                startActivity(myintent);
            }
        });
        guest.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, GuestSpeaker.class);
                startActivity(myintent);
            }
        });
        update.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, Updates.class);
                startActivity(myintent);
            }
        });




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

     /*   if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
