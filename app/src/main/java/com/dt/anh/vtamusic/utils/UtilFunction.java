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

    @SuppressLint("DefaultLocale")
    public static String convertMilliSecondsToTimer(long milliseconds) {
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
        return hours > 0 ? String.format("%02d:%02d:%02d",
                hours, minutes, seconds) : String.format("%02d:%02d", minutes, seconds);
    }
}
