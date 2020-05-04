package com.example.moodi;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import com.google.gson.Gson;


/**
 * Luokka sisältää
 * @author Oskari Toivonen
 * @version 0.1 5/2020
 */

public class MainActivity extends AppCompatActivity {
    /**
     * tamapaiva muuttujan avulla seurataan tämänhetkistä päivämäärää
     * TextView Seekbar alustaa textviewin seekbarin arvoja varten
     * TextView aikatv alustaa textviewin aika-arvoa varten
     * Imagebutton avaa datepicker dialogin
     * Textview date alustaa textviewin päivämäärän näyttöä varten
     * DatePickerDialog alustaa datepicker kalenterivalikon
     * @param int year alustaa vuoden
     * @param int month alustaa kuukauden
     * @param int dayOfMonth alustaa päivän
     * calendar alustaa kalenterin
     * EditText muistiinpanot alustaa tekstikentän kirjoittamista varten
     * @author Oskari Toivonen
     * @version 0.1 5/2020
     */
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
    EditText muistiinpanot;

    protected void updateradiobuttons(){

    }
    /**
     * date_n asetetaan tekstikenttään tämäpäivä
     *
     * @author Oskari Toivonen
     * @version 0.1 5/2020
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String date_n = new SimpleDateFormat("dd.MM.yyyy", //selvitetään nykyinen päivämäärä ja asetetaan se tekstikenttään.
                Locale.getDefault()).format(new Date());
        aikatv = findViewById(R.id.aika);
        aikatv.setText(date_n);
        muistiinpanot=findViewById(R.id.tvNotes);
        selectDate = findViewById(R.id.datepicker);
        date = findViewById(R.id.aika);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        tamapaiva=Paivaus.load(year,month,dayOfMonth, getApplicationContext());
        updateradiobuttons();//tähän metodi jotta saadaan muistista vanhat radiobuttoneiden arvot
        selectDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int newyear, int newmonth, int newday) {
                                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                             date.setText(newday + "." + (newmonth + 1) + "." + newyear);
                             tamapaiva.save(year,month,dayOfMonth,getApplicationContext());
                             tamapaiva=Paivaus.load(newyear,newmonth,newday, getApplicationContext());
                                updateradiobuttons();//kutsuu metodia jota toistaiseksi ei ole olemassaa, tarkoitus asettaa radiobuttonit aiemmin kirjattuihin arvoihin
                             year=newyear;
                             month=newmonth;
                             dayOfMonth=newday;
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialog.show();
            }
        });



        RadioGroup masis = (RadioGroup) findViewById(R.id.masisRadio);
        masis.check(R.id.masisRadio1);

        masis.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.masisRadio1:
                        depression = 1;
                        tamapaiva.setDepression(1);
                        Log.i("result", "" + depression);
                        break;
                    case R.id.masisRadio2:
                        depression = 2;
                        tamapaiva.setDepression(2);
                        Log.i("result", "" + depression);
                        break;
                    case R.id.masisRadio3:
                        depression = 3;
                        tamapaiva.setDepression(3);
                        Log.i("result", "" + depression);
                        break;
                    case R.id.masisRadio4:
                        depression = 4;
                        tamapaiva.setDepression(4);
                        Log.i("result", "" + depression);
                        break;
                    case R.id.masisRadio5:
                        depression = 5;
                        tamapaiva.setDepression(5);
                        Log.i("result", "" + depression);
                        break;
                }
            }
        });
        RadioGroup kiihtyneisyys = (RadioGroup) findViewById(R.id.kiihtyneisyysRadio);

        kiihtyneisyys.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.kiihtyneisyysRadio1:
                        agitation = 1;
                        tamapaiva.setAgitation(1);
                        Log.i("result", "" + agitation);
                        break;
                    case R.id.kiihtyneisyysRadio2:
                        agitation = 2;
                        tamapaiva.setAgitation(2);
                        Log.i("result", "" + agitation);
                        break;
                    case R.id.kiihtyneisyysRadio3:
                        agitation = 3;
                        tamapaiva.setAgitation(3);
                        Log.i("result", "" + agitation);
                        break;
                    case R.id.kiihtyneisyysRadio4:
                        agitation = 4;
                        tamapaiva.setAgitation(4);
                        Log.i("result", "" + agitation);
                        break;
                    case R.id.kiihtyneisyysRadio5:
                        agitation = 5;
                        tamapaiva.setAgitation(5);
                        Log.i("result", "" + agitation);
                        break;
                }
            }
        });
        RadioGroup arsutus = (RadioGroup) findViewById(R.id.arsutusRadio);

        arsutus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.arsutusRadio1:
                        irritation = 1;
                        tamapaiva.setIrritation(1);
                        Log.i("result", "" + irritation);
                        break;
                    case R.id.arsutusRadio2:
                        irritation = 2;
                        tamapaiva.setIrritation(2);
                        Log.i("result", "" + irritation);
                        break;
                    case R.id.arsutusRadio3:
                        irritation = 3;
                        tamapaiva.setIrritation(3);
                        Log.i("result", "" + irritation);
                        break;
                    case R.id.arsutusRadio4:
                        irritation = 4;
                        tamapaiva.setIrritation(4);
                        Log.i("result", "" + irritation);
                        break;
                    case R.id.arsutusRadio5:
                        irritation = 5;
                        tamapaiva.setIrritation(5);
                        Log.i("result", "" + irritation);
                        break;
                }
            }
        });
        RadioGroup ahdistus = (RadioGroup) findViewById(R.id.ahdistusRadio);

        ahdistus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ahdistusRadio1:
                        anxiety = 1;
                        tamapaiva.setAnxiety(1);
                        Log.i("result", "" + anxiety);
                        break;
                    case R.id.ahdistusRadio2:
                        anxiety = 2;
                        tamapaiva.setAnxiety(2);
                        Log.i("result", "" + anxiety);
                        break;
                    case R.id.ahdistusRadio3:
                        anxiety = 3;
                        tamapaiva.setAnxiety(3);
                        Log.i("result", "" + anxiety);
                        break;
                    case R.id.ahdistusRadio4:
                        anxiety = 4;
                        tamapaiva.setAnxiety(4);
                        Log.i("result", "" + anxiety);
                        break;
                    case R.id.ahdistusRadio5:
                        anxiety = 5;
                        tamapaiva.setAnxiety(5);
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
                tamapaiva.setSleep(unet);
                sleepText.setText("" + unet + "h");//asetetaan seekbarin arvo näkymään tekstikentässä

            }

            @Override//seek bar metodeja, ei välttämättä tarvita
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override//seek bar metodeja, ei välttämättä tarvita
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        // Muistiinpanojen tallennus napista tekstitiedostoon.
        Button buttonSave = (Button)findViewById(R.id.btOk);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    muistiinpanot = findViewById(R.id.tvNotes);
                    String tunniste = "" + year + "-" + month + "-" + dayOfMonth + "_notes";
                    String muistiinpanoText = muistiinpanot.getText().toString();
                    File file = new File("data/data/com.example.moodi/files/" + tunniste+".txt"); // Luo tiedoston päivämäärä_notes.txt nimellä
                    if (!file.exists()) {

                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter(file, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(muistiinpanoText);  // Kirjoittaa tekstitiedostoon muistiinpanokenttään syötetyn tekstin.
                    bufferedWriter.close();

            }catch (IOException e) {
                e.printStackTrace();}


            }
        });

    }



    /**
     * Alanapit eri activityihin
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

    private void saveData() {
        //hae kaikkien radiogrouppien arvot, tallenna tamapaiva muuttujaan
    }

    private void loadData() {


    }

}

