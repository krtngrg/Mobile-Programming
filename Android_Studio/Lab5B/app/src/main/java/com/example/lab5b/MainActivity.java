package com.example.lab5b;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import org.json.*;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText etName, etMessage;
    Button btnSend, btnRetrieve;
    TextView tvResult;

    String SERVER_URL = "https://httpbin.org/post";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);
        btnRetrieve = findViewById(R.id.btnRetrieve);
        tvResult = findViewById(R.id.tvResult);

        RequestQueue queue = Volley.newRequestQueue(this);

        btnSend.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String message = etMessage.getText().toString();

            StringRequest postRequest = new StringRequest(Request.Method.POST, SERVER_URL,
                    response -> Toast.makeText(MainActivity.this, "Data Sent", Toast.LENGTH_SHORT).show(),
                    error -> Toast.makeText(MainActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show()) {

                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("name", name);
                    params.put("message", message);
                    return params;
                }
            };
            queue.add(postRequest);
        });


        btnRetrieve.setOnClickListener(v -> {
            JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, SERVER_URL, null,
                    response -> {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                sb.append("Name: ").append(obj.getString("name")).append("\n");
                                sb.append("Message: ").append(obj.getString("message")).append("\n\n");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        tvResult.setText(sb.toString());
                    },
                    error -> Toast.makeText(MainActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show()
            );
            queue.add(getRequest);
        });
    }
}
