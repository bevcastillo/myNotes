package com.example.beverly.mynotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class UserHome extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout homeDrawerLayout;
    private ActionBarDrawerToggle homeToggle;

    //the floating add action button
    FloatingActionButton addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        homeDrawerLayout = (DrawerLayout) findViewById(R.id.homeDrawer);

        homeToggle = new ActionBarDrawerToggle(this, homeDrawerLayout,R.string.open,R.string.close);
        homeDrawerLayout.addDrawerListener(homeToggle);
        homeToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //get the object of floatingactionbutton
        addBtn = (FloatingActionButton)findViewById(R.id.addButton);

        //add events to the floating action button
        addBtn.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(homeToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v==addBtn){
            Intent addnote = new Intent(this,AddActivity.class);
            startActivity(addnote);
        }
    }
}
