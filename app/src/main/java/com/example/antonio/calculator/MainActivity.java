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
    String [] botones = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."};
    int result = 0; // Guardamos el resultado de las operaciones realizadas.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = (TextView) findViewById(R.id.textView);
        tvResult.setText("");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button0:
                tvResult.setText(tvResult.getText() + botones[0]);
                break;
            case R.id.button1:
                tvResult.setText(tvResult.getText() + botones[1]);
                break;
            case R.id.button2:
                tvResult.setText(tvResult.getText() + botones[2]);
                break;
            case R.id.button3:
                tvResult.setText(tvResult.getText() + botones[3]);
                break;
            case R.id.button4:
                tvResult.setText(tvResult.getText() + botones[4]);
                break;
            case R.id.button5:
                tvResult.setText(tvResult.getText() + botones[5]);
                break;
            case R.id.button6:
                tvResult.setText(tvResult.getText() + botones[6]);
                break;
            case R.id.button7:
                tvResult.setText(tvResult.getText() + botones[7]);
                break;
            case R.id.button8:
                tvResult.setText(tvResult.getText() + botones[8]);
                break;
            case R.id.button9:
                tvResult.setText(tvResult.getText() + botones[9]);
                break;
            case R.id.buttonComa:
                tvResult.setText(tvResult.getText() + botones[10]);
                break;
            /*case R.id.buttonDivide:
                //
                break;*/
            case R.id.buttonClear:
                tvResult.setText("");
                result = 0;
                break;
            //case R.id.buttonMultiply:
                //
               // break;
            case R.id.buttonRest:
                //
                break;
            case R.id.buttonSum:
                onSum();
                break;
            case R.id.buttonResultado:
                tvResult.setText("" + result);
                Toast.makeText(this, "El resultado de la operación es " + result, Toast.LENGTH_LONG).show();
                break;
        }
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
