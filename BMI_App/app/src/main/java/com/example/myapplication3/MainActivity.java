package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static String TAG = "Done with: ";

    private EditText etWeight;
    private EditText etHeight;
    private Button bCalculateBmi;
    private TextView tvBmiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
    }

    private void setView(){
        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        bCalculateBmi = findViewById(R.id.bCalculateBmi);
        tvBmiResult = findViewById(R.id.tvBmiResult);

        bCalculateBmi.setOnClickListener(this);
        Log.d(TAG, "Setting view");
    }

    @Override
    public void onClick(View v) {
        String weightString = etWeight.getText().toString();
        String heightString = etHeight.getText().toString();

        double weight = Double.parseDouble(weightString);
        double height = Double.parseDouble(heightString);

        double result = calculateBmi(weight, height);

        tvBmiResult.setText(String.format("%.2f", result));
    }

    private double calculateBmi(double weight, double height){
        Log.d(TAG, "Calculating BMI");

        return weight / (height * height);
    }


}