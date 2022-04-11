package com.example.a1_avaliativo_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TemperatureConversion extends AppCompatActivity {

    private EditText inputCelsius, inputKelvin, inputFahrenheit;
    private TextView conversionResult;
    private Button buttonConvertCelsiusToFahrenheit, buttonConvertFahrenheitToCelsius,
            buttonConvertCelsiusToKelvin, buttonConvertKelvinToCelsius,
            buttonConvertFahrenheitToKelvin, buttonConvertKelvinToFahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_conversion);

        inputCelsius = findViewById(R.id.inputCelsius);
        inputKelvin = findViewById(R.id.inputKelvin);
        inputFahrenheit = findViewById(R.id.inputFahrenheit);

        conversionResult = findViewById(R.id.conversionResult);

        buttonConvertCelsiusToFahrenheit = findViewById(R.id.buttonConvertCelsiusToFahrenheit);
        buttonConvertFahrenheitToCelsius = findViewById(R.id.buttonConvertFahrenheitToCelsius);
        buttonConvertCelsiusToKelvin = findViewById(R.id.buttonConvertCelsiusToKelvin);
        buttonConvertKelvinToCelsius = findViewById(R.id.buttonConvertKelvinToCelsius);
        buttonConvertFahrenheitToKelvin = findViewById(R.id.buttonConvertFahrenheitToKelvin);
        buttonConvertKelvinToFahrenheit = findViewById(R.id.buttonConvertKelvinToFahrenheit);

        buttonConvertCelsiusToFahrenheit.setOnClickListener(convertTemperature);
        buttonConvertFahrenheitToCelsius.setOnClickListener(convertTemperature);
        buttonConvertCelsiusToKelvin.setOnClickListener(convertTemperature);
        buttonConvertKelvinToCelsius.setOnClickListener(convertTemperature);
        buttonConvertFahrenheitToKelvin.setOnClickListener(convertTemperature);
        buttonConvertKelvinToFahrenheit.setOnClickListener(convertTemperature);

    }

    private boolean isInputEmpty(EditText input) {
        if (input.getText().toString().isEmpty()) {
            input.setError("Empty Field");
        } else {
            return false;
        }
        return true;
    }

    private void clearInputs() {
        inputCelsius.setText("");
        inputKelvin.setText("");
        inputFahrenheit.setText("");
    }

    private void convertCelsiusToFahrenheit() {
        if (!isInputEmpty(inputCelsius)) {
            double celsius = Double.parseDouble(inputCelsius.getText().toString());
            conversionResult.setText(String.format("%.2f", celsius * 1.8 + 32));
        }
    }

    private void convertFahrenheitToCelsius() {
        if (!isInputEmpty(inputFahrenheit)) {
            double fahrenheit = Double.parseDouble(inputFahrenheit.getText().toString());
            conversionResult.setText(String.format("%.2f", (fahrenheit - 32) / 1.8));
        }
    }

    private void convertCelsiusToKelvin() {
        if (!isInputEmpty(inputCelsius)) {
            double celsius = Double.parseDouble(inputCelsius.getText().toString());
            conversionResult.setText(String.format("%.2f", celsius + 273.15));
        }
    }

    private void convertKelvinToCelsius() {
        if (!isInputEmpty(inputKelvin)) {
            double kelvin = Double.parseDouble(inputKelvin.getText().toString());
            conversionResult.setText(String.format("%.2f", kelvin - 273.15));
        }
    }

    private void convertFahrenheitToKelvin() {
        if (!isInputEmpty(inputFahrenheit)) {
            double fahrenheit = Double.parseDouble(inputFahrenheit.getText().toString());
            conversionResult.setText(String.format("%.2f", (fahrenheit + 459.67) / 1.8));
        }
    }

    private void convertKelvinToFahrenheit() {
        if (!isInputEmpty(inputKelvin)) {
            double kelvin = Double.parseDouble(inputKelvin.getText().toString());
            conversionResult.setText(String.format("%.2f", kelvin * 1.8 - 459.67));
        }
    }

    private void selectConversionButtonAction(View v) {
        switch (v.getId()) {
            case R.id.buttonConvertCelsiusToFahrenheit:
                convertCelsiusToFahrenheit();
                break;
            case R.id.buttonConvertFahrenheitToCelsius:
                convertFahrenheitToCelsius();
                break;
            case R.id.buttonConvertCelsiusToKelvin:
                convertCelsiusToKelvin();
                break;
            case R.id.buttonConvertKelvinToCelsius:
                convertKelvinToCelsius();
                break;
            case R.id.buttonConvertFahrenheitToKelvin:
                convertFahrenheitToKelvin();
                break;
            case R.id.buttonConvertKelvinToFahrenheit:
                convertKelvinToFahrenheit();
                break;
        }
    }

    View.OnClickListener convertTemperature = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectConversionButtonAction(view);
            clearInputs();
        }
    };

}