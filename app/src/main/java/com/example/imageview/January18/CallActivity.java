package com.example.imageview.January18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.imageview.R;

public class CallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

    }
    public void call(View v) {
        int id = v.getId();
        LinearLayout layout = (LinearLayout) v.findViewById(id);
        String tag = (String) layout.getTag();

        Resources res = getResources();

        int id_tel = res.getIdentifier("tel" + tag,"string",getPackageName());

        String tel = res.getString(id_tel);

        Uri number = Uri.parse("tel:" + tel);
        Intent intent = new Intent(Intent.ACTION_CALL,number);
        startActivity(intent);
    }
}
