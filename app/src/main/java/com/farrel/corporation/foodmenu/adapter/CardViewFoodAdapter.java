package com.farrel.corporation.foodmenu.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.farrel.corporation.foodmenu.FoodDetailActivity;
import com.farrel.corporation.foodmenu.R;
import com.farrel.corporation.foodmenu.model.Food;

import java.util.ArrayList;

public class CardViewFoodAdapter extends RecyclerView.Adapter<CardViewFoodAdapter.CardViewViewHolder> {

    private ArrayList<Food> listFood;

    public CardViewFoodAdapter(ArrayList<Food> list) {
        this.listFood = list;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(parent.getContext());
        View myView = myInflater.inflate(R.layout.item_food_cardview, parent, false);
        return new CardViewViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        Food food = listFood.get(position);

        Glide.with(holder.itemView.getContext())
                .load(food.getPhoto())
                .apply(new RequestOptions().override(100,100))
                .into(holder.ivFoodPhoto);

        holder.tvFoodName.setText(food.getName());
        holder.tvFoodDescription.setText(food.getDescription());
        holder.tvFoodPrice.setText(food.getPrice());
        holder.tvFoodRating.setText(String.valueOf(food.getRating()));

        holder.tvFoodLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), listFood.get(holder.getBindingAdapterPosition()).getName() + " added to your favorite", Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodDetail = new Intent(holder.itemView.getContext(), FoodDetailActivity.class);
                foodDetail.putExtra("food_photo", listFood.get(holder.getBindingAdapterPosition()).getPhoto());
                foodDetail.putExtra("food_name", listFood.get(holder.getBindingAdapterPosition()).getName());
                foodDetail.putExtra("food_description", listFood.get(holder.getBindingAdapterPosition()).getDescription());
                foodDetail.putExtra("food_price", listFood.get(holder.getBindingAdapterPosition()).getPrice());
                foodDetail.putExtra("food_rating", listFood.get(holder.getBindingAdapterPosition()).getRating());
                holder.itemView.getContext().startActivity(foodDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }

    public static class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoodPhoto;
        TextView tvFoodName, tvFoodDescription, tvFoodPrice, tvFoodRating, tvFoodLove;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoodPhoto = itemView.findViewById(R.id.img_item_photo);
            tvFoodName = itemView.findViewById(R.id.tv_item_name);
            tvFoodDescription = itemView.findViewById(R.id.tv_item_description);
            tvFoodPrice = itemView.findViewById(R.id.tv_item_price);
            tvFoodRating = itemView.findViewById(R.id.tv_item_rating);
            tvFoodLove = itemView.findViewById(R.id.tv_item_love);
        }
    }
}
