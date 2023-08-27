package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button le,we;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        le=findViewById(R.id.le);
        we=findViewById(R.id.we);
        le.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lenght=new Intent(MainActivity.this, length.class);
                startActivity(lenght);
            }
        });
        we.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent weight=new Intent(MainActivity.this, weight.class);
                startActivity(weight);
            }
        });
    }
}