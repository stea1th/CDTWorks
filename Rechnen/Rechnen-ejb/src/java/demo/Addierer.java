/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author stea1th
 */
@Stateful(mappedName = "AddiererBean")
public class Addierer implements AddiererRemote {
    
    private long summe;
    private int count;
    
    
    @PostConstruct
    public void init(){
        summe = 0;
        count = 0;
        
    }

    @Override
    public void add(int i) {
        summe+=i;
        count++;
    }

    
    @Override
    public long getSumme() {
        return summe;
    }

    
    @Override
    public double getSchnitt() {
        return (double)summe/count;
    }
}
