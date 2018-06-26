/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoserver;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author stea1th
 */
@Remote
public interface BeanDemo2Remote {
     void erweitereAlleStaedte(String stadt);
    public List<String> getAlleStaedte();
}
