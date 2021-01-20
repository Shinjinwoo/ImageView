package com.example.imageview.January19;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imageview.R;

public class AlbumActivity extends AppCompatActivity {

    Button b1, b2, b3, b4;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        b1 = findViewById(R.id.AlbumButton1);
        b2 = findViewById(R.id.AlbumButton2);
        b3 = findViewById(R.id.AlbumButton3);
        b4 = findViewById(R.id.AlbumButton4);

        image = findViewById(R.id.AlbumView);

        b2.setAlpha(0.3f);
        b3.setAlpha(0.3f);
        b4.setAlpha(0.3f);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.photo1);
                b1.setAlpha(1.0f);
                b2.setAlpha(0.3f);
                b3.setAlpha(0.3f);
                b4.setAlpha(0.3f);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.photo2);
                b1.setAlpha(0.3f);
                b2.setAlpha(1.0f);
                b3.setAlpha(0.3f);
                b4.setAlpha(0.3f);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.photo3);
                b1.setAlpha(0.3f);
                b2.setAlpha(0.3f);
                b3.setAlpha(1.0f);
                b4.setAlpha(0.3f);

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.photo4);
                b1.setAlpha(0.3f);
                b2.setAlpha(0.3f);
                b3.setAlpha(0.3f);
                b4.setAlpha(1.0f);

            }
        });

    }

}
