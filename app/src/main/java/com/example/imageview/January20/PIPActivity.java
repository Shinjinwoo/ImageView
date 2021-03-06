package com.example.imageview.January20;


import android.app.PictureInPictureParams;
import android.os.Build;
import android.os.Bundle;
import android.util.Rational;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imageview.R;

public class PIPActivity extends AppCompatActivity {
    private Button button;
    private FrameLayout player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pip);

        player = findViewById(R.id.player);
        button = findViewById(R.id.pip);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >=26) {
                    try {
                        Rational rational = new Rational(player.getWidth(), player.getHeight());

                        PictureInPictureParams mParams = new PictureInPictureParams.Builder().setAspectRatio(rational).build();

                        enterPictureInPictureMode(mParams);

                    } catch(IllegalStateException e) {
                        e.printStackTrace();

                    }
                } else {
                    Toast.makeText(getApplicationContext(), "API 26가 필요합니다.",  Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
        if(!isInPictureInPictureMode) {
            button.setVisibility(View.VISIBLE);
        } else {
            button.setVisibility(View.GONE);
        }
    }
}