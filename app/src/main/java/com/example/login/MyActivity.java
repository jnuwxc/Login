package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        int[] dataX = {1, 2, 3, 4, 5, 6};
        float[] dataY = {3.1f, 3.5f, 0, 2.9f, 4.5f, 3.4f};

        List<Entry> entries = new ArrayList<>();
        for(int i = 0; i < dataX.length; i++){
            entries.add(new Entry(dataX[i], dataY[i]));
        }
        LineDataSet dataSet = new LineDataSet(entries, "label");

        LineChart lineChart = findViewById(R.id.lineChart);
        lineChart.setData(new LineData(dataSet));
    }
}