/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koerpergewichtclient;

import exceptions.InvalidCharacterException;
import exceptions.NegativWertException;
import javax.naming.NamingException;
import koerper.MenschDTO;

/**
 *
 * @author stea1th
 */
public class Rechne {

    public static void main(String[] args) throws NamingException {
        RechneService service = new RechneService();

        try {
            System.out.println("Normal: " + service.getNormal(191));
            System.out.println("Ideal: " + service.getIdeal(191, 'm'));
            System.out.println("Bmi: " + service.getBmi(191, 112));
            MenschDTO mensch = service.getAll(-191, 'h', -112);
            System.out.println("Mensch Normal: " + mensch.getNormal());
            System.out.println("Mensch Ideal: " + mensch.getIdeal());
            System.out.println("Mensch Bmi: " + mensch.getBmi());

        } catch (InvalidCharacterException | NegativWertException e) {
            //System.err.println(e.getMessage());
            //e.printStackTrace();
            /*for(StackTraceElement element : e.getStackTrace()){
                System.out.println(element.getMethodName());
            }*/
            System.out.println(e.getStackTrace()[0].getMethodName() + " " + e.getMessage());
        }
    }
}
