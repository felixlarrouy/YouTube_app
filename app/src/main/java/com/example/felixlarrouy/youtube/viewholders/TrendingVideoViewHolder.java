package com.example.felixlarrouy.youtube.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.felixlarrouy.youtube.R;
import com.example.felixlarrouy.youtube.adapters.YTTrendings.OnTrendingVideoClickListener;
import com.example.felixlarrouy.youtube.models.YTTrendings.TrendingVideo;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by felixlarrouy on 08/03/2018.
 */

public class TrendingVideoViewHolder extends RecyclerView.ViewHolder {

    private Context context;
    @BindView(R.id.preview) ImageView preview;
    @BindView(R.id.videoName) TextView videoName;
    @BindView(R.id.channelName) TextView channelName;
    @BindView(R.id.publicationDate) TextView publishedAt;
    @BindView(R.id.rank) TextView trendingsRank;

    public TrendingVideoViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        ButterKnife.bind(this, itemView);
    }

    public void bind(final TrendingVideo trendingVideo, final OnTrendingVideoClickListener listener, int position) {
        Picasso.with(context)
                .load(trendingVideo.getSnippet().getThumbnails().getHigh().getUrl())
                .fit()
                .centerCrop()
                .into(preview);
        videoName.setText(trendingVideo.getSnippet().getTitle());
        channelName.setText(trendingVideo.getSnippet().getChannelTitle());
        publishedAt.setText(trendingVideo.getSnippet().getPublishedAt());
        position += 1;


        String rankText = "#" + position;
        trendingsRank.setText(rankText);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTrendingVideoClick(trendingVideo);
            }
        });
    }
}
