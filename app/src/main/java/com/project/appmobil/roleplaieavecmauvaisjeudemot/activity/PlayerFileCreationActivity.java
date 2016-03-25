package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.DataBasePJS4;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Joueur;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Partie;

import java.util.ArrayList;
import java.util.List;

/**
 * Used by the layout player_file_creation_layout.xml
 * Created by ZHOU Eric on 08/02/2016.
 */
public class PlayerFileCreationActivity extends Activity {

	/**
	 * The game that contain the list of Characteristics
	 */
	private static Partie p;
	private static int numeroPlayer = 1;
	private static int nbPlayerMAX;
	private static ArrayList<Joueur> playerList = new ArrayList<>();
	private static TextView nomPerso;
	private static TextView racePerso;
	private static TextView hpPerso;
	private static TextView manaPerso;


	private int numCapacities = 1;

	public static final String EXTRA_NUMPLAYER = "COM.PJS4.ROLEPLAIE.ROLEPLAIE.NumPlayer";
	//public static final String EXTRA_GAMENAME = "COM.PJS4.ROLEPLAIE.ROLEPLAIE.GameName";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player_file_creation_layout);

		nomPerso = (TextView) findViewById(R.id.ET_nomPerso);
		racePerso = (TextView) findViewById(R.id.ET_racePerso);
		hpPerso = (TextView) findViewById(R.id.ET_hpMax);
		manaPerso = (TextView) findViewById(R.id.ET_manaMax);


		Log.i("projet", "Lancement de la création d'une fiche de personnage");

		Log.i("Projet", "getIntent");
		Intent intent = getIntent();
		Log.i("Projet", "get intent ok");

		Log.i("Projet", "GetParcelable");
		p = intent.getExtras().getParcelable(NewGameActivity2.EXTRA_GAME);
		Log.i("projet", p.toString());
		Log.i("Projet", "fin getParcelable");

		TableRow tableRowName = (TableRow) findViewById(R.id.table_row_caracteristics_name);
		TableRow tableRowValue = (TableRow) findViewById(R.id.table_row_caracteristics_value);

		Log.i("Projet", "getListStat");
		List<String> listStats = p.getListStat();
		Log.i("Projet", "fin getListStat");
		Log.i("projet", listStats.toString());


		TextView tv;
		for (int i = 0; i < p.getStatNumber(); i++) {
			tv = new TextView(this);

			tv.setText(listStats.get(i));
			tableRowName.addView(tv);
		}


		EditText ed;
		for (int i = 0; i < p.getStatNumber(); i++) {
			ed = new EditText(this);
			ed.setHint(getResources().getString(R.string.value));
			ed.setInputType(InputType.TYPE_CLASS_NUMBER);

			tableRowValue.addView(ed, i);
		}

		if (p.getNombreJoueur() != 0) { //Récupère le nombre de joueur MAX
			nbPlayerMAX = p.getNombreJoueur();
		}

        if(intent.getStringExtra(PlayerFileCreationActivity.EXTRA_NUMPLAYER) != null){ //Récupération du numéro du joueur actuel
            Log.i("projet", "Incrémentation de numeroPlayer");
            numeroPlayer = Integer.parseInt(intent.getStringExtra(PlayerFileCreationActivity.EXTRA_NUMPLAYER));
        }

		TextView title = (TextView) findViewById(R.id.Text_Title);
		title.setText(title.getText() + " " + numeroPlayer + "/" + nbPlayerMAX);


	}


	/**
	 * Add a new line in the table of capacities
	 *
	 * @param view the view
	 */
	public void moreCapacity(View view) {
		Log.i("projet", "Ajout d'une nouelle ligne");
		TableLayout tbL = (TableLayout) findViewById(R.id.capacitiesTable);

		EditText ed1 = new EditText(this);
		ed1.setHint("Name");

		EditText ed2 = new EditText(this);
		ed2.setHint("Description");

		Log.i("projet ", "Début ajout ");
		TableRow tr = new TableRow(this);
		tr.addView(ed1);
		tr.addView(ed2);
		Log.i("projet ", "editText ajout reussi");
		tbL.addView(tr);
		Log.i("projet ", "ajout reussi");
	}

	/**
	 * Gets the list of the characteristics values
	 *
	 * @return the list of characteristics values
	 */
	public List<Integer> getCharacteristicValues() {
		Log.i("projet", "début récupération valeurs");

		TableRow tableRow = (TableRow) findViewById(R.id.table_row_caracteristics_value);

		List<Integer> listValues = new ArrayList<>();


		for (int i = 0; i < tableRow.getChildCount() - 1; i++) {
			EditText value = ((EditText) tableRow.getChildAt(i));

			listValues.add(Integer.parseInt(value.getText().toString()));
		}
		return listValues;
	}

	public List<String> getCapacities() {

		List<String> listCapacities = new ArrayList<>();

		TableLayout tableLayout = (TableLayout) findViewById(R.id.capacitiesTable);

		Log.i("projet", "Il y a " + tableLayout.getChildCount() + "fils dans tableLayout");
		for (int i = 0; i < tableLayout.getChildCount(); i++) {

			/*if (tableLayout.getChildAt(i) instanceof TableRow) {*/
				Log.i("projet", "la ligne : " + i + " est bien une table row");

				Log.i("projet", "Il y a " + ((TableRow) tableLayout.getChildAt(i)).getChildCount() + "fils dans tableRow");
				for (int j = 0; j < ((TableRow) tableLayout.getChildAt(i)).getChildCount(); j++) {

					/*if (((TableRow) tableLayout.getChildAt(i)).getChildAt(j) instanceof EditText) {*/
						listCapacities.add(((EditText) ((TableRow) tableLayout.getChildAt(i)).getChildAt(j)).getText().toString());
						Log.i("projet", "Ligne ajoutée");
					/*}*/
				/*}*/
			}
		}

		return listCapacities;
	}

    public void retour(View view){
        this.finish();
    }


    public void suivant(View view) {

		Log.i("projet", getCharacteristicValues().toString());
		Log.i("projet", getCapacities().toString());

		if (numeroPlayer < nbPlayerMAX) {
			Log.i("projet", "Préparation de l'intent PlayerFileCreationActivity");
			Intent intent = new Intent(this, PlayerFileCreationActivity.class);

			Log.i("projet", "Préparation du putExtra EXTRA_NUMPLAYER");
			intent.putExtra(EXTRA_NUMPLAYER, String.valueOf((numeroPlayer + 1) + ""));
			intent.putExtra(NewGameActivity2.EXTRA_GAME, p);
			intent.putParcelableArrayListExtra("List", playerList);
			startActivity(intent);
		} else {
			Log.i("projet", "Préparation de l'intent InGameMenu Activity");
			Intent intent = new Intent(this, InGameMenuActivity.class);
            intent.putExtra(LoadGameActivity.EXTRA_GAMENAME, p);
			Log.i("projet", "Lancement de l'intent InGameMenu Activity");

			for(Joueur j: playerList){
				MainActivity.db.insertJoueur(j);
			}

			MainActivity.db.insertparti(p);

			startActivity(intent);
		}

	}
}
