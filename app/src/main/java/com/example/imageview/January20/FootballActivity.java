package com.example.imageview.January20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.imageview.R;

public class FootballActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football);
    }

    public void myListener(View target) {
        Intent intent = new Intent(getApplicationContext(),
                Football2Activity.class);
        startActivity(intent);
    }

    public void myListener1(View target) {
        Intent intent = new Intent(getApplicationContext(),
                FootballSetupActivity.class);
        startActivity(intent);
    }

    public void myListener2(View target) {
        Intent intent = new Intent(getApplicationContext(),
                FootballStartActivity.class);
                startActivity(intent);
    }
}
