package com.kevine.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button start, stop, reset;
    boolean running;
    int seconds=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.timerTextViewId);
        start = findViewById(R.id.startButtonId);
        stop = findViewById(R.id.stopButtonId);
        reset = findViewById(R.id.resetButtonId);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        reset.setOnClickListener(this);
        runTimer();

    }

    private void runTimer() {

        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {


                int hour= seconds/3600;
                int minute= seconds/60;
                int mainseconds= seconds%60;

                String timer = String.format("%d:%02d:%02d",hour,minute,mainseconds);
                textView.setText(timer);

                if (running) {
                    seconds++;
                }

                handler.postDelayed(this,1000);
            }
        });


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.startButtonId) {
            running=true;
        }
        if (v.getId() == R.id.stopButtonId) {
            running=false;
        }
        if (v.getId() == R.id.resetButtonId) {
            running=false;
            seconds=0;

        }
    }
}