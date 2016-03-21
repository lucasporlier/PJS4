package com.example.qu2.basededonnees;

/**
 * Created by qu2 on 21/03/2016.
 */
public class Objet {
    private int nb;
    private String nom;
    private String effet;
    private int id;
    private String nomPro;



    public Objet(){};




    public Objet(int nb,String name,String effet,String nompro){
        this.nb = nb;
        this.nom=name;
        this.effet=effet;
        this.nomPro = nompro;
    }

    public String getEffet() {
        return effet;
    }

    public void setEffet(String effet) {
        this.effet = effet;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(int id){this.id=id;}

    public int getId() {
        return id;
    }

    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }
    public String getNomPro() {

        return nomPro;
    }
}
