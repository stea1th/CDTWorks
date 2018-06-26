/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmruebung.beans;

import cmruebung.entities.Countries;
import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface CMRJava2Local {
    String a2(int locationId);
    String b2(String city);
    Integer c2(String countryId);
    
}
