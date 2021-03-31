package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, getMyList());
        mRecyclerView.setAdapter(myAdapter);
    }

    private ArrayList<Model> getMyList(){
        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setTitle("Luka Modrić");
        m.setDescription("Luka Modrić, hrvatski je profesionalni nogometaš, " +
                "hrvatski nogometni reprezentativac i kapetan hrvatske nogometne reprezentacije " +
                "koji trenutačno igra za španjolski nogometni klub Real Madrid.");
        m.setImg(R.drawable.modric);
        models.add(m);

        m.setTitle("Luka Modrić");
        m.setDescription("Luka Modrić, hrvatski je profesionalni nogometaš, " +
                "hrvatski nogometni reprezentativac i kapetan hrvatske nogometne reprezentacije " +
                "koji trenutačno igra za španjolski nogometni klub Real Madrid.");
        m.setImg(R.drawable.modric);
        models.add(m);

        m.setTitle("Luka Modrić");
        m.setDescription("Luka Modrić, hrvatski je profesionalni nogometaš, " +
                "hrvatski nogometni reprezentativac i kapetan hrvatske nogometne reprezentacije " +
                "koji trenutačno igra za španjolski nogometni klub Real Madrid.");
        m.setImg(R.drawable.modric);
        models.add(m);

        return models;
    }
}