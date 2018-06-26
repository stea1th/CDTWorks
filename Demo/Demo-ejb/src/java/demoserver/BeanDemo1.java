/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoserver;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;


/**
 *
 * @author stea1th
 */
@Stateless(mappedName = "BeanDemo1Bean")
public class BeanDemo1 implements BeanDemo1Remote {
    
    private ArrayList<String> alleStaedte = new ArrayList<>();

    @Override
    public void erweitereAlleStaedte(String stadt) {
        alleStaedte.add(stadt);
    }

    @Override
    public List<String> getAlleStaedte() {
        return alleStaedte;
    }
    
    
}
