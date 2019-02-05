package com.example.beverly.mynotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity {

    DatabaseHelper db;

    EditText Editxtluser, Editxtlpassw;
    Button btnlLogin;
    TextView txtlregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        db = new DatabaseHelper(this);

        Editxtluser = (EditText) findViewById(R.id.editTextlUsername);
        Editxtlpassw = (EditText) findViewById(R.id.editTextlPassword);
        btnlLogin = (Button) findViewById(R.id.buttonlLogin);
        txtlregister = (TextView) findViewById(R.id.textViewlLogin);

        //call the listeners created
        onLoginClick();
        onRegisterClick();

        //call the hide-navigation bar created
        //hideNavigationBar();

    }

    public void onLoginClick(){
        btnlLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String l_username = Editxtluser.getText().toString();
                String l_password = Editxtlpassw.getText().toString();

                if(l_username.equals("") || l_password.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields can not be empty!", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuserpassword = db.chkuserpassw(l_username, l_password);
                    if(checkuserpassword == true){
                        Toast.makeText(getApplicationContext(), "Successfully Logged in.", Toast.LENGTH_SHORT).show();
                        Intent toHome = new Intent(UserLogin.this,UserHome.class);
                        startActivity(toHome);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Wrong email and password!", Toast.LENGTH_SHORT).show();
                    }//end of second if
                }//end of first if

                ///end of conditional statements
            }
        });
    }

    public void onRegisterClick(){
        txtlregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toregister = new Intent(UserLogin.this,Register.class);
                startActivity(toregister);
            }
        });
    }

}
