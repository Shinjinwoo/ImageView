package com.example.imageview.January18;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.imageview.R;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    final int RUNTIME_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.call).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // onRequestPermissionsResult() 메소드 호출하며
            // 여러 권한이 있을 경우 RUNTIME_PERMISSIONS_REQUEST_CALL_PHONE로 구분
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    RUNTIME_PERMISSIONS_REQUEST_CALL_PHONE);
        } else {
            startCall();
        }
    }

    private void startCall() {
        Intent callIntent = new Intent();
        callIntent.setAction(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:01012345678"));
        startActivity(callIntent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RUNTIME_PERMISSIONS_REQUEST_CALL_PHONE: {
                // 사용자가 권한을 수락했다면
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 해당 권한을 필요로 하는 코드 실행
                    startCall();
                } else {
                    // 권한을 거부했을 경우, 해당 기능을 사용하지 못함을 알리고 적절한 처리
                }
                return;
            }
            // 다른 권한에 대한 처리
        }
    }
}

