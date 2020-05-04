package com.example.moodi;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Luokka sisältää piiraskaavion. Piiraskaaviossa tällä hetkellä on vain staattista dataa, käyttäjän syötteestä emme saanut dataa
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
        List<PieEntry> entries = new ArrayList<>();

        pieChart.setBackgroundColor(20991);

        entries.add(new PieEntry(10, "Depression"));
        entries.add(new PieEntry(20, "Agitation"));
        entries.add(new PieEntry(40, "Irritation"));
        entries.add(new PieEntry(30, "Anxiety"));

        PieDataSet set = new PieDataSet(entries, "");
        set.setColors(ColorTemplate.MATERIAL_COLORS);
        PieData data = new PieData(set);
        pieChart.setData(data);
        pieChart.setBackgroundColor(0x0051FF);
        pieChart.invalidate();;


    }


    public void PieEntry (int value, String label){
        this.value = value;
        this.label = label;
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
