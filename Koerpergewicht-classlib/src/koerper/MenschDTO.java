/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koerper;

import java.io.Serializable;

/**
 *
 * @author stea1th
 */
public class MenschDTO implements Serializable{
    
    private int normal;
    private double ideal, bmi;

    public MenschDTO(int normal, double ideal, double bmi) {
        this.normal = normal;
        this.ideal = ideal;
        this.bmi = bmi;
    }

    public int getNormal() {
        return normal;
    }

    public double getIdeal() {
        return ideal;
    }

    public double getBmi() {
        return bmi;
    }
    
    
    
    
}
