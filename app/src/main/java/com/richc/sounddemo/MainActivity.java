package com.richc.sounddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.file_example_mp3_2mb);

        SeekBar volumnCtrl = findViewById(R.id.volumnSeekBar);
        volumnCtrl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("seekbar value", Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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

        //mp.stop();
    }
}
