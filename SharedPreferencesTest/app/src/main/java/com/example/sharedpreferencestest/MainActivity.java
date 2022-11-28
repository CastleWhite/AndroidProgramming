package com.example.sharedpreferencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("name", MODE_PRIVATE).edit();
                editor.putBoolean("male", true);
                editor.putInt("age", 19);
                editor.putString("name", "Kobe");
                editor.apply();
            }
        });

        Button res = (Button) findViewById(R.id.restore);
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("name", MODE_PRIVATE);
                Boolean male = preferences.getBoolean("male", true);
                int age = preferences.getInt("age", 0);
                String name = preferences.getString("name", "JoeDoe");
                Log.d("MainActivity", "name = " + name + "age = " + age);
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}