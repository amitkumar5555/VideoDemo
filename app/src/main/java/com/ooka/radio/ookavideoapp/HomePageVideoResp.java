package com.ooka.radio.ookavideoapp;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class HomePageVideoResp implements Serializable {
    @SerializedName("api_status")
    private int api_status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<HomeVideoModelList> videoModelLists;

    public int getApi_status() {
        return api_status;
    }

    public void setApi_status(int api_status) {
        this.api_status = api_status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<HomeVideoModelList> getVideoModelLists() {
        return videoModelLists;
    }

    public void setVideoModelLists(List<HomeVideoModelList> videoModelLists) {
        this.videoModelLists = videoModelLists;
    }
}
