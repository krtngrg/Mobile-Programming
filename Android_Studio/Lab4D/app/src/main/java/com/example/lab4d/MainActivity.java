package com.example.lab4d;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contactList = new ArrayList<>();
        contactList.add(new Contact("Ram", "9841000001"));
        contactList.add(new Contact("Sita", "9841000002"));
        contactList.add(new Contact("Hari", "9841000003"));
        contactList.add(new Contact("Gita", "9841000004"));

        ContactAdapter adapter = new ContactAdapter(this, contactList);
        recyclerView.setAdapter(adapter);
    }
}