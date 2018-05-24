package com.dt.anh.vtamusic.data.source.local;

import com.dt.anh.vtamusic.data.model.Song;
import com.dt.anh.vtamusic.data.source.SongDataSource;

public class SongLocalDataSource implements SongDataSource.LocalDataSource {
    private static SongLocalDataSource sSongLocalDataSource;

    public SongLocalDataSource() {
    }

    public static SongLocalDataSource getInstance() {
        if (sSongLocalDataSource == null) {
            sSongLocalDataSource = new SongLocalDataSource();
        }
        return sSongLocalDataSource;
    }

    @Override
    public void getLocalSongs(String category, SongDataSource.OnFetchDataListener<Song> listener) {
    }
}
