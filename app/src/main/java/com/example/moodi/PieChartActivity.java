package com.example.moodi;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Luokka sisältää piiraskaavion.
 * piiraskaavioon ajan puuttessa.
 * @author Jani Turpeinen
 * @version 0.1 5/2020
 */

public class PieChartActivity extends AppCompatActivity {

    /**
     * Luotu  Philipp Jahodan MpAndroidChart kirjastolla.
     * @param  Piechartilla luodaan piiraskaavio
     * @param  String label määrittää ja int value on keskeneräiseen metodiin millä oltaisiin saatu piiraskaavioon käyttäjän dataa.
     *          Rivit 42-56 luodaan piiraskaavio. Tällä hetkellä piiraskaaviossa on staattiset arvot.
     * @param set.setColors määrittää olemassa olevista templateista piiraskaavion lohkojen värit.
     */
    PieChart pieChart;
    int value;
    String label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        pieChart = findViewById(R.id.pieChart);
        ArrayList<Paivaus> paivaukset= Paivaus.loadall(getApplicationContext());

        pieChart.setBackgroundColor(20991);
        List<PieEntry> entries = new ArrayList<>();
        int i= 1;
        for (Paivaus p:paivaukset //arvojen lataus.
        ) {entries.add(new PieEntry(i,p.getDepression()));
            entries.add(new PieEntry(i,p.getAgitation()));
                entries.add(new PieEntry(i,p.getIrritation()));
                        entries.add(new PieEntry(i, p.getAnxiety()));
            i++;
        } //Piechartin styleä pitäisi vielä muuttaa, täyttyy turhalla dummy-arvoilla.

        PieDataSet set = new PieDataSet(entries, "");
        set.setColors(ColorTemplate.MATERIAL_COLORS);
        PieData data = new PieData(set);
        pieChart.setData(data);
        pieChart.setBackgroundColor(0x0051FF);
        pieChart.invalidate();;


    }



    /**
     * Alanapit eri activityihin
     */

    public void mainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void barChart(View view) {
        Intent intent = new Intent(this, BarChartActivity.class);
        startActivity(intent);
    }
    public void calendar(View view) {
        Intent intent = new Intent(this, Calendar.class);
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
