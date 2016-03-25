package com.project.appmobil.roleplaieavecmauvaisjeudemot;

import android.util.Log;

import java.util.Random;

/**
 Dices to launch
 Created by ZHOU Eric on 01/02/2016.
 */
public class Dice{

	/**
	 Gives a random number between 1 and n
	 @param n the highest number
	 @return random number in the given range
	 */
	public static int launchDice(int n) {
		Log.i("projet", "lancer des dés");
		Random random = new Random();
		return random.nextInt(n)+1;
	}
}

