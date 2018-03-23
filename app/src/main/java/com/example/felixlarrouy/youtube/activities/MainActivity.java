package com.example.felixlarrouy.youtube.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.felixlarrouy.youtube.R;
import com.example.felixlarrouy.youtube.adapters.YTSearch.OnSearchVideoClickListener;
import com.example.felixlarrouy.youtube.adapters.YTSearch.SearchVideoRecyclerAdapter;
import com.example.felixlarrouy.youtube.adapters.YTTrendings.OnTrendingVideoClickListener;
import com.example.felixlarrouy.youtube.adapters.YTTrendings.TrendingVideoRecyclerAdapter;
import com.example.felixlarrouy.youtube.models.YTSearch.SearchVideo;
import com.example.felixlarrouy.youtube.models.YTSearch.YTSearchResult;
import com.example.felixlarrouy.youtube.models.YTTrendings.TrendingVideo;
import com.example.felixlarrouy.youtube.models.YTTrendings.YTTrendingResult;
import com.example.felixlarrouy.youtube.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private EditText mSearchText;

    public static final String BUNDLE_VIDEO_ID = "BUNDLE_VIDEO_ID";
    public static final String BUNDLE_VIDEO_DESCRIPTION = "BUNDLE_VIDEO_DESCRIPTION";
    public static final String BUNDLE_VIDEO_TITLE = "BUNDLE_VIDEO_TITLE";
    public static final String BUNDLE_CHANNEL_TITLE = "BUNDLE_CHANNEL_TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get elements from xml file
        mSearchText = findViewById(R.id.search_text);
        mSearchText.setVisibility(View.GONE);

        // Link variables to listeners
        mSearchText.setOnKeyListener(onEnterClickListener);

        initializeRecyclerView();
        getTrendings("US");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_youtube, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_back:
                getTrendings("US");
                mSearchText.setText("");
                mSearchText.setVisibility(View.GONE);
                return true;
            case R.id.action_search:
                mSearchText.setVisibility(View.VISIBLE);
                mSearchText.requestFocus();
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
        }
        return super.onOptionsItemSelected(item);
    }

    View.OnKeyListener onEnterClickListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event.getAction()!=KeyEvent.ACTION_DOWN)
                return false;
            if(keyCode == KeyEvent.KEYCODE_ENTER ){
                String search = mSearchText.getText().toString();

                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                getSearchResults(search);

                mSearchText.setText("");
                mSearchText.setVisibility(View.GONE);
                return true;
            }
            return false;
        }
    };

    private void initializeRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void getTrendings(String regionCode) {
        final Call<YTTrendingResult> ytTrendingResult = ApiUtils.getYTService().getTrendings(regionCode);
        ytTrendingResult.enqueue(new Callback<YTTrendingResult>() {
            @Override
            public void onResponse(Call<YTTrendingResult> call, Response<YTTrendingResult> response) {
                YTTrendingResult apiResponse = response.body();
                TrendingVideoRecyclerAdapter adapter = new TrendingVideoRecyclerAdapter(apiResponse.getTrendingVideos(), new OnTrendingVideoClickListener() {
                    @Override
                    public void onTrendingVideoClick(TrendingVideo item) {
                        Intent videoPlayerActivityIntent = new Intent(MainActivity.this, VideoPlayerActivity.class);
                        videoPlayerActivityIntent.putExtra(BUNDLE_VIDEO_ID, item.getId());
                        videoPlayerActivityIntent.putExtra(BUNDLE_VIDEO_DESCRIPTION, item.getSnippet().getDescription());
                        videoPlayerActivityIntent.putExtra(BUNDLE_VIDEO_TITLE, item.getSnippet().getTitle());
                        videoPlayerActivityIntent.putExtra(BUNDLE_CHANNEL_TITLE, item.getSnippet().getChannelTitle());
                        startActivity(videoPlayerActivityIntent);
                    }
                });
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<YTTrendingResult> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occured", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getSearchResults(String keyword) {
        Call<YTSearchResult> ytSearchResult = ApiUtils.getYTService().getVideos(keyword);
        ytSearchResult.enqueue(new Callback<YTSearchResult>() {
            @Override
            public void onResponse(Call<YTSearchResult> call, Response<YTSearchResult> response) {
                YTSearchResult apiResponse = response.body();
                SearchVideoRecyclerAdapter adapter = new SearchVideoRecyclerAdapter(apiResponse.getSearchVideos(), new OnSearchVideoClickListener() {
                    @Override
                    public void onSearchVideoClick(SearchVideo item) {
                        Intent videoPlayerActivityIntent = new Intent(MainActivity.this, VideoPlayerActivity.class);
                        videoPlayerActivityIntent.putExtra(BUNDLE_VIDEO_ID, item.getId().getVideoId());
                        videoPlayerActivityIntent.putExtra(BUNDLE_VIDEO_DESCRIPTION, item.getSnippet().getDescription());
                        videoPlayerActivityIntent.putExtra(BUNDLE_VIDEO_TITLE, item.getSnippet().getTitle());
                        videoPlayerActivityIntent.putExtra(BUNDLE_CHANNEL_TITLE, item.getSnippet().getChannelTitle());
                        startActivity(videoPlayerActivityIntent);
                    }
                });
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<YTSearchResult> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occured", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
