package com.example.imageview.January19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.imageview.January19.AudioImage;
import com.example.imageview.R;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        setTitle("노래 목록");
    }

    public void play(View v) {
        int id = v.getId();
        LinearLayout layout = (LinearLayout) findViewById(id);
        String tag = (String) layout.getTag();

        Intent it = new Intent(this, AudioImage.class);
        it.putExtra("it_tag", tag);
        startActivity(it);


    }
}
