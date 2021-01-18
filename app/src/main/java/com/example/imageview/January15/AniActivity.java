package com.example.imageview.January15;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.example.imageview.R;

public class AniActivity extends AppCompatActivity {
    AnimationDrawable rocketAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani);

        ImageView rocketImage = (ImageView) findViewById(R.id.rocket_image);
        rocketImage.setBackgroundResource(R.drawable.roket);
        rocketAnimation = (AnimationDrawable) rocketImage.getBackground();
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            rocketAnimation.start();

            return true;
        }
        return super.onTouchEvent(event);
    }
}

