package com.example.fragment;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewProducts extends RecyclerView.Adapter<RecyclerViewProducts.ViewHolderProducts> {

    private Fragment_home context;
    private int resource;
    private ArrayList<Products>data;

    public RecyclerViewProducts(Fragment_home context, int resource, ArrayList<Products> data) {
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolderProducts onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardViewItem = (CardView) context.getLayoutInflater().
                inflate(viewType, parent, false);
        return new ViewHolderProducts(cardViewItem);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProducts holder, int position) {

        Products products = data.get(position);
        holder.tvproductName.setText(products.getProducts_name());
        holder.tvPrice.setText(products.getPrice());
        holder.tvdescription.setText(products.getDescription());
        holder.imgProducts.setImageResource(products.getImgProducts());
    }

    @Override
    public int getItemViewType(int position) {
        return resource;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolderProducts extends RecyclerView.ViewHolder {
        ImageView imgProducts;
        TextView tvproductName, tvPrice, tvRating, tvdescription;

        public ViewHolderProducts(@NonNull View itemView) {
            super(itemView);
            imgProducts = itemView.findViewById(R.id.imgPrducts);
            tvproductName = itemView.findViewById(R.id.tvProductname);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvRating = itemView.findViewById(R.id.tvTotalRating);
            tvdescription = itemView.findViewById(R.id.tvDescription);

        }
    }


}
