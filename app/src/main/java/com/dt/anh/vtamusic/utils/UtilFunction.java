package com.dt.anh.vtamusic.utils;

import android.annotation.SuppressLint;

import com.dt.anh.vtamusic.BuildConfig;

public class UtilFunction {
    @SuppressLint("DefaultLocale")
    public static String createUrlContent(String genre, int limit, int offset) {
        return String.format("%s%s%s&%s=%s&%s=%d&%s=%d", Constants.MAIN_URL,
                Constants.CONTENT_URL, genre, Constants.CLIENT_ID,
                BuildConfig.API_KEY, Constants.LIMIT, limit, Constants.OFFSET, offset);
    }
}
