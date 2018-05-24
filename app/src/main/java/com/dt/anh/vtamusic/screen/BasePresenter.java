package com.dt.anh.vtamusic.screen;

public interface BasePresenter<T> {
    void setView(T view);

    void onStart();

    void onStop();
}
