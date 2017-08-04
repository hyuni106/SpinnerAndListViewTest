package com.example.user.yogiyocopy.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.yogiyocopy.R;
import com.example.user.yogiyocopy.fragment.MyProfileFragment;
import com.example.user.yogiyocopy.fragment.OrderListFragment;
import com.example.user.yogiyocopy.fragment.SeeMoreFragment;
import com.example.user.yogiyocopy.fragment.StoreListFragment;

public class ViewPagerTestActivity extends AppCompatActivity {
    ViewPager mainViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_test);
        mainViewPager = (ViewPager) findViewById(R.id.myViewPager);
        mainViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    // 이 화면에서만 쓰이는 어댑터는 이 액티비티 내부에서 생성해주자
    class MyPagerAdapter extends FragmentStatePagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new StoreListFragment();
            } else if (position == 1) {
                return new OrderListFragment();
            } else if (position == 2) {
                return new SeeMoreFragment();
            } else  {
                return new MyProfileFragment();
            }
        }
    }
}
