package com.example.foodorderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foodorderapp.Models.OrdersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "mydatabase.db";
    private static final int DBVERSION = 2;

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE orders (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "phone TEXT, " +
                "price INTEGER, " +
                "image INTEGER, " +
                "quantity INTEGER, " +
                "description TEXT, " +
                "foodname TEXT" +
                ")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS orders");
        onCreate(db);
    }

    /**
     * Inserts a new order into the orders table.
     */
    public boolean insertOrder(String name, String phone, int price, int image, String description, String foodname, int quantity) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("description", description);
        values.put("foodname", foodname);
        values.put("quantity", quantity);

        long id = database.insert("orders", null, values);
        return id > 0;
    }

    /**
     * Updates an existing order by id.
     */
    public boolean updateOrder(String name, String phone, int price, int image, String description, String foodname, int quantity, int id) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("description", description);
        values.put("foodname", foodname);
        values.put("quantity", quantity);

        int rowsAffected = database.update("orders", values, "id = ?", new String[]{String.valueOf(id)});
        return rowsAffected > 0;
    }

    /**
     * Returns a list of all orders with limited info for summary display.
     */
    public ArrayList<OrdersModel> getOrder() {
        ArrayList<OrdersModel> orders = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT id, foodname, image, price, quantity, description FROM orders", null);
        if (cursor.moveToFirst()) {
            do {
                OrdersModel model = new OrdersModel(
                        cursor.getInt(cursor.getColumnIndexOrThrow("image")),
                        cursor.getString(cursor.getColumnIndexOrThrow("foodname")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("price")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                        cursor.getInt(cursor.getColumnIndexOrThrow("quantity")),
                        cursor.getString(cursor.getColumnIndexOrThrow("description"))
                );
                orders.add(model);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return orders;
    }


    /**
     * Retrieves a cursor to an order by its id.
     */
    public Cursor getOrderById(int id) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery("SELECT * FROM orders WHERE id = ?", new String[]{String.valueOf(id)});
    }

    /**
     * Deletes an order by id.
     */
    public int deleteOrder(String id) {
        SQLiteDatabase database = getWritableDatabase();
        return database.delete("orders", "id = ?", new String[]{id});
    }
}