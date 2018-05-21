package com.dt.anh.vtamusic.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {
    private String mArtworkUrl;
    private String mDescription;
    private boolean mDownloadable;
    private String mDownloadUrl;
    private long mDuration;
    private String mGenre;
    private int mId;
    private int mPlaybackCount;
    private String mTitle;
    private String mUri;
    private int mUserId;
    private String mAvatarUrl;
    private String mUsername;

    public Song() {
    }

    protected Song(Parcel in) {
        mArtworkUrl = in.readString();
        mDescription = in.readString();
        mDownloadable = in.readByte() != 0;
        mDownloadUrl = in.readString();
        mDuration = in.readInt();
        mGenre = in.readString();
        mId = in.readInt();
        mPlaybackCount = in.readInt();
        mTitle = in.readString();
        mUri = in.readString();
        mUserId = in.readInt();
        mAvatarUrl = in.readString();
        mUsername = in.readString();
    }

    public String getArtworkUrl() {
        return mArtworkUrl;
    }

    public void setArtworkUrl(String artworkUrl) {
        mArtworkUrl = artworkUrl;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public boolean isDownloadable() {
        return mDownloadable;
    }

    public void setDownloadable(boolean downloadable) {
        mDownloadable = downloadable;
    }

    public String getDownloadUrl() {
        return mDownloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        mDownloadUrl = downloadUrl;
    }

    public long getDuration() {
        return mDuration;
    }

    public void setDuration(long duration) {
        mDuration = duration;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getPlaybackCount() {
        return mPlaybackCount;
    }

    public void setPlaybackCount(int playbackCount) {
        mPlaybackCount = playbackCount;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        mUri = uri;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mArtworkUrl);
        parcel.writeString(mDescription);
        parcel.writeByte((byte) (mDownloadable ? 1 : 0));
        parcel.writeString(mDownloadUrl);
        parcel.writeLong(mDuration);
        parcel.writeString(mGenre);
        parcel.writeInt(mId);
        parcel.writeInt(mPlaybackCount);
        parcel.writeString(mTitle);
        parcel.writeString(mUri);
        parcel.writeInt(mUserId);
        parcel.writeString(mAvatarUrl);
        parcel.writeString(mUsername);
    }

    public final class SongEntry {
        public static final String COLLECTION = "collection";
        public static final String TRACK = "track";
        public static final String ARTWORK_URL = "artwork_url";
        public static final String DESCRIPTION = "description";
        public static final String DOWNLOADABLE = "downloadable";
        public static final String DOWNLOAD_URL = "download_url";
        public static final String DURATION = "duration";
        public static final String ID = "id";
        public static final String PLAYBACK_COUNT = "playback_count";
        public static final String TITLE = "title";
        public static final String URI = "uri";
        public static final String USER = "user";
        public static final String AVATAR_URL = "avatar_url";
        public static final String USERNAME = "username";
        public static final String GENRE = "genre";
    }
}
