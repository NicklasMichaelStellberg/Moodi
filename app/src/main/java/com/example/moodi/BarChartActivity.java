package com.example.moodi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import android.widget.Button;
/**
 * Luokka sisältää paalukaavion, josta voi seurata unen määrää. Yksi paalu kuvastaa yhtä päivää.
 * @author Jani Turpeinen
 * @version 0.1 5/2020
 */

public class BarChartActivity extends AppCompatActivity {
    /**
     * Luotu  Philipp Jahodan MpAndroidChart kirjastolla.
     * @param BarChartilla luodaan paalukaavio.
     * @param List<BarEntryllä> on asetettu staattiset arvot tällä hetkellä. Tarkoitus oli käyttäjän syöttämistä arvoista saada data
     *                         kaavioihin mutta sitä ei aikataulussa saatu valmiiksi.
     *
     */

    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        barChart = findViewById(R.id.barChart);
        Description description = barChart.getDescription();
        description.setText("");
        final Button depisbutton = findViewById(R.id.depisnappi);
        final Button sleepbutton = findViewById(R.id.sleepButton);
        final Button irritationbutton = findViewById(R.id.irritationButton);
        final Button agitationbutton = findViewById(R.id.agitationButton);
        final Button anxietybutton = findViewById(R.id.anxietyButton);

        ArrayList<Paivaus> paivaukset = Paivaus.loadall(getApplicationContext());
        List<BarEntry> entries = new ArrayList<>();
        int i = 1;
        for (Paivaus p : paivaukset) {
            entries.add(new BarEntry(i, p.getDepression()));
            i++;
        }

        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        BarData data = new BarData(set);
        data.setBarWidth(1f);
        barChart.setData(data);
        barChart.setFitBars(true);
        barChart.invalidate();

        depisbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ArrayList<Paivaus> paivaukset = Paivaus.loadall(getApplicationContext());
                List<BarEntry> entries = new ArrayList<>();
                int i = 1;
                for (Paivaus p : paivaukset) {
                    entries.add(new BarEntry(i, p.getDepression()));
                    i++;
                }

                BarDataSet set = new BarDataSet(entries, "BarDataSet");
                BarData data = new BarData(set);
                data.setBarWidth(1f);
                barChart.setData(data);
                barChart.setFitBars(true);
                barChart.invalidate();

            }


        });

        sleepbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ArrayList<Paivaus> paivaukset = Paivaus.loadall(getApplicationContext());
                List<BarEntry> entries = new ArrayList<>();
                int i = 1;
                for (Paivaus p : paivaukset) {
                    entries.add(new BarEntry(i, p.getSleep()));
                    i++;
                }

                BarDataSet set = new BarDataSet(entries, "BarDataSet");
                BarData data = new BarData(set);
                data.setBarWidth(1f);
                barChart.setData(data);
                barChart.setFitBars(true);
                barChart.invalidate();

            }


        });


        irritationbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ArrayList<Paivaus> paivaukset = Paivaus.loadall(getApplicationContext());
                List<BarEntry> entries = new ArrayList<>();
                int i = 1;
                for (Paivaus p : paivaukset) {
                    entries.add(new BarEntry(i, p.getIrritation()));
                    i++;
                }

                BarDataSet set = new BarDataSet(entries, "BarDataSet");
                BarData data = new BarData(set);
                data.setBarWidth(1f);
                barChart.setData(data);
                barChart.setFitBars(true);
                barChart.invalidate();

            }


        });

        anxietybutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ArrayList<Paivaus> paivaukset = Paivaus.loadall(getApplicationContext());
                List<BarEntry> entries = new ArrayList<>();
                int i = 1;
                for (Paivaus p : paivaukset) {
                    entries.add(new BarEntry(i, p.getAnxiety()));
                    i++;
                }

                BarDataSet set = new BarDataSet(entries, "BarDataSet");
                BarData data = new BarData(set);
                data.setBarWidth(1f);
                barChart.setData(data);
                barChart.setFitBars(true);
                barChart.invalidate();

            }


        });

        agitationbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ArrayList<Paivaus> paivaukset = Paivaus.loadall(getApplicationContext());
                List<BarEntry> entries = new ArrayList<>();
                int i = 1;
                for (Paivaus p : paivaukset) {
                    entries.add(new BarEntry(i, p.getAgitation()));
                    i++;
                }

                BarDataSet set = new BarDataSet(entries, "BarDataSet");
                BarData data = new BarData(set);
                data.setBarWidth(1f);
                barChart.setData(data);
                barChart.setFitBars(true);
                barChart.invalidate();

            }


        });

    }


       /* int laskuri= 0;//keskarin lasku
        for (Paivaus p:paivaukset
        ) {
            laskuri+=p.getSleep();
        }
        double keskari=(double)laskuri/(double)paivaukset.size();
                                      }



       /* ArrayList<Paivaus> paivaukset= Paivaus.loadall(getApplicationContext());
        List<BarEntry> entries = new ArrayList<>();
        int i= 1;
        for (Paivaus p:paivaukset
        ) {entries.add(new BarEntry(i,p.getSleep()));
            i++;
        }

        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        BarData data = new BarData(set);
        data.setBarWidth(1f);
        barChart.setData(data);
        barChart.setFitBars(true);
        barChart.invalidate();*/


       /* int laskuri= 0;//keskarin lasku
        for (Paivaus p:paivaukset
        ) {
            laskuri+=p.getSleep();
        }
        double keskari=(double)laskuri/(double)paivaukset.size();*/


    /**
     * Alanapit eri activityihin
     */

    public void mainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
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

