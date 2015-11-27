package com.example.l.projectbysr.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.l.projectbysr.fragment.PageFragment;

/**
 * Created by l on 2015/11/17.
 */
public class TabAdapter extends FragmentPagerAdapter {
    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return new PageFragment(position);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
