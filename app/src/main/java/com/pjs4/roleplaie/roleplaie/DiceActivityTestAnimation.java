package com.pjs4.roleplaie.roleplaie;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class DiceActivityTestAnimation extends Activity {
    ImageView dice_picture;		//reference to dice picture
    Random rng=new Random();	//generate random numbers
    SoundPool dice_sound = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
    int sound_id;		//Used to control sound stream return by SoundPool
    Handler handler;	//Post message to start roll
    Timer timer=new Timer();	//Used to implement feedback to user
    boolean rolling=false;		//Is dice rolling?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_activity_test_animation);

        //load dice sound
        sound_id=dice_sound.load(this,R.raw.shake_dice,1);
        //get reference to image widget
        dice_picture = (ImageView) findViewById(R.id.imageView1);
        //link handler to callback
        handler=new Handler(callback);
    }

    //User pressed dice, lets start
    public void HandleClick(View arg0) {
        if(!rolling) {
            rolling=true;
            //Show rolling image
            dice_picture.setImageResource(R.drawable.dice3droll6);
            //Start rolling sound
            dice_sound.play(sound_id,1.0f,1.0f,0,0,1.0f);
            //Pause to allow image to update
            timer.schedule(new Roll(), 400);
        }
    }

    //When pause completed message sent to callback
    class Roll extends TimerTask {
        public void run() {
            handler.sendEmptyMessage(0);
        }
    }

    //Receives message from timer to start dice roll
    Callback callback = new Callback() {
        public boolean handleMessage(Message msg) {
            //Get roll result
            //Remember nextInt returns 0 to 5 for argument of 6
            //hence + 1
            switch(rng.nextInt(6)+1) {
                case 1:
                    dice_picture.setImageResource(R.drawable.face1);
                    break;
                case 2:
                    dice_picture.setImageResource(R.drawable.face2);
                    break;
                case 3:
                    dice_picture.setImageResource(R.drawable.face3);
                    break;
                case 4:
                    dice_picture.setImageResource(R.drawable.face4);
                    break;
                case 5:
                    dice_picture.setImageResource(R.drawable.face5);
                    break;
                case 6:
                    dice_picture.setImageResource(R.drawable.face6);
                    break;
                default:
            }
            rolling=false;	//user can press again
            return true;
        }
    };

    //Clean up
    @Override
    protected void onPause() {
        super.onPause();
        dice_sound.pause(sound_id);
    }
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}