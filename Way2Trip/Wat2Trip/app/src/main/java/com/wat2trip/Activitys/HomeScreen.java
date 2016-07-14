package com.wat2trip.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.github.lzyzsd.circleprogress.CircleProgress;
import com.wat2trip.R;
import java.util.TimerTask;
import java.util.Timer;

/**
 * Created by User on 14-07-2016.
 */

public class HomeScreen extends Activity {
    private CircleProgress circleProgress;
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        circleProgress = (CircleProgress) findViewById(R.id.circle_progress);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        circleProgress.setProgress(circleProgress.getProgress() + 1);
                        int p=circleProgress.getProgress();
                        if (p == 100) {
                            Intent i = new Intent(HomeScreen.this, MainActivity.class);
                            startActivity(i);
                        }
                    }
                });
            }
        }, 1000, 100);
    }
}
