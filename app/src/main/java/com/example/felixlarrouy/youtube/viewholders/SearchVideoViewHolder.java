package com.example.felixlarrouy.youtube.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.felixlarrouy.youtube.R;
import com.example.felixlarrouy.youtube.adapters.YTSearch.OnSearchVideoClickListener;
import com.example.felixlarrouy.youtube.models.YTSearch.SearchVideo;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by felixlarrouy on 01/03/2018.
 */

public class SearchVideoViewHolder extends RecyclerView.ViewHolder {

    private Context context;
    @BindView(R.id.preview) ImageView preview;
    @BindView(R.id.channelPreview) ImageView channelPreview;
    @BindView(R.id.videoName) TextView videoName;
    @BindView(R.id.channelName) TextView channelName;
    @BindView(R.id.publicationDate) TextView publishedAt;

    public SearchVideoViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        ButterKnife.bind(this, itemView);
    }

    public void bind(final SearchVideo searchVideo, final OnSearchVideoClickListener listener) {
        Picasso.with(context)
                .load(searchVideo.getSnippet().getThumbnails().getHigh().getUrl())
                .fit()
                .centerCrop()
                .into(preview);

        videoName.setText(searchVideo.getSnippet().getTitle());
        channelName.setText(searchVideo.getSnippet().getChannelTitle());
        publishedAt.setText(searchVideo.getSnippet().getPublishedAt());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSearchVideoClick(searchVideo);
            }
        });
    }
}
