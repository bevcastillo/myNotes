package com.example.beverly.mynotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    DatabaseHelper db;

    EditText EditTextrUsername, EditTextrEmail, EditTextrPassword, EditTextrConfPassw;
    Button ButtonrRegister;
    TextView TextViewrLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        EditTextrUsername = (EditText) findViewById(R.id.editTextrUsername);
        EditTextrEmail = (EditText) findViewById(R.id.editTextrEmail);
        EditTextrPassword = (EditText) findViewById(R.id.editTextrPassword);
        EditTextrConfPassw = (EditText) findViewById(R.id.editTextrConfPass);
        ButtonrRegister = (Button) findViewById(R.id.buttonrRegister);
        TextViewrLogin = (TextView) findViewById(R.id.textViewlLogin);

        //call the buttons created
        onRegister();
        onLogin();

        //call the hide-navigation bar created
        hideNavigationBar();
    }

    public void onRegister(){
        ButtonrRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r_username = EditTextrUsername.getText().toString();
                String r_email = EditTextrEmail.getText().toString();
                String r_password = EditTextrPassword.getText().toString();
                String r_confpass = EditTextrConfPassw.getText().toString();

                ///start
                if(r_username.equals("") || r_email.equals("") || r_password.equals("") || r_confpass.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields can not be empty!", Toast.LENGTH_SHORT).show();
                }//end of first if
                else{
                    if(r_password.equals(r_confpass)){
                        Boolean checkuser = db.chkusername(r_username);
                        if(checkuser == true){
                            Boolean checkemail = db.chkemail(r_email);
                            if(checkemail == true){
                                Boolean insert = db.insertData(r_username, r_email, r_password);
                                if(insert == true){
                                    Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                                    Intent moveHome = new Intent(Register.this,UserHome.class);
                                    startActivity(moveHome);
                                }//end of fifth if
                            }//end fourth if
                            else{
                                Toast.makeText(getApplicationContext(),"Email address already exists!",Toast.LENGTH_SHORT).show();

                            }//end fourth else
                        }//end third if
                        else{
                            Toast.makeText(getApplicationContext(),"Username already exists!",Toast.LENGTH_SHORT).show();

                        }//enf of third else
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Password did not match!",Toast.LENGTH_SHORT).show();

                    }//end of second if
                }
                ///end of conditional statements
            }
        });
    }

    public void onLogin(){
        TextViewrLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toLogin = new Intent(Register.this,UserLogin.class);
                startActivity(toLogin);
            }
        });
    }

    /// hide the navigation bar
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
