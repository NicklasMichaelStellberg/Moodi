package com.example.moodi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class MainActivity extends AppCompatActivity  {
    private Paivaus tamapaiva;
    private TextView sleepText;
    private SeekBar sleepSeek;
    TextView aikatv;
    int depression = 0;
    int agitation = 0;
    int irritation = 0;
    int anxiety = 0;
    ImageButton selectDate;
    TextView date;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String date_n = new SimpleDateFormat("dd.MM.yyyy", //selvitetään nykyinen päivämäärä ja asetetaan se tekstikenttään.
                Locale.getDefault()).format(new Date());
        aikatv = findViewById(R.id.aika);
        aikatv.setText(date_n);
        selectDate = findViewById(R.id.datepicker);
        date = findViewById(R.id.aika);

        selectDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                date.setText(day + "." + (month + 1) + "." + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });

        RadioGroup masis = (RadioGroup) findViewById(R.id.masisRadio);

        masis.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.masisRadio1:
                        depression = 1;
                        Log.i("result", "" + depression);
                        break;
                    case R.id.masisRadio2:
                        depression = 2;
                        Log.i("result", "" + depression);
                        break;
                    case R.id.masisRadio3:
                        depression = 3;
                        Log.i("result", "" + depression);
                        break;
                    case R.id.masisRadio4:
                        depression= 4;
                        Log.i("result", "" + depression);
                        break;
                    case R.id.masisRadio5:
                        depression = 5;
                        Log.i("result", "" + depression);
                        break;
                }
            }
        });
        RadioGroup kiihtyneisyys = (RadioGroup) findViewById(R.id.kiihtyneisyysRadio);

        kiihtyneisyys.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.kiihtyneisyysRadio1:
                        agitation = 1;
                        Log.i("result", "" + agitation);
                        break;
                    case R.id.kiihtyneisyysRadio2:
                        agitation = 2;
                        Log.i("result", "" + agitation);
                        break;
                    case R.id.kiihtyneisyysRadio3:
                        agitation = 3;
                        Log.i("result", "" + agitation);
                        break;
                    case R.id.kiihtyneisyysRadio4:
                        agitation = 4;
                        Log.i("result", "" + agitation);
                        break;
                    case R.id.kiihtyneisyysRadio5:
                        agitation = 5;
                        Log.i("result", "" + agitation);
                        break;
                }
            }
        });
        RadioGroup arsutus = (RadioGroup) findViewById(R.id.arsutusRadio);

        arsutus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.arsutusRadio1:
                        irritation = 1;
                        Log.i("result", "" + irritation);
                        break;
                    case R.id.arsutusRadio2:
                        irritation = 2;
                        Log.i("result", "" + irritation);
                        break;
                    case R.id.arsutusRadio3:
                        irritation = 3;
                        Log.i("result", "" + irritation);
                        break;
                    case R.id.arsutusRadio4:
                        irritation = 4;
                        Log.i("result", "" + irritation);
                        break;
                    case R.id.arsutusRadio5:
                        irritation = 5;
                        Log.i("result", "" + irritation);
                        break;
                }
            }
        });
        RadioGroup ahdistus = (RadioGroup) findViewById(R.id.ahdistusRadio);

        ahdistus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.ahdistusRadio1:
                        anxiety = 1;
                        Log.i("result", "" + anxiety);
                        break;
                    case R.id.ahdistusRadio2:
                        anxiety = 2;
                        Log.i("result", "" + anxiety);
                        break;
                    case R.id.ahdistusRadio3:
                        anxiety = 3;
                        Log.i("result", "" + anxiety);
                        break;
                    case R.id.ahdistusRadio4:
                        anxiety = 4;
                        Log.i("result", "" + anxiety);
                        break;
                    case R.id.ahdistusRadio5:
                        anxiety = 5;
                        Log.i("result", "" + anxiety);
                        break;
                }
            }
        });
        /*String date_n = new SimpleDateFormat("dd.MM.yyyy", //selvitetään nykyinen päivämäärä ja asetetaan se tekstikenttään.
                Locale.getDefault()).format(new Date());
        aikatv = findViewById(R.id.aika);
        aikatv.setText(date_n);
        findViewById(R.id.datepicker).setOnClickListener(new View.OnClickListener() {//listener imagebuttonille joka avaa kalenterivalinnan
            @Override
            public void onClick(View v) {
                showDatePickerDialog(); //kutsutaan päivämäärävalitsin metodia
            }


        });*/
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

    /*private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }*/

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

    /*@Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = +dayOfMonth + "." + month + "." + year;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
        this.tamapaiva = Paivaus.load(calendar, this.getApplicationContext());
        //tamapaiva objektista ladataan arvot radiobuttoneihin ja slideriin

        aikatv.setText(date);


    }*/

    private void saveData() {
        //hae kaikkien radiogrouppien arvot, tallenna tamapaiva muuttujaan
    }

    private void loadData() {


    }
}

