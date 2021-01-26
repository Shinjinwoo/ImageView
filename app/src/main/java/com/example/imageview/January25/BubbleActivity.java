package com.example.imageview.January25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.example.imageview.R;

import java.util.ArrayList;
import java.util.Random;

public class BubbleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView3(this));
    }

    class MyBubble{
        public int x, y, rad;   // x좌표, y좌표, 반지름
        public Bitmap imgBubble;    // 비눗방울 이미지
        public boolean dead = false;    // 비눗방울 터짐 허용

        private int count = 0;  // 벽 충돌 횟수
        private int sx, sy; // 이동방향, 속도
        private int width, height;  // View의 크기

        // 생성자
        MyBubble(int _x, int _y, int _width, int _height){
            // 생성된 비눗방울 상태 초기화
            x = _x;
            y = _y;
            width = _width;
            height = _height;

            Random random = new Random();
            rad = random.nextInt(31) + 10;  // 비눗방울 크기 (반지름 : 10~40)
            int k = random.nextInt(2) == 0 ? -1 : 1;    // -1, +1
            sx = (random.nextInt(4) + 2 * k);   // 비눗방울 속도 (+-2~5)
            sy = (random.nextInt(4) + 2 * k);   // 비눗방울 속도 (+-2~5)

            // 비트맵 이미지 크기 설정
            imgBubble = BitmapFactory.decodeResource(getResources(), R.drawable.bubble);
            imgBubble = Bitmap.createScaledBitmap(imgBubble, rad * 2, rad * 2, false);
        }
        // 비눗방울 이동
        private void moveBubble(){
            x += sx;
            y += sy;    // 비눗방울 이동

            // 벽 충돌 처리
            if(x <= rad || x >= width - rad) {
                sx = -sx;
                count++;
            }
            if(y <= rad || y >= height - rad){
                sy = -sy;
                count++;
            }

            // 벽 충돌 3번 이상된 비눗방울은
            // 다음 충돌시 터짐
            if(count >= 3) dead = true;
        }
    }
    // 비눗방울 생성 클래스
    class MyView3 extends View {
        int width, height;
        Bitmap imgBack;
        ArrayList<MyBubble> myBubbles;

        public MyView3(Context context){
            super(context);

            Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

            // SDK 13 버전 이상
            if(Build.VERSION.SDK_INT > 12){
                Point size = new Point();
                display.getSize(size);
                width = size.x;
                height = size.y;
            }

            // SDK 12 버전 이하
            else{
                width = display.getWidth();     // View의 너비
                height = display.getHeight();   // View의 높이
            }

            imgBack = BitmapFactory.decodeResource(context.getResources(), R.drawable.back);
            imgBack = Bitmap.createScaledBitmap(imgBack, width, height, false);

            myBubbles = new ArrayList<MyBubble>();
            handler.sendEmptyMessageDelayed(0, 10); // Handler 호출
        }
        private void moveBubble(){
            for(int i = myBubbles.size() - 1; i >= 0; i--){
                myBubbles.get(i).moveBubble();
                if(myBubbles.get(i).dead == true)
                    myBubbles.remove(i);
            }
        }

        private void checkBubble(int x, int y){
            boolean flag = false;
            for(MyBubble tmp : myBubbles){
                if(Math.pow(tmp.x - x, 2) + Math.pow(tmp.y - y, 2) <= Math.pow(tmp.rad, 2)){
                    tmp.dead = true;
                    flag = true;
                }
            }
            if(flag == false)
                myBubbles.add(new MyBubble(x, y, width, height));
        }

        public void onDraw(Canvas canvas){
            moveBubble();
            canvas.drawBitmap(imgBack, 0, 0, null);
            for(MyBubble tmp : myBubbles){
                canvas.drawBitmap(tmp.imgBubble, tmp.x - tmp.rad, tmp.y - tmp.rad, null);
            }
        }
        Handler handler = new Handler(){
            public void handleMessage(Message msg){
                invalidate();
                handler.sendEmptyMessageDelayed(0, 10);
            }
        };

        @Override
        public boolean onTouchEvent(MotionEvent event){
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                int x = (int) event.getX();
                int y = (int) event.getY();
                checkBubble(x, y);  // 비눗방울 상태 조사
            }
            return true;
        }
    }
}