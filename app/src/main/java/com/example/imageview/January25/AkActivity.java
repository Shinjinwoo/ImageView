package com.example.imageview.January25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.imageview.R;

public class AkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView myView = new MyView(this);
        setContentView(myView);
    }
}
