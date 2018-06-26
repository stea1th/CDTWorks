/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geom;

import exceptions.MinusWerteException;
import javax.ejb.Stateless;

/**
 *
 * @author stea1th
 */
@Stateless(mappedName = "QuaderBean")
public class Quader implements QuaderRemote {

    

    @Override
    public double getFlaeche(int a, int b, int c) throws MinusWerteException {
        if (Pruefen.pruef(a, b, c).length() != 0) {
            throw new MinusWerteException(Pruefen.pruef(a, b, c).toString(), new Throwable("getFlaeche()"));
        }
        return 2 * (a * b + b * c + a * c);
    }

    @Override
    public double getVolume(int a, int b, int c) throws MinusWerteException {
        if (Pruefen.pruef(a, b, c).length() != 0) {
            throw new MinusWerteException(Pruefen.pruef(a, b, c).toString(), new Throwable("getVolume()"));
        }
        return a * b * c;
    }
}
