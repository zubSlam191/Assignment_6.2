package com.emailprocessing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.zubair.myapplication.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView registerScreen = (TextView) findViewById(R.id.activateButton);
        TextView dBManager = (TextView) findViewById(R.id.openDBEditor);

        // Listening to register new account link
        assert registerScreen != null;
        registerScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), ActivateActivity.class);
                startActivity(i);
            }
        });

        dBManager.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), AndroidDatabaseManager.class);
                startActivity(i);
            }
        });


    }
}