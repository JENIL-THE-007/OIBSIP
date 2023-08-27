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

public class length extends AppCompatActivity {

    private EditText in;
    private Spinner sp;
    private TextView meter, kilo, centi, mili, micro, nano, mile, foot, inch;
    private String[] arr = {"M", "KM", "CM", "MM", "Micro", "NM", "MI", "FT", "IN"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        in = findViewById(R.id.in1);
        sp = findViewById(R.id.sp1);
        meter = findViewById(R.id.meter);
        kilo = findViewById(R.id.kilo);
        centi = findViewById(R.id.centi);
        mili = findViewById(R.id.mili);
        micro = findViewById(R.id.micro);
        nano = findViewById(R.id.nano);
        mile = findViewById(R.id.mile);
        foot = findViewById(R.id.foot);
        inch = findViewById(R.id.inch);
        sp.setAdapter(new ArrayAdapter(length.this, android.R.layout.simple_list_item_1, arr));
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
                    meter.setText("-");
                    kilo.setText("-");
                    centi.setText("-");
                    mili.setText("-");
                    micro.setText("-");
                    nano.setText("-");
                    mile.setText("-");
                    foot.setText("-");
                    inch.setText("-");
                }
            }
        });
    }

    private void cal() {
        if (!in.getText().toString().equals("") && !sp.getSelectedItem().toString().equals("")) {
            float num = Float.parseFloat(in.getText().toString());
            switch (sp.getSelectedItem().toString()) {
                case "M":
                    allm(num);
                    break;
                case "KM":
                    allm(num * 1000);
                    break;
                case "CM":
                    allm(num / 100);
                    break;
                case "MM":
                    allm(num / 100000);
                    break;
                case "Micro":
                    allm(num / 1000000);
                    break;
                case "NM":
                    allm(num / 1000000000);
                    break;
                case "MI":
                    allm(num * 1609.35f);
                    break;
                case "FT":
                    allm(num * 0.3048f);
                    break;
                case "IN":
                    allm(num * 0.0254f);
            }
        } else {
            meter.setText("-");
            kilo.setText("-");
            centi.setText("-");
            mili.setText("-");
            micro.setText("-");
            nano.setText("-");
            mile.setText("-");
            foot.setText("-");
            inch.setText("-");
        }
    }

    private void allm(float num) {
        meter.setText(String.valueOf(num));
        kilo.setText(String.valueOf(num / 1000));
        centi.setText(String.valueOf(num * 100));
        mili.setText(String.valueOf(num * 1000));
        micro.setText(String.valueOf(num * 1000000));
        nano.setText(String.valueOf(num * 1000000000));
        mile.setText(String.valueOf(num / 1609));
        foot.setText(String.valueOf(num * 3.28083f));
        inch.setText(String.valueOf(num * 39.37007f));
    }
}