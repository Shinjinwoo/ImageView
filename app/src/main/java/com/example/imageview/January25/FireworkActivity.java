package com.example.imageview.January25;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

import com.example.imageview.R;

public class FireworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firework);

        ImageView sea = findViewById(R.id.sea);
        ImageView ball = findViewById(R.id.ball);
        ImageView fire = findViewById(R.id.fire);

        // 화면 크기 측정
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        // 바다 이미지 크기 측정
        sea.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);

        int sea_height = sea.getMeasuredHeight();   // 바다 이미지 세로 크기
        int sea_y_pos = height - sea_height;        // 바다 이미지 y 위치

        // 바다 위치
        ObjectAnimator sea_y = ObjectAnimator.ofFloat(sea, "translationY", sea_y_pos, sea_y_pos);
        sea_y.setDuration(2000);
        sea_y.setRepeatCount(ObjectAnimator.INFINITE);  // 무한 반복

        // 투명도
        ObjectAnimator sea_alpha = ObjectAnimator.ofFloat(sea, "alpha", 0.2f, 1.0f);
        sea_alpha.setDuration(2000);
        sea_alpha.setRepeatCount(ObjectAnimator.INFINITE);  // 무한 반복
// 불꽃 탄환 위치
        ObjectAnimator ball_x = ObjectAnimator.ofFloat(ball, "translationX", 50.0f, 450.0f);    // x축
        ObjectAnimator ball_y = ObjectAnimator.ofFloat(ball, "translationY", height, 450.0f);   // y축
        ball_x.setDuration(2000);
        ball_x.setRepeatCount(ObjectAnimator.INFINITE); // 무한 반복
        ball_y.setDuration(2000);
        ball_y.setRepeatCount(ObjectAnimator.INFINITE); // 무한 반복

        // 불꽃 탄환 크기
        ObjectAnimator ball_scaleX = ObjectAnimator.ofFloat(ball, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ball_scaleY = ObjectAnimator.ofFloat(ball, "scaleY", 1.0f, 0.0f);
        ball_scaleX.setDuration(2000);
        ball_scaleX.setRepeatCount(ObjectAnimator.INFINITE); // 무한 반복
        ball_scaleY.setDuration(2000);
        ball_scaleY.setRepeatCount(ObjectAnimator.INFINITE); // 무한 반복

        // 불꽃 위치
        ObjectAnimator fire_x = ObjectAnimator.ofFloat(fire, "translationX", 100.0f, 100.0f);
        ObjectAnimator fire_y = ObjectAnimator.ofFloat(fire, "translationY", 20.0f, 20.0f);
        fire_x.setDuration(2000);
        fire_x.setRepeatCount(ObjectAnimator.INFINITE); // 무한 반복
        fire_y.setDuration(2000);
        fire_y.setRepeatCount(ObjectAnimator.INFINITE); // 무한 반복

        // 불꽃 크기
        ObjectAnimator fire_scale = ObjectAnimator.ofPropertyValuesHolder(fire,
                PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f),
                PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f));
        fire_scale.setDuration(2000);
        fire_scale.setRepeatCount(ObjectAnimator.INFINITE);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(sea_y, sea_alpha, ball_x, ball_y, ball_scaleX, ball_scaleY, fire_x, fire_y, fire_scale);
        set.start();
    }
}