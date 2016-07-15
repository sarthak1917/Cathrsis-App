package com.example.sarthak.cathapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.sarthak.cathapp.R;
import com.example.sarthak.cathapp.model.EventData;
import java.util.ArrayList;

/**
 * Created by Sarthak on 4/5/2016.
 */
public class EventAdapter extends ArrayAdapter<EventData> {

    ArrayList<EventData> dataList;
    Context ctx;

    public EventAdapter(Context context, int resource, ArrayList<EventData> objects) {
        super(context, resource, objects);
        dataList=objects;
        ctx=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View myView= LayoutInflater.from(ctx).inflate(R.layout.list_item,parent,false);
        TextView txtName= (TextView)myView.findViewById(R.id.textViewEventName);
        TextView txtDescp=(TextView)myView.findViewById(R.id.textViewEventDescription);
        ImageView iv=(ImageView)myView.findViewById(R.id.imageViewList);

        iv.setImageResource(dataList.get(position).getImage());
        txtName.setText(dataList.get(position).getName());
        txtDescp.setText(dataList.get(position).getDescp());

        return  myView;
    }
}
