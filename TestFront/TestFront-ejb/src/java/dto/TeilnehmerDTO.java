/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author stea1th
 */
public class TeilnehmerDTO implements Serializable{
    
    private  String name;
    private  String vorname;
    private  Integer fehlTage;
    private  String massnahme;
    private  String baustein;

    public TeilnehmerDTO() {
    }
    
    

    public TeilnehmerDTO(String name, String vorname, Integer fehlTage, String massnahme) {
        this(name, vorname, fehlTage, massnahme, null);
    }

    public TeilnehmerDTO(String name, String vorname, Integer fehlTage, String massnahme, String baustein) {
        this.name = name;
        this.vorname = vorname;
        this.fehlTage = fehlTage;
        this.massnahme = massnahme;
        this.baustein = baustein;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public Integer getFehlTage() {
        return fehlTage;
    }

    public String getMassnahme() {
        return massnahme;
    }

    public String getBaustein() {
        return baustein;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setFehlTage(Integer fehlTage) {
        this.fehlTage = fehlTage;
    }

    public void setMassnahme(String massnahme) {
        this.massnahme = massnahme;
    }

    public void setBaustein(String baustein) {
        this.baustein = baustein;
    }
    
    
    
    
    
    
    
    
    
    
}
