package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.DataBasePJS4;
import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Objet;

/**
 * Created by Utilisateur on 29/03/2016.
 */
public class UseItemActivity extends Activity {

	Objet objet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_objet_layout);
		Intent intent = getIntent();

		String nomObjet = intent.getStringExtra(InventoryActivity.EXTRA_NOMOBJET);
		String nomPro = intent.getStringExtra(InventoryActivity.EXTRA_NOMPRO);

		objet = MainActivity.db.getObjetWithName(nomObjet, nomPro);

		TextView textViewNomPro = (TextView) findViewById(R.id.nomProObjUtil);
		TextView textViewNom = (TextView) findViewById(R.id.nomObjUtil);
		TextView textViewQuantity = (TextView) findViewById(R.id.quantityObjUtil);
		TextView textViewEffet = (TextView) findViewById(R.id.effetObjUtil);

		textViewNomPro.setText(objet.getNomPro());
		textViewNom.setText(objet.getNom());
		textViewQuantity.setText(String.valueOf(objet.getNb()));
		textViewEffet.setText(objet.getEffet());

	}

	public void cancel(View view) {
		finish();
	}

	public void use(View view) {
		DataBasePJS4 db = MainActivity.db;

		EditText useQuantity = (EditText) findViewById(R.id.nombreUse);
		objet.setNb(objet.getNb() - Integer.parseInt(useQuantity.getText().toString()));
		if(Integer.parseInt(useQuantity.getText().toString())<= objet.getNb()){
			db.updateObjet(objet.getNom(), objet, objet.getNomPro());
		}

		cancel(view);
	}
}
