package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class TouchActivity extends AppCompatActivity {
    protected class MyView extends View {
        int x = 100, y = 100;
        String str;
        public MyView(Context context){
            super(context);
            setBackgroundColor(Color.YELLOW);
        }

        @Override
        protected void onDraw(Canvas canvas){
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            canvas.drawCircle(x, y, 50, paint);
            paint.setTextSize(50);
            canvas.drawText("ACTION : " + str, x-250, y+150, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event){
            x = (int) event.getX();
            y = (int) event.getY();

            // 누르는 동작이 시작됨
            if(event.getAction() == MotionEvent.ACTION_DOWN)
                str = "ACTION_DOWN";

            // 누르는 도중에 움직임
            if(event.getAction() == MotionEvent.ACTION_MOVE)
                str = "ACTION_MOVE";

            // 누르고 있다가 뗄때 발생함
            if(event.getAction() == MotionEvent.ACTION_UP)
                str = "ACTION_UP";

            invalidate();
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        MyView w = new MyView(this);
        setContentView(w);
    }
}
