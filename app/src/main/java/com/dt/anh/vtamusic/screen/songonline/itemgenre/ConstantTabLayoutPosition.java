package com.dt.anh.vtamusic.screen.songonline.itemgenre;

import android.support.annotation.IntDef;

@IntDef({ConstantTabLayoutPosition.TAB_ALL_MUSIC, ConstantTabLayoutPosition.TAB_ALL_AUDIO,
        ConstantTabLayoutPosition.TAB_AMBIENT, ConstantTabLayoutPosition.TAB_CLASSICAL,
        ConstantTabLayoutPosition.TAB_COUNTRY, ConstantTabLayoutPosition.TAB_ALTERNATIVEROCK})
public @interface ConstantTabLayoutPosition {
    int TAB_ALL_MUSIC = 0;
    int TAB_ALL_AUDIO = 1;
    int TAB_ALTERNATIVEROCK = 2;
    int TAB_AMBIENT = 3;
    int TAB_CLASSICAL = 4;
    int TAB_COUNTRY = 5;
    int TOTAL_TAB = 6;
}
