package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CurveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SingleTouchView(this,null));
    }
}
