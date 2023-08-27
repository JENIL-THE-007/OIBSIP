package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView r, s;
    Button add, lb, rb, sub, mul, div, eq, dot, back, c, one, two, three, four, five, six, seven, eight, nine, zero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = findViewById(R.id.r);s = findViewById(R.id.s);add = findViewById(R.id.add);lb = findViewById(R.id.lb);
        rb = findViewById(R.id.rb);sub = findViewById(R.id.sub);mul = findViewById(R.id.mul);div = findViewById(R.id.div);
        eq = findViewById(R.id.eq);dot = findViewById(R.id.dot);back = findViewById(R.id.back);c = findViewById(R.id.c);
        one = findViewById(R.id.one);two = findViewById(R.id.two);three = findViewById(R.id.three);four = findViewById(R.id.four);
        five = findViewById(R.id.five);six = findViewById(R.id.six);seven = findViewById(R.id.seven);eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);zero = findViewById(R.id.zero);
        r.setOnClickListener(this);s.setOnClickListener(this);add.setOnClickListener(this);lb.setOnClickListener(this);
        rb.setOnClickListener(this);sub.setOnClickListener(this);mul.setOnClickListener(this);div.setOnClickListener(this);
        eq.setOnClickListener(this);dot.setOnClickListener(this);back.setOnClickListener(this);c.setOnClickListener(this);
        one.setOnClickListener(this);two.setOnClickListener(this);three.setOnClickListener(this);four.setOnClickListener(this);
        five.setOnClickListener(this);six.setOnClickListener(this);seven.setOnClickListener(this);eight.setOnClickListener(this);
        nine.setOnClickListener(this);zero.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        String bt = b.getText().toString();
        String dtc = s.getText().toString();
        if (bt.equals("C")) {
            s.setText("");
            r.setText("0");
            return;
        }
        if (bt.equals("=")) {
            s.setText(r.getText());
            return;
        }
        if (bt.equals("B")) {
            if (dtc.length() == 1) s.setText("0");
            else dtc = dtc.substring(0, dtc.length() - 1);
        } else {
            dtc = dtc + bt;
        }
        s.setText(dtc);
        String alldone = done(dtc);
        if (!alldone.equals("error")) {
            r.setText(alldone);
        }
    }

    private String done(String d) {
        try {
            Context con = Context.enter();
            con.setOptimizationLevel(-1);
            Scriptable sc = con.initStandardObjects();
            String f = con.evaluateString(sc, d, "Javascript", 1, null).toString();
            if (f.endsWith(".0")) {
                f = f.replace(".0", "");
            }
            return f;
        } catch (Exception e) {
            return "error";
        }
    }
}