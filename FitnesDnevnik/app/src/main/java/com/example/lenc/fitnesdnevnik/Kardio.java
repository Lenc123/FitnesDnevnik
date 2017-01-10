package com.example.lenc.fitnesdnevnik;

/**
 * Created by Lenc on 16. 05. 2016.
 */
public class Kardio {
    private String nazivKardio;
    private String cas;

    public Kardio(String nazivKardio, String cas) {
        this.nazivKardio = nazivKardio;
        this.cas = cas;
    }

    public String getCas() {
        return cas;
    }

    public void setCas(String cas) {
        this.cas = cas;
    }

    public Kardio(String nazivKardio) {
        this.nazivKardio = nazivKardio;
    }

    public String getNazivKardio() {
        return nazivKardio;
    }

    public void setNazivKardio(String nazivKardio) {
        this.nazivKardio = nazivKardio;    }

    @Override
    public String toString() {
        return "Kardio{" +
                "nazivKardio='" + nazivKardio + '\'' +"cas"+cas+
                '}';
    }
}
