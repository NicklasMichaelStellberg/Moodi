package com.example.moodi;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

public class charts extends AppCompatActivity {
    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);

        barChart = findViewById(R.id.barChart);
        BarDataSet barDataSet = new BarDataSet(barChartDataSet(), "data set");
        ArrayList<IBarDataSet> iBarDataSets = new ArrayList<>();
        iBarDataSets.add(barDataSet);

        BarData barData = new BarData(iBarDataSets);
        barChart.setData(barData);
        barChart.invalidate();
    }

    private ArrayList<BarEntry> barChartDataSet(){
        ArrayList<BarEntry> dataSet = new ArrayList<>();

        dataSet.add(new BarEntry(0,8));
        dataSet.add(new BarEntry(1,9));
        dataSet.add(new BarEntry(2,5));
        dataSet.add(new BarEntry(3,7));
        dataSet.add(new BarEntry(4,7));
        return dataSet;
    }
}
