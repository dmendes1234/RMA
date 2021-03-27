package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "MainActivity";

    public static final String HUMANS_DESTROYED_MESSAGE = "Humans destroyed!";
    public static final String HUMANS_RESTORED_MESSAGE = "Humans restored!";
    public static final String HUMANS_IGNORED_MESSAGE = "Humans ignored!";

    private Button bDestroyAllHumans;
    private TextView tvHeaderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
    }

    private void setView(){
        bDestroyAllHumans = findViewById(R.id.bDestroyAllHumans);
        tvHeaderMessage = findViewById(R.id.tvHeaderMessage);
        bDestroyAllHumans.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "button clicked");
        tvHeaderMessage.setText(HUMANS_DESTROYED_MESSAGE);
        displayToast(HUMANS_DESTROYED_MESSAGE);
    }

    public void customOnClick(View v){
        Toast.makeText(this, "Humans ignored!", Toast.LENGTH_SHORT).show();
    }

    private void displayToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
