package com.example.moodi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }
    public void mainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void barChart(View view) {
        Intent intent = new Intent(this, BarChartActivity.class);
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
