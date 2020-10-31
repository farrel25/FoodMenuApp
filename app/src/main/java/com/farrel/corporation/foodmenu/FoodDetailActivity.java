package com.farrel.corporation.foodmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class FoodDetailActivity extends AppCompatActivity {

    String foodName, foodDescription, foodPrice;
    Double foodRating;
    int foodPhoto;
    TextView tvFoodName, tvFoodDescription, tvFoodPrice, tvFoodRating;
    ImageView ivFoodPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_food_detail);

        foodName = getIntent().getStringExtra("food_name");
        foodDescription = getIntent().getStringExtra("food_description");
        foodPrice = getIntent().getStringExtra("food_price");
        foodRating = getIntent().getDoubleExtra("food_rating", 0);
        foodPhoto = getIntent().getIntExtra("food_photo", 0);

        tvFoodName = (TextView) findViewById(R.id.tv_item_name_detail);
        tvFoodDescription = (TextView) findViewById(R.id.tv_item_description_detail);
        tvFoodPrice = (TextView) findViewById(R.id.tv_item_price_detail);
        tvFoodRating = (TextView) findViewById(R.id.tv_item_rating_detail);
        ivFoodPhoto = (ImageView) findViewById(R.id.img_item_photo_detail);

        Glide.with(this)
                .load(foodPhoto)
                .into(ivFoodPhoto);
        tvFoodName.setText(foodName);
        tvFoodRating.setText(String.valueOf(foodRating));
        tvFoodDescription.setText(foodDescription);
        tvFoodPrice.setText(foodPrice);

    }

    public void btnActionOrder(View view) {
        Toast.makeText(this,"You ordered " + foodName,Toast.LENGTH_SHORT).show();
    }
}