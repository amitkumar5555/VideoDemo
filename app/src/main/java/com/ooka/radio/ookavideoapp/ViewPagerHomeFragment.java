package com.ooka.radio.ookavideoapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

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
    private String homeVideoModelList;
    private Context context;
    private int position;
    private PlayerView playerView;
    private View view;
    private SimpleExoPlayer simpleExoPlayer;
    private boolean isPlayerPlay;
    private int seekPosition;
    private ViewPager2 view_pager_stories;
    private long modelduration;
    private boolean b = true;
    private String duration;
    private ProgressBar progressBar;
    private final int FIVE_SECONDS = 1000;


    SimpleExoPlayer.EventListener eventListener = new Player.EventListener() {
        @Override
        public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {

            if (playbackState == Player.STATE_READY && playWhenReady) {
                modelduration = simpleExoPlayer.getDuration();
                  duration =toMMSS(modelduration);
                progressBar.setVisibility(View.GONE);

                if (b){
                    b = false;
                     Log.d("amit","thread line up");
                      scheduleSendPosition();
                     Log.d("amit","thread line down");
                }
                Toast.makeText(context, "duration : " + duration, Toast.LENGTH_SHORT).show();
            }
            if (playbackState == Player.STATE_ENDED && playWhenReady) {
                Log.v("amit","ended");
                b = true;
                view_pager_stories.setCurrentItem(view_pager_stories.getCurrentItem()+1);
            }

        }
    };

    public static Fragment newInstance(String homeVideoModelList, Context context, int position,
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
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                checkTimeLeft();          // this method will contain your almost-finished HTTP calls
                handler.postDelayed(this, FIVE_SECONDS);
            }
        }, FIVE_SECONDS);
    }

    private void checkTimeLeft() {
        if (simpleExoPlayer!=null){
            float progress = simpleExoPlayer.getDuration() > 0 ? ((float) simpleExoPlayer.getCurrentPosition() / simpleExoPlayer.getDuration()) * 100 : 0f;
            Log.d("amit","progress :  "+Math.round(progress));
            //  mProgressBar.setProgress(Math.round(progress));
            long totalDuration = simpleExoPlayer.getDuration() / 1000;
            Log.d("amit","total duration :  "+totalDuration);

            if ((totalDuration-Math.round(progress)) == 15){
                Log.d("amit","Show recyclerview");
            }
        }
    }

    private void initViews(View view) {
        playerView = view.findViewById(R.id.video_view);
    }

    private void initializePlayer() {
        try {
            progressBar = view.findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);
            simpleExoPlayer = new SimpleExoPlayer.Builder(context).build();
            if (simpleExoPlayer != null) {
                playerView.setPlayer(simpleExoPlayer);
                simpleExoPlayer.addListener(eventListener);
               // simpleExoPlayer.setRepeatMode(Player.REPEAT_MODE_ONE);
                Uri uri = Uri.parse(homeVideoModelList);
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