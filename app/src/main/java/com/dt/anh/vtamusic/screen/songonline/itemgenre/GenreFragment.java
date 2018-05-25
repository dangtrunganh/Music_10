package com.dt.anh.vtamusic.screen.songonline.itemgenre;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dt.anh.vtamusic.R;
import com.dt.anh.vtamusic.data.model.GenreType;
import com.dt.anh.vtamusic.data.model.Song;
import com.dt.anh.vtamusic.screen.BaseFragment;
import com.dt.anh.vtamusic.screen.songonline.online.adapter.SongOnlineAdapter;
import com.dt.anh.vtamusic.utils.Constants;

import java.util.ArrayList;
import java.util.List;

//GenreFragment includes RecyclerView for each genre
public class GenreFragment extends BaseFragment implements GenreContract.View {
    public static final String PARAM_GENRE = "param_genre";
    private SongOnlineAdapter mSongOnlineAdapter;
    private GenreContract.Presenter mPresenter;

    public GenreFragment() {
    }

    public static GenreFragment newInstance(String genre) {
        GenreFragment genreFragment = new GenreFragment();
        Bundle args = new Bundle();
        args.putString(PARAM_GENRE, genre);
        genreFragment.setArguments(args);
        return genreFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeVariable();
    }

    private void initializeVariable() {
        mPresenter = new GenrePresenter();
        mPresenter.setView(this);
        mSongOnlineAdapter = new SongOnlineAdapter(new ArrayList<Song>());
    }

    @Override
    protected void initializeComponents() {
        View view = getView();
        if (view == null) {
            return;
        }
        RecyclerView recyclerViewSongs = getView().findViewById(R.id.recycler_song);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        recyclerViewSongs.setLayoutManager(linearLayoutManager);
        recyclerViewSongs.setAdapter(mSongOnlineAdapter);
        mSongOnlineAdapter.notifyDataSetChanged();
        loadOnlineMusic();
    }

    private String getGenre() {
        if (getArguments() == null || getArguments().getString(PARAM_GENRE) == null) {
            return GenreType.ALL_MUSIC;
        }
        return getArguments().getString(PARAM_GENRE);
    }

    private void loadOnlineMusic() {
        mPresenter.loadMusic(getGenre(), Constants.LIMIT_NUMBER, Constants.OFFSET_NUMBER);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_genre;
    }

    @Override
    public void showListSongsSuccess(List<Song> arrSongs) {
        mSongOnlineAdapter.updateListSongs(arrSongs);
    }

    @Override
    public void showListSongFailure(String message) {

    }
}
