package com.example.felixlarrouy.youtube.models.YTTrendings;

import com.example.felixlarrouy.youtube.models.Snippet;
import com.google.gson.annotations.SerializedName;

/**
 * Created by felixlarrouy on 08/03/2018.
 */

public class TrendingVideo {

    @SerializedName("id")
    private String id;

    @SerializedName("snippet")
    private Snippet snippet;

    public String getId() {
        return id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

}
