package com.example.lenc.fitnesdnevnik;

import android.provider.ContactsContract;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Lenc on 16. 05. 2016.
 */
public class DataAll {
    public  DataAll(){
       utezi = new ArrayList<Utezi>();
       kardio=new ArrayList<Kardio>();
    }
    private ArrayList<Utezi> utezi;
    private ArrayList<Kardio> kardio;

    public ArrayList<Utezi> getUtezi() {
        return utezi;
    }

    public void setUtezi(ArrayList<Utezi> utezi) {
        this.utezi = utezi;
    }

    public ArrayList<Kardio> getKardio() {
        return kardio;
    }

    public Kardio getKardioFilter(String naziv){
        for(int i=0;i<kardio.size();i++){
            if(naziv.equals(kardio.get(i).getNazivKardio())){
                return kardio.get(i);
            }
        }
    return null;
    }
    public Utezi getUteziFilter(String naziv){
        for(int i=0;i<utezi.size();i++){
            if(naziv.equals(utezi.get(i).getNazivUtezi())){
                return utezi.get(i);
            }
        }
        return null;
    }

    public void setKardio(ArrayList<Kardio> kardio) {
        this.kardio = kardio;
    }

    public void dodaj(Kardio k){kardio.add(k);}
    public void dodaj(Utezi u){utezi.add(u);}
    public void zbrisiKardio(int i){kardio.remove(i);}
    public void zbrisiUtezi(int j){utezi.remove(j);}

    public int velikostKardio(){return kardio.size(); }
    public int velikostUtezi(){return utezi.size();}
    public int velikost(){return 1;}

    public  static DataAll getPodatke(){
        DataAll data = new DataAll();
        data.dodaj(new Kardio("Hoja"));
        data.dodaj(new Kardio("Tek"));
        data.dodaj(new Kardio("Hoja v hrib"));
        data.dodaj(new Kardio("Kolesarjenje"));
        data.dodaj(new Kardio("Tek v hrib"));
        data.dodaj(new Kardio("Hitra hoja"));
        data.dodaj(new Utezi("Zgornji del hrbta"));
        data.dodaj(new Utezi("Spodnji del hrbta"));
        data.dodaj(new Utezi("Meča"));
        data.dodaj(new Utezi("Stegno"));
        data.dodaj(new Utezi("Biceps"));
        data.dodaj(new Utezi("Triceps"));
        data.dodaj(new Utezi("Rame"));
        data.dodaj(new Utezi("Prsa"));
        return data;
    }


}
