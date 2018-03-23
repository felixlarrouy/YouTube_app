package com.example.felixlarrouy.youtube.models.YTSearch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by felixlarrouy on 01/03/2018.
 */

public class YTSearchResult {

    @SerializedName("items")
    private List<SearchVideo> mSearchVideos = null;

    public List<SearchVideo> getSearchVideos() {
        return mSearchVideos;
    }

}
