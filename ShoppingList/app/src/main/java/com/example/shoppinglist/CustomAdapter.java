package com.example.shoppinglist;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.NameViewHolder> {

    private static final String TAG = "CustomAdapter";
    private RemoveClickListener removeClickListener;

    private List<String> dataList;

    public CustomAdapter(List<String> dataList, RemoveClickListener removeClickListener) {
        this.dataList = dataList;
        this.removeClickListener = removeClickListener;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listItemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new NameViewHolder(listItemView, removeClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.setName(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class NameViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvListItem;
        private final ImageView ivRemove;

        public NameViewHolder(@NonNull View itemView, RemoveClickListener removeClickListener) {
            super(itemView);

            tvListItem = itemView.findViewById(R.id.tvListItem);

            ivRemove = itemView.findViewById(R.id.ivRemove);
            ivRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeClickListener.onRemoveClick(getAdapterPosition());
                }
            });
        }

        public void setName(String name){
            tvListItem.setText(name);
        }

    }
}
