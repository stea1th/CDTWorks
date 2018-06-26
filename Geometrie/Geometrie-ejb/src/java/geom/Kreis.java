/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geom;

import exceptions.MinusWerteException;
import javax.ejb.Stateless;

@Stateless(mappedName = "KreisBean")
public class Kreis implements KreisRemote, KreisLocal {

    @Override
    public double getUmfang(int radius) throws MinusWerteException {
        if (Pruefen.pruef(radius).length() != 0) {
            throw new MinusWerteException("" + radius, new Throwable("getUmfang()"));
        }
        return 2 * Math.PI * radius;
    }

    @Override
    public double getFlaeche(int radius) throws MinusWerteException {
        if (Pruefen.pruef(radius).length() != 0) {
            throw new MinusWerteException("" + radius, new Throwable("getFlaeche()"));
        }
        return Math.PI * Math.pow(radius, 2);
    }
}
