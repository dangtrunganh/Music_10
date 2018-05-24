package com.dt.anh.vtamusic.data.model;

import android.support.annotation.StringDef;

import static com.dt.anh.vtamusic.data.model.GenreType.ALL_AUDIO;
import static com.dt.anh.vtamusic.data.model.GenreType.ALL_MUSIC;
import static com.dt.anh.vtamusic.data.model.GenreType.ALTERNATIVEROCK;
import static com.dt.anh.vtamusic.data.model.GenreType.AMBIENT;
import static com.dt.anh.vtamusic.data.model.GenreType.CLASSICAL;
import static com.dt.anh.vtamusic.data.model.GenreType.COUNTRY;

@StringDef({ALL_MUSIC, ALL_AUDIO, ALTERNATIVEROCK, AMBIENT, CLASSICAL, COUNTRY})
public @interface GenreType {
    String ALL_MUSIC = "all-music";
    String ALL_AUDIO = "all-audio";
    String ALTERNATIVEROCK = "alternativerock";
    String AMBIENT = "ambient";
    String CLASSICAL = "classical";
    String COUNTRY = "country";
}
