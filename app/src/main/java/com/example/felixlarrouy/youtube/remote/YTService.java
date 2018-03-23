package com.example.felixlarrouy.youtube.remote;

import com.example.felixlarrouy.youtube.models.YTComments.YTCommentResult;
import com.example.felixlarrouy.youtube.models.YTSearch.YTSearchResult;
import com.example.felixlarrouy.youtube.models.YTTrendings.YTTrendingResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by felixlarrouy on 01/03/2018.
 */

public interface YTService {

    @GET("search?part=snippet&maxResults=50&type=video&key=AIzaSyAkHKF0HthLihLZyJoUerolm_2xi-0nLZE")
    Call<YTSearchResult> getVideos(@Query("q") String keywords);

    @GET("videos?part=snippet&chart=mostPopular&maxResults=50&key=AIzaSyAkHKF0HthLihLZyJoUerolm_2xi-0nLZE")
    Call<YTTrendingResult> getTrendings(@Query("regionCode") String code);

    @GET("commentThreads?part=snippet&maxResults=50&key=AIzaSyAkHKF0HthLihLZyJoUerolm_2xi-0nLZE&")
    Call<YTCommentResult> getComments(@Query("videoId") String id);
}
