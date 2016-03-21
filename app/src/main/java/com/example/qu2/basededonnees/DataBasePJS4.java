package com.example.qu2.basededonnees;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qu2 on 21/03/2016.
 */
public class DataBasePJS4 extends SQLiteOpenHelper {

    private static final int version = 1;
    private static final String dataBaseName = "PJS4.db";

/*-----------------------------------------------------------------Competance---------------------------------------------------------*/
    private static final String tab_competance = "table_competance";

    private static final String COL_IDComp = "ID";
    private static final int NUM_COL_IDComp = 0;

    private static final String COL_nomComp = "nomComp";
    private static final int NUM_COL_nomComp = 1;

    private static final String COL_effetComp = "effet";
    private static final int NUM_COL_effetComp = 2;

    private static final String COL_nomProComp = "nomproprietaire";
    private static final int NUM_COL_nomProComp = 3;

    private static final String COL_manaUseComp= "manaUse";
    private static final int NUM_COL_manaUseComp = 4;

    private static final String tab_comp = "CREATE TABLE " + tab_competance + " ("
            + COL_IDComp + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_nomComp + " TEXT NOT NULL, "
            + COL_effetComp + " TEXT NOT NULL, "
            + COL_nomProComp + " TEXT NOT NULL, "
            + COL_manaUseComp+" INTEGER NOT NULL);";

/*---------------------------------------------------------------------Objet-------------------------------------------------------*/
private static final String tab_objet = "table_objet";

    private static final String COL_IDObj = "ID";
    private static final int NUM_COL_IDObj = 0;

    private static final String COL_nomObj = "nom";
    private static final int NUM_COL_nomObj = 1;

    private static final String COL_nbObj = "nombre";
    private static final int NUM_COL_nbObj = 2;

    private static final String COL_effetObj = "effet";
    private static final int NUM_COL_effetObj = 3;

    private static final String COL_nomproObj = "nomproprietaire";
    private static final int NUM_COL_nomproObj = 4;

    private static final String tab_ob = "CREATE TABLE " + tab_objet + " ("
            + COL_IDObj + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_nomObj + " TEXT NOT NULL, "
            + COL_nbObj + " TEXT NOT NULL, "
            + COL_effetObj + " TEXT NOT NULL, "
            + COL_nomproObj + " TEXT NOT NULL);";

/*------------------------------------------------------------------------Joueur---------------------------------------------------------------*/
private static final String tab_joueur = "table_joueur";

    private static final String COL_IDPerso = "ID";
    private static final int NUM_COL_ID = 0;

    private static final String COL_nomPerso = "nom";
    private static final int NUM_COL_nomPerso = 1;

    private static final String COL_racePerso = "race";
    private static final int NUM_COL_racePerso = 2;

    private static final String COL_pvPerso = "pv";
    private static final int NUM_COL_pvPerso = 3;

    private static final String COL_manaPerso = "mana";
    private static final int NUM_COL_manaPerso = 4;

    private static final String COL_lvlPerso = "lvl";
    private static final int NUM_COL_lvlPerso = 5;

    private static final String COL_nbExpPerso = "nbexp";
    private static final int NUM_COL_nbExpPerso = 6;

    private static final String COL_lorePerso = "lore";
    private static final int NUM_COL_lorePerso = 7;

    private static final String COL_nomPartiePerso = "lore";
    private static final int NUM_COL_nomPartiePerso = 8;


    private static final String tab_player = "CREATE TABLE " + tab_joueur + " ("
            + COL_IDPerso + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_nomPerso + " TEXT NOT NULL, "
            + COL_racePerso + " TEXT NOT NULL, "
            + COL_pvPerso + " INTEGER NOT NULL, "
            + COL_manaPerso +" INTEGER NOT NULL, "
            + COL_lvlPerso + " INTEGER NOT NULL, "
            + COL_nbExpPerso + " INT NOT NULL, "
            + COL_nomPartiePerso + " TEXT NOT NUL "
            + COL_lorePerso +" TEXT);";
/*--------------------------------------------------------------------------------------------Partie----------------------------------------------------------------------------------------*/

    private static final String tab_partie = "table_partie";

    private static final String COL_IDParti = "ID";
    private static final int NUM_COL_IDParti = 0;

    private static final String COL_nomParti = "nom";
    private static final int NUM_COL_nomParti = 1;

    private static final String COL_typeParti = "type";
    private static final int NUM_COL_typeParti = 2;

    private static final String COL_nbJoueurParti = "nbJoueur";
    private static final int NUM_COL_nbJoueurParti = 3;


    private static final String tab_game = "CREATE TABLE " + tab_partie + " ("
            + COL_IDParti + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_nomParti + " TEXT NOT NULL, "
            + COL_nbJoueurParti + " TEXT NOT NULL, "
            + COL_typeParti + " TEXT NOT NULL);";

/*-------------------------------------------------------------------------------------------------------------------------------------------*/

