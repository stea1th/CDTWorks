/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmrbeispiele.beans;

import cmrbeispiele.entities.Abteilung;
import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface CMRJavaDemoLocal {
    String frageTyp1(Integer mnr);
    void frageTyp2(String abtNr);
}
