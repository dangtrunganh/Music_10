package com.dt.anh.vtamusic.data.source.remote;

import com.dt.anh.vtamusic.data.model.Song;
import com.dt.anh.vtamusic.data.source.SongDataSource;

import org.json.JSONException;
import org.json.JSONObject;

public class FetchGenreFromUrl extends BaseFetchSongFromUrl {
    public FetchGenreFromUrl(SongDataSource.OnFetchDataListener<Song> listener) {
        super(listener);
    }

    @Override
    protected JSONObject getJsonSong(JSONObject jsonObject) throws JSONException {
        return jsonObject.getJSONObject(Song.SongEntry.TRACK);
    }
}
