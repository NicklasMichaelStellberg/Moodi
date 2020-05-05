package com.example.moodi;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * luokan olio vastaa aina yhden päivän kirjattuja tietoja
 * @author Oskari Toivonen
 * @version 0.1 5/2020
 */
public class Paivaus extends MainActivity {


    private int sleep = 0;
    private int depression = 0;
    private int agitation = 0;
    private int irritation = 0;
    private int anxiety = 0;
    private String muistiinpanot;

    public String getMuistiinpanot() {
        return muistiinpanot;
    }



    public void setMuistiinpanot(String muistiinpanot) {
        this.muistiinpanot = muistiinpanot;
    }




    private Paivaus(int sleep, int depression, int agitation, int irritation, int anxiety, String muistiinpanot) {

        this.sleep = sleep;
        this.depression = depression;
        this.agitation = agitation;
        this.irritation = irritation;
        this.anxiety = anxiety;
        this.muistiinpanot = muistiinpanot;
    }

    private static Paivaus loadfromfile(File file){
        StringBuilder text = new StringBuilder();

        String muistiinpanot = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
           /* int sleep = Integer.parseInt(br.readLine());
            int depression = Integer.parseInt(br.readLine());
            int agitation = Integer.parseInt(br.readLine());
            int irritation = Integer.parseInt(br.readLine());
            int anxiety = Integer.parseInt(br.readLine());
            String line=br.readLine();
            while (line!=null){
                muistiinpanot += line +"\n";
                line= br.readLine();
            }*/
           JsonParser jsonParser=new JsonParser();
           JsonElement object= jsonParser.parse(br);
           JsonObject j=object.getAsJsonObject();
            int sleep = j.get("sleep").getAsInt();
            int depression = j.get("depression").getAsInt();
            int agitation =  j.get("agitation").getAsInt();
            int irritation =  j.get("irritation").getAsInt();
            int anxiety =  j.get("anxiety").getAsInt();
            muistiinpanot=  j.get("muistiinpanot").getAsString();

            br.close();
            return new Paivaus(sleep, depression, agitation, irritation, anxiety, muistiinpanot);
        } catch (IOException |NullPointerException|JsonSyntaxException|IllegalStateException e) {

            //handlaa sen  jos tiedostoa ei ole olemassa tai muuta siihen liittyvää virhettä
            //lisää jonkinlainen toiminto joka diilaa errorien kanssa
        }
        return new Paivaus(0, 0, 0, 0, 0, muistiinpanot);//palauta nämä arvot
    }


    public static ArrayList<Paivaus> loadall(Context context){
     ArrayList<Paivaus> paivaukset= new ArrayList<Paivaus>();
     File muisti = context.getFilesDir();
        for (File file:muisti.listFiles()) {
        paivaukset.add(loadfromfile(file));
        }
        return paivaukset;
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
        return loadfromfile(file);
    }

    public void save(int year,int month, int dayOfMonth, Context context) {// tallennetaan paivaustiedosto
        String tunniste = "" + year+"-"+month+"-"+dayOfMonth;
        File muisti = context.getFilesDir();
        File file = new File(muisti, tunniste);
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
          /*  br.write(this.sleep + "\n");
            br.write(this.depression + "\n");
            br.write(this.agitation + "\n");
            br.write(this.irritation + "\n");
            br.write(this.anxiety + "\n");
            br.write(this.muistiinpanot + "\n");*/
            JSONObject object=new JSONObject();
            object.put("sleep",this.sleep);
            object.put("depression",this.depression);
            object.put("agitation",this.agitation);
            object.put("irritation",this.irritation);
            object.put("anxiety",this.anxiety);
            object.put("muistiinpanot",this.muistiinpanot);
            br.write(object.toString());
            br.close();
        } catch (IOException | JSONException e) {
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
