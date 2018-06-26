/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koerper;


import javax.ejb.Stateless;

/**
 *
 * @author stea1th
 */
@Stateless(mappedName = "GewichtBean")
public class Gewicht implements GewichtRemote, GewichtLocal {

    @Override
    public int getNormal(int gr) {
        return gr - 100;
    }

    
    @Override
    public double getIdeal(int gr, char c){
        switch(Character.valueOf(c).toString().toLowerCase()){
            case "m" :
                return 0.9 * getNormal(gr);
            case "w" :
                return 0.85 * getNormal(gr);
        }
        return 0;
    }
}
