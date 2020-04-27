package com.example.moodi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    private TextView sleepText;
    private ProgressBar sleepBar;
    private SeekBar sleepSeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sleepText= (TextView) findViewById(R.id.sleepTv);
        sleepSeek= (SeekBar) findViewById(R.id.sleepSeek);
        sleepSeek.setMax(24);

        sleepSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int unet, boolean fromUser) {
                sleepText.setText("" +unet +"h");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    /** Called when the user taps the button */
    public void barChart(View view) {
        Intent intent = new Intent(this, BarChartActivity.class);
        startActivity(intent);
    }
    public void calendar(View view) {
        Intent intent = new Intent(this, Calendar.class);
        startActivity(intent);
    }
    public void pieChart(View view) {
        Intent intent = new Intent(this, PieChartActivity.class);
        startActivity(intent);
    }
    public void info(View view) {
        Intent intent = new Intent(this, Info.class);
        startActivity(intent);
    }
    public void averageDay(View view) {
        Intent intent = new Intent(this, AverageDay.class);
        startActivity(intent);
    }
}
