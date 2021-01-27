package com.example.imageview.January27;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.imageview.R;

import org.w3c.dom.Text;

public class JumpActivity extends AppCompatActivity implements SensorEventListener {

    TextView tv_count;
    Sensor sensor_accelerometer;
    SensorManager sm;

    int count = 0; //점프 횟수 초기화
    int dir_UP = 0; // 이전 방향 (UP,DOWN )
    int dir_DOWN = 0;

    double gravity = 9.8;
    double acceleration = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);

        tv_count = (TextView)findViewById(R.id.count);
        tv_count.setText("" + count);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor_accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    public void initialize(View v) {
        count = 0;
        tv_count.setText(""+count);
    }

    @Override
    protected void onResume(){
        super.onResume();

        sm.registerListener(this,sensor_accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected  void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()== Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            acceleration = Math.sqrt(x*x + y*y + z*z);

            if (acceleration - gravity >5)
                dir_UP = 1;
            // 가속도가 중력보다 5(실험으로 조정) 크면, 공중으로 뛰는 상태

            if (dir_UP == 1 && gravity - acceleration > 5 )
                dir_DOWN = 1;
            // 공중으로 뛰었다가 중력이 가속도보다 5크면, 공중에서 내려오는 상태

            if (dir_DOWN == 1) {
                count ++;
                tv_count.setText(""+count);

                dir_UP = 0;
                dir_DOWN = 0;

                //공중에서 내려오는 상태이면, 점프 회수를 1증가하고 화면에 출력하며 점프 상태 변수를 초기화
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {


    }
}
