package com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase;

/**
 * An object or Item
 * <p/>
 * Created by qu2 on 21/03/2016.
 *
 * @see DataBasePJS4
 */
public class Objet {
    /**
     * a quantity
     */
    private int nb;

    /**
     * the name of the object
     */
    private String nom;

    /**
     * the effect of the object
     */
    private String effet;

    /**
     * the identifier of the object
     */
    private int id;
    /**
     * the object owner
     */
    private String nomPro;


    public Objet() {
    }

    public Objet(int nb, String name, String effet, String nompro) {
        this.nb = nb;
        this.nom = name;
        this.effet = effet;
        this.nomPro = nompro;
    }


    // ***** GETTER *****
    public String getEffet() {
        return effet;
    }

    public int getNb() {
        return nb;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public String getNomPro() {

        return nomPro;
    }
    // ***** END GETTER


    // ***** SETTER *****

    public void setEffet(String effet) {
        this.effet = effet;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }
// ***** END SETTER *****

}
