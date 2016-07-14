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

public class FlightFragment extends Fragment {
    View rootView;
    public FlightFragment() {

    }


    public static FlightFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt("ARG_PAGE", page);
        FlightFragment fragment = new FlightFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.flight_fragment, container, false);
        return rootView;
    }
}
