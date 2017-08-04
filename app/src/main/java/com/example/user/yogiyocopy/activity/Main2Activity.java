package com.example.user.yogiyocopy.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.user.yogiyocopy.R;
import com.example.user.yogiyocopy.fragment.MyProfileFragment;
import com.example.user.yogiyocopy.fragment.OrderListFragment;
import com.example.user.yogiyocopy.fragment.SeeMoreFragment;
import com.example.user.yogiyocopy.fragment.StoreListFragment;

public class Main2Activity extends AppCompatActivity {

    private ViewPager mainViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mainViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        mainViewPager.setAdapter(new Main2Activity.MyViewPagerAdapter(getSupportFragmentManager()));
    }

    class MyViewPagerAdapter extends FragmentStatePagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0) {
                return new StoreListFragment();
            } else if(position == 1) {
                return new MyProfileFragment();
            } else {
                return new SeeMoreFragment();
            }
        }
    }
}
