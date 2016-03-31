package com.project.appmobil.roleplaieavecmauvaisjeudemot.dataBase;

/**
 * A capacity
 *
 * Created by qu2 on 21/03/2016.
 *
 * @see com.project.appmobil.roleplaieavecmauvaisjeudemot.activity.NewGameActivity2
 */
public class Competance {
    /**
     * An identifier for the capacity
     */
    private int id;

    /**
     * The name of the capacity
     */
    private String NomComp;

    /**
     * the effect of the capacity
     */
    private String effetComp;

    /**
     * the capacity owner name
     */
    private String nomPro;

    public Competance() {
    }

    public Competance(String nomComp, String effetComp, String nomPro) {
        NomComp = nomComp;
        this.effetComp = effetComp;
        this.nomPro = nomPro;
    }


    // ***** GETTERS *****
    public String getNomComp() {
        return NomComp;
    }

    public String getNomPro() {
        return nomPro;
    }

    public int getId() {
        return id;
    }

    public String getEffetComp() {
        return effetComp;
    }
    // ***** END GETTER *****


    // ***** SETTER *****
    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    public void setEffetComp(String effetComp) {
        this.effetComp = effetComp;
    }

    public void setNomComp(String nomComp) {
        NomComp = nomComp;
    }

    public void setId(int id) {
        this.id = id;
    }
    // ***** END SETTER ******


}
