package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static String TAG = "Done with: ";

    private EditText etWeight;
    private EditText etHeight;
    private Button bCalculateBmi;
    private TextView tvBmiResult;
    private TextView tvBmiResultTitle;
    private TextView tvBmiResultDescription;
    private ImageView imageBmiResult;

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
        tvBmiResultTitle = findViewById(R.id.tvBmiResultTitle);
        tvBmiResultDescription = findViewById(R.id.tvBmiResultDescription);
        imageBmiResult = findViewById(R.id.imageBmiResult);

        bCalculateBmi.setOnClickListener(this);
        Log.d(TAG, "Setting view");
    }

    @Override
    public void onClick(View v) {
        String weightString = etWeight.getText().toString();
        String heightString = etHeight.getText().toString();

        double weight = Double.parseDouble(weightString);
        double height = Double.parseDouble(heightString);

        if(weight == 0 || height == 0 || weight > 350 || height > 2.5) {
            Toast.makeText(this, "Pogrešan unos!", Toast.LENGTH_SHORT).show();
        }
        else {
            double result = calculateBmi(weight, height);
            tvBmiResult.setText("Your BMI is " + String.format("%.2f", result));

            if (result < 18.5) {
                tvBmiResultTitle.setText("You are underweight!");
                tvBmiResultDescription.setText("People who are underweight may need to eat more often to consume enough calories to gain weight. " +
                        "This is especially true if you don't have a very big appetite. " +
                        "Aim for six small meals spread throughout the day instead of trying to pack more into three meals.");
                imageBmiResult.setImageResource(R.drawable.underweight);
            } else if (result > 24.9) {
                tvBmiResultTitle.setText("You are overweight!");
                tvBmiResultDescription.setText("Consume nutrient-dense foods, " +
                        "such as lean protein, whole grains, legumes, low-fat dairy products, nuts and seeds and fruits and vegetables. " +
                        "Limit foods that are high in saturated fat, cholesterol, sugars and sodium, as these can increase your risks for certain health conditions.");
                imageBmiResult.setImageResource(R.drawable.overweight);
            } else {
                tvBmiResultTitle.setText("You are normal weight!");
                tvBmiResultDescription.setText("You are good. Keep it up!");
                imageBmiResult.setImageResource(R.drawable.normal_weight);
            }
        }
    }

    private double calculateBmi(double weight, double height){
        Log.d(TAG, "Calculating BMI");

        return weight / (height * height);
    }


}