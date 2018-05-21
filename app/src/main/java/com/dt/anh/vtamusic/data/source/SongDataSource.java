package com.dt.anh.vtamusic.data.source;

import com.dt.anh.vtamusic.data.model.Song;

import java.util.List;

public interface SongDataSource {
    interface LocalDataSource {
        void getLocalSongs(String category, OnFetchDataListener<Song> listener);
    }

    interface RemoteDataSource {
        void getRemoteSongs(String genre, int limit, int offSet,
                           OnFetchDataListener<Song> listener);
    }

    interface OnFetchDataListener<T> {
        void onFetchDataSuccess(List<T> data);

        void onFetchDataFailure(String message);
    }
}
