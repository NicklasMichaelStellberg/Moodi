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
 * Ensimmäinen prototyyppi kaavioiden luontiin. Käyttämätön luokka.
 * @author Jani Turpeinen
 * @version 0.1 5/2020
 */

public class charts extends AppCompatActivity {
    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);

        barChart = findViewById(R.id.barChart);
        ArrayList<Paivaus> paivaukset= Paivaus.loadall(getApplicationContext());
        List<BarEntry> entries = new ArrayList<>();
        int i= 1;
        for (Paivaus p:paivaukset
             ) {entries.add(new BarEntry(i,p.getSleep()));
                i++;
        }




        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        BarData data = new BarData(set);
        data.setBarWidth(0.9f);
        barChart.setData(data);
        barChart.setFitBars(true);
        barChart.invalidate();

    }
}
