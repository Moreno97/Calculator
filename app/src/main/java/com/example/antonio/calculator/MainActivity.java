package com.example.antonio.calculator;

import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvOperacion, tvResultado;
    Button b1;
    Double num1, num2, resultado;
    String operador;
    DecimalFormat decimalFormat = new DecimalFormat();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOperacion = (TextView) findViewById(R.id.textView);
        tvResultado = (TextView) findViewById(R.id.textView2);
        tvOperacion.setText("");
    }

    public void onClick(View view) {
        tvOperacion.setText(tvOperacion.getText() + view.getTag().toString());
    }

    public void onClear(View view) {
        tvOperacion.setText("");
        tvResultado.setText("");
        resultado = 0.0;
        num1 = 0.0;
        num2 = 0.0;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
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
            tvResultado.setText(decimalFormat.format(resultado));
        } catch (NullPointerException npe) {
            Toast.makeText(this, "No results", Toast.LENGTH_SHORT).show();
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
        try {
            num1 = Double.parseDouble(tvOperacion.getText().toString());
            tvOperacion.setText("");
        } catch (Exception e) {
            e.getMessage();
        }

    }

}
