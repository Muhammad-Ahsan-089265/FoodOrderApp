package com.example.foodorderapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodorderapp.Adapters.OrdersAdapter;
import com.example.foodorderapp.Models.OrdersModel;
import com.example.foodorderapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper dbHelper = new DBHelper(this);
        ArrayList<OrdersModel> ordersList = dbHelper.getOrder();

        if (ordersList.isEmpty()) {
            Toast.makeText(this, "No orders found", Toast.LENGTH_SHORT).show();
            binding.ordersRecyclerView.setVisibility(View.GONE);  // Hide RecyclerView
        } else {
            binding.ordersRecyclerView.setVisibility(View.VISIBLE);
            OrdersAdapter adapter = new OrdersAdapter(ordersList, this);
            binding.ordersRecyclerView.setAdapter(adapter);
            binding.ordersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }
}
