package com.wat2trip.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wat2trip.fragment.home.Fragment1;
import com.wat2trip.fragment.home.Fragment2;
import com.wat2trip.fragment.home.Fragment3;

/**
 * Created by User on 12-07-2016.
 */

public final class PageAdapterHome extends FragmentPagerAdapter {

    public PageAdapterHome(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new Fragment1();
        } else if (position == 1) {
            return new Fragment2();
        }  else
            return new Fragment3();
    }

    @Override
    public int getCount() {
        return 3;
    }

}