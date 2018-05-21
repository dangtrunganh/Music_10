package com.dt.anh.vtamusic.data.source.remote;

import com.dt.anh.vtamusic.data.model.Song;
import com.dt.anh.vtamusic.data.source.SongDataSource;
import com.dt.anh.vtamusic.utils.UtilFunction;

public class SongRemoteDataSource implements SongDataSource.RemoteDataSource {
    private static SongRemoteDataSource sSongRemoteDataSource;

    private SongRemoteDataSource() {
    }

    public static SongRemoteDataSource getInstance() {
        if (sSongRemoteDataSource == null) {
            sSongRemoteDataSource = new SongRemoteDataSource();
        }
        return sSongRemoteDataSource;
    }

    @Override
    public void getRemoteSongs(String genre, int limit, int offSet, SongDataSource.OnFetchDataListener<Song> listener) {
        new FetchGenreFromUrl(listener).execute(UtilFunction.createUrlContent(genre, limit, offSet));
    }
}
