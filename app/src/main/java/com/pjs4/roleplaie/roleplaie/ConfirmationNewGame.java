package com.pjs4.roleplaie.roleplaie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pjs4.roleplaie.roleplaie.dataBase.Game;

/**
 * Created by nivet on 21/03/2016.
 */
public class ConfirmationNewGame extends AppCompatActivity {
    private Game game;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_confirmation_newgame);

        game = getIntent().getExtras().getParcelable("game");
    }
}
