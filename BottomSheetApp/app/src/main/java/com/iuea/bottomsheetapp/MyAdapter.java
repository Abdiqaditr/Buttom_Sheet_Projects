package com.iuea.bottomsheetapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<String> items;

    // Constructor
    public MyAdapter(List<String> items) {
        this.items = items;
    }

    // ViewHolder class
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewItem;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewItem = itemView.findViewById(R.id.textView_item);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Bind data to the TextView
        String currentItem = items.get(position);
        holder.textViewItem.setText(currentItem);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
