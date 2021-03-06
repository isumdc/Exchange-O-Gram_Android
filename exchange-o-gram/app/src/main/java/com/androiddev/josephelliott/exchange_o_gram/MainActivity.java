package com.androiddev.josephelliott.exchange_o_gram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.JacksonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Callback<List<Post>> {

    private GridView gridView;
    private PostAdapter postAdapter;

    private List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posts = new ArrayList<>();
        postAdapter = new PostAdapter(this, posts);

        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(postAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Post post = postAdapter.getItem(position);
                Toast.makeText(MainActivity.this, "Author: " + post.getAuthor(),
                        Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadPosts();
    }

    private void loadPosts() {
        setProgressBarIndeterminateVisibility(true);
        String url = getString(R.string.api_url);

        /*
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        ExchangeOGramAPI exchangeOGramAPI = retrofit.create(ExchangeOGramAPI.class);

        Call<List<Post>> call = exchangeOGramAPI.loadPosts();
        //asynchronous call
        call.enqueue(this);
    }

    public void goToCameraActivity(View v) {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResponse(Response<List<Post>> response) {
        setProgressBarIndeterminateVisibility(false);
        posts = response.body();
        postAdapter.setNewPosts(posts);
        //postAdapter = new PostAdapter(this, posts);
        //gridView.setAdapter(postAdapter);
        //postAdapter.notifyDataSetChanged();
        //gridView.invalidateViews();
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
}
