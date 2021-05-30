package com.ooka.radio.ookavideoapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragmentNew extends Fragment {
    private ViewPager2 view_pager_stories;
    private ProgressBar progressBar;
    View view;
    private VideoPlayerJobHomeAdapter1 myPageAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_new, container, false);
        initViews(view);
        getAllVideoList();
        return view;
    }

    private void initViews(View view) {
        view_pager_stories = view.findViewById(R.id.view_pager_stories);
        progressBar = view.findViewById(R.id.progressBar);
    }


    private void getAllVideoList() {

        progressBar.setVisibility(View.VISIBLE);
        ApiInterface interfaceApi = ApiClient.getClient().create(ApiInterface.class);
        Call<PlaylistResp> call = interfaceApi.getPlayList();
        call.enqueue(new Callback<PlaylistResp>() {
            @Override
            public void onResponse(Call<PlaylistResp> call, Response<PlaylistResp> response) {

                    if (response.isSuccessful()){
                        if (response.body().getStatusCode() == 200){
                            List<PlaylistData> data = response.body().getResponse().getData();
                            if (data!=null && data.size()>0){
                                setVideoPlayerJobAdapter(data);
                            }
                        }
                    }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<PlaylistResp> call, Throwable t) {
                progressBar.setVisibility(View.GONE);

            }
        });



       /* List<String> video = new ArrayList<>();
        video.add("http://18.191.187.85/videos/p1.mp4");
        video.add("http://18.191.187.85/videos/p2.mp4");
        video.add("http://18.191.187.85/videos/p3.mp4");
        video.add("http://18.191.187.85/videos/p4.mp4");
        video.add("http://18.191.187.85/videos/p5.mp4");*/
       // setVideoPlayerJobAdapter(video);
    }




    private void setVideoPlayerJobAdapter(final List<PlaylistData> videoModelLists) {
        view_pager_stories.setOffscreenPageLimit(10);
        myPageAdapter = new VideoPlayerJobHomeAdapter1(getActivity().getSupportFragmentManager(), getLifecycle(), videoModelLists, getActivity());
        view_pager_stories.setSaveFromParentEnabled(false);
        view_pager_stories.setUserInputEnabled(false);
        view_pager_stories.setAdapter(myPageAdapter);
        view_pager_stories.setCurrentItem(0);
    }

    public class VideoPlayerJobHomeAdapter1 extends FragmentStateAdapter {
        private final List<PlaylistData> videoModelLists;
        private final Context context;

        public VideoPlayerJobHomeAdapter1(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, List<PlaylistData> videoModelLists, FragmentActivity activity) {
            super(fragmentManager, lifecycle);
            this.videoModelLists = videoModelLists;
            context = activity;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return ViewPagerHomeFragment.newInstance(videoModelLists.get(position), context, position,view_pager_stories);
        }

        @Override
        public int getItemCount() {
            if (videoModelLists != null && videoModelLists.size() > 0) {
                return videoModelLists.size();
            } else {
                return 0;
            }
        }

    }

}