package com.beebrainy.servicesex.rest;

import com.beebrainy.servicesex.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Prajwal Gambhir on 19-Apr-18.
 * Copyright (2018) by Cogitate Technology Solution
 */

public interface ApiInterface {


    @GET("api/users")
    Call<ResponseModel> listUsers(@Query("page") int pageNo);

}
