package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MultiTouchView(this,null));
    }
}
