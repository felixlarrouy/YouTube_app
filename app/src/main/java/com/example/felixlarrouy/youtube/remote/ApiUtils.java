package com.example.felixlarrouy.youtube.remote;

/**
 * Created by felixlarrouy on 01/03/2018.
 */

public class ApiUtils {
    private static final String BASE_URL = "https://www.googleapis.com/youtube/v3/";

    public static YTService getYTService() {
        return RetrofitClient.getClient(BASE_URL).create(YTService.class);
    }
}
