package com.example.a1_avaliativo_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SplitBill extends AppCompatActivity {

    private EditText inputPerson1, inputPerson2, inputPerson3;
    private TextView percentageResult, redistributionResult;
    private Button buttonCalcSplitBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_bill);

        inputPerson1 = findViewById(R.id.inputPerson1);
        inputPerson2 = findViewById(R.id.inputPerson2);
        inputPerson3 = findViewById(R.id.inputPerson3);
        buttonCalcSplitBill = findViewById(R.id.buttonCalcSplitBill);
        percentageResult = findViewById(R.id.percentageResult);
        redistributionResult = findViewById(R.id.redistributionResult);

        buttonCalcSplitBill.setOnClickListener(calcSplitBill);

    }

    private void clearInputs() {
        inputPerson1.setText("");
        inputPerson2.setText("");
        inputPerson3.setText("");
    }

    private boolean isInputEmpty(EditText input) {
        if (input.getText().toString().isEmpty()) {
            input.setError("Empty Field");
        } else {
            return false;
        }
        return true;
    }

    View.OnClickListener calcSplitBill = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!isInputEmpty(inputPerson1)
                    && !isInputEmpty(inputPerson2)
                    && !isInputEmpty(inputPerson3)) {
                double person1Value, person2Value, person3Value, billTotal, person1Percentage, person2Percentage, person3Percentage;

                person1Value = Double.parseDouble(inputPerson1.getText().toString());
                person2Value = Double.parseDouble(inputPerson2.getText().toString());
                person3Value = Double.parseDouble(inputPerson3.getText().toString());

                billTotal = person1Value + person2Value + person3Value;

                person1Percentage = (person1Value * 100) / billTotal;
                person2Percentage = (person2Value * 100) / billTotal;
                person3Percentage = (person3Value * 100) / billTotal;

                percentageResult.setText("Total gasto: " + String.format("%.2f", billTotal) + "\n" +
                        "Pessoa 1: " + String.format("%.2f", person1Percentage) + "%" + "\n" +
                        "Pessoa 2: " + String.format("%.2f", person2Percentage) + "%" + "\n" +
                        "Pessoa 3: " + String.format("%.2f", person3Percentage) + "%" + "\n");
                redistributionResult.setText("");

                clearInputs();
            }
        }
    };

}