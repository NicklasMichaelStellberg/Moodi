package com.example.moodi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Luokka sisältää palkkikaavion
 * @author
 * @version 0.1 5/2020
 */
public class charts extends AppCompatActivity {
    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);

        barChart = findViewById(R.id.barChart);
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0,10f));
        entries.add(new BarEntry(1,7.5f));
        entries.add(new BarEntry(2,8.5f));
        entries.add(new BarEntry(3,6f));

        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        BarData data = new BarData(set);
        data.setBarWidth(0.9f);
        barChart.setData(data);
        barChart.setFitBars(true);
        barChart.invalidate();

    }
}
