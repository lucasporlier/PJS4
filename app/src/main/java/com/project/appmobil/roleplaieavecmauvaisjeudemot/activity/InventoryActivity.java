package com.project.appmobil.roleplaieavecmauvaisjeudemot.activity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.ListView;
        import android.widget.TextView;

        import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;
        import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Joueur;
        import com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase.Objet;

        import java.util.List;

/**
 * Created by nivet on 23/03/2016.
 */
public class InventoryActivity extends AppCompatActivity {
    public static final String EXTRA_NOMPRO = "com.project.appmobil.roleplaieavecmauvaisjeudemot.activity.EXTRA_NOMPRO";
    private Joueur joueur;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);
         joueur = getIntent().getParcelableExtra(PlayerFileActivity.EXTRA_NOMPROP);
        ListView lv = (ListView) findViewById(R.id.listObjectView);
        List<Objet> objets = MainActivity.db.getObjetWithNomPro(joueur.getNom());

        if (objets.isEmpty()){
            TextView tv = (TextView) findViewById(R.id.invenrotyTitle);
            tv.setText(tv.getText() + "\n\n" + getString(R.string.inventory_is_empty));
        }else{



            ObjetArrayAdapter adapter = new ObjetArrayAdapter(this, objets);
            ListView objetView = (ListView) findViewById(R.id.listObjectView);
            objetView.setAdapter(adapter);
        }
    }

    public void newObjet(View view) {
        Intent intent = new Intent(this,AddObjetActivity.class);

        intent.putExtra(EXTRA_NOMPRO,joueur.getNom());
        startActivity(intent);
    }
}
