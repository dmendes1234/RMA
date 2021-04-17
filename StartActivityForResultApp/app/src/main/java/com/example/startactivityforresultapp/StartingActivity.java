package com.example.startactivityforresultapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartingActivity extends AppCompatActivity {

    public static final String KEY_EMAIL = "e-mail";
    public static final int KEY_REQUEST_EMAIL = 10;

    TextView tvResult;
    Button bStartProcessing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        setUpUI();
    }

    private void setUpUI(){
        tvResult = findViewById(R.id.tvResult);
        bStartProcessing = findViewById(R.id.bStartProcessing);

        bStartProcessing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicitIntent = new Intent(getApplicationContext(), ResultingActivity.class);
                startActivityForResult(explicitIntent, KEY_REQUEST_EMAIL);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case KEY_REQUEST_EMAIL:
                if(resultCode == RESULT_OK){
                    processEmail(data.getExtras());
                }
                break;
        }
    }

    private void processEmail(Bundle extras){
        String email = extras.getString(KEY_EMAIL);
        tvResult.setText(email);
    }


}