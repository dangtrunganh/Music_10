package com.dt.anh.vtamusic.data.source;

import com.dt.anh.vtamusic.data.model.Song;
import com.dt.anh.vtamusic.data.source.local.SongLocalDataSource;
import com.dt.anh.vtamusic.data.source.remote.SongRemoteDataSource;

public class SongRepository implements SongDataSource.RemoteDataSource, SongDataSource.LocalDataSource{
    private static SongRepository sSongRepository;
    private SongDataSource.RemoteDataSource mRemoteDataSource;
    private SongDataSource.LocalDataSource mLocalDataSource;

    private SongRepository(SongDataSource.RemoteDataSource remoteDataSource,
                           SongDataSource.LocalDataSource localDataSource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSource = localDataSource;
    }

    public static SongRepository getInstance() {
        if (sSongRepository == null) {
            sSongRepository = new SongRepository(SongRemoteDataSource.getInstance(),
                    SongLocalDataSource.getInstance());
        }
        return sSongRepository;
    }
    @Override
    public void getRemoteSongs(String genre, int limit, int offSet, SongDataSource.OnFetchDataListener<Song> listener) {
        if (mRemoteDataSource == null) {
            return;
        }
        mRemoteDataSource.getRemoteSongs(genre, limit, offSet, listener);
    }

    @Override
    public void getLocalSongs(String category, SongDataSource.OnFetchDataListener<Song> listener) {

    }
}
