package com.example.foodorderapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodorderapp.Adapters.OrdersAdapter;
import com.example.foodorderapp.Models.OrdersModel;
import com.example.foodorderapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        ArrayList<OrdersModel> list = new ArrayList<>();
//        list.add(new OrdersModel(R.drawable.burgerdeal, "Cheese Burger", "4.99", "1"));
//        list.add(new OrdersModel(R.drawable.burgerdeal2, "Chicken Burger", "7.99", "2"));
//        list.add(new OrdersModel(R.drawable.pizza, "Pizza", "6.99", "3"));
//        list.add(new OrdersModel(R.drawable.paratharoll, "Paratha Roll", "3.99", "4"));
//        list.add(new OrdersModel(R.drawable.colddrink, "Cold Drink", "0.99", "5"));

        DBHelper helper = new DBHelper(this);
        ArrayList<OrdersModel> list = helper.getOrder();

        OrdersAdapter adapter = new OrdersAdapter(list, this);
        binding.ordersRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.ordersRecyclerView.setLayoutManager(layoutManager);


    }
}