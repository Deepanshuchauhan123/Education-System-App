package com.example.app_deepanshu;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class Splash_Moral extends Activity {
@Override
    protected void onCreate(Bundle sa) {
    super.onCreate(sa);
    try{
        VideoView videoView=new VideoView(this);
        setContentView(videoView);
        Uri path =Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.ved12);
videoView.setVideoURI(path);

videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mp) {
        jump();
    }


});
videoView.start();
    } catch (Exception e) {
        jump();
    }
}
    private void jump() {

    if(isFinishing())
        return;
    startActivity(new Intent(this,student_grid.class));
    finish();
    }
}
