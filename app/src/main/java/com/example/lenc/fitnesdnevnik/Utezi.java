package com.example.lenc.fitnesdnevnik;

/**
 * Created by Lenc on 16. 05. 2016.
 */
public class Utezi {
    private String nazivUtezi;
    private String cas;

    public String getCas() {
        return cas;
    }

    public void setCas(String cas) {
        this.cas = cas;
    }

    public Utezi(String nazivUtezi) {
        this.nazivUtezi = nazivUtezi;
    }

    public String getNazivUtezi() {
        return nazivUtezi;
    }

    public void setNazivUtezi(String nazivUtezi) {
        this.nazivUtezi = nazivUtezi;
    }

    @Override
    public String toString() {
        return "Utezi{" +
                "nazivUtezi='" + nazivUtezi + '\'' + "cas"+cas+
                '}';
    }
}


