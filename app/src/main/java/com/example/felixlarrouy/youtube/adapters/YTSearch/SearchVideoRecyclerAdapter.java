package com.example.felixlarrouy.youtube.adapters.YTSearch;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.felixlarrouy.youtube.R;
import com.example.felixlarrouy.youtube.models.YTSearch.SearchVideo;
import com.example.felixlarrouy.youtube.viewholders.SearchVideoViewHolder;

import java.util.List;

/**
 * Created by felixlarrouy on 01/03/2018.
 */

public class SearchVideoRecyclerAdapter extends RecyclerView.Adapter<SearchVideoViewHolder> {

    private final List<SearchVideo> mSearchVideos;
    private final OnSearchVideoClickListener mListener;

    public SearchVideoRecyclerAdapter(List<SearchVideo> searchVideos, OnSearchVideoClickListener listener) {
        this.mSearchVideos = searchVideos;
        this.mListener = listener;
    }

    @Override
    public SearchVideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SearchVideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_search_video, parent, false), parent.getContext());
    }

    @Override
    public void onBindViewHolder(SearchVideoViewHolder holder, int position) {
        holder.bind(mSearchVideos.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mSearchVideos != null ? mSearchVideos.size() : 0;
    }
}
