package com.dt.anh.vtamusic.screen.songonline.itemgenre;

import com.dt.anh.vtamusic.data.model.Song;
import com.dt.anh.vtamusic.screen.BasePresenter;

import java.util.List;

public interface GenreContract {
    interface View {
        void showListSongsSuccess(List<Song> arrSongs);

        void showListSongFailure(String message);
    }

    interface Presenter extends BasePresenter<GenreContract.View> {
        void loadMusic(String genre, int limit, int offSet);

        List<Song> getListSongs();
    }
}
