package com.ooka.radio.ookavideoapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("playlist")
    Call<PlaylistResp> getPlayList();
}
