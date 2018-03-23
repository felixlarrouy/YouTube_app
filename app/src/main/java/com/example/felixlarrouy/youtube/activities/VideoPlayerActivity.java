package com.example.felixlarrouy.youtube.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.felixlarrouy.youtube.R;
import com.example.felixlarrouy.youtube.adapters.YTComment.CommentRecyclerAdapter;
import com.example.felixlarrouy.youtube.models.YTComments.YTCommentResult;
import com.example.felixlarrouy.youtube.remote.ApiUtils;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoPlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private RecyclerView recyclerView;

    private TextView mDescriptionText;
    private TextView mVideoTitle;
    private TextView mChannelTitle;

    public static final String API_KEY = "AIzaSyAkHKF0HthLihLZyJoUerolm_2xi-0nLZE";

    //https://www.youtube.com/watch?v=<VIDEO_ID>
    public static String VIDEO_ID = "VIDEO_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        mDescriptionText = findViewById(R.id.description);
        mVideoTitle = findViewById(R.id.videoPlayerTitle);
        mChannelTitle = findViewById(R.id.videoPlayerChannelTitle);

        // Initializing YouTube player view
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(API_KEY, this);

        initializeRecyclerView();
        Log.d("Create", "Initialisation done");

        mVideoTitle.setText(getIntent().getStringExtra(MainActivity.BUNDLE_VIDEO_TITLE));
        mDescriptionText.setText(getIntent().getStringExtra(MainActivity.BUNDLE_VIDEO_DESCRIPTION));
        mChannelTitle.setText(getIntent().getStringExtra(MainActivity.BUNDLE_CHANNEL_TITLE));
        mDescriptionText.setMovementMethod(new ScrollingMovementMethod());

        // Get the id from MainActivity
        VIDEO_ID = getIntent().getStringExtra(MainActivity.BUNDLE_VIDEO_ID);
        getComment(VIDEO_ID);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if(null == youTubePlayer) return;

        // Start buffering
        if (!wasRestored) {
            youTubePlayer.loadVideo(VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failed to initialize.", Toast.LENGTH_LONG).show();
    }

    private void initializeRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView_comment);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void getComment(String video_id) {
        final Call<YTCommentResult> ytCommentResult = ApiUtils.getYTService().getComments(video_id);
        ytCommentResult.enqueue(new Callback<YTCommentResult>() {
            @Override
            public void onResponse(Call<YTCommentResult> call, Response<YTCommentResult> response) {
                YTCommentResult apiResponse = response.body();
                CommentRecyclerAdapter adapter = new CommentRecyclerAdapter(apiResponse.getComments());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<YTCommentResult> call, Throwable t) {
                Toast.makeText(VideoPlayerActivity.this, "An error occured", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
