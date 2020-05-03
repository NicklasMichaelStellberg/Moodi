package com.example.moodi;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//luokan olio vastaa aina yhden päivän kirjattuja tietoja
public class Paivaus extends MainActivity {


    private int sleep = 0;
    private int depression = 0;
    private int agitation = 0;
    private int irritation = 0;
    private int anxiety = 0;
    private String Muistiinpanot;

    public String getMuistiinpanot() {
        return Muistiinpanot;
    }



    public void setMuistiinpanot(String muistiinpanot) {
        Muistiinpanot = muistiinpanot;
    }




    private Paivaus(int sleep, int depression, int agitation, int irritation, int anxiety, String muistiinpanot) {

        this.sleep = sleep;
        this.depression = depression;
        this.agitation = agitation;
        this.irritation = irritation;
        this.anxiety = anxiety;
        this.Muistiinpanot = muistiinpanot;
    }

    public static Paivaus load(int year,int month, int dayOfMonth, Context context) {//ladataan paivaus tiedosto
        String tunniste = "" + year+"-"+month+"-"+dayOfMonth;
        //avataan tiedosto jonka nimi on tunniste
        //lue tiedostosta tarvittava tieto päiväys luokalle
        //return new paivaus
        //etsitään directory tiedoston tallennukseen

        File muisti = context.getFilesDir();

        //Luodaan tekstitiedosto
        File file = new File(muisti, tunniste);

        //Luetaan tekstitiedostosta
        StringBuilder text = new StringBuilder();

        String muistiinpanot = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int sleep = Integer.parseInt(br.readLine());
            int depression = Integer.parseInt(br.readLine());
            int agitation = Integer.parseInt(br.readLine());
            int irritation = Integer.parseInt(br.readLine());
            int anxiety = Integer.parseInt(br.readLine());

            br.close();
            return new Paivaus(sleep, depression, agitation, irritation, anxiety, muistiinpanot);
        } catch (IOException e) { //handlaa sen  jos tiedostoa ei ole olemassa tai muuta siihen liittyvää virhettä
            //lisää jonkinlainen toiminto joka diilaa errorien kanssa
        }
        return new Paivaus(0, 0, 0, 0, 0, muistiinpanot);//palauta nämä arvot
    }

    public void save(int year,int month, int dayOfMonth, Context context) {// tallennetaan paivaustiedosto
        String tunniste = "" + year+"-"+month+"-"+dayOfMonth;
        File muisti = context.getFilesDir();
        File file = new File(muisti, tunniste);
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            br.write(this.sleep + "\n");
            br.write(this.depression + "\n");
            br.write(this.agitation + "\n");
            br.write(this.irritation + "\n");
            br.write(this.anxiety + "\n");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // metodi unenmäärän saamiseen
    public int getSleep() {
        return sleep;
    }

    // metodi masennus arvon saamiseen
    public int getDepression() {
        return depression;
    }

    // metodi kiihtyneisyys arvon saamiseen
    public int getAgitation() {
        return agitation;
    }

    // metodi ärsyynnyksen arvon saamiseen
    public int getIrritation() {
        return irritation;
    }

    //metodi ahdistus arvon saamiseen
    public int getAnxiety() {
        return anxiety;
    }

    //metodi unenmäärän arvon asettamiseen
    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    //metodi masennus arvon asettamiseen
    public void setDepression(int depression) {
        this.depression = depression;
    }

    //metodi kiihtyneisyys arvon asettamiseen
    public void setAgitation(int agitation) {
        this.agitation = agitation;
    }

    //metodi ärsyyntyneisyys arvon asettamiseen
    public void setIrritation(int irritation) {
        this.irritation = irritation;
    }

    //metodi ahdistuneisuus arvon asettamiseen
    public void setAnxiety(int anxiety) {
        this.anxiety = anxiety;
    }
}
