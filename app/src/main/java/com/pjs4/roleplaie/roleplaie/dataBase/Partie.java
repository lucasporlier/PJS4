package com.pjs4.roleplaie.roleplaie.dataBase;

import java.util.List;

/**
 * Created by qu2 on 21/03/2016.
 */
public class Partie {
    private int id;
    private String nom;
    private String type;
    private int nombreJoueur;
    private String resume;
    private List<Joueur> listJoueur;

    public Partie(String nom, String type, int nombreJoueur) {
        this.nom = nom;
        this.type = type;
        this.nombreJoueur = nombreJoueur;
        this.resume = "";
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

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}

