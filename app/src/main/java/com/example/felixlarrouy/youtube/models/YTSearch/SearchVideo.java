package com.example.felixlarrouy.youtube.models.YTSearch;

import com.example.felixlarrouy.youtube.models.Snippet;
import com.google.gson.annotations.SerializedName;

/**
 * Created by felixlarrouy on 01/03/2018.
 */

public class SearchVideo {

    @SerializedName("id")
    private Id id;

    @SerializedName("snippet")
    private Snippet snippet;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

}
