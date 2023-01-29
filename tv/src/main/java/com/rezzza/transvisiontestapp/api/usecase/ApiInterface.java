package com.rezzza.transvisiontestapp.api.usecase;

import com.rezzza.transvisiontestapp.api.model.GlobalResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface  ApiInterface {
    @GET
    public Call<GlobalResponse> getCategory(@Url String url );
}
