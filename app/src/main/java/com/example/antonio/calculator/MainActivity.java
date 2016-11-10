package com.example.antonio.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvOperacion;
    Button b1;
    Double num1, num2, resultado;
    String operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOperacion = (TextView) findViewById(R.id.textView);
        tvOperacion.setText("");
    }

    public void onClick(View view) {
        tvOperacion.setText(tvOperacion.getText() + view.getTag().toString());
    }

    public void onClear(View view) {
        tvOperacion.setText("");
        resultado = 0.0;
        num1 = 0.0;
        num2 = 0.0;
    }

    public void onResult(View view) {
        try {
            num2 = Double.parseDouble(tvOperacion.getText().toString());
            switch (operador) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    resultado = num1 / num2;
                    break;
            }
            tvOperacion.setText(resultado.toString());
        } catch (NullPointerException npe) {
            Toast.makeText(this, "No results", Toast.LENGTH_SHORT).show();
            tvOperacion.setText("0");
        } catch (Exception e) {
            e.getMessage();
        }


    }


    public void onClickSuma(View view) {
        operador = "+";
        onClickOperacionCapturaNumero1(view);
    }

    public void onClickResta(View view) {
        operador = "-";
        onClickOperacionCapturaNumero1(view);
    }

    public void onClickMultiplicacion(View view) {
        operador = "*";
        onClickOperacionCapturaNumero1(view);
    }

    public void onClickDivision(View view) {
        operador = "/";
        onClickOperacionCapturaNumero1(view);
    }

    public void onClickOperacionCapturaNumero1(View miView) {
        num1 = Double.parseDouble(tvOperacion.getText().toString());
        tvOperacion.setText("");
    }

}
