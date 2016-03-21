package com.example.qu2.basededonnees;

/**
 * Created by qu2 on 21/03/2016.
 */
public class Stat {
    private int stat;
    private String nomStat;
    private String nomJoueurStat;

    public Stat(int stat, String nomStat,String nomJoueurStat) {
        this.stat = stat;
        this.nomStat = nomStat;
        this.nomJoueurStat = nomJoueurStat;
    }

    public String getNomStat() {
        return nomStat;
    }

    public int getStat() {
        return stat;
    }

    public void setNomStat(String nomStat) {
        this.nomStat = nomStat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }
}
