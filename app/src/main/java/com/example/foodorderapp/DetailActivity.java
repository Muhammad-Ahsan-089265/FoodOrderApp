package com.example.foodorderapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorderapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;
    private DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        helper = new DBHelper(this);
        int type = getIntent().getIntExtra("type", 0);

        // Increase quantity button
        binding.add.setOnClickListener(v -> {
            int quantity = parseQuantity(binding.quantity.getText().toString());
            if (quantity < 0) quantity = 0;
            quantity++;
            binding.quantity.setText(String.valueOf(quantity));
        });

        // Decrease quantity button
        binding.minus.setOnClickListener(v -> {
            int quantity = parseQuantity(binding.quantity.getText().toString());
            if (quantity > 1) {
                quantity--;
                binding.quantity.setText(String.valueOf(quantity));
            } else {
                Toast.makeText(this, "Quantity cannot be less than 1", Toast.LENGTH_SHORT).show();
            }
        });

        if (type == 1) {
            showNewOrderForm();
        } else {
            int id = getIntent().getIntExtra("id", -1);
            if (id != -1) {
                showExistingOrder(id);
            } else {
                Toast.makeText(this, "Invalid order ID", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    private void showNewOrderForm() {
        int image = getIntent().getIntExtra("image", 0);
        String priceStr = getIntent().getStringExtra("price");
        String name = getIntent().getStringExtra("name");
        String desc = getIntent().getStringExtra("description");

        int price = parsePrice(priceStr);

        binding.detailImage.setImageResource(image);
        binding.priceLable.setText(String.format("%.2f", price / 100.0));
        binding.nameBox.setText(name);
        binding.detailDescription.setText(desc);

        binding.InsertButton.setText("Order Now");

        binding.InsertButton.setOnClickListener(v -> {
            String userPhone = binding.phoneBox.getText().toString().trim();
            if (userPhone.isEmpty()) {
                Toast.makeText(DetailActivity.this, "Phone number is required!", Toast.LENGTH_SHORT).show();
                return;
            }

            int quantity = parseQuantity(binding.quantity.getText().toString());
            if (quantity <= 0) return;

            boolean ok = helper.insertOrder(
                    binding.nameBox.getText().toString(),
                    userPhone,
                    price,
                    image,
                    desc,
                    name,
                    quantity
            );

            Toast.makeText(this,
                    ok ? "Order placed!" : "Insert failed",
                    Toast.LENGTH_SHORT).show();
        });
    }

    private void showExistingOrder(int id) {
        Cursor c = helper.getOrderById(id);
        if (c != null && c.moveToFirst()) {
            int image = c.getInt(c.getColumnIndexOrThrow("image"));
            int price = c.getInt(c.getColumnIndexOrThrow("price"));
            String name = c.getString(c.getColumnIndexOrThrow("name"));
            String phone = c.getString(c.getColumnIndexOrThrow("phone"));
            String desc = c.getString(c.getColumnIndexOrThrow("description"));
            int quantity = c.getInt(c.getColumnIndexOrThrow("quantity"));

            binding.detailImage.setImageResource(image);
            binding.priceLable.setText(String.format("%.2f", price / 100.0));
            binding.nameBox.setText(name);
            binding.phoneBox.setText(phone);
            binding.detailDescription.setText(desc);
            binding.quantity.setText(String.valueOf(quantity));

            binding.InsertButton.setText("Update Now");

            binding.InsertButton.setOnClickListener(v -> {
                String userPhone = binding.phoneBox.getText().toString().trim();
                if (userPhone.isEmpty()) {
                    Toast.makeText(DetailActivity.this, "Phone number is required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                int updatedQuantity = parseQuantity(binding.quantity.getText().toString());
                if (updatedQuantity <= 0) return;

                boolean ok = helper.updateOrder(
                        binding.nameBox.getText().toString(),
                        userPhone,
                        price,
                        image,
                        desc,
                        name,
                        updatedQuantity,
                        id
                );

                Toast.makeText(this,
                        ok ? "Order updated!" : "Update failed",
                        Toast.LENGTH_SHORT).show();
            });

            c.close();
        } else {
            Toast.makeText(this, "Order not found", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private int parsePrice(String priceStr) {
        try {
            return (priceStr != null) ? (int) (Double.parseDouble(priceStr.replace("$", "")) * 100) : 0;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid price format", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

    private int parseQuantity(String quantityStr) {
        try {
            int quantity = Integer.parseInt(quantityStr);
            if (quantity < 1) {
                Toast.makeText(this, "Quantity must be at least 1", Toast.LENGTH_SHORT).show();
                return -1;
            }
            return quantity;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid quantity", Toast.LENGTH_SHORT).show();
            return -1;
        }
    }
}
