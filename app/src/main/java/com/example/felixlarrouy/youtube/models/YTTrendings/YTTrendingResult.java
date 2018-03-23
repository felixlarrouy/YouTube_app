package com.example.felixlarrouy.youtube.models.YTTrendings;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by felixlarrouy on 08/03/2018.
 */

public class YTTrendingResult {

    @SerializedName("items")
    private List<TrendingVideo> items = null;

    public List<TrendingVideo> getTrendingVideos() {
        return items;
    }

}
