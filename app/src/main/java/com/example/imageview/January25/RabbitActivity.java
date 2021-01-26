package com.example.imageview.January25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.imageview.R;

public class RabbitActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //전체 화면 모드
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                , WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //사용자 VIEW 모드
        setContentView(new MyView(this));
    }

    class MyView extends View{
        int width, height; // VIEW의 폭과 높이
        int x, y; //캐릭터의 현재 좌표
        int sx, sy;  //캐릭터가 이동할 방향과 거리
        int rw, rh; // 캐릭터의 중심점

        int counter = 0; // 루프 카운터
        int n; //애니메이션 번호
        Bitmap rabbits[] = new Bitmap[2];

        //생성자
        public MyView(Context context){
            super(context);
            Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            width = display.getWidth(); // View의 가로 폭
            height = display.getHeight(); // View의 세로 높이

            int counter = 0;
            rabbits[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.rabbit_1);
            rabbits[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.rabbit_2);
            rw = rabbits[0].getWidth() / 2 ; // 캐릭터의 중심점
            rh = rabbits[1].getHeight() / 2;

            x = 100; // 캐릭터의 초기 좌표
            y = 100;
            sx = 3; // 캐릭터가 1회 이동할 거리 이므로 즉 토끼의 이동속도가 된다.
            sy = 3;

            mHandler.sendEmptyMessageDelayed(0, 10); // Handler 호출

        }
        public void onDraw(Canvas canvas){
            x += sx;    // x축 이동
            y += sy;    // y축 이동
            counter++;
            n = counter % 20/ 10;

            // 벽 충돌 처리
            if(x < rw){
                x = rw;
                sx = -sx;
            }
            if(x > width - rw){
                x = width - rw;
                sx = -sx;
            }
            if(y < rh){
                y = rh;
                sy = -sy;
            }
            if(y > height - rh){
                y = height - rh;
                sy = -sy;
            }
            canvas.drawBitmap(rabbits[n], x - rw, y - rh, null);
        }

        //Timer Handler
        Handler mHandler = new Handler(){
            public void handleMessage(Message meg){
                invalidate(); // View를 다시 그림
                mHandler.sendEmptyMessageDelayed(0, 10);

            }
        };

        //on TouchEvent
        @Override
        public boolean onTouchEvent(MotionEvent event){
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                x = (int) event.getX();
                y = (int) event.getY();
            }
            return true;
        }
        //onTouchEvent;

    }

}