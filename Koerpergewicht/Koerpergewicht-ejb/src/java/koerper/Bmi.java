/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koerper;


import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author stea1th
 */
@Stateless(mappedName = "BmiBean")
public class Bmi implements BmiRemote {

    @EJB
    private GewichtLocal gewicht;
    
    @Override
    public double getBmi(int gr, int gew) {
        return ((double) gew) / Math.pow((double)gr / 100, 2);
    }

    @Override
    public MenschDTO getAll(int gr, char c, int gew){
        return new MenschDTO(gewicht.getNormal(gr), gewicht.getIdeal(gr, c), getBmi(gr, gew));
    }
}
