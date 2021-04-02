package com.example.predavanje23_03_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ActivitySecond extends AppCompatActivity {

    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_second);

        Intent intent = getIntent();
        String fname = intent.getStringExtra("fname");

        if(fname != null) {
            Toast.makeText(this, "Name sent from first activity: " + fname, Toast.LENGTH_SHORT).show();
        }

        username = intent.getStringExtra("username");
        password = intent.getStringExtra("password");
        Toast.makeText(ActivitySecond.this, "Username: " + username + " Pass: " + password, Toast.LENGTH_LONG).show();
    }

    public void closeThisActivity(View v){
        finish();
    }
}