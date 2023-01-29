package com.rezzza.transvisiontestapp.viewmodel;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.rezzza.transvisiontestapp.api.model.GlobalResponse;
import com.rezzza.transvisiontestapp.api.repository.CategoryRepository;
import com.rezzza.transvisiontestapp.api.repository.CouponRepository;

import java.util.ArrayList;

public class MainViewModel extends AndroidViewModel {

    private final Application application;

    private final CategoryRepository categoryRepository;
    private final CouponRepository couponRepository;
    private LiveData<GlobalResponse> liveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.application = application;

        categoryRepository = new CategoryRepository();
        couponRepository = new CouponRepository();
        liveData = new MutableLiveData<>();
    }

    public void getCategory(){
        if (isNetworkConnected()){
            MutableLiveData<GlobalResponse> data = new MutableLiveData<>();
            GlobalResponse model = new GlobalResponse();
            model.setStatus(false);
            ArrayList<String> msg = new ArrayList<>();
            msg.add("Internet Connection Error");
            model.setMessage(msg);
            data.postValue(model);
            return;
        }
        liveData =  categoryRepository.getCategory();
    }

    public void getCoupon(){
        if (isNetworkConnected()){
            MutableLiveData<GlobalResponse> data = new MutableLiveData<>();
            GlobalResponse model = new GlobalResponse();
            model.setStatus(false);
            ArrayList<String> msg = new ArrayList<>();
            msg.add("Internet Connection Error");
            model.setMessage(msg);
            data.postValue(model);
            return;
        }

        liveData = couponRepository.getCoupon();
    }

    public LiveData<GlobalResponse> getLiveData() {
        return liveData;
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isConnected();
    }
}
