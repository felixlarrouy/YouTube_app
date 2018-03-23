
package com.example.felixlarrouy.youtube.models.YTComments;

import com.google.gson.annotations.SerializedName;

public class Comment {

    @SerializedName("snippet")
    private CommentSnippet mCommentSnippet;

    public CommentSnippet getCommentSnippet() {
        return mCommentSnippet;
    }

}
