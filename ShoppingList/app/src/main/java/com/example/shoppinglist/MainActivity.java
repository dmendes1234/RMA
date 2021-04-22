package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RemoveClickListener {

    private Context context;
    AdapterDatabase database;

    private RecyclerView recyclerView;
    private List<String> dataList;
    private CustomAdapter customAdapter;

    private Button btnAdd;
    private EditText etItemToAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupData();
        setupRecyclerView();

        etItemToAdd = findViewById(R.id.etItemToAdd);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long mId = database.addItem(etItemToAdd.getText().toString());
                dataList.add(0, new String(etItemToAdd.getText().toString()));
                customAdapter.notifyItemInserted(0);
            }
        });
    }

    private void setupData(){
        this.context = this;
        database = new AdapterDatabase(context);
        dataList = new ArrayList<>(database.getAllItems());
    }

    private void setupRecyclerView(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        customAdapter = new CustomAdapter(dataList, this);
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void onRemoveClick(int position) {
        int mCount = database.deleteItem(dataList.get(position));
        dataList.remove(position);
        customAdapter.notifyItemRemoved(position);
    }
}