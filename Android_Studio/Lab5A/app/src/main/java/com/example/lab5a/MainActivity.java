package com.example.lab5a;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etId, etName, etMarks;
    Button btnAdd, btnView, btnUpdate, btnDelete;
    TextView tvResult;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);

        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        etMarks = findViewById(R.id.etMarks);

        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        tvResult = findViewById(R.id.tvResult);


        btnAdd.setOnClickListener(v -> {
            boolean inserted = db.insertData(
                    etName.getText().toString(),
                    etMarks.getText().toString()
            );
            Toast.makeText(this, inserted ? "Inserted" : "Failed", Toast.LENGTH_SHORT).show();
        });


        btnView.setOnClickListener(v -> {
            Cursor res = db.getAllData();
            StringBuilder buffer = new StringBuilder();

            while (res.moveToNext()) {
                buffer.append("ID: ").append(res.getString(0)).append("\n");
                buffer.append("Name: ").append(res.getString(1)).append("\n");
                buffer.append("Marks: ").append(res.getString(2)).append("\n\n");
            }

            tvResult.setText(buffer.toString());
        });


        btnUpdate.setOnClickListener(v -> {
            db.updateData(
                    etId.getText().toString(),
                    etName.getText().toString(),
                    etMarks.getText().toString()
            );
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
        });


        btnDelete.setOnClickListener(v -> {
            db.deleteData(etId.getText().toString());
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        });
    }
}
