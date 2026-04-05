package com.example.lab4b;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    ImageView img;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        img = findViewById(R.id.imgDetail);
        tv = findViewById(R.id.tvDetail);

        String name = getIntent().getStringExtra("fruitName");
        int image = getIntent().getIntExtra("fruitImage", 0);

        tv.setText(name);
        img.setImageResource(image);
    }
}
