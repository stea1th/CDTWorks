/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmrbeispiele.beans;

import cmrbeispiele.entities.Abteilung;
import cmrbeispiele.entities.Mitarbeiter;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stea1th
 */
@Stateless
public class CMRJavaDemo implements CMRJavaDemoLocal {

    @PersistenceContext(unitName = "CMRBeispiele-ejbPU")
    private EntityManager em;

    @Override
    public String frageTyp1(Integer mnr) {
        Mitarbeiter m = em.find(Mitarbeiter.class, mnr);
        if (m != null) {
            Abteilung a = m.getAbteilung();
            if (a != null) {
                //System.out.printf("Abteilung %s in der Stadt %s\n", a.getAbtName(), a.getStadt());
                return String.format("Abteilung %s in der Stadt %s\n", a.getAbtName(), a.getStadt());
            } else {
                // im Firmen-Szenario nicht möglich!
            }
        } else {
            return String.format("Es existiert kein Mitarbeiter mit Nummer %d\n", mnr);
        }
        return null;
    }

    @Override
    public void frageTyp2(String abtNr) {
        Abteilung a = em.find(Abteilung.class, abtNr);
        if(a!= null){
            List<Mitarbeiter> list = a.getMitarbeiterList();
            if(!list.isEmpty()){
                list.forEach(x-> System.out.println(x.getMVorname()+" "+x.getMName()));
                System.out.println(list.size());
            }else{
                System.out.println("Abteilung hat keine Mitarbeiter");
            }
        }else{
            System.out.println("Abteilung existiert nicht!");
        }
    }

}
