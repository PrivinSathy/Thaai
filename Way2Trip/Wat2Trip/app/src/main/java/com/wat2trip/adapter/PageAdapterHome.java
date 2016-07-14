package com.wat2trip.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wat2trip.fragment.BusFragment;
import com.wat2trip.fragment.FlightFragment;
import com.wat2trip.fragment.HotelFragment;
import com.wat2trip.fragment.TrainFragment;

/**
 * Created by User on 12-07-2016.
 */

public final class PageAdapterHome extends FragmentPagerAdapter {

  /*  public PageAdapterHome(FragmentManager fragmentManager) {
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
    }*/
  final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[] { "Flight", "Train", "Bus" , "Hotel" };
    private Context context;

    public PageAdapterHome(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return FlightFragment.newInstance(position);
        }else if (position == 1){
            return TrainFragment.newInstance(position);
        } else if (position == 2) {
            return BusFragment.newInstance(position);
        } else if (position == 3) {
            return HotelFragment.newInstance(position);
        } else
            return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}