/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmrbeispiele.beans;

import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface CMRJPQLDemoLocal {
    void abfrageTyp1();
    void abfrageTyp2();
    void abfrageTyp3();
    void abfrageTypX();
}