    public DataBasePJS4(Context context) {
        super(context, dataBaseName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(tab_comp);
        db.execSQL(tab_ob);
        db.execSQL(tab_player);
        db.execSQL(tab_game);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        db.execSQL("DROP TABLE " + tab_competance + ";");
        db.execSQL("DROP TABLE " + tab_objet + ";");
        db.execSQL("DROP TABLE " + tab_joueur + ";");
        db.execSQL("DROP TABLE " + tab_partie + ";");
        onCreate(db);
    }


    /* *********************************************************** OBJET ********************************************************** */

    public Objet getObjetWithName(String nom){

        SQLiteDatabase bdd = getWritableDatabase();

        String query =  "SELECT * FROM " + tab_objet + " WHERE " + COL_nomObj +" = \"" + nom + "\"";
        Cursor c = bdd.rawQuery(query,null);

        return cursorToObjet(c);
    }

    public void insertObjets(Objet o){

        SQLiteDatabase bdd = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_nomObj, o.getNom());
        values.put(COL_nbObj, o.getNb());
        values.put(COL_effetObj, o.getEffet());
        values.put(COL_nomproObj, o.getNomPro());

        bdd.insert(tab_objet, null, values);
    }

    public int updateObjet(String nom, Objet o){
        SQLiteDatabase bdd = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_nomObj, o.getNom());
        values.put(COL_nbObj, o.getNb());
        values.put(COL_effetComp, o.getEffet());
        values.put(COL_nomProComp, o.getNomPro());
        return bdd.update(tab_objet, values, COL_nomObj + " = " + nom, null);
    }

    public int removeObjetWithName(String name){
        SQLiteDatabase bdd = getWritableDatabase();
        return bdd.delete(tab_objet, COL_nomObj + " = " + name, null);
    }

    private Objet cursorToObjet(Cursor c){

        if (c.getCount() == 0) {
            return null;
        }

        c.moveToFirst();

        Objet o = new Objet();

        o.setId(c.getInt(NUM_COL_IDObj));
        o.setNom(c.getString(NUM_COL_nomObj));
        o.setNb(c.getInt(NUM_COL_nbObj));
        o.setEffet(c.getString(NUM_COL_effetObj));
        o.setNomPro(c.getString(NUM_COL_nomproObj));

        c.close();

        return o;
    }

    /* *********************************************************** COMPETANCES ********************************************************** */

    public Competance getCompetanceWithName(String nom){
        SQLiteDatabase bdd = getWritableDatabase();
        String query =  "SELECT * FROM " + tab_competance + " WHERE " + COL_nomComp +" = \"" + nom + "\"";
        Cursor c = bdd.rawQuery(query, null);

        return cursorToCompetance(c);
    }

    public void insertCompetance(Competance c){
        SQLiteDatabase bdd = getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(COL_nomComp, c.getNomComp());
        values.put(COL_effetComp, c.getEffetComp());
        values.put(COL_nomProComp, c.getNomPro());
        values.put(COL_manaUseComp, c.getManaUse());

        bdd.insert(tab_competance, null, values);
    }

    public int updateCompetance(String nom, Objet o){
        SQLiteDatabase bdd = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_nomComp, o.getNom());
        values.put(COL_effetComp, o.getNb());
        values.put(COL_nomProComp, o.getEffet());
        values.put(COL_manaUseComp,o.getNomPro());
        return bdd.update(tab_competance, values, COL_nomComp + " = " + nom, null);
    }

    public int removeCompetanceWithName(String name){
        SQLiteDatabase bdd = getWritableDatabase();
        return bdd.delete(tab_competance, COL_nomComp + " = " + name, null);
    }

    private Competance cursorToCompetance(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        c.moveToFirst();

        Competance competance = new Competance();

        competance.setId(c.getInt(NUM_COL_ID));
        competance.setNomComp(c.getString(NUM_COL_nomComp));
        competance.setEffetComp(c.getString(NUM_COL_effetComp));
        competance.setNomPro(c.getString(NUM_COL_nomProComp));
        competance.setManaUse(c.getInt(NUM_COL_manaUseComp));

        c.close();

        return competance;
    }

    /* *********************************************************** JOUEURS ********************************************************** */

    public Joueur getJoueurWithName(String nom){
        SQLiteDatabase bdd = getWritableDatabase();
        String query =  "SELECT * FROM " + tab_joueur + " WHERE " + COL_nomPerso +" = \"" + nom + "\"";
        Cursor c = bdd.rawQuery(query, null);

        return cursorToJoueur(c);
    }

    public void insertJoueur(Joueur j){
        SQLiteDatabase bdd = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_nomPerso, j.getNom());
        values.put(COL_racePerso, j.getRace());
        values.put(COL_pvPerso, j.getPv());
        values.put(COL_manaPerso, j.getMana());
        values.put(COL_lvlPerso, j.getLvl());
        values.put(COL_nbExpPerso, j.getNbExp());
        values.put(COL_lorePerso, j.getLore());
        values.put(COL_nomPartiePerso, j.getNomPartie());

        bdd.insert(tab_joueur, null, values);
    }

    public int updateJoueur(String nom, Joueur j){
        SQLiteDatabase bdd = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_nomPerso, j.getNom());
        values.put(COL_racePerso, j.getRace());
        values.put(COL_pvPerso, j.getPv());
        values.put(COL_manaPerso, j.getMana());
        values.put(COL_lvlPerso, j.getLvl());
        values.put(COL_nbExpPerso, j.getNbExp());
        values.put(COL_lorePerso, j.getLore());
        values.put(COL_nomPartiePerso, j.getNomPartie());

        return bdd.update(tab_joueur, values, COL_nomPerso + " = " + nom, null);
    }

    public int removeJoueurWithName(String name){
        SQLiteDatabase bdd = getWritableDatabase();
        //Suppression d'un livre de la BDD grâce à l'ID
        return bdd.delete(tab_joueur, COL_nomPerso + " = " + name, null);
    }



    private Joueur cursorToJoueur(Cursor c){

        if (c.getCount() == 0)
            return null;

        c.moveToFirst();

        Joueur joueur = new Joueur();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        joueur.setId(c.getInt(NUM_COL_ID));
        joueur.setNom(c.getString(NUM_COL_nomPerso));
        joueur.setRace(c.getString(NUM_COL_racePerso));
        joueur.setPv(c.getInt(NUM_COL_pvPerso));
        joueur.setMana(c.getInt(NUM_COL_manaPerso));
        joueur.setLvl(c.getInt(NUM_COL_lvlPerso));
        joueur.setNbExp(c.getInt(NUM_COL_nbExpPerso));
        joueur.setLore(c.getString(NUM_COL_lorePerso));
        joueur.setNomPartie(c.getString(NUM_COL_nomPartiePerso));

        c.close();
        return joueur;
    }


    private List<Joueur> cursorToListJoueur(Cursor c){
        List<Joueur> l = new ArrayList<Joueur>();


        while(c.moveToNext()){
            Joueur joueur = new Joueur();
            //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
            joueur.setId(c.getInt(NUM_COL_ID));
            joueur.setNom(c.getString(NUM_COL_nomPerso));
            joueur.setRace(c.getString(NUM_COL_racePerso));
            joueur.setPv(c.getInt(NUM_COL_pvPerso));
            joueur.setMana(c.getInt(NUM_COL_manaPerso));
            joueur.setLvl(c.getInt(NUM_COL_lvlPerso));
            joueur.setNbExp(c.getInt(NUM_COL_nbExpPerso));
            joueur.setLore(c.getString(NUM_COL_lorePerso));
            joueur.setNomPartie(c.getString(NUM_COL_nomPartiePerso));
            l.add(joueur);
        }



        return l;
    }

    public List<Joueur> getJoueurWithNomPartie(String nomPartie){
        SQLiteDatabase bdd = getWritableDatabase();
        String query =  "SELECT * FROM " + tab_joueur + " WHERE " + COL_nomPartiePerso +" = \"" + nomPartie + "\"";
        Cursor c = bdd.rawQuery(query,null);

        return cursorToListJoueur(c);
    }


   /* *********************************************************** PARTIE ********************************************************** */

    public Partie getPartietWithName(String nom){
        SQLiteDatabase bdd = getWritableDatabase();
        String query =  "SELECT * FROM " + tab_partie + " WHERE " + COL_nomParti +" = \"" + nom + "\"";
        Cursor c = bdd.rawQuery(query,null);

        return cursorToparti(c);
    }

    public void insertparti(Partie p){
        SQLiteDatabase bdd = getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(COL_nomParti, p.getNom());
        values.put(COL_typeParti, p.getType());
        values.put(COL_nbJoueurParti, p.getNombreJoueur());

        bdd.insert(tab_partie, null, values);
    }

    public int updateParti(String nom, Partie p){
        SQLiteDatabase bdd = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_nomParti, p.getNom());
        values.put(COL_typeParti, p.getType());
        values.put(COL_nbJoueurParti, p.getNombreJoueur());

        return bdd.update(tab_partie, values, COL_nomParti + " = " + nom, null);
    }

    public int removePartiWithName(String name){
        SQLiteDatabase bdd = getWritableDatabase();
        return bdd.delete(tab_partie, COL_nomParti + " = " + name, null);
    }



    private Partie cursorToparti(Cursor c){

        if (c.getCount() == 0) {
            return null;
        }

        c.moveToFirst();

        Partie j = new Partie();

        j.setId(c.getInt(NUM_COL_ID));
        j.setNom(c.getString(NUM_COL_nomParti));
        j.setType(c.getString(NUM_COL_typeParti));
        j.setNombreJoueur(c.getInt(NUM_COL_nbJoueurParti));

        c.close();

        return j;
    }
}
