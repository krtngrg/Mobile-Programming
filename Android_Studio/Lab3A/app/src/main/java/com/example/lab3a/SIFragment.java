package com.example.lab3a;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;

public class SIFragment extends Fragment {

    EditText etPrincipal, etRate, etTime;
    Button btnCalculate;
    TextView tvResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_si, container, false);

        etPrincipal = view.findViewById(R.id.etPrincipal);
        etRate = view.findViewById(R.id.etRate);
        etTime = view.findViewById(R.id.etTime);
        btnCalculate = view.findViewById(R.id.btnCalculate);
        tvResult = view.findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pStr = etPrincipal.getText().toString();
                String rStr = etRate.getText().toString();
                String tStr = etTime.getText().toString();

                if (TextUtils.isEmpty(pStr) || TextUtils.isEmpty(rStr) || TextUtils.isEmpty(tStr)) {
                    tvResult.setText("Please enter all values");
                    return;
                }

                double p = Double.parseDouble(pStr);
                double r = Double.parseDouble(rStr);
                double t = Double.parseDouble(tStr);

                double si = (p * r * t) / 100;

                tvResult.setText("Simple Interest: " + si);
            }
        });

        return view;
    }
}