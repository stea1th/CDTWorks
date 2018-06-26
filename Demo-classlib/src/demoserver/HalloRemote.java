/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoserver;

import exceptions.KeinNameException;
import javax.ejb.Remote;

/**
 *
 * @author stea1th
 */
@Remote
public interface HalloRemote {

    String sagWas(String name) throws KeinNameException;
    
}
