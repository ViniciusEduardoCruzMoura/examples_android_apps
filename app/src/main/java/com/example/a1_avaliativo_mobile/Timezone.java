package com.example.a1_avaliativo_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Timezone extends AppCompatActivity {

    private EditText inputHour, inputMinute, inputDestinationTimezone;
    private RadioGroup timezoneRadioGroup;
    private Button buttonCalcDestinationTime, buttonClearTimezone;
    private TextView destinationTimeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timezone);

        inputHour = findViewById(R.id.inputHour);
        inputMinute = findViewById(R.id.inputMinute);
        inputDestinationTimezone = findViewById(R.id.inputDestinationTimezone);
        timezoneRadioGroup = findViewById(R.id.timezoneRadioGroup);
        buttonCalcDestinationTime = findViewById(R.id.buttonCalcDestinationTime);
        destinationTimeResult = findViewById(R.id.destinationTimeResult);
        buttonClearTimezone = findViewById(R.id.buttonClearTimezone);

        buttonCalcDestinationTime.setOnClickListener(calcTimezone);

        buttonClearTimezone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearInputs();
                destinationTimeResult.setText("");
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

    private int getLocalTimezone() {
        switch (timezoneRadioGroup.getCheckedRadioButtonId()) {
            case R.id.radioButton:
                return -2;
            case R.id.radioButton2:
                return -3;
            case R.id.radioButton3:
                return -4;
            case R.id.radioButton4:
                return -5;
        }
        return 0;
    }

    private void clearInputs() {
        inputHour.setText("");
        inputMinute.setText("");
        inputDestinationTimezone.setText("");
    }

    private boolean isValidTime(EditText inputHour, EditText inputMinute) {
        int hour = Integer.parseInt(inputHour.getText().toString());
        int minute = Integer.parseInt(inputMinute.getText().toString());
        if (hour > 24 || hour < 0) {
            inputHour.setError("0 a 24");
        }
        if (minute < 0 || minute > 60) {
            inputMinute.setError("0 a 60");
        } else {
            return true;
        }
        return false;
    }

    private boolean isValidDestinationTimezone(EditText inputDestinationTimezone) {
        int destinationTimezone = Integer.parseInt(inputDestinationTimezone.getText().toString());
        if (destinationTimezone > 12 || destinationTimezone < -12) {
            inputDestinationTimezone.setError("-12 a 12");
        } else {
            return true;
        }
        return false;
    }

    View.OnClickListener calcTimezone = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!isInputEmpty(inputHour)
                    && !isInputEmpty(inputMinute)
                    && isValidTime(inputHour, inputMinute)
                    && !isInputEmpty(inputDestinationTimezone) && isValidDestinationTimezone(inputDestinationTimezone)) {
                int hour = Integer.parseInt(inputHour.getText().toString());
                int minute = Integer.parseInt(inputMinute.getText().toString());
                int destinationTimezone = Integer.parseInt(inputDestinationTimezone.getText().toString());
                int localTimezone = getLocalTimezone();
                if ((Math.abs((destinationTimezone - (localTimezone))) + hour) > 24) {
                    destinationTimeResult.setText((Math.abs((destinationTimezone - (localTimezone))) + hour) - 24 + ":" + minute);
                } else {
                    destinationTimeResult.setText(Math.abs((destinationTimezone - (localTimezone))) + hour + ":" + minute);
                }
                //clearInputs();
            }
        }
    };

}