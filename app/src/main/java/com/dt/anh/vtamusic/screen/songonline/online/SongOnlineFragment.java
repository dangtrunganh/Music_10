package com.dt.anh.vtamusic.screen.songonline.online;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.dt.anh.vtamusic.R;
import com.dt.anh.vtamusic.screen.BaseFragment;
import com.dt.anh.vtamusic.screen.songonline.itemgenre.adapter.GenreViewPagerAdapter;


//SongOnlineFragment that includes viewpager off all genre tabs
public class SongOnlineFragment extends BaseFragment implements SongOnlineContract.View {

    @Override
    protected void initializeComponents() {
        initViews();
    }

    private void initViews() {
        View view = getView();
        if (view == null) return;
        ViewPager viewPager = view.findViewById(R.id.view_pager_genre);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout_genre);
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        GenreViewPagerAdapter adapter = new GenreViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_online_song;
    }
}
