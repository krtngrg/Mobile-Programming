package com.example.lab4b;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] fruits = {"Apple", "Banana", "Mango", "Orange"};
    int[] images = {
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.mango,
            R.drawable.orange
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        FruitAdapter adapter = new FruitAdapter(this, fruits, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("fruitName", fruits[position]);
            intent.putExtra("fruitImage", images[position]);
            startActivity(intent);
        });
    }
}
