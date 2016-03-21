package com.pjs4.roleplaie.roleplaie;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView;

import android.media.AudioManager;
import android.media.SoundPool;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Used by the layout dice_screen.xml
 * Created by Eric ZHOU on 01/02/2016.
 *
 * @see Dice
 */
public class DiceActivity extends Activity {

    private int chosenDice = 100;   // The number of faces for the dice
    ImageView dice_picture;		//reference to dice picture
    SoundPool dice_sound = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
    int sound_id;		//Used to control sound stream return by SoundPool
    Handler handler;	//Post message to start roll
    Timer timer=new Timer();	//Used to implement feedback to user
    boolean rolling=false;		//Is dice rolling?

    /**
     * The display of the chosen dice
     */
    private TextView chosenDiceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("projet", "lancement de l'activité des dés");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice_screen);

        // Hardcoded list of dices
        String listDices[] = {"4", "6", "8", "10", "12", "20", "100"};

        //***************************************************************
        //CHANTIER EN COURS

        // load dice sound
        sound_id=dice_sound.load(this,R.raw.shake_dice,1);
        // get reference to image widget
        dice_picture = (ImageView) findViewById(R.id.imageView1);
        // link handler to callback
        handler=new Handler(callback);

        //***************************************************************

        chosenDiceTextView = (TextView) findViewById(R.id.chosen_dice);
        chosenDiceTextView.setText(chosenDiceTextView + String.valueOf(chosenDice));

        final ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listDices);

        ListView lv = (ListView) findViewById(R.id.dice_list);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String chosenDiceInList = String.valueOf(parent.getItemAtPosition(position));
                chosenDice = Integer.parseInt(chosenDiceInList);
                Log.i("projet", "Selected dice" + String.valueOf(chosenDice));
                chosenDiceTextView.setText(getResources().getText(R.string.you_chose_the_dice) + String.valueOf(chosenDice));
            }
        });
    }

    //Receives message from timer to start dice roll
    Callback callback = new Callback() {
        public boolean handleMessage(Message msg) {



            //Get roll result
            dice_picture.setImageResource(R.drawable.face1);

            rolling=false;	//user can press again
            return true;
        }
    };

    /**
     * Gives a random result between 1 and the max possible result of the chosen dice
     *
     * @param view
     */
    public void launchDice(View view) {
        ImageView iv = (ImageView) findViewById(R.id.imageDice3d);

        int result = Dice.launchDice(chosenDice);

        iv.setImageResource(Faces.getFace(chosenDice, result)); //face + result

        Log.i("projet", "Dés lancés");
    }

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
