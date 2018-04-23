package com.beebrainy.servicesexample.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Prajwal Gambhir on 19-Apr-18.
 * Copyright (2018) by Cogitate Technology Solution
 */

public class HttpClient {

    public static final String BASE_URL = "https://reqres.in/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory
                    (GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
