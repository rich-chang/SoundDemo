package com.richc.sounddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.file_example_mp3_2mb);
    }

    MediaPlayer mp;

    public void playAudio (View view) {
        Log.i("richc", "Press Play");

        mp.start();
    }

    public void pauseAudio (View view) {
        Log.i("richc", "Press Pause");

        mp.pause();
    }

    public void stopAudio (View view) {
        Log.i("richc", "Press Stop");

        mp.stop();
    }
}
