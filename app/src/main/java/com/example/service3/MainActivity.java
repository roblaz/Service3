package com.example.service3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btStart,btStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btStart = findViewById(R.id.bt_Start);
        btStop = findViewById(R.id.bt_stop);

    }

    public void onStart(View view) {
        Intent intent = new Intent(this, MyService.class);
        intent.setAction("start");
        startService(intent);

    }

    public void onStop(View view) {
        Intent intent = new Intent(this, MyService.class);
        intent.setAction("stop");
        startService(intent);

//        stopService(new Intent(this, MyService.class));

    }
}


