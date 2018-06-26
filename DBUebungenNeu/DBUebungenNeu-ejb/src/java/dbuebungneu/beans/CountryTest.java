/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbuebungneu.beans;

import dbuebungneu.entities.Countries;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stea1th
 */
@Stateless
public class CountryTest implements CountryTestLocal {

    @PersistenceContext(unitName = "DBUebungenNeu-ejbPU")
    private EntityManager em;

    @Override
    public Countries getById(String countryId) {
        Countries c = em.find(Countries.class, countryId.toUpperCase());
        System.out.println(c != null ? c.toString() : String.format("Es gibt kein DatenSatz zu diesem Id: %s", countryId.toUpperCase()));
        return c;
    }

    @Override
    public void createCountry(String countryId, String country, int regionId) {
        Countries c = getById(countryId);
        if (c == null) {
            em.persist(new Countries(countryId.toUpperCase(), country));
            try {
                c.setRegionId((short) regionId);
            } catch (Exception e) {
                System.out.println("Region Id ist falsch!!");
            }
            System.out.println("Country created...");
        } else {
            System.out.println("Country Id schon existiert!!!");
        }

    }

    @Override
    public void deleteCountry(String countryId) {
        Countries c = getById(countryId);
        if (c != null) {
            em.remove(c);
        } else {
            System.out.println("Country existiert nicht!");
        }
    }

    @Override
    public void setCountryById(String countryId, String country) {
        Countries c = getById(countryId);
        if (c != null) {
            c.setCountryName(country);
        } else {
            System.out.println("Country Id existiert nicht!");
        }
    }

    @Override
    public void getProperties() {

    }

}
