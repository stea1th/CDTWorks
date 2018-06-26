/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koerper;


import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface GewichtLocal {

    int getNormal(int gr);

    double getIdeal(int gr, char c);
}
