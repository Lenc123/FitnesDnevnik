package com.example.lenc.fitnesdnevnik;

/**
 * Created by Lenč on 29. 12. 2016.
 */

public class User {

    private String ime;
    private int teza;
    private int velikost;
    private int obseg;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getTeza() {
        return teza;
    }

    public void setTeza(int teza) {
        this.teza = teza;
    }

    public int getVelikost() {
        return velikost;
    }

    public void setVelikost(int velikost) {
        this.velikost = velikost;
    }

    public int getObseg() {
        return obseg;
    }

    public void setObseg(int obseg) {
        this.obseg = obseg;
    }

    @Override
    public String toString() {
        return "User{" +
                ", teza=" + teza +
                ", velikost=" + velikost +
                ", obseg=" + obseg +
                '}';
    }
}
