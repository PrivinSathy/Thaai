package com.wat2trip.Activitys;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ImageButton;

import com.wat2trip.R;
import com.wat2trip.Utils.CircleImageView;
import com.wat2trip.adapter.PageAdapterHome;
import com.wat2trip.fragment.BusFragment;
import com.wat2trip.fragment.FlightFragment;
import com.wat2trip.fragment.HotelFragment;
import com.wat2trip.fragment.TrainFragment;

public class MainActivity extends AppCompatActivity {
    CircleImageView flight,bus,train,hotel;
    ViewPager viewPager;
    RelativeLayout homeLayout;
    FloatingActionButton fab;
    ImageButton settings;
    private static final String KEY_SELECTED_PAGE = "KEY_SELECTED_PAGE";
    private static final String KEY_SELECTED_CLASS = "KEY_SELECTED_CLASS";
    private int mSelectedItem;

    PageAdapterHome mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        SetOnClickListener();
        getCurrentFragment();
    }

    private void initialization() {

        settings = (ImageButton) findViewById(R.id.settings);
        flight = (CircleImageView) findViewById(R.id.flight);
        bus = (CircleImageView) findViewById(R.id.bus);
        train = (CircleImageView) findViewById(R.id.train);
        hotel = (CircleImageView) findViewById(R.id.hotel);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        viewPager = (ViewPager) findViewById(R.id.homePager);
        homeLayout = (RelativeLayout) findViewById(R.id.homeDetails);
        mAdapter = new PageAdapterHome(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
    }

    private void SetOnClickListener() {

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , Settings.class);
                startActivity(i);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearBackStack();
                homeLayout.setVisibility(View.VISIBLE);
            }
        });

        flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeLayout.setVisibility(View.GONE);
                clearBackStack();
                Fragment fragment = new FlightFragment();
                FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.container, fragment, "Flight");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeLayout.setVisibility(View.GONE);
                clearBackStack();
                Fragment fragment = new BusFragment();
                FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.container, fragment, "Bus");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeLayout.setVisibility(View.GONE);
                clearBackStack();
                Fragment fragment = new TrainFragment();
                FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.container, fragment, "Train");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeLayout.setVisibility(View.GONE);
                clearBackStack();
                Fragment fragment = new HotelFragment();
                FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.container, fragment, "Hotel");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }

    private Fragment getCurrentFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);
        return fragment;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getCurrentFragment().onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void clearBackStack() {
        FragmentManager fm = getSupportFragmentManager();
        int count = fm.getBackStackEntryCount();
        for (int i = 0; i < count; ++i) {
            fm.popBackStackImmediate();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent i = new Intent(this , Settings.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_SELECTED_CLASS, mSelectedItem);
        outState.putInt(KEY_SELECTED_PAGE, viewPager.getCurrentItem());
    }
}
