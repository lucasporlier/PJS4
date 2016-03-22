package com.pjs4.roleplaie.roleplaie.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.pjs4.roleplaie.roleplaie.Dice;
import com.pjs4.roleplaie.roleplaie.R;

/**
 * Used by the layout dice_screen.xml
 * Created by ZHOU Eric on 01/02/2016.
 *
 * @see Dice
 */
public class DiceActivity extends Activity {

    /**
     * The number of faces for the dice
     */
    private int chosenDice = 100;

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

    /**
     * Display a random result between 1 and the max possible result of the chosen dice in a TextView
     *
     * @param view a view
     */
    public void launchDice(View view) {
        TextView tv = (TextView) findViewById(R.id.dicePlace);

        int result = Dice.launchDice(chosenDice);

        tv.setText(String.valueOf(result));

        Log.i("projet", "Dés lancés");
    }
}
