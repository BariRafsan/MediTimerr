package edu.ewubd.meditimer2019162001;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Timer extends AppCompatActivity {
    //InitialSize variable
    TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        //Asigning variable
        textview = findViewById(R.id.text_view1);
        //Initialize timer duration
        long duration = TimeUnit.MINUTES.toMillis(1);
        //Initial cntdown timer
        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long l) {
                String duration = String.format(Locale.ENGLISH,"%02d : %02d"
                ,TimeUnit.MILLISECONDS.toMinutes(1),
                        TimeUnit.MILLISECONDS.toSeconds(1) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(1)));
                textview.setText(duration);
            }

            @Override
            public void onFinish() {
                textview.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "CountDown timer has ended", Toast.LENGTH_LONG).show();

            }
        }.start();
    }
}
