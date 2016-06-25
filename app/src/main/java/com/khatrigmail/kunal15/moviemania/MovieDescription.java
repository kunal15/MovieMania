package com.khatrigmail.kunal15.moviemania;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDescription extends AppCompatActivity {
    TextView title,description,votes,releaseDate,popularity;
    ImageView image1,image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_description);
        assign();
        Intent i =getIntent();
        title.setText(i.getStringExtra("Title").toUpperCase());

        description.setText(i.getStringExtra("Info"));
        votes.setText("Votes : " + Integer.toString(i.getIntExtra("Votes", 0)));
        popularity.setText("Popularity : " +  Integer.toString(i.getIntExtra("Popularity", 100)));
        releaseDate.setText("Release Date : " + i.getStringExtra("Release"));
        Picasso.with(this).load(i.getStringExtra("Image")).into(image1);
        Picasso.with(this).load(i.getStringExtra("Image2")).into(image2);
    }
    public void assign(){
        title = (TextView) findViewById(R.id.tvTitle);
        description = (TextView) findViewById(R.id.tvInfo);
        votes = (TextView) findViewById(R.id.tvVotes);
        releaseDate = (TextView) findViewById(R.id.tvReleaseDate);
        popularity = (TextView) findViewById(R.id.tvPopularity);
        image1 = (ImageView) findViewById(R.id.ivImage);
        image2 = (ImageView) findViewById(R.id.ivImage2);

    }
}
