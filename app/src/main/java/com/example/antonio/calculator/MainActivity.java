package com.example.antonio.calculator;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvOperacion, tvResultado;
    Double num1, num2, resultado;
    String operador;
    DecimalFormat decimalFormat = new DecimalFormat();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent about = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(about);
            return true;
        }

        return super.onOptionsItemSelected(item);
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
        tvOperacion.append(view.getTag().toString());
    }

    public void appendCharacter(View view) {
        tvOperacion.append(view.getTag().toString());
    }

    public void onClear(View view) {
        tvOperacion.setText("");
        tvResultado.setText("");
        clearNumbers();
    }

    public void clearNumbers() {
        resultado = 0.0;
        num1 = 0.0;
        num2 = 0.0;
    }

    public void onDelete(View view) {
        if (tvOperacion.getText().length() != 0) {
            tvOperacion.setText(tvOperacion.getText().toString().substring(0, tvOperacion.getText().length() - 1));
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
            tvOperacion.startAnimation(animation);
        }
    }

    public void onClickPercentage(View view) {
        onClickOperacionCapturaNumero1(view);
        resultado = num1 / 100;
        tvResultado.setText(resultado + "");
        animationZoom(view);
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
            animationZoom(view);
            clearNumbers();

        } catch (NullPointerException npe) {
            Toast.makeText(this, "No results", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public void onClickLogarithms(View view) {
        onClickOperacionCapturaNumero1(view);
        switch (view.getTag().toString()) {
            case "tan":
                double toRadians = Math.toRadians(num1);
                resultado = Math.tan(toRadians);
                tvResultado.setText(resultado + "");
                break;
            case "sin":
                toRadians = Math.toRadians(num1);
                resultado = Math.sin(toRadians);
                tvResultado.setText(resultado + "");
                break;
            case "cos":
                toRadians = Math.toRadians(num1);
                resultado = Math.cos(toRadians);
                tvResultado.setText(resultado + "");
                break;
        }

        animationZoom(view);
    }

    public void animationZoom(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        tvResultado.startAnimation(animation);
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

    public void onClickExponent(View view) {
        onClickOperacionCapturaNumero1(view);
        resultado = Math.pow(num1, 2);
        tvResultado.setText(decimalFormat.format(resultado));
        animationZoom(view);
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
