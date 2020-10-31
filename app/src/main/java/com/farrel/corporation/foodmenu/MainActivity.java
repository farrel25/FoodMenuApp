package com.farrel.corporation.foodmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;

import com.farrel.corporation.foodmenu.adapter.CardViewFoodAdapter;
import com.farrel.corporation.foodmenu.model.Food;
import com.farrel.corporation.foodmenu.model.FoodData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvFoods;
    private ArrayList<Food> listFood = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
            getSupportActionBar().setTitle(Html.fromHtml("<font color=\"" + R.color.textBlack + "\">Menu</font>"));
        }

        rvFoods = (RecyclerView) findViewById(R.id.rv_foods);
        rvFoods.setHasFixedSize(true);

        listFood.addAll(FoodData.getFoodListData());

        rvFoods.setLayoutManager(new LinearLayoutManager(this));
        CardViewFoodAdapter cardViewFoodAdapter = new CardViewFoodAdapter(listFood);
        rvFoods.setAdapter(cardViewFoodAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}