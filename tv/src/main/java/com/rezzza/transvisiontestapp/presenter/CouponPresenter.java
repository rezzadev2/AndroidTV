package com.rezzza.transvisiontestapp.presenter;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;

import com.bumptech.glide.Glide;
import com.rezzza.transvisiontestapp.R;
import com.rezzza.transvisiontestapp.model.Category;
import com.rezzza.transvisiontestapp.model.Coupon;

/*
 * A CardPresenter is used to generate Views and bind Objects to them on demand.
 * It contains an Image CardView
 */

public class CouponPresenter extends Presenter {
    private static final String TAG = "CardPresenter";

    private static final int CARD_WIDTH = 317;
    private static final int CARD_HEIGHT = 170;
    private static int sSelectedBackgroundColor;
    private static int sDefaultBackgroundColor;
    private Drawable mDefaultCardImage;

    private static void updateCardBackgroundColor(ImageCardView view, boolean selected) {
        int color = selected ? sSelectedBackgroundColor : sDefaultBackgroundColor;
        view.setBackgroundColor(color);
        view.setInfoAreaBackgroundColor(color);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        sDefaultBackgroundColor =
                ContextCompat.getColor(parent.getContext(), R.color.default_background);
        sSelectedBackgroundColor =
                ContextCompat.getColor(parent.getContext(), R.color.selected_background);

        mDefaultCardImage = ContextCompat.getDrawable(parent.getContext(), R.drawable.movie);
        ImageCardView cardView =
                new ImageCardView(parent.getContext()) {
                    @Override
                    public void setSelected(boolean selected) {
//                        updateCardBackgroundColor(this, selected);
                        super.setSelected(selected);


                    }
                };

        cardView.setOnFocusChangeListener((view, b) -> {
            final View  titleField = view.findViewById(androidx.leanback.R.id.info_field);

        });

        cardView.setCardType(ImageCardView.CARD_TYPE_FLAG_IMAGE_ONLY);
        cardView.getMainImageView().setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
//        updateCardBackgroundColor(cardView, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        Coupon coupon = (Coupon) item;
        ImageCardView cardView = (ImageCardView) viewHolder.view;
        cardView.setTitleText(coupon.getName());
        cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
        Glide.with(viewHolder.view.getContext())
                .load(coupon.getBrandLogo())
                .error(mDefaultCardImage)
                .into(cardView.getMainImageView());
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
        Log.d(TAG, "onUnbindViewHolder");
        ImageCardView cardView = (ImageCardView) viewHolder.view;
        cardView.setBadgeImage(null);
        cardView.setMainImage(null);
    }

}