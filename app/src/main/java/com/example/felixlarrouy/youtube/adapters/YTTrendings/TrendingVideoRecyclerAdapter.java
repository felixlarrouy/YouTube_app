package com.example.felixlarrouy.youtube.adapters.YTTrendings;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.felixlarrouy.youtube.R;
import com.example.felixlarrouy.youtube.models.YTTrendings.TrendingVideo;
import com.example.felixlarrouy.youtube.viewholders.TrendingVideoViewHolder;

import java.util.List;

/**
 * Created by felixlarrouy on 08/03/2018.
 */

public class TrendingVideoRecyclerAdapter extends RecyclerView.Adapter<TrendingVideoViewHolder> {
    private final List<TrendingVideo> mTrendingVideos;
    private final OnTrendingVideoClickListener mListener;

    public TrendingVideoRecyclerAdapter(List<TrendingVideo> trendingVideos, OnTrendingVideoClickListener listener) {
        this.mTrendingVideos = trendingVideos;
        this.mListener = listener;
    }

    @Override
    public TrendingVideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TrendingVideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_trending_video, parent, false), parent.getContext());
    }

    @Override
    public void onBindViewHolder(TrendingVideoViewHolder holder, int position) {
        holder.bind(mTrendingVideos.get(position), mListener, position);
    }

    @Override
    public int getItemCount() {
        return mTrendingVideos != null ? mTrendingVideos.size() : 0;
    }
}
