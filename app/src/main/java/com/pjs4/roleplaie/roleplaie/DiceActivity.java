package com.pjs4.roleplaie.roleplaie;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
/**
 Created by Eric ZHOU on 01/02/2016.
 Used by the layout dice_screen.xml

 @see Dice */
public class DiceActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("projet", "lancement de l'activité des dés");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice_screen);
    }

    /**
     Gives a random result between 1 and the max possible result of the choosen dice
     @param view
     */
    public void launchDice(View view) {
        int result = Dice.launchDice(100);
        TextView tv = (TextView) findViewById(R.id.dicePlace);
        tv.setText(result + "");
        Log.i("projet", "Dés lancés");
    }
}
