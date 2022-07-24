package com.shemuchemi.burningbushent.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.shemuchemi.burningbushent.DiscoverFragment;
import com.shemuchemi.burningbushent.TopRatedFragment;
import com.shemuchemi.burningbushent.TrendingFragment;

public class TabsAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public TabsAdapter(Context context,FragmentManager fm,int totalTabs){
        super(fm);
        this.myContext = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TrendingFragment();
            case 1:
                return new TopRatedFragment();
            case 2:
                return new DiscoverFragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
