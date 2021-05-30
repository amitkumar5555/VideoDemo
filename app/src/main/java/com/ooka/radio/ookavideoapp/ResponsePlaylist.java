package com.ooka.radio.ookavideoapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsePlaylist {
    @SerializedName("data")
    @Expose
    private List<PlaylistData> data;

    public List<PlaylistData> getData() {
        return data;
    }

    public void setData(List<PlaylistData> data) {
        this.data = data;
    }
}
