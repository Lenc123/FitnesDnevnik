package com.example.lenc.fitnesdnevnik;

/**
 * Created by Lenc on 16. 05. 2016.
 */
public class Skupina {
    private String kardio;
    private String utezi;

    public Skupina(String kardio, String utezi) {
        this.kardio = kardio;
        this.utezi = utezi;
    }

    public String getKardio() {
        return kardio;
    }

    public void setKardio(String kardio) {
        this.kardio = kardio;
    }

    public String getUtezi() {
        return utezi;
    }

    public void setUtezi(String utezi) {
        this.utezi = utezi;
    }
}

