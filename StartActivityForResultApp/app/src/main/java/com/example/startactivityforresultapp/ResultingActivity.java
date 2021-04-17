package com.example.startactivityforresultapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultingActivity extends AppCompatActivity {

    EditText etMailInput;
    Button bProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resulting);

        setUpUI();
    }

    private void setUpUI(){
        etMailInput = findViewById(R.id.etMailInput);
        bProcess = findViewById(R.id.bProcess);

        bProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etMailInput.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra(StartingActivity.KEY_EMAIL, email);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }


}