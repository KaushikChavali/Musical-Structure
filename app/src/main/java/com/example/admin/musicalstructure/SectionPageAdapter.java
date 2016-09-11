package com.example.admin.musicalstructure;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by admin on 9/6/2016.
 */
public class SectionPageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public SectionPageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Tracks tracks = new Tracks();
                return tracks;
            case 1:
                Playlists playlists = new Playlists();
                return playlists;
            case 2:
                Favorites favorites = new Favorites();
                return favorites;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}