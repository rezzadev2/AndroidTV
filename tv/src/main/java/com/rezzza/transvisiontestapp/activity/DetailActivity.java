package com.rezzza.transvisiontestapp.activity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.rezzza.transvisiontestapp.R;
import com.rezzza.transvisiontestapp.model.Category;

/*
 * Mochamad Rezza Gumilang
 */

public class DetailActivity extends FragmentActivity {

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
        String info = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum";
        Category coupon = (Category) getIntent().getSerializableExtra("data");
        txvw_title.setText(coupon.getTitle());
        txvw_description.setText(Html.fromHtml(info));
        Glide.with(this).load(coupon.getImageRes()).into(imvw_image);
    }
}