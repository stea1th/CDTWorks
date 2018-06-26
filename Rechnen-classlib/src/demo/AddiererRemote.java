/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import javax.ejb.Remote;

/**
 *
 * @author stea1th
 */
@Remote
public interface AddiererRemote {
    void add(int i);
    long getSumme();
    double getSchnitt();
    
}
