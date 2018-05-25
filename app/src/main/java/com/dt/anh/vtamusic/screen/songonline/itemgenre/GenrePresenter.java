package com.dt.anh.vtamusic.screen.songonline.itemgenre;

import com.dt.anh.vtamusic.data.model.Song;
import com.dt.anh.vtamusic.data.source.SongDataSource;
import com.dt.anh.vtamusic.data.source.SongRepository;

import java.util.List;

public class GenrePresenter implements GenreContract.Presenter,
        SongDataSource.OnFetchDataListener<Song> {
    private GenreContract.View mView;
    private SongRepository mSongRepository;

    public GenrePresenter() {
        mSongRepository = SongRepository.getInstance();
    }

    @Override
    public void onFetchDataSuccess(List<Song> data) {
        mView.showListSongsSuccess(data);
    }

    @Override
    public void onFetchDataFailure(String message) {

    }

    @Override
    public void loadMusic(String genre, int limit, int offSet) {
        mSongRepository.getRemoteSongs(genre, limit, offSet, this);
    }

    @Override
    public List<Song> getListSongs() {
        return null;
    }

    @Override
    public void setView(GenreContract.View view) {
        mView = view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
