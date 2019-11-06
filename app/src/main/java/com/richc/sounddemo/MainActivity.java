package com.richc.sounddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    AudioManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.file_example_mp3_2mb);

        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolumn = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolumn = am.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar volumnCtrl = findViewById(R.id.volumnSeekBar);
        volumnCtrl.setMax(maxVolumn);
        volumnCtrl.setProgress(curVolumn);

        volumnCtrl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("seekbar value", Integer.toString(i));

                am.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

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

        //mp.stop();
    }
}
