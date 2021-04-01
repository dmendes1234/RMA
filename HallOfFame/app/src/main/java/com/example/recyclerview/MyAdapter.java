package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Model> models;

    public MyAdapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, int i) { // i = position
        myHolder.mTitle.setText(models.get(i).getTitle());
        myHolder.mDes.setText(models.get(i).getDescription());
        myHolder.mImageView.setImageResource(models.get(i).getImg());

        myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                if(models.get(position).getTitle().equals("Luka Modrić")){
                    Toast.makeText(c.getApplicationContext(), "Luka igra u Real Madrid-u", Toast.LENGTH_SHORT).show();
                    //or move to another activity
                }
                if(models.get(position).getTitle().equals("Cristiano Ronaldo")){
                    Toast.makeText(c.getApplicationContext(), "Ronaldo igra za Juventus", Toast.LENGTH_SHORT).show();
                }
                if(models.get(position).getTitle().equals("Ivica Kostelić")) {
                    Toast.makeText(c.getApplicationContext(), "Kostelic je bio clan hrvatske reprezentacije", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
