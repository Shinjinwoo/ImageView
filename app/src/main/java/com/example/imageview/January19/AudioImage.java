package com.example.imageview.January19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imageview.R;

public class AudioImage extends AppCompatActivity {

    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_image);

        setTitle("노래 재생");

        Intent it = getIntent();
        String tag = it.getStringExtra("it_tag");

        TextView title = (TextView) findViewById(R.id.title);
        ImageView song_image = (ImageView) findViewById(R.id.song_image);
        TextView lyrics = (TextView) findViewById(R.id.lyrics);

        Resources res = getResources();

        int stringId;
        String mykey;

        stringId = res.getIdentifier("title" + tag, "string",
                getPackageName());

        mykey = res.getString(stringId);
        title.setText(mykey);

        // 노래 이미지
        stringId = res.getIdentifier("song_image" + tag, "string", getPackageName());
        mykey = res.getString(stringId);
        int id_image = res.getIdentifier(mykey, "drawable", getPackageName());
        song_image.setImageResource(id_image);


        stringId = res.getIdentifier("lyrics" + tag, "string",
                getPackageName());
        mykey = res.getString(stringId);
        lyrics.setText(mykey);

        stringId = res.getIdentifier("audio" + tag, "string",
                getPackageName());
        mykey = res.getString(stringId);
        int id_audio = res.getIdentifier(mykey, "raw", getPackageName());
        mp = MediaPlayer.create(this, id_audio);
        mp.setLooping(false);
        mp.start();

    }

    public void goBack(View v) {
        mp.stop();
        mp.release();
        finish();
    }
}