package com.ooka.radio.ookavideoapp;

import java.util.List;

public class DataHolder {
    public static List<PlaylistData> mPlaylist;

    public static void setPlaylist(List<PlaylistData> playlist) {
        mPlaylist = playlist;
    }

    public static List<PlaylistData> getPlaylist() {
        return mPlaylist;
    }
}
