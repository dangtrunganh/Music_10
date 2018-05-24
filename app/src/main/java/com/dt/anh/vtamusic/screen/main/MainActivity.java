package com.dt.anh.vtamusic.screen.main;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dt.anh.vtamusic.R;
import com.dt.anh.vtamusic.screen.BaseActivity;
import com.dt.anh.vtamusic.screen.songonline.online.SongOnlineFragment;

import java.lang.reflect.Field;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private BottomNavigationView mBottomNavigationView;
    private Toolbar mToolbar;
    private ImageView mImagePreviousSong;
    private ImageView mImageNextSong;
    private ImageView mImagePlaySong;
    private CircleImageView mImageCoverSong;
    private TextView mTextTitle;
    private TextView mTextArtist;
    private ConstraintLayout mConstraintControlMusic;
    private SongOnlineFragment mSongOnlineFragment;

    @Override
    protected void registerListeners() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        mImagePlaySong.setOnClickListener(this);
        mImagePreviousSong.setOnClickListener(this);
        mImageNextSong.setOnClickListener(this);
        mConstraintControlMusic.setOnClickListener(this);
    }

    @Override
    protected void initializeComponents() {
        initViews();
        addOnlineSongFragment();
    }

    @Override
    protected int getLayoutActivity() {
        return R.layout.activity_main;
    }

    /**
     * Initialize all views of this screen
     */
    private void initViews() {
        mBottomNavigationView = findViewById(R.id.bnv_view);
        mImageCoverSong = findViewById(R.id.circle_image_song_small);
        mImagePreviousSong = findViewById(R.id.image_previous_control_music);
        mImageNextSong = findViewById(R.id.image_next_control_music);
        mImagePlaySong = findViewById(R.id.image_play_control_music);
        mToolbar = findViewById(R.id.toolbar_main_activity);
        mTextTitle = findViewById(R.id.text_title_control_music);
        mTextArtist = findViewById(R.id.text_artist_control_music);
        mConstraintControlMusic = findViewById(R.id.constraint_control_music);
        disableShiftMode(mBottomNavigationView);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.navigation_home:
                addOnlineSongFragment();
                return true;
            case R.id.navigation_offline_music:
                addOfflineSongFragment();
                return true;
            case R.id.navigation_favourite_song:
                addFavouriteSongFragment();
                return true;
            case R.id.navigation_other:
                addOtherFragment();
                return true;
            default:
                return false;
        }
    }

    /**
     * Add other fragment into main screen
     */
    private void addOtherFragment() {

    }

    /**
     * Add favourite fragment into main screen
     */
    private void addFavouriteSongFragment() {

    }

    /**
     * Add offline fragment into main screen
     */
    private void addOfflineSongFragment() {

    }

    /**
     * Add online fragment into main screen
     */
    private void addOnlineSongFragment() {
        if (mSongOnlineFragment == null) {
            mSongOnlineFragment = new SongOnlineFragment();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, mSongOnlineFragment)
                .commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_previous_control_music:
                moveToPreviousSong();
                break;
            case R.id.image_play_control_music:
                changeStateSong();
                break;
            case R.id.image_next_control_music:
                moveToNextSong();
                break;
            case R.id.constraint_control_music:
                showDetailSong();
                break;
        }
    }

    /**
     * Show detail of a song selected
     */
    private void showDetailSong() {

    }

    /**
     * Move to the next song
     */
    private void moveToNextSong() {

    }

    /**
     * Change state of song
     * If state is playing, change to pause
     * In contrast, if state is paused, chane to playing
     */
    private void changeStateSong() {

    }

    /**
     * Move to the previous song
     */
    private void moveToPreviousSong() {

    }

    /**
     * Disable shift mode of BottomNavigationView
     *
     * @param view BottomNavigationView
     */
    @SuppressLint("RestrictedApi")
    public void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
