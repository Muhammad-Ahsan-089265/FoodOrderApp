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

    final static String DBNAME = "mydatabase.db";
    final static int DBVERSION = 1; //Change version again and again, until it works
    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE orders (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT, " +
                        "phone TEXT, " +
                        "price INTEGER, " +
                        "image INTEGER, " +
                        "quantity INTEGER, " +
                        "description TEXT, " +
                        "foodname TEXT" +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists orders");
        onCreate(sqLiteDatabase);
    }


    /*
        id=0
        name=1
        phone=2
        price=3
        image=4
        description=5
        foodname=6
        quantity=7
         */
    public boolean insertOrder(String name, String phone, int price, int image, String description, String foodname, int quantity) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();


        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image );
        values.put("description", description );
        values.put("foodname", foodname );
        values.put("quantity", quantity );
        long id = database.insert("orders", null, values);
        if (id <= 0) {
            return false;
        }
        else {
            return true;
        }
    }
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

        long row = database.update("orders", values, "id = " + id, null);
        return row > 0;
    }

    public ArrayList<OrdersModel> getOrder() {
        ArrayList<OrdersModel> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();

        Cursor cursor = database.rawQuery("select id,foodname,image,price from orders", null);
        if (cursor.moveToFirst()) {
            do {
                OrdersModel model = new OrdersModel();
                model.setSoldItemName(cursor.getString(0) + "");
                model.setSoldItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3)+"");
                orders.add(model);

            }while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return orders; // Return local list, do NOT call getOrder() here to avoid recursion
    }

    public Cursor getOrderById(int id) {
        ArrayList<OrdersModel> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();

        Cursor cursor = database.rawQuery("select * from orders where id = "+ id, null);

        if(cursor!= null)
            cursor.moveToFirst();
        return cursor;
    }

    public boolean updateOrder(String name, String phone, int price, int image, String description, String foodname, int quantity) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();

        /*
        id=0
        name=1
        phone=2
        price=3
        image=4
        description=5
        foodname=6
        quantity=7
         */
        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image );
        values.put("description", description );
        values.put("foodname", foodname );
        values.put("quantity", quantity );
        long row = database.update("orders", values, "id = " +id, null);

        if (row <= 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public int deleteOrder(String id) {
        SQLiteDatabase database = getWritableDatabase();
        return database.delete("orders", "id = " + id, null);
    }
}
