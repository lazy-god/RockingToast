package com.pratap.ninja.rockingtoastexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.pratap.ninja.rockingtoastapp.ToastCreator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ToastCreator toastCreator = new ToastCreator(this);

        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastCreator.makeRockingCustomToast(ToastCreator.UP_TOAST, "Uploading Content...", ToastCreator.TOAST_LONG).show();
            }
        });
    }
}
