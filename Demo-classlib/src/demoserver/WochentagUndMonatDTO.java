/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoserver;

import java.io.Serializable;

/**
 *
 * @author stea1th
 */
public class WochentagUndMonatDTO implements Serializable {
    
    private String wochenTag, monat;

    public WochentagUndMonatDTO(String wochenTag, String monat) {
        this.wochenTag = wochenTag;
        this.monat = monat;
    }

    public WochentagUndMonatDTO() {
        
    }

    public String getWochenTag() {
        return wochenTag;
    }

    public void setWochenTag(String wochenTag) {
        this.wochenTag = wochenTag;
    }

    public String getMonat() {
        return monat;
    }

    public void setMonat(String monat) {
        this.monat = monat;
    }
}
