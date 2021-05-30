package com.ooka.radio.ookavideoapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaylistResp {
    @SerializedName("isSuccess")
    @Expose
    private boolean isSuccess;
    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("response")
    @Expose
    private ResponsePlaylist response;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public ResponsePlaylist getResponse() {
        return response;
    }

    public void setResponse(ResponsePlaylist response) {
        this.response = response;
    }
}
