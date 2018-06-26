/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmruebung.beans;

import cmruebung.entities.Countries;
import cmruebung.entities.Locations;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author stea1th
 */
@Stateless
public class CMRJava2 implements CMRJava2Local {

    @PersistenceContext(unitName = "CMRUebung-ejbPU")
    private EntityManager em;

    @Override
    public String a2(int locationId) {
        Locations l = em.find(Locations.class, (short) locationId);
        if (l != null) {
            Countries c = l.getCountries();
            if (c != null) {
                return c.getCountryName();
            } else {
                return "Keines Land zu diesem ID";
            }
        }
        return "ID ist ungültig!";
    }

    @Override
    public String b2(String city) {
        /*List<Locations> list = em.createNamedQuery("Locations.findAll").getResultList();
         if (!list.isEmpty()) {
         Locations l = list.stream().filter(x -> x.getCity().equals(city)).findAny().orElse(null);
         if (l != null) {
         return l.getCountries().getCountryName();
         } else {
         return "Es existiert kein Country zu diesem ID";
         }
         }*/

        Query q = em.createQuery("SELECT l "
                + "FROM Locations l "
                + "WHERE l.city = :city ").setParameter("city", city);
        if (q != null) {
            List<Locations> list = q.getResultList();
            if (!list.isEmpty() && list.size() == 1) {
                return list.get(0).getCountries().getCountryName();
            }
        }
        return "Ungültiges ID!!!";
    }

    @Override
    public Integer c2(String countryId) {
        Countries c = em.find(Countries.class, countryId);
        if (c != null) {
            return c.getLocationsList().size();
        }
        return null;
    }

}
