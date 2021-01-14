package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class TempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
    }

    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.btnChange:
                RadioButton celsiusButton = (RadioButton) findViewById(R.id.celsius);
                RadioButton fahrenheitButton =
                        (RadioButton) findViewById(R.id.fahrenheit);

                EditText text = (EditText) findViewById(R.id.editText1);

                if (text.getText().length() == 0) {
                    Toast.makeText(this, "정확한 값을 입력하시오.",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(text.getText().toString());
                if (celsiusButton.isChecked()) {
                    text.setText(String.valueOf(convertFahrenheitToCelsius(inputValue)));
                    celsiusButton.setChecked(false);
                    fahrenheitButton.setChecked(true);
                } else {
                    text.setText(String.valueOf(convertCelsiusToFahrenheit(inputValue)));
                    celsiusButton.setChecked(true);
                }
                break;
        }
    }

    private float convertFahrenheitToCelsius(float fahrenheit) {
        return ((fahrenheit - 32) * 5 / 9);
    }

    private float convertCelsiusToFahrenheit(float celsius) {
        return ((celsius * 9) / 5) + 32;
    }

}

