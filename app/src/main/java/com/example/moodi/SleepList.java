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

public class SleepList extends AppCompatActivity {

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
