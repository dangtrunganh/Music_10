package com.dt.anh.vtamusic.screen.songonline.itemgenre;

import android.support.annotation.IntDef;

@IntDef({TabPosition.TAB_ALL_MUSIC, TabPosition.TAB_ALL_AUDIO,
        TabPosition.TAB_AMBIENT, TabPosition.TAB_CLASSICAL,
        TabPosition.TAB_COUNTRY, TabPosition.TAB_ALTERNATIVEROCK})
public @interface TabPosition {
    int TAB_ALL_MUSIC = 0;
    int TAB_ALL_AUDIO = 1;
    int TAB_ALTERNATIVEROCK = 2;
    int TAB_AMBIENT = 3;
    int TAB_CLASSICAL = 4;
    int TAB_COUNTRY = 5;
    int TOTAL_TAB = 6;
}
