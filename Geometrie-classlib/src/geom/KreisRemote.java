/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geom;

import exceptions.MinusWerteException;
import javax.ejb.Remote;

@Remote
public interface KreisRemote {
    double getUmfang(int radius) throws MinusWerteException;
    double getFlaeche(int radius) throws MinusWerteException;
    
}
