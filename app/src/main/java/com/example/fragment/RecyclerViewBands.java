package com.example.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewBands extends RecyclerView.Adapter<RecyclerViewBands.MyViewHolder> {
    private Fragment_home context;
    private int resource;
    private ArrayList<Brands> data;

    public RecyclerViewBands(Fragment_home context, int resource, ArrayList<Brands> data) {
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerViewBands.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CardView cardView = (CardView) context.getLayoutInflater().
                inflate(viewType, parent, false);
        return new RecyclerViewBands.MyViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewBands.MyViewHolder holder, int position) {
        Brands brands = data.get(position);
        holder.tvBrands_name.setText(brands.getBrands_name());
        holder.imgBrands.setImageResource(brands.getImg_brands());
    }
    @Override
    public int getItemViewType(int position) {
        return resource;
    }
    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvBrands_name;
        ImageView imgBrands;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvBrands_name = itemView.findViewById(R.id.tvBrand);
            imgBrands = itemView.findViewById(R.id.imgBrand);
        }
    }
}
