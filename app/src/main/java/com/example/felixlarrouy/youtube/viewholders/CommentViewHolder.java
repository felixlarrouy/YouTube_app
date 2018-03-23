package com.example.felixlarrouy.youtube.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.felixlarrouy.youtube.R;
import com.example.felixlarrouy.youtube.models.YTComments.Comment;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by felixlarrouy on 15/03/2018.
 */

public class CommentViewHolder extends RecyclerView.ViewHolder{

    private Context context;
    @BindView(R.id.author_picture) ImageView author_pic;
    @BindView(R.id.comment) TextView mComment;
    @BindView(R.id.channelNameComment) TextView channelName;
    @BindView(R.id.publicationDateComment) TextView publishedAt;

    public CommentViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Comment comment) {
        Picasso.with(context)
                .load(comment.getCommentSnippet().getTopLevelComment().getSnippetDetails().getAuthorProfileImageUrl())
                .resize(100, 100)
                .centerInside()
                .into(author_pic);

        mComment.setText(comment.getCommentSnippet().getTopLevelComment().getSnippetDetails().getTextOriginal());
        channelName.setText(comment.getCommentSnippet().getTopLevelComment().getSnippetDetails().getAuthorDisplayName());
        publishedAt.setText(comment.getCommentSnippet().getTopLevelComment().getSnippetDetails().getPublishedAt());
    }
}
