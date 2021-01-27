package com.example.imageview.January27;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.imageview.R;

public class LightActivity extends AppCompatActivity implements SensorEventListener {

    ImageView img;

    SensorManager sm;

    Sensor sensor;

    Camera cam;
    Camera.Parameters p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        cam = Camera.open();
        img = findViewById(R.id.light_img);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
    }
    @Override
    protected void onResume(){
        super.onResume();

        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause(){
        super.onPause();

        sm.unregisterListener(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        cam.release();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_LIGHT){
            int lux = (int)event.values[0];

            if(lux <= 100){
                img.setImageResource(R.drawable.streetlight_off);

                p = cam.getParameters();
                p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                cam.setParameters(p);
                cam.startPreview();
            }else{
                img.setImageResource(R.drawable.streetlight_on);

                p = cam.getParameters();
                p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                cam.setParameters(p);
                cam.startPreview();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}