package com.pjs4.roleplaie.roleplaie;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ZHOU Eric on 22/02/2016.
 */
public class PlayerFileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_file_layout);
        Log.i("projet", "OnCreate PlayerFileActivity");

        /*
           fill player informations here:

           NAME
           LEVEL
           HP
           MP
           XP
           CARACTERISTICS
           CAPACITIES
        */

        final TextView tvHP = (TextView) findViewById(R.id.tvHP);
        SeekBar sbHP = (SeekBar) findViewById(R.id.seekBarHP);
        sbHP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("projet", "onProgressChanged");

                tvHP.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


        final TextView tvMP = (TextView) findViewById(R.id.tvMP);
        SeekBar sbMP = (SeekBar) findViewById(R.id.seekBarMP);
        sbMP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("projet", "onProgressChanged");

                tvMP.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        final TextView tvXP = (TextView) findViewById(R.id.tvXP);
        SeekBar sbXP = (SeekBar) findViewById(R.id.seekBarXP);
        sbXP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("projet", "onProgressChanged");

                tvXP.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    public void bleuh(View view) {
        SeekBar sb = (SeekBar) findViewById(R.id.seekBarHP);
        sb.setMax(20);
        sb.setProgress(14);
    }

    public void inventory(View view) {
        Toast.makeText(this, R.string.todo, Toast.LENGTH_SHORT).show();
    }
}
