package com.example.fetchdatafromjson.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fetchdatafromjson.adapter.CustomAdapter;
import com.example.fetchdatafromjson.databinding.ActivityMainBinding;
import com.example.fetchdatafromjson.model.ImageModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String url = "https://jsonplaceholder.typicode.com/photos";

        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {
            try {

                List<ImageModel> listItems = new ArrayList<>();

                JSONArray jsonArray = new JSONArray(response);
                for (int i = 0; i < jsonArray.length(); ++i) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int id = jsonObject.getInt("id");
                    String title = jsonObject.getString("title");
                    String imageUrl = jsonObject.getString("url");
                    String thumbnailUrl = jsonObject.getString("thumbnailUrl");
                    ImageModel imageModel = new ImageModel(id, title, imageUrl, thumbnailUrl);
                    listItems.add(imageModel);
                }

                CustomAdapter adapter = new CustomAdapter(this, listItems);
                recyclerView.setAdapter(adapter);

            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }, error -> Log.i("Error", error.toString()));

        Volley.newRequestQueue(this).add(request);
    }
}