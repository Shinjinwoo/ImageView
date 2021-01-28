package com.example.imageview.January27;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.imageview.R;

public class RocketView extends View {

    private Context context;
    private GameThread mThread;

    private Bitmap imgBack;
    private int w, h;

    private Rocket rocket;
    private boolean isLaunch = false;

    public RocketView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w, h, oldw, oldh);

        //화면의 폭과 높이
        this.w = w;
        this.h = h;

        //배경 이미지
        imgBack = BitmapFactory.decodeResource(getResources(), R.drawable.sky);
        imgBack = Bitmap.createScaledBitmap(imgBack, w, h, true);

        //로켓
        rocket = new Rocket(context, w, h);

        // 스레드 기동
        if(mThread == null){
            mThread = new GameThread();
            mThread.start();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        mThread.canRun = false;
        super.onDetachedFromWindow();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(imgBack,0,0,null);

        canvas.rotate(rocket.ang,rocket.x,rocket.y);
        canvas.drawBitmap(rocket.rocket,rocket.x - rocket.w,rocket.y -rocket.h,null);
        canvas.rotate(-rocket.ang, rocket.x, rocket.y);
    }

    private  void moveRocket() {
        if(isLaunch) {
            isLaunch = rocket.update();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isLaunch && event.getAction() == MotionEvent.ACTION_DOWN) {
            rocket.launch(event.getX(), event.getY() );
            isLaunch = true;
        }

        return true;
    }


    class GameThread extends Thread {
        public boolean canRun = true;

        @Override
        public void run() {
            while (canRun) {
                try {
                    Time.update();

                    moveRocket();
                    postInvalidate();
                    sleep(10);

                } catch (Exception e) {

                }
            }
        }
    }





}
