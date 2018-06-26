/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geom;

import exceptions.MinusWerteException;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author stea1th
 */
@Stateless(mappedName = "ZylinderBean")
public class Zylinder implements ZylinderRemote {
    
    @EJB
    private KreisLocal kreis;

    @Override
    public double getFlaeche(int radius, int h) throws MinusWerteException {
        if (Pruefen.pruef(radius, h).length()!=0) {
            throw new MinusWerteException(Pruefen.pruef(radius, h).toString(), new Throwable("getFlaeche()"));
        }
        return kreis.getUmfang(radius) * (h + radius);
    }

    @Override
    public double getVolumen(int radius, int h) throws MinusWerteException {
        if (Pruefen.pruef(radius, h).length()!=0) {
            throw new MinusWerteException(Pruefen.pruef(radius, h).toString(), new Throwable("getVolumen()"));
        }
        return kreis.getFlaeche(radius) * h;
    }

    @Override
    public GeoDataDTO getData(int radius, int h) throws MinusWerteException {
        if (Pruefen.pruef(radius, h).length()!=0) {
            throw new MinusWerteException(Pruefen.pruef(radius, h).toString(), new Throwable("getData()"));
        }
        return new GeoDataDTO(getFlaeche(radius, h), getVolumen(radius, h));
    }
}
