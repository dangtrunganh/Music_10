package com.dt.anh.vtamusic.data.source.remote;

import android.os.AsyncTask;

import com.dt.anh.vtamusic.data.model.Song;
import com.dt.anh.vtamusic.data.source.SongDataSource;
import com.dt.anh.vtamusic.utils.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseFetchSongFromUrl extends AsyncTask<String, Void, List<Song>> {
    protected SongDataSource.OnFetchDataListener<Song> mListener;

    protected abstract JSONObject getJsonSong(JSONObject jsonObject) throws JSONException;

    public BaseFetchSongFromUrl(SongDataSource.OnFetchDataListener<Song> listener) {
        mListener = listener;
    }

    @Override
    protected List<Song> doInBackground(String... strings) {
        try {
            JSONObject jsonObject = new JSONObject(getJSONFormatString(strings[0]));
            return getListSong(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
            mListener.onFetchDataFailure(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            mListener.onFetchDataFailure(e.getMessage());
        }
        return null;
    }

    /**
     * Get list of songs from jsonObject
     *
     * @param jsonObject
     * @return list of songs
     * @throws JSONException
     */
    protected List<Song> getListSong(JSONObject jsonObject) throws JSONException {
        List<Song> arrSongs = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray(Song.SongEntry.COLLECTION);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject objectSong = getJsonSong(jsonArray.getJSONObject(i));
            Song song = convertJsonObjectToSongObject(objectSong);
            if (song != null) {
                arrSongs.add(song);
            }
        }
        return arrSongs;
    }

    @Override
    protected void onPostExecute(List<Song> songs) {
        if (mListener != null) {
            mListener.onFetchDataSuccess(songs);
        }
    }

    /**
     * Convert from JsonObject to Song Object
     *
     * @param jsonObjectSong jsonObject that want to convert
     * @return Song Object
     */
    protected Song convertJsonObjectToSongObject(JSONObject jsonObjectSong) {
        Song mSong = new Song();
        try {
            JSONObject jsonObjectUser = jsonObjectSong.getJSONObject(Song.SongEntry.USER);
            String mAvatarUrl = jsonObjectUser.getString(Song.SongEntry.AVATAR_URL);
            String mArtworkUrl = jsonObjectSong.getString(Song.SongEntry.ARTWORK_URL);
            if (mArtworkUrl.equals(Constants.NULL_RESULT)) {
                mArtworkUrl = mAvatarUrl;
            }
            mSong.setArtworkUrl(mArtworkUrl);
            mSong.setAvatarUrl(mAvatarUrl);
            mSong.setDescription(jsonObjectSong.getString(Song.SongEntry.DESCRIPTION));
            mSong.setDownloadable(jsonObjectSong.getBoolean(Song.SongEntry.DOWNLOADABLE));
            mSong.setDownloadUrl(jsonObjectSong.getString(Song.SongEntry.DOWNLOAD_URL));
            mSong.setDuration(jsonObjectSong.getLong(Song.SongEntry.DURATION));
            mSong.setId(jsonObjectSong.getInt(Song.SongEntry.ID));
            mSong.setGenre(jsonObjectSong.getString(Song.SongEntry.GENRE));
            mSong.setPlaybackCount(jsonObjectSong.getInt(Song.SongEntry.PLAYBACK_COUNT));
            mSong.setTitle(jsonObjectSong.getString(Song.SongEntry.TITLE));
            mSong.setUri(jsonObjectSong.getString(Song.SongEntry.URI));
            mSong.setUserId(jsonObjectUser.getInt(Song.SongEntry.ID));
            mSong.setUsername(jsonObjectUser.getString(Song.SongEntry.USERNAME));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mSong;
    }

    /**
     * Get Json format from url
     *
     * @param urlJSON
     * @return string after formatting json from url
     * @throws IOException
     */
    protected String getJSONFormatString(String urlJSON) throws IOException {
        URL url = new URL(urlJSON);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(Constants.METHOD_GET);
        httpURLConnection.setReadTimeout(Constants.TIME_OUT_TO_READ);
        httpURLConnection.setConnectTimeout(Constants.TIME_OUT_TO_CONNECT);
        httpURLConnection.setDoInput(true);
        httpURLConnection.connect();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder stringBuilder = new StringBuilder();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append(Constants.ENTER_LINE);
        }
        bufferedReader.close();
        httpURLConnection.disconnect();
        return stringBuilder.toString();
    }
}
