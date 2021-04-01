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

        m = new Model();
        m.setTitle("Cristiano Ronaldo");
        m.setDescription("Cristiano Ronaldo dos Santos Aveiro, poznatiji kao Cristiano Ronaldo, " +
                "portugalski nogometaš, član je torinskog Juventusa. Reprezentativac je i kapetan Portugala.");
        m.setImg(R.drawable.ronaldo2);
        models.add(m);

        m = new Model();
        m.setTitle("Ivica Kostelić");
        m.setDescription("Ivica Kostelić je bivši hrvatski alpski skijaš. " +
                "Specijalizirao se za slalom i kombinaciju no također bio je jedan od rijetkih skijaša koji je osvajao bodove u svim disciplinama. " +
                "Najveći uspjesi karijere su mu osvajanje velikog kristalnog globusa sezone 2010.");
        m.setImg(R.drawable.kostelic);
        models.add(m);

        return models;
    }
}