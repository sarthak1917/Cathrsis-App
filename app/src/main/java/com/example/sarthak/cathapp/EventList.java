package com.example.sarthak.cathapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sarthak.cathapp.adapter.EventAdapter;
import com.example.sarthak.cathapp.model.EventData;

import java.util.ArrayList;

public class EventList extends AppCompatActivity {

    ListView lv;
    EventAdapter adapter;
    ArrayList<EventData> dataList;

    private void initViews(){
        lv=(ListView)findViewById(R.id.myListView);
        dataList=new ArrayList<>();
        adapter=new EventAdapter(this,R.layout.list_item,dataList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        initViews();
        setData();
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                switch(dataList.get(position).getName()){
                    case "Slow Cycling":
                        i=new Intent(EventList.this,ResultActivity.class);
                        i.putExtra("url","https://www.facebook.com/catharsis15/?fref=ts");
                        i.putExtra("check",1);
                        startActivity(i);
                        break;
                    case "Eco Click":
                        i=new Intent(EventList.this,ResultActivity.class);
                        i.putExtra("url","https://www.facebook.com/events/990025461078901/");
                        i.putExtra("check",1);
                        startActivity(i);
                        break;
                    case "Eco Quiz":
                        i=new Intent(EventList.this,ResultActivity.class);
                        i.putExtra("url","https://www.facebook.com/events/206077139770763/");
                        i.putExtra("check",1);
                        startActivity(i);
                        break;
                    case "Speak-O-Speak":
                        i=new Intent(EventList.this,ResultActivity.class);
                        i.putExtra("url","https://www.facebook.com/events/1725846907659348/");
                        i.putExtra("check",1);
                        startActivity(i);
                        break;
                    case "Scavenger Hunt":
                        i=new Intent(EventList.this,ResultActivity.class);
                        i.putExtra("url","https://www.facebook.com/events/375765722593647/");
                        i.putExtra("check",1);
                        startActivity(i);
                        break;
                    case "Mini Miltia":
                        i=new Intent(EventList.this,ResultActivity.class);
                        i.putExtra("url","https://www.facebook.com/catharsis15/?fref=ts");
                        i.putExtra("check",1);
                        startActivity(i);
                        break;
                    case "Workshop":
                        i=new Intent(EventList.this,ResultActivity.class);
                        i.putExtra("url","https://www.facebook.com/events/220842108274218/");
                        i.putExtra("check",1);
                        startActivity(i);
                        break;
                    case "Zorbing":
                        i=new Intent(EventList.this,ResultActivity.class);
                        i.putExtra("url","https://www.facebook.com/catharsis15/?fref=ts");
                        i.putExtra("check",1);
                        startActivity(i);
                        break;
                    case "Dart Throw":
                        i=new Intent(EventList.this,ResultActivity.class);
                        i.putExtra("url","https://www.facebook.com/catharsis15/?fref=ts");
                        i.putExtra("check",1);
                        startActivity(i);
                        break;
                    case "Blits Chess":
                        i=new Intent(EventList.this,ResultActivity.class);
                        i.putExtra("url","https://www.facebook.com/catharsis15/?fref=ts");
                        i.putExtra("check",1);
                        startActivity(i);
                        break;
                    case "Mr. Fit":
                        i=new Intent(EventList.this,ResultActivity.class);
                        i.putExtra("url","https://www.facebook.com/catharsis15/?fref=ts");
                        i.putExtra("check",1);
                        startActivity(i);
                        break;
                    case "TV Maniac":
                        i=new Intent(EventList.this,ResultActivity.class);
                        i.putExtra("url","https://www.facebook.com/catharsis15/?fref=ts");
                        i.putExtra("check",1);
                        startActivity(i);
                        break;
                    case "Shero Shayari":
                        i=new Intent(EventList.this,ResultActivity.class);
                        i.putExtra("url","https://www.facebook.com/events/1558294777801990/");
                        i.putExtra("check",1);
                        startActivity(i);
                        break;
                    case "Blobby Baloon":
                        i=new Intent(EventList.this,ResultActivity.class);
                        i.putExtra("url","https://www.facebook.com/events/956687874415090/");
                        i.putExtra("check",1);
                        startActivity(i);
                        break;
                }
            }
        });
    }

    private void setData(){
        dataList.add(new EventData(R.drawable.slwocycle,"Slow Cycling","A slow cycling yo guys"));
        dataList.add(new EventData(R.drawable.eco_click,"Eco Click","click and win"));
        dataList.add(new EventData(R.drawable.ecoquiz,"Eco Quiz","A quiz on nature"));
        dataList.add(new EventData(R.drawable.ecohunt,"Eco Hunt","hunt and find the hints"));
        dataList.add(new EventData(R.drawable.scavanger_hunt,"Scavenger Hunt","its all about hunting"));

        dataList.add(new EventData(R.drawable.minimiltia,"Mini Miltia","welcoming all gamers"));
        dataList.add(new EventData(R.drawable.workshop,"Workshop","Come and attend the Environmental Awareness Workshop by Dr. KALPNA from IIT DELHI and know how to preserve our mother nature."));
        dataList.add(new EventData(R.drawable.zorbing,"Zorbing","enjoy the ride"));
        dataList.add(new EventData(R.drawable.dartthrow,"Dart Throw","Show your shooting skills"));
        dataList.add(new EventData(R.drawable.mathki_phod,"Matki phod","Are u a krishna...?"));

        dataList.add(new EventData(R.drawable.mrfit,"Mr. Fit","welcoming all Finess freaks"));
        dataList.add(new EventData(R.drawable.tvmaniac,"TV Maniac","lets see who knows more"));
        dataList.add(new EventData(R.drawable.sher_shyari,"Shero Shayari","sing a song "));
        dataList.add(new EventData(R.drawable.happy,"Blobby Baloon","Burst the balloons with pin, the one who does the same in the least time will win."));


    }
}
