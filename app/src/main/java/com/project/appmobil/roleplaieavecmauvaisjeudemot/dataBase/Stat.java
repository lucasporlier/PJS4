package com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase;

/**
 * A Characteristic
 * <p/>
 * Created by qu2 on 21/03/2016.
 *
 * @see DataBasePJS4
 */
public class Stat {

    /**
     * the identifier of the characteristic
     */
    private int ID;
    /**
     * the level of the characteristic
     */
    private int stat;
    /**
     * the name of the characteristic
     */
    private String nomStat;
    /**
     * the owner of the characteristic
     */
    private String nomJoueurStat;


    public Stat() {
    }

    public Stat(int stat, String nomStat, String nomJoueurStat) {
        this.stat = stat;
        this.nomStat = nomStat;
        this.nomJoueurStat = nomJoueurStat;
    }

    // ***** GETTER *****
    public int getID() {
        return ID;
    }


    public String getNomStat() {
        return nomStat;
    }

    public String getNomJoueurStat() {

        return nomJoueurStat;
    }

    public int getStat() {
        return stat;
    }
    // ***** END GETTER *****

    // ***** SETTER *****
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNomStat(String nomStat) {
        this.nomStat = nomStat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public void setNomJoueurStat(String nomJoueurStat) {
        this.nomJoueurStat = nomJoueurStat;
    }
    // ***** END SETTER *****


}

