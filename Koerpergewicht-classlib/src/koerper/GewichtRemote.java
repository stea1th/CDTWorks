/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koerper;

import exceptions.InvalidCharacterException;
import javax.ejb.Remote;

/**
 *
 * @author stea1th
 */
@Remote
public interface GewichtRemote {
    
    int getNormal(int gr);
    double getIdeal(int gr, char c); 
    
}
