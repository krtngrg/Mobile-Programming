package com.example.lab4c;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class FullscreenActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        imageView = findViewById(R.id.fullImage);

        int image = getIntent().getIntExtra("image", 0);
        imageView.setImageResource(image);
    }
}