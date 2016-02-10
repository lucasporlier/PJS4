package com.pjs4.roleplaie.roleplaie;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Used by the layout dice_screen.xml
 * Created by Eric ZHOU on 01/02/2016.
 *
 * @see Dice
 */
public class DiceActivity extends Activity {

    private int chosenDice = 100;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("projet", "lancement de l'activité des dés");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice_screen);

        // Hardcoded list of dices
        String listDices[] = {"4", "6", "8", "10", "12", "20", "100"};

        Log.i("projet", "Selected dice" + String.valueOf(chosenDice));

        tv = (TextView) findViewById(R.id.chosen_dice);
        tv.setText(tv + String.valueOf(chosenDice));

        final ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listDices);

        ListView lv = (ListView) findViewById(R.id.dice_list);

        lv.setAdapter(listAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String chosenDiceInList = String.valueOf(parent.getItemAtPosition(position));

                chosenDice = Integer.parseInt(chosenDiceInList);

                Log.i("projet", "Selected dice" + String.valueOf(chosenDice));

                tv.setText(getResources().getText(R.string.you_chose_the_dice) + String.valueOf(chosenDice));


            }
        });
    }

    /**
     * Gives a random result between 1 and the max possible result of the chosen dice
     *
     * @param view
     */
    public void launchDice(View view) {
        Log.i("projet", "preparation du lancer du de : " + String.valueOf(chosenDice));
        int result = Dice.launchDice(chosenDice);

        TextView tv = (TextView) findViewById(R.id.dicePlace);
        tv.setText(String.valueOf(result));

        Log.i("projet", "Dés lancés");
    }
}
