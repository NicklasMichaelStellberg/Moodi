package com.example.moodi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Luokka näyttää käyttäjän syöttämien arvojen keskiarvon.
 * @author Nicklas Stellberg
 * @version 0.1 5/2020
 */

public class AverageDay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_day);
        ArrayList<Paivaus> paivaukset= Paivaus.loadall(getApplicationContext());
        List<BarEntry> entries = new ArrayList<>();
        /**
         * Laskee unen keskiarvon
         */
        int s= 1;
        for (Paivaus p:paivaukset
        ) {entries.add(new BarEntry(s,p.getSleep()));
            s++;
        }
        int unilaskuri= 0;//keskarin lasku
        for (Paivaus p:paivaukset
        ) {
            unilaskuri+=p.getSleep();
        }
        double unikeskari=(double)unilaskuri/(double)paivaukset.size();
        TextView uniTv = (TextView) findViewById(R.id.sleepTv);
        uniTv.setText(""+unikeskari);

        /**
         * Laskee masentuneisuuden keskiarvon
         */
        int d= 1;
        for (Paivaus p:paivaukset
        ) {entries.add(new BarEntry(s,p.getDepression()));
            d++;
        }
        int masislaskuri= 0;//keskarin lasku
        for (Paivaus p:paivaukset
        ) {
            masislaskuri+=p.getDepression();
        }
        double masiskeskari=(double)masislaskuri/(double)paivaukset.size();
        TextView depressionTv = (TextView) findViewById(R.id.depressionTv);
        depressionTv.setText(""+masiskeskari);

        /**
         * Laskee kiihtyneisyyden keskiarvon
         */
        int ag= 1;
        for (Paivaus p:paivaukset
        ) {entries.add(new BarEntry(ag,p.getAgitation()));
            ag++;
        }
        int kiihtyneisyyslaskuri= 0;//keskarin lasku
        for (Paivaus p:paivaukset
        ) {
            kiihtyneisyyslaskuri+=p.getAgitation();
        }
        double kiihtyneisyyskeskari=(double)kiihtyneisyyslaskuri/(double)paivaukset.size();
        TextView agitationTv = (TextView) findViewById(R.id.agitationTv);
        agitationTv.setText(""+kiihtyneisyyskeskari);

        /**
         * Laskee ärsytyksen keskiarvon
         */
        int i= 1;
        for (Paivaus p:paivaukset
        ) {entries.add(new BarEntry(i,p.getIrritation()));
            i++;
        }
        int arsytyslaskuri= 0;//keskarin lasku
        for (Paivaus p:paivaukset
        ) {
            arsytyslaskuri+=p.getIrritation();
        }
        double arsytyskeskari=(double)arsytyslaskuri/(double)paivaukset.size();
        TextView irritationTv = (TextView) findViewById(R.id.irritationTv);
        irritationTv.setText(""+arsytyskeskari);

        /**
         * Laskee ahdistuksen keskiarvon
         */
        int an= 1;
        for (Paivaus p:paivaukset
        ) {entries.add(new BarEntry(i,p.getAnxiety()));
            an++;
        }
        int ahdistuslaskuri= 0;//keskarin lasku
        for (Paivaus p:paivaukset
        ) {
            ahdistuslaskuri+=p.getAnxiety();
        }
        double ahdistuskeskari=(double)ahdistuslaskuri/(double)paivaukset.size();
        TextView anxietyTv = (TextView) findViewById(R.id.anxietyTv);
        anxietyTv.setText(""+ahdistuskeskari);
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
    public void pieChart(View view) {
        Intent intent = new Intent(this, PieChartActivity.class);
        startActivity(intent);
    }
    public void info(View view) {
        Intent intent = new Intent(this, Info.class);
        startActivity(intent);
    }

}
