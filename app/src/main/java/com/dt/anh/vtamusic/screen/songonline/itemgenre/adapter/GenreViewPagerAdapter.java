package com.dt.anh.vtamusic.screen.songonline.itemgenre.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dt.anh.vtamusic.data.model.GenreType;
import com.dt.anh.vtamusic.screen.songonline.itemgenre.TabPosition;
import com.dt.anh.vtamusic.screen.songonline.itemgenre.GenreFragment;

public class GenreViewPagerAdapter extends FragmentPagerAdapter {

    public GenreViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case TabPosition.TAB_ALL_MUSIC:
                return GenreFragment.newInstance(GenreType.ALL_MUSIC);
            case TabPosition.TAB_ALL_AUDIO:
                return GenreFragment.newInstance(GenreType.ALL_AUDIO);
            case TabPosition.TAB_AMBIENT:
                return GenreFragment.newInstance(GenreType.AMBIENT);
            case TabPosition.TAB_ALTERNATIVEROCK:
                return GenreFragment.newInstance(GenreType.ALTERNATIVEROCK);
            case TabPosition.TAB_CLASSICAL:
                return GenreFragment.newInstance(GenreType.CLASSICAL);
            case TabPosition.TAB_COUNTRY:
                return GenreFragment.newInstance(GenreType.COUNTRY);
            default:
                return GenreFragment.newInstance(GenreType.ALL_MUSIC);
        }
    }

    @Override
    public int getCount() {
        return TabPosition.TOTAL_TAB;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case TabPosition.TAB_ALL_MUSIC:
                return GenreType.ALL_MUSIC;
            case TabPosition.TAB_ALL_AUDIO:
                return GenreType.ALL_AUDIO;
            case TabPosition.TAB_AMBIENT:
                return GenreType.AMBIENT;
            case TabPosition.TAB_ALTERNATIVEROCK:
                return GenreType.ALTERNATIVEROCK;
            case TabPosition.TAB_CLASSICAL:
                return GenreType.CLASSICAL;
            case TabPosition.TAB_COUNTRY:
                return GenreType.COUNTRY;
            default:
                return GenreType.ALL_MUSIC;
        }
    }
}
