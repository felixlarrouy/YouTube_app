package com.example.felixlarrouy.youtube.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by felixlarrouy on 01/03/2018.
 */

public class Snippet {

    @SerializedName("publishedAt")
    private String publishedAt;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("thumbnails")
    private Thumbnails thumbnails;

    @SerializedName("channelTitle")
    private String channelTitle;

    public String getPublishedAt() {
        return publishedAt.substring(0, 10);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public String getChannelTitle() {
        return channelTitle;
    }
}
