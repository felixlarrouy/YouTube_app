package com.example.felixlarrouy.youtube.models.YTSearch;

import com.google.gson.annotations.SerializedName;

/**
 * Created by felixlarrouy on 01/03/2018.
 */

public class Id {

    @SerializedName("videoId")
    private String videoId;

    public String getVideoId() {
        return videoId;
    }
}
