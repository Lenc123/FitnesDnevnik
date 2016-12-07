package com.example.lenc.fitnesdnevnik;

/**
 * Created by Lenc on 16. 05. 2016.
 */
public class Utezi {
    private String nazivUtezi;
    private String ponovitve;
    private String serije;


    public Utezi(String nazivUtezi) {
        this.nazivUtezi = nazivUtezi;
    }

    public String getNazivUtezi() {
        return nazivUtezi;
    }

    public Utezi(String nazivUtezi, String cas) {
        this.nazivUtezi = nazivUtezi;
        this.ponovitve = ponovitve;
        this.serije = serije;
    }

    public String getPonovitve() {
        return ponovitve;
    }

    public String getSerije() {
        return serije;
    }

    public void setSerije(String serije) {
        this.serije = serije;
    }

    public void setPonovitve(String ponovitve) {
        this.ponovitve = ponovitve;
    }

    public void setNazivUtezi(String nazivUtezi) {
        this.nazivUtezi = nazivUtezi;
    }

    @Override
    public String toString() {
        return "Utezi{" +
                "nazivUtezi='" + nazivUtezi + '\'' + "ponovitve"+ponovitve+ "serije" +serije+
                '}';
    }
}


