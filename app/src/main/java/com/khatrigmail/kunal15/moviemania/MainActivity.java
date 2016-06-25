package com.khatrigmail.kunal15.moviemania;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gv;
    private String API_KEY = "69961736ee88b39584ba695c3da7a759";
    private int page_number = 1;
    private String FEED_URL = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=" + API_KEY + "&page=" + "" + page_number;


    int[] arr = {R.drawable.images, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    String[] str = {"Civil War", "Dead Pool", "Escape Plan", "Batman"};
    ArrayList<Data> db = new ArrayList<>();
    CustomAdapter c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView) findViewById(R.id.grid_view);
        getData();
        c = new CustomAdapter(db,MainActivity.this);
        gv.setAdapter(c);
    }

    public void getData() {
        Log.d("MainActivity", "MainMethod");
        String url = FEED_URL;
        Log.d("MainActivity", "URL: " + url);

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject obj = null;
                try {
                    obj = new JSONObject(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONArray jsonArray = obj.optJSONArray("results");
                Data item;
                Log.d("MainActivity", "Response: " + response);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject post = jsonArray.optJSONObject(i);
                    String title = post.optString("original_title");
                    item = new Data();
                    item.setImageName(title);
                    String image = post.optString("poster_path");
                    image = "http://image.tmdb.org/t/p/w500/"+image.substring(1);
                    item.setImage(image);
                    String backdrop = post.optString("backdrop_path");
                    backdrop = "http://image.tmdb.org/t/p/w500/"+backdrop.substring(1);
                    item.setBackdrop(backdrop);
                    int id = post.optInt("id");
                    item.setId(id);
                    String release_date = post.optString("release_date");
                    item.setRelease_date(release_date);
                    String adult = post.optString("adult");
                    item.setAdult(adult);
                    String overview = post.optString("overview");
                    item.setOverview(overview);
                    String original_language = post.optString("original_language");
                    item.setOriginal_language(original_language);
                    int vote_count = post.optInt("vote_count");
                    item.setVote_count(vote_count);
                    double popularity = post.optDouble("popularity");
                    item.setPopularity(popularity);
                    double vote_average = post.optDouble("vote_average");
                    item.setVote_average(vote_average);
                    db.add(item);
                }
                c = new CustomAdapter(db,getApplicationContext());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "asdfghjk" + error + "   ", Toast.LENGTH_SHORT).show();
            }
        });

        AppController.getInstance().addToRequestQueue(stringRequest, "req_login");
    }

}
