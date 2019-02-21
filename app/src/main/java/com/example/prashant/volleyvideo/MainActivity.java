package com.example.prashant.volleyvideo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    ProgressDialog progressDialog;
    String videourl = "http://18.191.19.203/api/video";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.VideoView);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("streaming");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        MediaController mediaController = new MediaController(MainActivity.this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse(videourl);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        progressDialog.dismiss();
        videoView.start();


    }
}
