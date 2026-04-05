package com.example.lab2c;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvDisplay = findViewById(R.id.tvDisplay);

        // Receiving data from MainActivity
        String name = getIntent().getStringExtra("NAME");
        String age = getIntent().getStringExtra("AGE");
        String gender = getIntent().getStringExtra("GENDER");

        tvDisplay.setText("Name: " + name + "\nAge: " + age + "\nGender: " + gender);
    }
}