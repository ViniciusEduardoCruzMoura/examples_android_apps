package com.example.a1_avaliativo_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GasolineOrEthanol extends AppCompatActivity {

    private EditText inputGasolinePrice, inputEthanolPrice;
    private TextView resultGasolineOrEthanol;
    private Button buttonGasolineOrEthanol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasoline_or_ethanol);

        inputEthanolPrice = findViewById(R.id.inputEthanolPrice);
        inputGasolinePrice = findViewById(R.id.inputGasolinePrice);
        resultGasolineOrEthanol = findViewById(R.id.resultGasolineOrEthanol);
        buttonGasolineOrEthanol = findViewById(R.id.buttonGasolineOrEthanol);

        buttonGasolineOrEthanol.setOnClickListener(calcGasolineOrAlcool);

    }

    private boolean isValidInputValues() {
        if (inputGasolinePrice.getText().toString().isEmpty()) {
            inputGasolinePrice.setError("Is Empty");
        } else if (inputEthanolPrice.getText().toString().isEmpty()){
            inputEthanolPrice.setError("Is Empty");
        } else if (inputGasolinePrice.getText().toString().isEmpty() && inputEthanolPrice.getText().toString().isEmpty()) {
            inputGasolinePrice.setError("Is Empty");
            inputEthanolPrice.setError("Is Empty");
        } else {
            return true;
        }
        return false;
    }

    View.OnClickListener calcGasolineOrAlcool = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isValidInputValues()) {
                double gasolinePrice, alcoolPrice, result = 0;
                gasolinePrice = Double.parseDouble(inputGasolinePrice.getText().toString());
                alcoolPrice = Double.parseDouble(inputEthanolPrice.getText().toString());
                result = alcoolPrice / gasolinePrice;
                if (result < 0.7) {
                    resultGasolineOrEthanol.setText("Alcool Melhor");
                } else {
                    resultGasolineOrEthanol.setText("Gasolina Melhor");
                }
            }
        }
    };

}