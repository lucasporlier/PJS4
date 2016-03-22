package com.pjs4.roleplaie.roleplaie.dataBase;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qu2 on 21/03/2016.
 */
public class Partie implements Parcelable {
    private int id;
    private String nom;
    private String type;
    private int nombreJoueur;
    private int nombreStat;
    private List<String> listStat;
    private List<Joueur> listJoueur;

    public Partie(String nom, String type, int nombreJoueur, int nombreStat) {
        this.nom = nom;
        this.type = type;
        this.nombreJoueur = nombreJoueur;
        this.nombreStat = nombreStat;
        this.listStat = new ArrayList<String>();
        this.listJoueur = new ArrayList<Joueur>();
    }

    public Partie(){}

    public int getId() {

        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getType()
    {
        return type;
    }

    public int getNombreJoueur() {
        return nombreJoueur;
    }

    public List<Joueur> getListJoueur() {

        return listJoueur;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setNombreJoueur(int nombreJoueur) {

        this.nombreJoueur = nombreJoueur;
    }

    public void setListJoueur(List<Joueur> listJoueur) {

        this.listJoueur = listJoueur;
    }

    public Partie(Parcel in) {
        nom = in.readString();
        type = in.readString();
        nombreJoueur = in.readInt();
        nombreStat = in.readInt();
        List<String> l = new ArrayList<String>();
        in.readStringList(l);
        if(l!=null){
            listStat = l;
        }
        else
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

    public void addStat(int i, String name){
        listStat.add(i, name);
    }

    public int getStatNumber(){
        return nombreStat;
    }

}

