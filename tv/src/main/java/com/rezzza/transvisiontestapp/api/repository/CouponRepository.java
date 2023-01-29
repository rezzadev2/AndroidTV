package com.rezzza.transvisiontestapp.api.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.rezzza.transvisiontestapp.api.ApiConfig;
import com.rezzza.transvisiontestapp.api.CallApiService;
import com.rezzza.transvisiontestapp.api.model.GlobalResponse;
import com.rezzza.transvisiontestapp.api.usecase.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CouponRepository {

    private final ApiInterface apiInterface;
    private MutableLiveData<GlobalResponse> data;

    public CouponRepository() {
        CallApiService callApiService = new CallApiService();
        this.apiInterface = callApiService.getClient().create(ApiInterface.class);
    }

    public LiveData<GlobalResponse> getCoupon(){
        data = new MutableLiveData<>();
        String url = ApiConfig.COUPON+"?username="+ApiConfig.USERNAME;
        apiInterface.getCategory(url).enqueue(new Callback<GlobalResponse>() {
            @Override
            public void onResponse(Call<GlobalResponse> call, Response<GlobalResponse> response) {
                GlobalResponse rsp = response.body();
                data.postValue(rsp);
            }

            @Override
            public void onFailure(Call<GlobalResponse> call, Throwable t) {
                GlobalResponse rsp = new GlobalResponse();
                rsp.setStatus(false);
                data.postValue(rsp);
            }
        });

        return data;
    }
}
