package com.example.assignmentmvp__rxjava.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsApiClient {

    public static final String NEWS_API_KEY = "6d0df12f66ef4483bad3908f781308b1";
    private static final String NEWS_BASE_URL = "https://newsapi.org/v2/";
    private static NewsApiClient newsApiClient;
    private static Retrofit retrofit;

    private NewsApiClient(){
        retrofit = new Retrofit.Builder().baseUrl(NEWS_BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
    }

    public static synchronized NewsApiClient getInstance(){
        if (newsApiClient == null){
            newsApiClient = new NewsApiClient();
        }
        return newsApiClient;
    }


    public ApiInterface getApi(){
        return retrofit.create(ApiInterface.class);
    }
}