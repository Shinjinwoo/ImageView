package com.example.imageview.January18;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imageview.R;

public class Picture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture);

        setTitle("명화");

        TextView tv_title = (TextView)findViewById(R.id.title);
        TextView tv_autor = (TextView)findViewById(R.id.artist);
        ImageView iv_picture = (ImageView)findViewById(R.id.picture);

        Intent it = getIntent();
        String tag = it.getStringExtra("it_tag");
        //이 액티비티를 호출한 인텐트를 반환하고, 인텐트의 it_tag 변수에 저장된 값 추출

        Resources res = getResources();
        //어플리케이션 리소스 객체 생성

        int id_title = res.getIdentifier("title" + tag, "string",getPackageName());

        String title = res.getString(id_title);
        tv_title.setText(title);

        // 명화 제목 출력

        int id_autor = res.getIdentifier("artist" + tag, "string", getPackageName());

        String author = res.getString(id_autor);
        tv_autor.setText(author);

        // 작가 출력

        int id_picture = res.getIdentifier("picture" + tag,"string",getPackageName());
        String picture = res.getString(id_picture);
        int id_img = res.getIdentifier(picture,"drawable",getPackageName());

        Drawable drawable = res.getDrawable(id_img);
        iv_picture.setBackground(drawable);

        // 명화 이미지 출력
    }

    public void closePicture(View v) {
        finish();
        // 현재 액티비티 종료

        // 전체 화면에 걸친 리니어 레이아웃에 설정된 메소드로,클릭 시에 시스템에 의해 자동으로 호출되는 콜백 메소드.
        // 클릭된 뷰의 정보가 전달됨.
    }
}