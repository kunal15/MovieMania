package com.khatrigmail.kunal15.moviemania;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Admin on 22-06-2016.
 */
public class CustomAdapter extends BaseAdapter {
    Context c;
    LayoutInflater inflater;
    ArrayList<Data> arr = new ArrayList<>();
    public CustomAdapter(ArrayList<Data> data,Context c){
        this.arr = data;
        this.c = c;
        inflater = ( LayoutInflater )c.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }


    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v;
        convertView = inflater.inflate(R.layout.gridview_layout,null);
        Log.d("CustomAdapter","We are here");
        final Holder h = new Holder();
        h.tv = (TextView) convertView.findViewById(R.id.tvMovieName);
        h.img = (ImageView) convertView.findViewById(R.id.ivMoviePoster);
        h.tv.setText(arr.get(position).getImageName());
        Picasso.with(c).load(arr.get(position).getImage()).into(h.img);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(c,"You clicked : " + arr.get(position).getImageName(),Toast.LENGTH_LONG).show();
                Intent i = new Intent(c,MovieDescription.class);
                i.putExtra("Title",arr.get(position).getImageName());
                i.putExtra("Image",arr.get(position).getBackdrop());
                i.putExtra("Info",arr.get(position).getOverview());
                i.putExtra("Votes",arr.get(position).getVote_count());
                i.putExtra("Popularity",arr.get(position).getPopularity());
                i.putExtra("Release",arr.get(position).getRelease_date());
                i.putExtra("Image2",arr.get(position).getImage());
                c.startActivity(i);
            }
        });
        return convertView;
    }
    public class Holder
    {
        TextView tv;
        ImageView img;
    }

}

