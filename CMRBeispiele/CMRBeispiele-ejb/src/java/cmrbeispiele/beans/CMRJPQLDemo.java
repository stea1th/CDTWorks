/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmrbeispiele.beans;

import cmrbeispiele.entities.Abteilung;
import cmrbeispiele.entities.Mitarbeiter;
import java.util.List;
import java.util.function.Consumer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stea1th
 */
@Stateless
public class CMRJPQLDemo implements CMRJPQLDemoLocal {
    
    @PersistenceContext(unitName = "CMRBeispiele-ejbPU")
    private EntityManager em;

    @Override
    public void abfrageTyp1() {
      
        System.out.println("Mitarbeiter der Abteilung Freigabe");
         em.createQuery("SELECT m "
                + "FROM Mitarbeiter m "
                + "WHERE m.abteilung.abtName = 'Freigabe' ")
                 .getResultList()
                 .forEach(new Consumer<Mitarbeiter>() {
                     @Override
                     public void accept(Mitarbeiter m) {
                System.out.printf("%5d %-20s %-20s\n", m.getMNr(), m.getMVorname(), m.getMName());
            }
        });
    }

    @Override
    public void abfrageTyp2() {
        
        System.out.println("Abteilungen ohne Mitarbeiter");
        List<Abteilung> erg = em.createQuery("SELECT a "
                + "FROM Abteilung a "
                + "WHERE a.mitarbeiterList IS EMPTY ")
                 .getResultList();
        if(erg.isEmpty())
            System.out.println("Keine");
        else 
            erg.forEach(x -> System.out.printf("Abteilung: %s ", x.getAbtName()));
                 
                 
    }

    @Override
    public void abfrageTyp3() {
        System.out.println("Abteilungen der Münchner Mitarbeiter");
        List<Abteilung> erg1 = em.createQuery("SELECT DISTINCT a "
                + "FROM Abteilung a, IN(a.mitarbeiterList) m "
                + "WHERE m.wohnort = 'Augsburg'")
                .getResultList();
        
        List<Abteilung> erg = em.createQuery("SELECT DISTINCT a "
                + "FROM Abteilung a JOIN a.mitarbeiterList m "
                + "WHERE m.wohnort = 'Augsburg'")
                .getResultList();
        
        erg.forEach(x->  System.out.println(x.getAbtName()));
    }

    @Override
    public void abfrageTypX() {
        System.out.println("Test");
        List<Abteilung> erg = em.createQuery("SELECT a "
                + "FROM Abteilung a ")
                .getResultList();
        erg.stream().map((a) -> {
            System.out.println("Abteilung: "+a.getAbtName());
            return a;
        }).forEach((a) -> {
            for(Mitarbeiter m : a.getMitarbeiterList()){
                System.out.println("Mitarbeiter: "+m.getMName());
            }
        });
    }
}
