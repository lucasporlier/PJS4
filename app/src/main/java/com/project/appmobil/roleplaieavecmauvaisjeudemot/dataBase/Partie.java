package com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * A Game
 * <p/>
 * Created by qu2 on 21/03/2016.
 *
 *  @see DataBasePJS4
 */


public class Partie implements Parcelable {

    /**
     * the identifier of the game
     */
    private int id;

    /**
     * the name of the game
     */
    private String nom;


    /**
     * the type of the game
     */
    private String type;

    /**
     * the resume of the game
     */
    private String resume;

    /**
     * the number of player of the game
     */
    private int nombreJoueur;


    /**
     * the number of stats of the game
     */
    private int nombreStat;
    private List<String> listStat;
    private List<Joueur> listJoueur;

    public Partie(String nom, String type, int nombreJoueur, int nombreStat) {
        this.nom = nom;
        this.type = type;
        this.nombreJoueur = nombreJoueur;
        this.nombreStat = nombreStat;
        this.resume = "";
        this.listStat = new ArrayList<>();
        this.listJoueur = new ArrayList<>();
    }

    public Partie() {
    }

    public static final Creator<Partie> CREATOR = new Creator<Partie>() {
        @Override
        public Partie createFromParcel(Parcel in) {
            return new Partie(in);
        }

        @Override
        public Partie[] newArray(int size) {
            return new Partie[size];
        }
    };

    // ***** GETTER *****
    public int getId() {

        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public int getNombreJoueur() {
        return nombreJoueur;
    }

    public List<Joueur> getListJoueur() {

        return listJoueur;
    }

    public String getResume() {
        return resume;
    }

    public String getStat(int i) {
        return listStat.get(i);
    }

    public int getNombreStat() {
        return nombreStat;
    }
    // ***** GETTER *****


    // ***** SETTER *****
    public void setId(int id) {

        this.id = id;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNombreJoueur(int nombreJoueur) {

        this.nombreJoueur = nombreJoueur;
    }

    public void setNombreStat(int nombreStat) {
        this.nombreStat = nombreStat;
    }

    public List<String> getListStat() {
        return listStat;
    }

    public void setListStat(List<String> listStat) {
        this.listStat = listStat;
    }

    public void setListJoueur(List<Joueur> listJoueur) {

        this.listJoueur = listJoueur;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
    // ***** END SETTER *****

    /**
     * Adds a player
     * @param j the player
     */
    public void addJoueur(Joueur j) {
        this.listJoueur.add(j);
    }

    public Partie(Parcel in) {
        nom = in.readString();
        type = in.readString();
        nombreJoueur = in.readInt();
        nombreStat = in.readInt();
        List<String> l = new ArrayList<String>();
        in.readStringList(l);
        if (l != null) {
            listStat = l;
        } else
            listStat = new ArrayList<String>();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeString(type);
        dest.writeInt(nombreJoueur);
        dest.writeInt(nombreStat);
        dest.writeStringList(listStat);
    }

    public void addStat(int i, String name) {
        listStat.add(i, name);
    }

    public int getStatNumber() {
        return nombreStat;
    }


}


