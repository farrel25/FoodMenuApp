package com.farrel.corporation.foodmenu.model;

import com.farrel.corporation.foodmenu.R;

import java.util.ArrayList;

public class FoodData {
    private static String[] foodNames = {
            "Pizza",
            "Burger",
            "Pancake",
            "Cream Soup",
            "Toast Bread",
            "Grilled Squid",
            "Waffle",
            "Frappe",
            "Ramen",
            "Baked Creepes"
    };

    private static String[] foodDescriptions = {
            "a savory dish of Italian origin consisting of a usually round, flattened base of leavened wheat-based dough topped with various ingredients, which is then baked at a high temperature, traditionally in a wood-fired oven.",
            "a sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.",
            "a flat cake, prepared from a starch-based batter that may contain eggs, milk and butter and cooked on a hot surface such as a griddle or frying pan, often frying with oil or butter.",
            "a simple type of soup where a basic roux is thinned with cream or milk and then mushrooms and/or mushroom broth are added.",
            "a form of bread that has been browned by toasting, that is, exposure to radiant heat.",
            "is simply flavored with olive oil and lemon juice, then quickly grilled to tender perfection.",
            "a dish made from leavened batter or dough that is cooked between two plates that are patterned to give a characteristic size, shape, and surface impression.",
            "a Greek iced coffee drink made from instant coffee, water, sugar, and milk.",
            "a Japanese noodle soup. It consists of Chinese wheat noodles served in a meat or fish-based broth, often flavored with soy sauce or miso, and uses toppings.",
            "a type of very thin pancake. Crêpes are usually of two types: sweet crêpes and savoury galettes. Crêpes are served with a variety of fillings, from the simplest with only sugar to flambéed crêpes Suzette or elaborate savoury galettes."
    };

    private static String[] foodPrices = {
            "Rp. 80.000",
            "Rp. 30.000",
            "Rp. 28.000",
            "Rp. 32.000",
            "Rp. 23.000",
            "Rp. 56.000",
            "Rp. 26.000",
            "Rp. 27.000",
            "Rp. 44.000",
            "Rp. 37.000"
    };

    private static Double[] foodRatings = {
            4.9,
            4.8,
            4.4,
            4.7,
            3.8,
            5.0,
            4.3,
            4.6,
            3.8,
            4.5
    };

    private static int[] foodPhotos = {
            R.drawable.pizza,
            R.drawable.burger,
            R.drawable.pancake,
            R.drawable.cream_soup,
            R.drawable.toast_bread,
            R.drawable.grilled_squid,
            R.drawable.waffle,
            R.drawable.frappe,
            R.drawable.ramen,
            R.drawable.baked_creepes
    };

    public static ArrayList<Food> getFoodListData() {

        ArrayList<Food> list = new ArrayList<>();

        for (int idx=0 ; idx<foodNames.length ; idx++) {

            Food food = new Food();

            food.setName(foodNames[idx]);
            food.setDescription(foodDescriptions[idx]);
            food.setPrice(foodPrices[idx]);
            food.setRating(foodRatings[idx]);
            food.setPhoto(foodPhotos[idx]);

            list.add(food);
        }

        return list;
    }
}
