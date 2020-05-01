package com.example.moodi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.widget.DatePicker;

import java.util.Calendar;


import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Paivaus tamapaiva;
    private TextView sleepText;
    private SeekBar sleepSeek;
    TextView aikatv;
    int masennus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rg = (RadioGroup) findViewById(R.id.masisRadio);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.masisRadio1:
                        masennus = 1;
                        Log.i("result", "" + masennus);
                        break;
                    case R.id.masisRadio2:
                        // do operations specific to this selection
                        break;
                    case R.id.masisRadio3:
                        // do operations specific to this selection
                        break;
                }
            }
        });
        String date_n = new SimpleDateFormat("dd.MM.yyyy", //selvitetään nykyinen päivämäärä ja asetetaan se tekstikenttään.
                Locale.getDefault()).format(new Date());
        aikatv = findViewById(R.id.aika);
        aikatv.setText(date_n);
        findViewById(R.id.datepicker).setOnClickListener(new View.OnClickListener() {//listener imagebuttonille joka avaa kalenterivalinnan
            @Override
            public void onClick(View v) {
                showDatePickerDialog(); //kutsutaan päivämäärävalitsin metodia
            }


        });
        //seekerbar
        sleepText = (TextView) findViewById(R.id.sleepTv); //määritetään seeker bar ja laitetaan sen maksimiarvoksi 24(h)
        sleepSeek = (SeekBar) findViewById(R.id.sleepSeek);
        sleepSeek.setMax(24);
        sleepSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int unet, boolean fromUser) {
                sleepText.setText("" + unet + "h");//asetetaan seekbarin arvo näkymään tekstikentässä

            }

            @Override//seek bar metodeja, ei välttämättä tarvita
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override//seek bar metodeja, ei välttämättä tarvita
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    /**
     * Called when the user taps the button
     */
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

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = +dayOfMonth + "." + month + "." + year;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
        this.tamapaiva = Paivaus.load(calendar, this.getApplicationContext());
        //tamapaiva objektista ladataan arvot radiobuttoneihin ja slideriin

        aikatv.setText(date);


    }

    private void saveData() {
        //hae kaikkien radiogrouppien arvot, tallenna tamapaiva muuttujaan
    }

    private void loadData() {


    }
}

