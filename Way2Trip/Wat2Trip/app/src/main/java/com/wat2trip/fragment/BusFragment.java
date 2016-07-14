package com.wat2trip.fragment;

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

public class BusFragment extends Fragment {
    View rootView;
    public BusFragment() {

    }
    public static BusFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt("ARG_PAGE", page);
        BusFragment fragment = new BusFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.bus_fragment, container, false);
        return rootView;
    }
}
