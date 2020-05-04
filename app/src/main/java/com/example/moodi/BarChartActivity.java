package com.example.moodi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Luokka sisältää paalukaavion, josta voi seurata unen määrää. Yksi paalu kuvastaa yhtä päivää. Tämä ominaisuus ei valitettavasti valmistunut ajallaan.
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

        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0,10f));
        entries.add(new BarEntry(1,7.5f));
        entries.add(new BarEntry(2,8.5f));
        entries.add(new BarEntry(3,6f));

        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        BarData data = new BarData(set);
        data.setBarWidth(1f);
        barChart.setData(data);
        barChart.setFitBars(true);
        barChart.invalidate();

    }
    // Alanapit eri activityihin
    public void mainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
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
