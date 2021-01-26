package com.example.imageview.January20;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import com.example.imageview.R;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Uri uri = Uri.parse("android.resource://com.example.imageview/" + R.raw.fountain_night);

        VideoView videoView = (VideoView)findViewById(R.id.videoview1);

        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setVisibility(View.VISIBLE);

    }
}
