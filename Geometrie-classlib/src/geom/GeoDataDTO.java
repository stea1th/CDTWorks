/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geom;

import java.io.Serializable;

/**
 *
 * @author stea1th
 */
public class GeoDataDTO implements Serializable {
    
    private double flaeche, volumen;

    public GeoDataDTO(double flaeche, double volumen) {
        this.flaeche = flaeche;
        this.volumen = volumen;
    }

    public GeoDataDTO() {
    }

    public double getFlaeche() {
        return flaeche;
    }

    public void setFlaeche(double flaeche) {
        this.flaeche = flaeche;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }
}
