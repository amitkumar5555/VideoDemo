package com.ooka.radio.ookavideoapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class ViewPagerHomeFragment extends Fragment {
    private PlaylistData homeVideoModelList;
    private Context context;
    private int position;
    private PlayerView playerView;
    private View view;
    private SimpleExoPlayer simpleExoPlayer;
    private boolean isPlayerPlay;
    private int seekPosition;
    private ViewPager2 view_pager_stories;
    private long modelduration;
    private boolean b = true, p = true;
    private String duration;
    private final int FIVE_SECONDS = 1000;
    private Handler handler = new Handler();

    SimpleExoPlayer.EventListener eventListener = new Player.EventListener() {
        @Override
        public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {

            if (playbackState == Player.STATE_BUFFERING || playbackState == Player.STATE_IDLE ||
                    playbackState == Player.STATE_READY) {
                playerView.setKeepScreenOn(true);
            }


            if (playbackState == Player.STATE_READY && playWhenReady) {
                modelduration = simpleExoPlayer.getDuration();
                duration = toMMSS(modelduration);

                if (b) {
                    b = false;
                    Log.d("amit", "thread line up");
                    scheduleSendPosition();
                    Log.d("amit", "thread line down");
                }
            }
            if (playbackState == Player.STATE_ENDED && playWhenReady) {
                Log.v("amit", "ended");
                b = true;
                p = true;
                handler.removeCallbacksAndMessages(null);
                view_pager_stories.setCurrentItem(view_pager_stories.getCurrentItem() + 1);
            }

        }
    };

    public static Fragment newInstance(PlaylistData homeVideoModelList, Context context, int position,
                                       ViewPager2 view_pager_stories) {
        ViewPagerHomeFragment fragment = new ViewPagerHomeFragment();
        fragment.homeVideoModelList = homeVideoModelList;
        fragment.context = context;
        fragment.position = position;
        fragment.view_pager_stories = view_pager_stories;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_view_pager_home, container, false);

        initViews(view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializePlayer();
    }


    public void scheduleSendPosition() {

        handler.postDelayed(new Runnable() {
            public void run() {
                checkTimeLeft();          // this method will contain your almost-finished HTTP calls
                handler.postDelayed(this, FIVE_SECONDS);
            }
        }, FIVE_SECONDS);

    }

    private void checkTimeLeft() {
        if (simpleExoPlayer != null) {
            float progress = simpleExoPlayer.getDuration() > 0 ? ((float) simpleExoPlayer.getCurrentPosition() / simpleExoPlayer.getDuration()) * 100 : 0f;
            Log.d("amit", "progress :  " + Math.round(progress));
            long totalDuration = simpleExoPlayer.getDuration() / 1000;
            Log.d("amit", "total duration :  " + totalDuration);
            Log.d("amit", "total duration in milli :  " + Math.round(simpleExoPlayer.getDuration()));
            Log.d("amit", "progress duration in milli :  " + Math.round(simpleExoPlayer.getCurrentPosition()));

            if ((Math.round(simpleExoPlayer.getDuration()) - Math.round(simpleExoPlayer.getCurrentPosition())) <= 30000) {
                if (p) {
                    p = false;
                  /*  int nextSequenceNo = view_pager_stories.getCurrentItem() + 1;
                    PlaylistData nextTrack = DataHolder.getPlaylist().get(nextSequenceNo);
                    nextTrack.getTitle();
                    nextTrack.getImageUrl();

                    Log.d("atul", "Show recyclerview");
                    setLayoutDetails(nextTrack.getTitle(), nextTrack.getImageUrl());*/
                    View v = view.findViewById(R.id.linear);
                    v.setVisibility(View.VISIBLE);

                }
            }
        }
    }

    private void setLayoutDetails(String title, String image) {
        /*View v = view.findViewById(R.id.linear);
        v.setVisibility(View.VISIBLE);*/
        TextView textView = view.findViewById(R.id.title);
        textView.setText(title);
        ImageView imgView = view.findViewById(R.id.image);
        Glide.with(context).load(image).into(imgView);

    }



    private void initViews(View view) {
        playerView = view.findViewById(R.id.video_view);

        int nextSequenceNo = view_pager_stories.getCurrentItem() + 1;
        PlaylistData nextTrack = DataHolder.getPlaylist().get(nextSequenceNo);

        Log.d("atul", "Show recyclerview");
        setLayoutDetails(nextTrack.getTitle(), nextTrack.getImageUrl());

    }

    private void initializePlayer() {
        try {
            simpleExoPlayer = new SimpleExoPlayer.Builder(context).build();
            if (simpleExoPlayer != null) {
                playerView.setPlayer(simpleExoPlayer);
                simpleExoPlayer.addListener(eventListener);
                // simpleExoPlayer.setRepeatMode(Player.REPEAT_MODE_ONE);
                Uri uri = Uri.parse(homeVideoModelList.getVideoUrl());
                MediaSource mediaSource = buildMediaSource(uri);
                simpleExoPlayer.setPlayWhenReady(isPlayerPlay);
                simpleExoPlayer.seekTo(seekPosition);
                if (mediaSource != null)
                    simpleExoPlayer.prepare(mediaSource, false, false);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String toMMSS(long millis) {
        long mm = TimeUnit.MILLISECONDS.toMinutes(millis)
                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis));
        long ss = TimeUnit.MILLISECONDS.toSeconds(millis)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis));
        return String.format(Locale.US, "%02d:%02d", mm, ss);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            isPlayerPlay = true;
            seekPosition = 0;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setPlayWhenReady(true);
                simpleExoPlayer.seekTo(0);
            }
        } else {
            isPlayerPlay = false;
            if (simpleExoPlayer != null && simpleExoPlayer.getPlayWhenReady())
                simpleExoPlayer.setPlayWhenReady(false);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (MainActivity.fragmentPosition == 0) {
            resumePlayer();
        }
    }

    private void resumePlayer() {
        isPlayerPlay = true;
        seekPosition = 0;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(true);
        }
    }

    public void pausePlayer() {
        isPlayerPlay = false;
        if (simpleExoPlayer != null && simpleExoPlayer.getPlayWhenReady())
            simpleExoPlayer.setPlayWhenReady(false);
    }

    @Override
    public void onPause() {
        super.onPause();
        pausePlayer();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        releasePlayer();
    }

    private void releasePlayer() {
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release();
            simpleExoPlayer = null;
        }
    }

    private MediaSource buildMediaSource(Uri uri) {
        try {
            DataSource.Factory dataSourceFactory =
                    new DefaultDataSourceFactory(context, "exoplayer-codelab");
            return new ProgressiveMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}