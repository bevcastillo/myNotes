package com.example.beverly.mynotes;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///
        new Handler().postDelayed(new Runnable(){

            @Override
            public void run(){
                Intent registerIntent = new Intent(MainActivity.this, UserLogin.class);
                startActivity(registerIntent);
                finish();
            }
        },SPLASH_TIME_OUT);

        ////
        //call the method created to hide the navigation
        hideNavigationBar();

    }

    @Override
    protected void onResume(){
        super.onResume();

        hideNavigationBar();
    }

    public void hideNavigationBar(){
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                View.SYSTEM_UI_FLAG_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }
}
