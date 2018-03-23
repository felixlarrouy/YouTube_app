
package com.example.felixlarrouy.youtube.models.YTComments;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class YTCommentResult {

    @SerializedName("items")
    private List<Comment> mComments = null;

    public List<Comment> getComments() {
        return mComments;
    }

}
