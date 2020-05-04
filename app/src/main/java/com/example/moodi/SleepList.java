package com.example.moodi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Luokka sisältää
 * @author
 * @version 0.1 5/2020
 */
public class SleepList extends AppCompatActivity {
    /**
     * Luokka näyttää listana päivämäärät, mistä käyttäjä voi napauttaa päivämäärää mikä näyttää
     * arvot mitkä käyttäjä oli sinä päivänä syöttänyt. Tämä luokka ei ehtinyt valmistua.
     * @author Jani Turpeinen
     * @version 0.1 5/2020
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_list);
        final ListView lv = findViewById(R.id.tvList);
        ///data/data/com.example.moodi/files

        //ArrayList<SleepList> sleepList = new ArrayList<>();
        //try (Scanner s = new Scanner(new File()))


    }
}
