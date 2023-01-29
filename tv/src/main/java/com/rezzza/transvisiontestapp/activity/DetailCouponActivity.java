package com.rezzza.transvisiontestapp.activity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.rezzza.transvisiontestapp.R;
import com.rezzza.transvisiontestapp.model.Coupon;

/*
 * Mochamad Rezza Gumilang
 */

public class DetailCouponActivity extends FragmentActivity {

    private TextView txvw_title,txvw_description;
    private ImageView imvw_image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txvw_title       = findViewById(R.id.txvw_title);
        txvw_description = findViewById(R.id.txvw_description);
        imvw_image       = findViewById(R.id.imvw_image);

        create();
    }

    private void create(){
        Coupon coupon = (Coupon) getIntent().getSerializableExtra("data");
        txvw_title.setText(coupon.getName());
        txvw_description.setText(Html.fromHtml(coupon.getCouponTnc()));
        Glide.with(this).load(coupon.getBrandLogo()).into(imvw_image);
    }
}