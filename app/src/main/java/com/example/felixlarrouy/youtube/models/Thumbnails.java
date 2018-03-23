package com.example.felixlarrouy.youtube.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by felixlarrouy on 01/03/2018.
 */

public class Thumbnails {

    @SerializedName("high")
    private High high;

    public High getHigh() {
        return high;
    }

}
