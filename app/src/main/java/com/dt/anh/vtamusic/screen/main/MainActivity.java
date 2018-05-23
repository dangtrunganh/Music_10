package com.dt.anh.vtamusic.screen.main;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.dt.anh.vtamusic.R;
import com.dt.anh.vtamusic.screen.BaseActivity;

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
    }

    @Override
    protected int getLayoutActivity() {
        return R.layout.activity_main;
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
}
