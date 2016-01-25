package com.example.arpit.mukti_2015_16;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;




/**
 * Created by arpit on 12/12/15.
 */
public class Offline extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offline);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.home3);
        toolbar.setTitle("MUKTI 2016");
        //  setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Connectify"));
        tabLayout.addTab(tabLayout.newTab().setText("Incanity"));
        tabLayout.addTab(tabLayout.newTab().setText("Lipi"));
        tabLayout.addTab(tabLayout.newTab().setText("Behind The Scenes"));
        tabLayout.addTab(tabLayout.newTab().setText("Fantasy-Football"));
        tabLayout.addTab(tabLayout.newTab().setText("Perplexity"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final OfflinePageViewer adapter = new OfflinePageViewer
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });





    }

    @Override
    public void onBackPressed() {
        Intent myintent = new Intent(Offline.this, MainActivity.class);
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
            Intent myintent = new Intent(Offline.this, MainActivity.class);
            startActivity(myintent);
            finish();
            // Handle the camera action
        } else if (id == R.id.nav_Sponsers) {
            Intent myintent = new Intent(Offline.this, Sponsers.class);
            startActivity(myintent);
            finish();

        } else if (id == R.id.nav_onevents) {
            Intent myintent = new Intent(Offline.this, Online.class);
            startActivity(myintent);
            finish();

        } else if (id == R.id.nav_offevents) {


        } else if (id == R.id.nav_workshops) {
            Intent myintent = new Intent(Offline.this, Workshop.class);
            startActivity(myintent);
            finish();

        } else if (id == R.id.nav_lectures) {
            Intent myintent = new Intent(Offline.this, GuestSpeaker.class);
            startActivity(myintent);
            finish();


        }
        else if (id == R.id.Contacts) {
            Intent myintent = new Intent(Offline.this, Contact.class);
            startActivity(myintent);
            finish();


        }
        else if (id == R.id.nav_updates) {
            Intent myintent = new Intent(Offline.this, Updates.class);
            startActivity(myintent);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}



