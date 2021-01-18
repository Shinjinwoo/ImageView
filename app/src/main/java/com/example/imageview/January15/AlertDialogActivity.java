package com.example.imageview.January15;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.imageview.R;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    public void open(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("결제하시겠습니까?");

        
        alertDialogBuilder.setPositiveButton("Yse",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogActivity.this,"결제가 완료 되었습니다.",
                                Toast.LENGTH_LONG).show();
                    }
                });


        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i ) {
                        Toast.makeText(AlertDialogActivity.this,"결제가 취소 되었습니다.",
                                Toast.LENGTH_LONG).show();
                        finish();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
