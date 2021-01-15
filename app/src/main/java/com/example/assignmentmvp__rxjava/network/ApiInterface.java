package com.example.assignmentmvp__rxjava.network;

import com.example.assignmentmvp__rxjava.models.NewsData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Observable<NewsData> getHeadlines(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );
}
