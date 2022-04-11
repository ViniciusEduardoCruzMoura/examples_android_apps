package com.example.a1_avaliativo_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class BarBill extends AppCompatActivity {

    private EditText inputTotalValue, inputPeopleQuantity, inputTipPrice;
    private Button buttonCalcBill, buttonClearBarBill;
    private TextView tipResult, billTotalResult, valueEachPersonResult;
    private RadioGroup tipPercentageRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_bill);

        inputTotalValue = findViewById(R.id.inputTotalValue);
        inputPeopleQuantity = findViewById(R.id.inputPeopleQuantity);
        inputTipPrice = findViewById(R.id.inputTipPrice);

        buttonCalcBill = findViewById(R.id.buttonCalcBill);

        tipResult = findViewById(R.id.tipResult);
        billTotalResult = findViewById(R.id.billTotalResult);
        valueEachPersonResult = findViewById(R.id.valueEachPersonResult);

        buttonClearBarBill= findViewById(R.id.buttonClearBarBill);

        buttonCalcBill.setOnClickListener(calculateBill);

        tipPercentageRadioGroup = findViewById(R.id.tipPercentageRadioGroup);

        buttonClearBarBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearInputs();
                tipResult.setText("");
                billTotalResult.setText("");
                valueEachPersonResult.setText("");
            }
        });

        tipPercentageRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonPercentage15:
                        inputTipPrice.setText(String.valueOf(15));
                        break;
                    case R.id.radioButtonPercentage20:
                        inputTipPrice.setText(String.valueOf(20));
                        break;
                    case R.id.radioButtonPercentageAnother:
                        inputTipPrice.setText("");
                        break;
                }
            }
        });

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
        inputTotalValue.setText("");
        inputPeopleQuantity.setText("");
        inputTipPrice.setText("");
    }

    private void calcBillTotal() {
        double total = Double.parseDouble(inputTotalValue.getText().toString());
        double tip = Double.parseDouble(tipResult.getText().toString());
        try {
            billTotalResult.setText(String.format("%.2f", total + tip));
        } catch (Exception e) {}
    }

    private void calcTip() {
        double total = Double.parseDouble(inputTotalValue.getText().toString());;
        int tip = Integer.parseInt(inputTipPrice.getText().toString());
        if (tip <= 100 && tip >= 0) {
            tipResult.setText(String.format("%.2f", ((total * tip) / 100)));
        } else {
            inputTipPrice.setError("0% a 100%");
        }

    }

    private void calcValueEachPerson() {
        double total = Double.parseDouble(billTotalResult.getText().toString());
        int peopleQuantity = Integer.parseInt(inputPeopleQuantity.getText().toString());
        try {
            valueEachPersonResult.setText(String.format("%.2f", total / peopleQuantity));
        } catch (Exception e) {}
    }

    View.OnClickListener calculateBill = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!isInputEmpty(inputTotalValue)
                    && !isInputEmpty(inputPeopleQuantity)
                    && !isInputEmpty(inputTipPrice)) {
                calcTip();
                calcBillTotal();
                calcValueEachPerson();
                //clearInputs();
            }
        }
    };

}