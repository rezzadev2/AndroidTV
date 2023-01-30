package com.rezzza.transvisiontestapp.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.leanback.app.BackgroundManager;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.gson.Gson;
import com.rezzza.transvisiontestapp.R;
import com.rezzza.transvisiontestapp.activity.DetailActivity;
import com.rezzza.transvisiontestapp.activity.DetailCouponActivity;
import com.rezzza.transvisiontestapp.data.CategoryData;
import com.rezzza.transvisiontestapp.model.Category;
import com.rezzza.transvisiontestapp.model.Coupon;
import com.rezzza.transvisiontestapp.model.MyHeaderItem;
import com.rezzza.transvisiontestapp.presenter.CardPresenter;
import com.rezzza.transvisiontestapp.presenter.CouponPresenter;
import com.rezzza.transvisiontestapp.viewmodel.MainViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends BrowseSupportFragment {

    private MainViewModel mainViewModel;
    private BackgroundManager mBackgroundManager;

    private final Handler mHandler = new Handler(Looper.myLooper());
    private Drawable mDefaultBackground;
    private DisplayMetrics mMetrics;
    private Timer mBackgroundTimer;
    private int selectedItem = R.drawable.background;

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        startBackgroundTimer(selectedItem);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBackgroundManager = BackgroundManager.getInstance(requireActivity());
        mBackgroundManager.attach(requireActivity().getWindow());
        mDefaultBackground = ContextCompat.getDrawable(requireActivity(), R.drawable.background);
        mMetrics = new DisplayMetrics();
        requireActivity().getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
        setupUIElements();

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        ArrayObjectAdapter rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        setAdapter(rowsAdapter);

        loadCoupon();
        setOnItemViewClickedListener(new ItemViewClickedListener());
        setOnItemViewSelectedListener(new ItemViewSelectedListener());
    }

    private void setupUIElements() {
        setBrandColor(ContextCompat.getColor(requireActivity(), R.color.fastlane_background));
    }

    private void loadCoupon(){
        mainViewModel.getCoupon();
        mainViewModel.getLiveData().observe(getViewLifecycleOwner(), globalResponse -> {
            if (globalResponse != null){
                if (globalResponse.isStatus()){
                    buildCoupon(globalResponse.getResult());
                }
                else {
                    Toast.makeText(requireActivity(),"Error API Connection", Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(requireActivity(),"Error API Connection", Toast.LENGTH_LONG).show();
            }

            loadCategory();
        });
    }

    private void loadCategory(){
        mainViewModel.getCategory();
        mainViewModel.getLiveData().observe(getViewLifecycleOwner(), globalResponse -> {
            if (globalResponse != null){
               if (globalResponse.isStatus()){
                   buildCategory(globalResponse.getResult());
               }
               else {
                   Toast.makeText(requireActivity(),"Error API Connection", Toast.LENGTH_LONG).show();
               }
            }
            else {
                Toast.makeText(requireActivity(),"Error API Connection", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void buildCategory(ArrayList<Object> objects){
        ArrayObjectAdapter rowsAdapter = (ArrayObjectAdapter) getAdapter();
        CardPresenter mGridPresenter = new CardPresenter();

        String cat = arrayToString(objects);
        try {
            JSONArray ja = new JSONArray(cat);
            for (int i=0; i<ja.length(); i++){
                JSONObject jo = ja.getJSONObject(i);
                int categoryId = Integer.parseInt(jo.getString("categoryId"));
                ArrayObjectAdapter gridRowAdapter = new ArrayObjectAdapter(mGridPresenter);

                for (Category category : CategoryData.getList(categoryId)){
                    gridRowAdapter.add(category);
                }

                MyHeaderItem gridHeader = new MyHeaderItem(categoryId, jo.getString("categoryName"), R.drawable.ic_travel);
                rowsAdapter.add(new ListRow(gridHeader, gridRowAdapter));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void buildCoupon(ArrayList<Object> objects){
        ArrayObjectAdapter rowsAdapter = (ArrayObjectAdapter) getAdapter();
        CouponPresenter mGridPresenter = new CouponPresenter();
        ArrayObjectAdapter gridRowAdapter = new ArrayObjectAdapter(mGridPresenter);

        String cat = arrayToString(objects);
        try {
            JSONArray ja = new JSONArray(cat);
            for (int i=0; i<ja.length(); i++){
                JSONObject jo = ja.getJSONObject(i);
                Coupon coupon = new Coupon();
                coupon.setId(jo.getString("couponId"));
                coupon.setName(jo.getString("couponName"));
                coupon.setBrandLogo(jo.getString("couponBrandLogo"));
                coupon.setCouponTnc(jo.getString("couponTnc"));
                gridRowAdapter.add(coupon);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rowsAdapter.add(new ListRow( gridRowAdapter));
    }

    public static <T> String arrayToString(ArrayList<T> list) {
        Gson g = new Gson();
        return g.toJson(list);
    }

    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item,  RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item instanceof Coupon){
                Coupon coupon = (Coupon) item;
                Intent intent = new Intent(requireActivity(), DetailCouponActivity.class);
                intent.putExtra("data", coupon);
                startActivity(intent);
            }
            else {
                Category category = (Category) item;
                Intent intent = new Intent(requireActivity(), DetailActivity.class);
                intent.putExtra("data", category);
                startActivity(intent);
            }

        }
    }

    private final class ItemViewSelectedListener implements OnItemViewSelectedListener {
        @Override
        public void onItemSelected( Presenter.ViewHolder itemViewHolder,  Object item,  RowPresenter.ViewHolder rowViewHolder,Row row) {
            if (row.getHeaderItem() == null){
                return;
            }
            long id = row.getHeaderItem().getId();
            if (id == 4){
                startBackgroundTimer(R.drawable.background_otomotive);
            }
            else if (id == 5){
                startBackgroundTimer(R.drawable.background_travel);
            }
            else if (id == 1){
                startBackgroundTimer(R.drawable.background_food);
            }
            else if (id == 6){
                startBackgroundTimer(R.drawable.background_movie);
            }
            else {
                startBackgroundTimer(R.drawable.background);
            }
        }
    }

    private void startBackgroundTimer(int res) {
        selectedItem = res;
        if (null != mBackgroundTimer) {
            mBackgroundTimer.cancel();
        }
        mBackgroundTimer = new Timer();
        mBackgroundTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.post(() -> updateBackground(res));
            }
        }, 300);
    }


    private void updateBackground(int res) {
        int width = mMetrics.widthPixels;
        int height = mMetrics.heightPixels;
        Glide.with(requireActivity())
                .load(res)
                .centerCrop()
                .error(mDefaultBackground)
                .into(new SimpleTarget<Drawable>(width, height) {
                    @Override
                    public void onResourceReady(@NonNull Drawable drawable,
                                                @Nullable Transition<? super Drawable> transition) {
                        mBackgroundManager.setDrawable(drawable);
                    }
                });
        mBackgroundTimer.cancel();
    }
}