package com.example.beverly.mynotes;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class UserHome extends AppCompatActivity {

    private DrawerLayout homeDrawerLayout;
    private ActionBarDrawerToggle homeToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        homeDrawerLayout = (DrawerLayout) findViewById(R.id.homeDrawer);

        homeToggle = new ActionBarDrawerToggle(this, homeDrawerLayout,R.string.open,R.string.close);
        homeDrawerLayout.addDrawerListener(homeToggle);
        homeToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(homeToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
