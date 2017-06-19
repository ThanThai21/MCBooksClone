package com.esp.mcbooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    Toolbar toolbar;
    ProgressBar progressBar;
    VideoView videoView;
    ImageButton ccButton;
    ImageButton preButton;
    ImageButton playButton;
    ImageButton nextButton;
    ImageButton countButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        mapping();

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }

    private void mapping() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        progressBar = (ProgressBar) findViewById(R.id.video_progress_bar);
        videoView = (VideoView) findViewById(R.id.video_video_view);
        ccButton = (ImageButton) findViewById(R.id.video_cc_button);
        preButton = (ImageButton) findViewById(R.id.video_previous_button);
        playButton = (ImageButton) findViewById(R.id.video_play_button);
        nextButton = (ImageButton) findViewById(R.id.video_next_button);
        countButton = (ImageButton) findViewById(R.id.video_count_button);
    }
}
