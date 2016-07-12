package com.wat2trip.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wat2trip.R;

/**
 * Created by User on 12-07-2016.
 */

public class Fragment2 extends Fragment {
    View rootView;
    public Fragment2() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment2, container, false);
        return rootView;
    }
}
