package com.example.imageview.January27;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;

import java.util.Random;

public class Sparrow {


    // 화면 크기, 터치 영역
    private int scrW, scrH;
    private RectF rect = new RectF();

    // 이동 속도, 이동 방향
    private int speed;
    private PointF dir = new PointF();


    //프레임의 지연시간, 경과시간, 이미지 번호
    private float animTime;
    private float animSpan = 0;
    private int animNum = 0;

    // 참새 위치, 크기
    public float x, y;
    public int w, h;

    // 현재 이미지, 추락시 참새 회전, 사망
    public Bitmap bird;
    public int ang = 0;
    public boolean isDead;

    // 생성자 : Context와 화면의 크기

    public Sparrow(int width, int height) {
        scrW = width;
        scrH = height;

        //참새 만들기, 초기화
        bird = CommonResources.arBirds[0];
        w = CommonResources.bw;
        h = CommonResources.bh;

        intSparrow();
    }

    // Class  초기화
    private void intSparrow() {
        Random rnd = new Random();

        //이동 속도
        speed = rnd.nextInt(101) + 700;

        //프레임당 지연시간
        animTime = 0.85f - speed / 1000f;

        //이동 방향과 속도
        dir.x = speed;
        dir.y = 0;

        // 참새의 초기 위치
        x = -w * 2;
        y = rnd.nextInt(scrH - 500) + 100;

    }

    public void update() {
        x += dir.x * Time.deltaTime;
        y += dir.y * Time.deltaTime;

        animationBird();

        // 화면을 벗어 났는가 ?
        if (x > scrW + w || y > scrH + h) {
            isDead = true;
        }
    }

    //참새 애니메이션

    private void animationBird() {
        //애니메이션 후 경과 시간
        animSpan += Time.deltaTime;
        //추락 중이면 애니메이션 없음
        if (dir.y > 0 || animSpan < animTime) return;

        animSpan = 0;
        animNum++;

        if (animNum >= 5) {
            animNum = 0;
        }

        bird = CommonResources.arBirds[animNum];

    }

    public boolean hitTest(float px, float py) {

        //추락중이면 득점 없음
        if (dir.y > 0) return false;

        //참새 위치에 참새 크기의 Rect 만들기
        rect.set(x - w, y - h, x + w, y + h);

        //터치 위치가 참새 내부인가?
        float dist = (px - x) * (px - y) + (py - y) * (py - y);
        if (dist < h * h * 0.7f) {
            dir.y = speed;
            dir.x = 0;

            ang = 180;
        }

        return (dir.x == 0);
    }

}
