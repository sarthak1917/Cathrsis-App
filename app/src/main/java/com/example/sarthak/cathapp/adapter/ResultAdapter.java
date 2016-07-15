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
 * Created by Sarthak on 4/14/2016.
 */
public class ResultAdapter extends ArrayAdapter<EventData> {

    ArrayList<EventData> dataList;
    Context ctx;

    public ResultAdapter(Context context, int resource, ArrayList<EventData> objects) {
        super(context, resource, objects);
        dataList=objects;
        ctx=context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View myView= LayoutInflater.from(ctx).inflate(R.layout.result_list_item,parent,false);
        TextView txtName= (TextView)myView.findViewById(R.id.textViewResultEventName);
        TextView txtDescp=(TextView)myView.findViewById(R.id.textViewWinners);
        ImageView iv=(ImageView)myView.findViewById(R.id.imageViewEventName);

        iv.setImageResource(dataList.get(position).getImage());
        txtName.setText(dataList.get(position).getName());
        txtDescp.setText(dataList.get(position).getDescp());

        return  myView;
    }

}
