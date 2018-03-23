package com.example.felixlarrouy.youtube.adapters.YTComment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.felixlarrouy.youtube.R;
import com.example.felixlarrouy.youtube.models.YTComments.Comment;
import com.example.felixlarrouy.youtube.viewholders.CommentViewHolder;

import java.util.List;

/**
 * Created by felixlarrouy on 15/03/2018.
 */

public class CommentRecyclerAdapter extends RecyclerView.Adapter<CommentViewHolder> {

    private final List<Comment> mComments;

    public CommentRecyclerAdapter(List<Comment> comments) {
        this.mComments = comments;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_comment, parent, false), parent.getContext());
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        holder.bind(mComments.get(position));
    }

    @Override
    public int getItemCount() {
        return mComments != null ? mComments.size() : 0;
    }
}
