/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geom;

import exceptions.MinusWerteException;
import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface KreisLocal {
    double getFlaeche(int radius) throws MinusWerteException;
    double getUmfang(int radius) throws MinusWerteException;
}
