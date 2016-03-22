package com.pjs4.roleplaie.roleplaie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.pjs4.roleplaie.roleplaie.*;
import com.pjs4.roleplaie.roleplaie.dataBase.Partie;

import java.util.ArrayList;

public class NewGameActivity2 extends AppCompatActivity {
    public static final String EXTRA_GAME = "com.pjs4.roleplai.roleplaie.EXTRA_GAME";
    private Partie game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game2);


        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        game = getIntent().getExtras().getParcelable(NewGameActivity.EXTRA_GAME1);

        ListView statView = (ListView) findViewById(R.id.listStatView);
        ArrayList<String> s = new ArrayList<String>();
        for (int i = 1; i <= game.getStatNumber(); i++) {
            s.add(i-1,"Caracteristique " + i);
            //EditText et = new EditText(this);
            //et.setId(i);
            //et.setHint(s[i - 1]);
            //statView.addView(et);
        }
        StatArrayAdapter adapter = new StatArrayAdapter(this, s);

        statView.setAdapter(adapter);
    }

    public void confirmNewGame2(View v){
        ListView statView = (ListView) findViewById(R.id.listStatView);
        ListAdapter la = statView.getAdapter();
        if(la == null){
            return;
        }

        for(int i = 0; i < game.getStatNumber(); i++) {
            //statView.findViewById(i);
            String strg = (String) la.getItem(i);
            if(strg != null){
                game.addStat(i, strg);
            }
        }

        Intent intent = new Intent(this, PlayerFileCreationActivity.class);
        intent.putExtra(EXTRA_GAME, game);
        startActivity(intent);
    }
}
