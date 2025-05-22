package com.example.foodorderapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodorderapp.Adapters.MainAdapter;
import com.example.foodorderapp.Models.MainModel;
import com.example.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Prepare list of food items
        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.singleburger, "Burger", "4.99", "Chicken Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.burgerdeal, "Burger Deal 1", "7.99", "1 Zinger Burger with Sizzling Fries"));
        list.add(new MainModel(R.drawable.burgerdeal2, "Burger Deal 2", "8.99", "3 Chicken Burger with Extra Cheese"));
        list.add(new MainModel(R.drawable.pizza, "Pizza", "6.99", "Pizza (Small - Medium - Large)"));
        list.add(new MainModel(R.drawable.paratharoll, "Paratha Roll", "3.99", "Paratha Roll with Extra Mayonnaise"));
        list.add(new MainModel(R.drawable.colddrink, "Cold Drink", "0.99", "Cold Drink (Pak Cola - Pak Lime)"));
        list.add(new MainModel(R.drawable.bacon_and_cheese_heaven, "Bacon and Cheese Heaven", "5.99", "Tasty bacon and cheese heaven to satisfy your cravings."));
        list.add(new MainModel(R.drawable.baconwrapped_filet_mignon, "Bacon-Wrapped Filet Mignon", "6.49", "Tasty bacon-wrapped filet mignon to satisfy your cravings."));
        list.add(new MainModel(R.drawable.bbq_chicken_delight, "BBQ Chicken Delight", "6.99", "Tasty BBQ chicken delight to satisfy your cravings."));
        list.add(new MainModel(R.drawable.bbq_ranch_delight, "BBQ Ranch Delight", "7.49", "Tasty BBQ ranch delight to satisfy your cravings."));
        list.add(new MainModel(R.drawable.beef_stirfry_with_broccoli, "Beef Stir-Fry with Broccoli", "7.99", "Tasty beef stir-fry with broccoli to satisfy your cravings."));
        list.add(new MainModel(R.drawable.berry_blast_smoothie, "Berry Blast Smoothie", "3.49", "Refreshing berry smoothie to satisfy your cravings."));
        list.add(new MainModel(R.drawable.california_roll, "California Roll", "5.99", "Delicious California roll to satisfy your cravings."));
        list.add(new MainModel(R.drawable.chicago_style_hot_dog, "Chicago Style Hot Dog", "4.99", "Authentic Chicago-style hot dog to satisfy your cravings."));
        list.add(new MainModel(R.drawable.chicken_avocado_bliss, "Chicken Avocado Bliss", "6.49", "Tasty chicken avocado combo to satisfy your cravings."));
        list.add(new MainModel(R.drawable.chili_cheese_dog, "Chili Cheese Dog", "4.99", "Hot dog with chili and cheese to satisfy your cravings."));
        list.add(new MainModel(R.drawable.classic_beef_burger, "Classic Beef Burger", "5.49", "Classic beef burger to satisfy your cravings."));
        list.add(new MainModel(R.drawable.classic_beef_hot_dog, "Classic Beef Hot Dog", "3.99", "Classic beef hot dog to satisfy your cravings."));
        list.add(new MainModel(R.drawable.coconut_water, "Coconut Water", "1.99", "Refreshing coconut water to satisfy your cravings."));
        list.add(new MainModel(R.drawable.dragon_roll, "Dragon Roll", "6.99", "Delicious dragon sushi roll to satisfy your cravings."));
        list.add(new MainModel(R.drawable.espresso_martini, "Espresso Martini", "4.49", "Chilled espresso martini to satisfy your cravings."));
        list.add(new MainModel(R.drawable.four_cheese_delight, "Four Cheese Delight", "5.99", "Cheesy pizza with four kinds of cheese to satisfy your cravings."));
        list.add(new MainModel(R.drawable.fresh_orange_juice, "Fresh Orange Juice", "2.49", "Freshly squeezed orange juice to satisfy your cravings."));
        list.add(new MainModel(R.drawable.garlic_parmesan_chicken, "Garlic Parmesan Chicken", "6.99", "Garlicky parmesan chicken to satisfy your cravings."));
        list.add(new MainModel(R.drawable.green_tea_latte, "Green Tea Latte", "2.99", "Soothing green tea latte to satisfy your cravings."));
        list.add(new MainModel(R.drawable.grilled_ribeye_steak, "Grilled Ribeye Steak", "12.99", "Juicy grilled ribeye steak to satisfy your cravings."));
        list.add(new MainModel(R.drawable.hawaiian_bbq_dog, "Hawaiian BBQ Dog", "4.99", "BBQ dog with pineapple twist to satisfy your cravings."));
        list.add(new MainModel(R.drawable.hawanan_paradise, "Hawanan Paradise", "7.49", "Tropical Hawaiian combo to satisfy your cravings."));
        list.add(new MainModel(R.drawable.honey_mustard_glazed_tenders, "Honey Mustard Glazed Tenders", "5.99", "Chicken tenders with honey mustard to satisfy your cravings."));
        list.add(new MainModel(R.drawable.iced_caramel_macchiato, "Iced Caramel Macchiato", "3.99", "Iced coffee with caramel flavor to satisfy your cravings."));
        list.add(new MainModel(R.drawable.kimchi_hot_dog, "Kimchi Hot Dog", "4.49", "Spicy kimchi-topped hot dog to satisfy your cravings."));
        list.add(new MainModel(R.drawable.korean_bbq_short_ribs, "Korean BBQ Short Ribs", "10.99", "Grilled Korean short ribs to satisfy your cravings."));
        list.add(new MainModel(R.drawable.korean_fried_chicken, "Korean Fried Chicken", "8.49", "Crispy Korean fried chicken to satisfy your cravings."));
        list.add(new MainModel(R.drawable.lemon_pepper_chicken, "Lemon Pepper Chicken", "6.49", "Zesty lemon pepper chicken to satisfy your cravings."));
        list.add(new MainModel(R.drawable.mango_tango_slush, "Mango Tango Slush", "3.49", "Cool mango and citrus slush to satisfy your cravings."));
        list.add(new MainModel(R.drawable.margherita_flatbread, "Margherita Flatbread", "5.99", "Flatbread with fresh tomatoes and mozzarella to satisfy your cravings."));
        list.add(new MainModel(R.drawable.margherita, "Margherita", "5.49", "Classic margherita pizza to satisfy your cravings."));
        list.add(new MainModel(R.drawable.meat_feast_pizza, "Meat Feast Pizza", "7.99", "Loaded meat pizza to satisfy your cravings."));
        list.add(new MainModel(R.drawable.mediterranean_joy, "Mediterranean Joy", "6.49", "Mediterranean style dish to satisfy your cravings."));
        list.add(new MainModel(R.drawable.mint_lemonade, "Mint Lemonade", "2.49", "Refreshing mint lemonade to satisfy your cravings."));
        list.add(new MainModel(R.drawable.mushroom_swiss_delight, "Mushroom Swiss Delight", "6.29", "Mushroom and swiss burger to satisfy your cravings."));
        list.add(new MainModel(R.drawable.original_crispy_chicken, "Original Crispy Chicken", "5.99", "Crispy fried chicken to satisfy your cravings."));
        list.add(new MainModel(R.drawable.panseared_garlic_butter_sirloin, "Pan-Seared Garlic Butter Sirloin", "11.49", "Sirloin in garlic butter to satisfy your cravings."));
        list.add(new MainModel(R.drawable.pasta_carbonara, "Pasta Carbonara", "7.49", "Creamy carbonara pasta to satisfy your cravings."));
        list.add(new MainModel(R.drawable.pepperoni_lovers, "Pepperoni Lovers", "6.99", "Pepperoni loaded pizza to satisfy your cravings."));
        list.add(new MainModel(R.drawable.pretzel_bun_dog, "Pretzel Bun Dog", "4.99", "Hot dog in pretzel bun to satisfy your cravings."));
        list.add(new MainModel(R.drawable.quinua_salad_bowl, "Quinua Salad Bowl", "5.49", "Healthy quinoa salad to satisfy your cravings."));
        list.add(new MainModel(R.drawable.rainbow_roll, "Rainbow Roll", "6.99", "Colorful sushi roll to satisfy your cravings."));
        list.add(new MainModel(R.drawable.reuben_style_hot_dog, "Reuben Style Hot Dog", "5.49", "Hot dog with reuben toppings to satisfy your cravings."));
        list.add(new MainModel(R.drawable.salmon_nigiri, "Salmon Nigiri", "6.99", "Fresh salmon nigiri sushi to satisfy your cravings."));
        list.add(new MainModel(R.drawable.sashimi_platter, "Sashimi Platter", "8.99", "Assorted fresh sashimi to satisfy your cravings."));
        list.add(new MainModel(R.drawable.shrimp_scampi, "Shrimp Scampi", "7.49", "Shrimp scampi pasta to satisfy your cravings."));
        list.add(new MainModel(R.drawable.smoked_bbq_brisket, "Smoked BBQ Brisket", "8.99", "Tender BBQ brisket to satisfy your cravings."));
        list.add(new MainModel(R.drawable.southern_style_chicken_biscuit, "Southern-Style Chicken Biscuit", "4.99", "Fried chicken in a biscuit to satisfy your cravings."));
        list.add(new MainModel(R.drawable.spicy_buffalo_wings, "Spicy Buffalo Wings", "5.99", "Spicy chicken wings to satisfy your cravings."));
        list.add(new MainModel(R.drawable.spicy_jalapeno_burger, "Spicy Jalapeño Burger", "6.49", "Spicy jalapeño topped burger to satisfy your cravings."));
        list.add(new MainModel(R.drawable.spicy_moroccan_lamb_chops, "Spicy Moroccan Lamb Chops", "9.49", "Spicy grilled lamb chops to satisfy your cravings."));
        list.add(new MainModel(R.drawable.spicy_tuna_roll, "Spicy Tuna Roll", "6.49", "Spicy tuna sushi roll to satisfy your cravings."));
        list.add(new MainModel(R.drawable.spinach_and_feta_stuffed_chicken, "Spinach and Feta Stuffed Chicken", "7.49", "Stuffed chicken with spinach and feta to satisfy your cravings."));
        list.add(new MainModel(R.drawable.stuffed_bell_peppers_with_ground_turkey, "Stuffed Bell Peppers", "6.99", "Bell peppers stuffed with turkey to satisfy your cravings."));
        list.add(new MainModel(R.drawable.tempura_shrimp_roll, "Tempura Shrimp Roll", "6.49", "Tempura shrimp sushi roll to satisfy your cravings."));
        list.add(new MainModel(R.drawable.teriyaki_chicken_wings, "Teriyaki Chicken Wings", "5.99", "Wings glazed in teriyaki to satisfy your cravings."));
        list.add(new MainModel(R.drawable.teriyaki_glazed_chicken_thighs, "Teriyaki Glazed Chicken Thighs", "6.49", "Chicken thighs in teriyaki glaze to satisfy your cravings."));
        list.add(new MainModel(R.drawable.teriyaki_pineapple_pleasure, "Teriyaki Pineapple Pleasure", "6.99", "Teriyaki dish with pineapple twist to satisfy your cravings."));
        list.add(new MainModel(R.drawable.thai_red_curry, "Thai Red Curry", "7.49", "Spicy Thai red curry to satisfy your cravings."));
        list.add(new MainModel(R.drawable.vegetarian_pad_thai, "Vegetarian Pad Thai", "6.99", "Veggie Pad Thai to satisfy your cravings."));
        list.add(new MainModel(R.drawable.veggie_dog_with_sauerkraut, "Veggie Dog with Sauerkraut", "4.49", "Veggie hot dog with sauerkraut to satisfy your cravings."));
        list.add(new MainModel(R.drawable.veggie_extravaganza, "Veggie Extravaganza", "5.99", "Loaded veggie delight to satisfy your cravings."));
        list.add(new MainModel(R.drawable.veggie_roll, "Veggie Roll", "5.49", "Vegetarian sushi roll to satisfy your cravings."));
        list.add(new MainModel(R.drawable.veggie_supreme, "Veggie Supreme", "6.49", "Supreme veggie pizza to satisfy your cravings."));

        // Setup adapter and RecyclerView
        MainAdapter adapter = new MainAdapter(list, this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);  // Inflate the menu resource
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle menu item clicks
        if (item.getItemId() == R.id.orders) {
            startActivity(new Intent(MainActivity.this, OrderActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // Show confirmation dialog on back press
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Exit")
                .setIcon(R.drawable.warning)  // Make sure this drawable exists
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", (dialogInterface, i) -> MainActivity.super.onBackPressed())
                .setNeutralButton("Help", (dialogInterface, i) ->
                        Toast.makeText(MainActivity.this, "Open help", Toast.LENGTH_LONG).show())
                .setNegativeButton("No", null)
                .show();
    }
}
