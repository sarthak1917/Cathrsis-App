package com.example.sarthak.cathapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.sarthak.cathapp.adapter.ResultAdapter;
import com.example.sarthak.cathapp.model.EventData;

import java.util.ArrayList;

public class ResultListActivity extends AppCompatActivity {

    ListView lv;
    ResultAdapter adapter;
    ArrayList<EventData> dataList;

    private void initViews(){
        lv=(ListView)findViewById(R.id.resultListView);
        dataList=new ArrayList<>();
        adapter=new ResultAdapter(this,R.layout.result_list_item,dataList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_list);

        initViews();
        setData();
        lv.setAdapter(adapter);
    }

    private void setData(){
        dataList.add(new EventData(R.drawable.slwocycle,"Slow Cycling : Winners","Aditya Singh"));
        dataList.add(new EventData(R.drawable.mathki_phod,"Matki Phod : Winners","Kapil Teotia and Amit Mann"));
        dataList.add(new EventData(R.drawable.mrfit,"Mr Fit : Winners","Satwic"));
        dataList.add(new EventData(R.drawable.ecohunt,"Eco Hunt : Winners","Anubhav and Satyam"));
        dataList.add(new EventData(R.drawable.minimiltia,"Mini Miltia : Winners","Yatin Maheshwari"));
        dataList.add(new EventData(R.drawable.tvmaniac,"TV Maniac : Winners","Vivek Rai"));
        dataList.add(new EventData(R.drawable.ecoquiz,"Eco Quiz : Winners","Saurabh"));

    }
}
