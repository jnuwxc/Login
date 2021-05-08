package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MyActivity extends AppCompatActivity {

    private LineChart lineChart;
    private BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        getSupportActionBar().hide();

        barChart = findViewById(R.id.barChart);
        lineChart = findViewById(R.id.lineChart);
        setBarChart();
        setLineChart();
    }

    private void setBarChart(){
        int[] dataX = {1, 2, 3, 4, 5, 6, 7};
        float[] dataY = {3.1f, 3.5f, 0, 2.9f, 4.5f, 3.4f, 0};

        List<BarEntry> entries = new ArrayList<>();
        for(int i = 0; i < dataX.length; i++){
            entries.add(new BarEntry(dataX[i], dataY[i]));
        }
        BarDataSet dataSet = new BarDataSet(entries, "test");
        BarData data = new BarData(dataSet);


        barChart.setData(data);
        barChart.invalidate();
    }

    private void setLineChart(){
//        int daysOfMonth = getDaysOfMonth(new Date());
//        int[] dataX = new int[daysOfMonth];
//        for(int i = 0; i < daysOfMonth; i++){
//            dataX[i] = i;
//        }
        int[]  dataX = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int[] dataY1 = {2, 1, 0, 1, 1, 0, 1, 0, 2, 1, 1, 1, 1, 1};
        int[] dataY2 = {1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1};

        List<Entry> entries1 = new ArrayList<>();
        for(int i = 0; i < dataX.length; i++){
            entries1.add(new BarEntry(dataX[i], dataY1[i]));
        }
        LineDataSet lineDataSet1 = new LineDataSet(entries1, "label1");

        List<Entry> entries2 = new ArrayList<>();
        for(int i = 0; i < dataX.length; i++){
            entries2.add(new BarEntry(dataX[i], dataY2[i]));
        }
        LineDataSet lineDataSet2 = new LineDataSet(entries2, "label2");

        LineData lineData = new LineData(lineDataSet1, lineDataSet2);
        lineChart.setData(lineData);
        lineChart.invalidate();
    }


    private int getDaysOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}