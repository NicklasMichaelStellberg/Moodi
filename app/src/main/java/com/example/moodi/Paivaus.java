package com.example.moodi;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

//luokan olio vastaa aina yhden päivän kirjattuja tietoja
public class Paivaus {


    private int sleep = 0;
    private int depression = 0;
    private int agitation = 0;
    private int irritation = 0;
    private int anxiety = 0;


    public Paivaus(int sleep, int depression, int agitation, int irritation, int anxiety) {

        this.sleep = sleep;
        this.depression = depression;
        this.agitation = agitation;
        this.irritation = irritation;
        this.anxiety = anxiety;

    }

          public static Paivaus load(Calendar calendar, Context context) {//ladataan paivaus tiedosto
            String tunniste = "" + calendar.get(Calendar.YEAR) + calendar.get(Calendar.MONTH) + calendar.get(Calendar.DAY_OF_MONTH);
            //avataan tiedosto jonka nimi on tunniste
            //lue tiedostosta tarvittava tieto päiväys luokalle
            //return new paivaus
            //etsitään directory tiedoston tallennukseen

            File muisti = context.getFilesDir();

            //Luodaan tekstitiedosto
            File file = new File(muisti, tunniste);

            //Luetaan tekstitiedostosta
            StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int sleep = Integer.parseInt(br.readLine());
            int depression = Integer.parseInt(br.readLine());
            int agitation = Integer.parseInt(br.readLine());
            int irritation = Integer.parseInt(br.readLine());
            int anxiety = Integer.parseInt(br.readLine());

            br.close();
            return new Paivaus(sleep, depression, agitation, irritation, anxiety);
        } catch (IOException e) { //handlaa sen  jos tiedostoa ei ole olemassa tai muuta siihen liittyvää virhettä
            //lisää jonkinlainen toiminto joka diilaa errorien kanssa
        }
        return new Paivaus(0, 0, 0, 0, 0);//palauta nämä arvot
    }

    public void save(Calendar calendar, Context context) {// tallennetaan paivaustiedosto
        String tunniste = "" + calendar.get(Calendar.YEAR) + calendar.get(Calendar.MONTH) + calendar.get(Calendar.DAY_OF_MONTH);
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
