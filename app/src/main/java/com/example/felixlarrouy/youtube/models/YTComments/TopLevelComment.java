
package com.example.felixlarrouy.youtube.models.YTComments;

import com.google.gson.annotations.SerializedName;

public class TopLevelComment {

    @SerializedName("snippet")
    private SnippetDetails mSnippetDetails;

    public SnippetDetails getSnippetDetails() {
        return mSnippetDetails;
    }

}
