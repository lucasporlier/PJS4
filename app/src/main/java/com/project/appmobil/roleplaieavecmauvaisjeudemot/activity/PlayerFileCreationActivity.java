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
	private static int nbPlayer;
	private static ArrayList<Joueur> playerList = new ArrayList<>();

	private int numCapacities = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player_file_creation_layout);

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

		if (p.getNombreJoueur() != 0) { //nbPLayer est static, on le fait qu'une fois
			nbPlayer = p.getNombreJoueur();
		}

		TextView title = (TextView) findViewById(R.id.Text_Title);
		title.setText(title.getText() + " " + numeroPlayer + "/" + nbPlayer);


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

		Log.i("projet", "récupération de la table row");
		TableRow tableRow = (TableRow) findViewById(R.id.table_row_caracteristics_value);
		Log.i("projet", "récupération de la table row terminé");
		List<Integer> listValues = new ArrayList<>();

		Log.i("projet", String.valueOf(tableRow.getChildCount() - 1));
		for (int i = 0; i < tableRow.getChildCount() - 1; i++) {
			EditText value = ((EditText) tableRow.getChildAt(i));
			Log.i("projet", value.getText().toString());
			listValues.add(Integer.parseInt(value.getText().toString()));
		}

		Log.i("projet", "fin récupération valeurs");
		return listValues;
	}

	public List<String> getCapacities() {

		List<String> listCapacities = new ArrayList<>();

		TableLayout tableLayout = (TableLayout) findViewById(R.id.capacitiesTable);

		Log.i("projet", "début de la boucle");
		for (int i = 0; i < tableLayout.getChildCount() - 1; i++) {
			Log.i("projet", "ligne : " + i);
			if (tableLayout.getChildAt(i) instanceof TableRow) {
				Log.i("projet", "la ligne : " + i + " est bien une table row");
				for (int j = 0; i < ((TableRow) tableLayout.getChildAt(i)).getChildCount() - 1; i++) {
					Log.i("projet", "colonne : " + j);
					Log.i("projet", ((TableRow) tableLayout.getChildAt(i)).getChildAt(i).toString());
					if (((TableRow) tableLayout.getChildAt(i)).getChildAt(j) instanceof EditText) {
						Log.i("projet", "la colonne : " + j + " est bien un Edit text");
						listCapacities.add(((EditText) ((TableRow) tableLayout.getChildAt(i)).getChildAt(j)).getText().toString());
						Log.i("projet", "Ligne ajoutée");
					}
				}
			}
		}

		return listCapacities;
	}

	public void suivant(View view) {

		Log.i("projet", getCharacteristicValues().toString());
		Log.i("projet", getCapacities().toString());

		if (numeroPlayer < nbPlayer) {
			Log.i("projet", "Préparation de l'intent PlayerFileCreationActivity");
			Intent intent = new Intent(this, PlayerFileCreationActivity.class);

			Log.i("projet", "Préparation du putExtra EXTRA_NUMPLAYER");
			intent.putExtra("EXTRA_NUMPLAYER", String.valueOf((numeroPlayer + 1)));
			intent.putExtra("EXTRA_MAXPLAYER", nbPlayer);
			intent.putExtra(NewGameActivity2.EXTRA_GAME, p);
			intent.putParcelableArrayListExtra("List", playerList);
			startActivity(intent);
		} else {
			Log.i("projet", "Préparation de l'intent InGameMenu Activity");
			Intent intent = new Intent(this, InGameMenuActivity.class);
			Log.i("projet", "Lancement de l'intent InGameMenu Activity");
			startActivity(intent);
		}

	}
}
