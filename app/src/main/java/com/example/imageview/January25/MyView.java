package com.example.imageview.January25;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class MyView extends View {

    Paint p1 = new Paint();
    Paint p2 = new Paint();
    Paint p3 = new Paint();

    MyView(Context context) {
        super(context);

        p1.setTextSize(50);
        p1.setColor(Color.BLUE);
        p1.setAntiAlias(true);
        p1.setStrokeWidth(8);
        p2.setColor(0x00990085);

        // 색상 16진수로 지정 투명도 red.green,blue

        p2.setARGB(100, 153, 0 ,133);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawRect(0,0,200,200,p1);
        canvas.drawRect(200,0,400,200,p2);
        canvas.drawRect(400,0,600,200,p3);
        canvas.drawCircle(100,300,100,p1);
        canvas.drawLine(0,0,200,200,p1);

        RectF rect = new RectF(200,600,600,1000);
        canvas.drawArc(rect,0,320,true,p1);

        canvas.drawARGB(100,150,50,50);

    }
}
