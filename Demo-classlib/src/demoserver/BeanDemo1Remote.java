/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoserver;

import java.util.List;
import javax.ejb.Remote;


@Remote
public interface BeanDemo1Remote {
    
    void erweitereAlleStaedte(String stadt);
    public List<String> getAlleStaedte();
}


