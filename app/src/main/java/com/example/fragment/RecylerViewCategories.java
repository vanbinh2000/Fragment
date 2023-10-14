package com.example.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecylerViewCategories extends RecyclerView.Adapter<RecylerViewCategories.ViewHolder> {
    private Fragment_home context;
    private int resource;
    private ArrayList<Categories> data;

    public RecylerViewCategories(Fragment_home context, int resource, ArrayList<Categories> data) {
        this.context = context;
        this.resource = resource;
        this.data = data;
    }


    @NonNull
    @Override
    public RecylerViewCategories.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) context.getLayoutInflater().
                inflate(viewType, parent, false);
        return new RecylerViewCategories.ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerViewCategories.ViewHolder holder, int position) {
        Categories categories = data.get(position);
        holder.tvCategories_name.setText(categories.getCategories_name());
        holder.imgCategories.setImageResource(categories.getImg_categories());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    @Override
    public int getItemViewType(int position) {
        return resource;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategories_name;
        ImageView imgCategories;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategories_name = itemView.findViewById(R.id.tvCategoriesname);
            imgCategories = itemView.findViewById(R.id.imgCategories);
        }
    }
}
