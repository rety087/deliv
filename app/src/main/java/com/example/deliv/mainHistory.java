package com.example.deliv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class mainHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);


        SimpleAdapter ad;


        ListView listView = (ListView) findViewById(R.id.listhis);

        List<Map<String, String>> Mydatalist = null;
        HistoryActivity MyData = new HistoryActivity();
        Mydatalist = MyData.getlist();

        String[] Fromw = {"dadd", "name"};
        int[] Tow = {R.id.dadd, R.id.name};
        ad = new SimpleAdapter(mainHistory.this, Mydatalist, R.layout.his_activity, Fromw, Tow);
        listView.setAdapter(ad);


    }
}
