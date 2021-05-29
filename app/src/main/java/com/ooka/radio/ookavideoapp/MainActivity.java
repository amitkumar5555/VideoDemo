package com.ooka.radio.ookavideoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static ViewPager2 view_pager2;
    private HomeFragmentNew homeFragmentNew;
    public static int fragmentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        view_pager2 = findViewById(R.id.view_pager2);
        view_pager2.setOffscreenPageLimit(1);
        view_pager2.setUserInputEnabled(false);
        view_pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                fragmentPosition = position;

            }
        });
        setViewPager2Adapter(view_pager2);
    }


    private void setViewPager2Adapter(ViewPager2 view_pager2) {
        try {
            ViewPager2Adapter adapter = new ViewPager2Adapter(getSupportFragmentManager(), getLifecycle());
            homeFragmentNew = new HomeFragmentNew();
            adapter.addFragment(homeFragmentNew);
            view_pager2.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void initViews() {
        view_pager2 = findViewById(R.id.view_pager2);
    }
}