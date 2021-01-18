package com.example.imageview.January15;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.imageview.R;

import java.util.Calendar;

public class DatePickerDialogActivity extends AppCompatActivity  {
    Button btnSelectDate, btnSelectTime;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSelectDate=(Button)findViewById(R.id.ADPbutton1);
        btnSelectTime=(Button)findViewById(R.id.ADPbutton2);
    }
    public void onClick(View v) {
        if (v == btnSelectDate) {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            btnSelectDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnSelectTime) {
            final Calendar c = Calendar.getInstance();
            int mHour = c.get(Calendar.HOUR_OF_DAY);
            int mMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            btnSelectTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
}

