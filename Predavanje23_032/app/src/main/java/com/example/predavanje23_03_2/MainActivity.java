package com.example.predavanje23_03_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShowMessage2, btnLogin;
    EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowMessage2 = findViewById(R.id.btnShowMessage2);
        btnShowMessage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Showing message 2!", Toast.LENGTH_SHORT).show();
            }
        });

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username, userPassword;
                Intent loginIntent = new Intent(MainActivity.this, ActivitySecond.class);

                username = etUsername.getText().toString();
                userPassword = etPassword.getText().toString();

                loginIntent.putExtra("username", username);
                loginIntent.putExtra("password", userPassword);
                startActivity(loginIntent);
            }
        });
    }

    public void showMessage(View v) {
        Toast.makeText(this, "Showing message!", Toast.LENGTH_SHORT).show();
    }

    public void start2ndActivity(View v){
        Intent intent = new Intent(this, ActivitySecond.class);
        intent.putExtra("fname", "Johntra");
        startActivity(intent);
    }

}