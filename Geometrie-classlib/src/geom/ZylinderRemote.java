/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geom;

import exceptions.MinusWerteException;
import javax.ejb.Remote;

/**
 *
 * @author stea1th
 */
@Remote
public interface ZylinderRemote {
    double getFlaeche(int radius, int h) throws MinusWerteException;
    double getVolumen(int radius, int h) throws MinusWerteException;
    GeoDataDTO getData(int radius, int h) throws MinusWerteException;
}
