package com.example.antonio.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvResult;
    Button b1;
    int result = 0; // Guardamos el resultado de las operaciones realizadas.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = (TextView) findViewById(R.id.textView);
        tvResult.setText("");
    }

    public void onClick(View view) {
        tvResult.setText(tvResult.getText() + view.getTag().toString());
    }

    public void onClear(View view) {
        tvResult.setText("");
        result = 0;
    }

    public void onSum() {
        try {
            if (tvResult.getText() != "") {
                result = result + Integer.parseInt((String) tvResult.getText());
                System.out.println(result);
                tvResult.setText("");
            } else {
                Toast.makeText(this, "En blanco", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            e.getMessage();
        }

    }

}
