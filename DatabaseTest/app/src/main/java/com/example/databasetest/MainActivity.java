package com.example.databasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new MyDatabaseHelper(this, "BookStroe.db", null, 2);
        Button create = (Button) findViewById(R.id.button);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.getWritableDatabase();
            }
        });

        Button add = (Button) findViewById(R.id.button2);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = helper.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put("name", "The Da Vinci");
                values.put("author", "Dan");
                values.put("pages", 100);
                values.put("price", 19.99);
                db.insert("Book", null, values);
                values.clear();
            }
        });
    }
}