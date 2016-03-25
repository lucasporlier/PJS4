package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

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

import android.media.AudioManager;
import android.media.SoundPool;

import java.util.Timer;
import java.util.TimerTask;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.Dice;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.Faces;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;

/**
 * Used by the layout dice_screen.xml
 * Created by ZHOU Eric on 01/02/2016.
 * Modified by Porlier-Pagnon Lucas on 25/03/2016.
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


	//When pause completed message sent to callback
	class Roll extends TimerTask {
		public void run() {
			Log.i("projet","koukou le TimerTask (pause)");
			handler.sendEmptyMessage(0);
		}
	}

	//Receives message from timer to start dice roll
	Callback callback = new Callback() {
		public boolean handleMessage(Message msg) {

			//Get roll result
			launchDice();

			rolling=false;	//user can press again
			return true;
		}
	};

	/**
	 * Gives a random result between 1 and the max possible result of the chosen dice
	 */
	public void launchDice() {
		dice_picture = (ImageView) findViewById(R.id.imageDice3d);

		int result = Dice.launchDice(chosenDice);

		dice_picture.setImageResource(Faces.getFace(chosenDice, result)); //face + result

		Log.i("projet", "Dé "+chosenDice+" lancé, resultat : "+result);
	}

	//Clean up
	@Override
	protected void onPause() {
		super.onPause();
		dice_sound.pause(sound_id);
		Log.i("projet", "DiceActivity paused");
	}

	protected void onDestroy() {
		super.onDestroy();
		timer.cancel();
	}
}
