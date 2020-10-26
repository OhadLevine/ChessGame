package ohad.levin.chess;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, GameActivity.class);
                startActivity(i);
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 3000);
    }
}
