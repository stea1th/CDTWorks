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
public interface QuaderRemote {
    double getFlaeche(int lange, int breite, int hohe) throws MinusWerteException;
    double getVolume(int lange, int breite, int hohe) throws MinusWerteException;
}
