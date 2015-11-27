package com.example.l.projectbysr;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.l.projectbysr.adapter.TabAdapter;
import com.example.l.projectbysr.view.ChangeColorIconWithTextView;

import java.util.ArrayList;

public class TabActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private ChangeColorIconWithTextView tab1,tab2,tab3,tab4;
    private ArrayList<ChangeColorIconWithTextView> textViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity);
        textViews = new ArrayList<ChangeColorIconWithTextView>();
        initView();
    }

    private void initView() {
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager)findViewById(R.id.pager);
        tab1 = (ChangeColorIconWithTextView) findViewById(R.id.tv_tab1);
        tab2 = (ChangeColorIconWithTextView) findViewById(R.id.tv_tab2);
        tab3 = (ChangeColorIconWithTextView) findViewById(R.id.tv_tab3);
        tab4 = (ChangeColorIconWithTextView) findViewById(R.id.tv_tab4);
        textViews.add(tab1);
        textViews.add(tab2);
        textViews.add(tab3);
        textViews.add(tab4);
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new ViewPagerListener());
        tab1.setOnClickListener(new txListener(0));
        tab2.setOnClickListener(new txListener(1));
        tab3.setOnClickListener(new txListener(2));
        tab4.setOnClickListener(new txListener(4));
    }

    public class ViewPagerListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {
            if (positionOffset > 0) {
                ChangeColorIconWithTextView left = textViews.get(position);
                ChangeColorIconWithTextView right = textViews.get(position + 1);

                left.setIconAlpha(1 - positionOffset);
                right.setIconAlpha(positionOffset);
            }

        }

        @Override
        public void onPageSelected(int index) {



        }
    }

    public class txListener implements View.OnClickListener {
        private int index = 0;

        public txListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            mViewPager.setCurrentItem(index);
        }

    }
}
