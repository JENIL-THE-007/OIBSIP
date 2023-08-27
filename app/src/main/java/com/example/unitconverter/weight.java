package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class weight extends AppCompatActivity {
    private EditText in;
    private Spinner sp;
    private TextView gram, kilo, mili, ton, pound, ounce, carrat;
    private String[] arr = {"G", "KG", "MG", "TON", "LB", "OZ", "CT"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        in = findViewById(R.id.in2);
        sp = findViewById(R.id.sp2);
        gram = findViewById(R.id.gram);
        kilo = findViewById(R.id.kilog);
        mili = findViewById(R.id.milig);
        ton = findViewById(R.id.ton);
        pound = findViewById(R.id.pound);
        ounce = findViewById(R.id.ounce);
        carrat = findViewById(R.id.carrat);
        sp.setAdapter(new ArrayAdapter(weight.this, android.R.layout.simple_list_item_1, arr));
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cal();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        in.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    float num = Float.parseFloat(in.getText().toString());
                    cal();
                } catch (Exception e) {
                    gram.setText("-");
                    kilo.setText("-");
                    mili.setText("-");
                    ton.setText("-");
                    pound.setText("-");
                    ounce.setText("-");
                    carrat.setText("-");
                }
            }
        });
    }
    private void cal() {
        if (!in.getText().toString().equals("") && !sp.getSelectedItem().toString().equals("")) {
            float num = Float.parseFloat(in.getText().toString());
            switch (sp.getSelectedItem().toString()) {
                case "G":
                    allm(num);
                    break;
                case "KG":
                    allm(num * 1000);
                    break;
                case "MG":
                    allm(num * 0.001f);
                    break;
                case "TON":
                    allm(num * 1000000);
                    break;
                case "LB":
                    allm(num / 453.592f);
                    break;
                case "OZ":
                    allm(num / 28.3495f);
                    break;
                case "CT":
                    allm(num * 0.2f);

            }
        } else {
            gram.setText("-");
            kilo.setText("-");
            mili.setText("-");
            ton.setText("-");
            pound.setText("-");
            ounce.setText("-");
            carrat.setText("-");
        }
    }

    private void allm(float num) {
        gram.setText(String.valueOf(num));
        kilo.setText(String.valueOf(num * 0.001f));
        mili.setText(String.valueOf(num * 1000));
        ton.setText(String.valueOf(num * 0.000001f));
        pound.setText(String.valueOf(num * 0.0022046f));
        ounce.setText(String.valueOf(num * 0.0352739907f));
        carrat.setText(String.valueOf(num * 5));
    }
}