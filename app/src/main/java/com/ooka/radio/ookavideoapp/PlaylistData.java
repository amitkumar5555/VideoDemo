package com.ooka.radio.ookavideoapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaylistData {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("sequenceNo")
    @Expose
    private Integer sequenceNo;
    @SerializedName("videoUrl")
    @Expose
    private String videoUrl;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
