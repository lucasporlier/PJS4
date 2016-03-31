package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Partie;


/**
 * Used by the activity new_game.xml
 * <p/>
 * Created by ZHOU Eric on 01/02/2016.
 *
 * @see NewGameActivity2
 */
public class NewGameActivity extends Activity implements Parcelable {

    public static final String EXTRA_GAME1 = "com.project.appmobil.roleplaieavecmauvaisjeudemot.activity.EXTRA_GAME1";

    public NewGameActivity() {
    }


    protected NewGameActivity(Parcel in) {
    }

    public static final Creator<NewGameActivity> CREATOR = new Creator<NewGameActivity>() {
        @Override
        public NewGameActivity createFromParcel(Parcel in) {
            return new NewGameActivity(in);
        }

        @Override
        public NewGameActivity[] newArray(int size) {
            return new NewGameActivity[size];
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game);
        Log.i("projet", "Lancement d'une nouvelel partie");
    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    /**
     * Confirms the creation of a new games
     *
     * @param view a view
     */
    public void ConfirmNewGame(View view) {
        String gameName = ((TextView) findViewById(R.id.GameNameEdiText)).getText().toString();
        String nbPlayer = ((TextView) findViewById(R.id.NbPlayereditText)).getText().toString();
        String typeGame = ((TextView) findViewById(R.id.TypeGameditText)).getText().toString();
        String nbStat = ((TextView) findViewById(R.id.nbStatEditText)).getText().toString();
        Partie p = MainActivity.db.getPartieWithName(gameName);

        if(gameName.equals("") || nbPlayer.equals("") || typeGame.equals("") || nbStat.equals("")){
            Toast.makeText(this, R.string.please_comp_all_fielsd, Toast.LENGTH_LONG).show();
            return ;
        }
        if( p != null ){
            Toast.makeText(this, R.string.game_name_used, Toast.LENGTH_LONG).show();
            return ;
        }

        Partie partie = new Partie(gameName, typeGame, Integer.parseInt(nbPlayer), Integer.parseInt(nbStat));

        Intent intent = new Intent(this, NewGameActivity2.class);

        intent.putExtra(EXTRA_GAME1, partie);
        startActivity(intent);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
