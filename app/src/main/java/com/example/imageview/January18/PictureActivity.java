package com.example.imageview.January18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.imageview.R;

public class PictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        setTitle("명화 목록");
    }

    public void displayPicture(View v) { //명화 아이템에 설정된 메소드로, 클릭 시에 시스템에 의해 자동으로 호출되는 콜백 메소드. 클릭된 뷰의 정보가 전달됨
        int id = v.getId();//클릭한 뷰의 ID를 인식
        LinearLayout layout = (LinearLayout)v.findViewById(id);//클릭한 뷰의 ID에해당하는 리니어 레이아웃을 인식
        String tag = (String)layout.getTag();//레이아웃의 태그 값을 추출

        Intent it = new Intent(this, Picture.class);//Picture 자바 클래스로 데이터를 전송하기 위한 인텐트 객체 생성
        it.putExtra("it_tag", tag);//태그 값을 인텐트에 it_tag변수 값으로 저장
        startActivity(it); //Picture 클래스의 액티비티를 호출
    }
}
