/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emdemo1.beans;

import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface EMDemo1Local {
    void holeDatenSatz();
    void schreibeDatenSatz();
    void loescheDatenSatz();
    void aendernDatenSatz();
}
