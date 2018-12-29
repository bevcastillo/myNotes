package com.example.beverly.mynotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Overview extends AppCompatActivity {

    DatabaseHelper db;

    TextView username, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        db = new DatabaseHelper(this);

        username = (TextView) findViewById(R.id.textViewusername);
        email = (TextView) findViewById(R.id.textViewemail);

    }
}
