package com.rezzza.transvisiontestapp.model;

import androidx.leanback.widget.HeaderItem;

public class MyHeaderItem extends HeaderItem {


    private static final String TAG = MyHeaderItem.class.getSimpleName();
    public static final int ICON_NONE = -1;
    /** Hold an icon resource id */
    private int mIconResId = ICON_NONE;

    public MyHeaderItem(long id, String name, int icon) {
        super(id, name);
        this.mIconResId = icon;
    }
    public MyHeaderItem(long id, String name) {
        super(id, name);
    }

    public MyHeaderItem(String name) {
        super(name);
    }

    public void setmIconResId(int mIconResId) {
        this.mIconResId = mIconResId;
    }

    public int getmIconResId() {
        return mIconResId;
    }
}
