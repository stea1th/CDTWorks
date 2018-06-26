/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoserver;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author stea1th
 */
@Stateful(mappedName = "BeanDemo2Bean")
public class BeanDemo2 implements BeanDemo2Remote {

    private List<String> alleStaedte;
    
    @PostConstruct
    public void init(){
        alleStaedte = new ArrayList<>();
        System.out.println("Instanz ist gerade geboren...");
    }

    @Override
    public void erweitereAlleStaedte(String stadt) {
        alleStaedte.add(stadt);
    }
    
    @PreDestroy
    public void preDestroy(){
        System.out.println("Instanz ist schon fast tot...");
    }

    @Remove
    @Override
    public List<String> getAlleStaedte() {
        System.out.println("Instanz soll sterben ...");
        return alleStaedte;
    }
    
    
}
