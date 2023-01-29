package com.rezzza.transvisiontestapp.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.rezzza.transvisiontestapp.R;
import com.rezzza.transvisiontestapp.fragment.HomeFragment;

/*
 * Mochamad Rezza Gumilang
 */

public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_browse_fragment, HomeFragment.newInstance())
                    .commitNow();
        }


    }
}