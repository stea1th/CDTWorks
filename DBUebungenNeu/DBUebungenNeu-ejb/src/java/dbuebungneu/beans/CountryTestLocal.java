/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbuebungneu.beans;

import dbuebungneu.entities.Countries;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface CountryTestLocal {
    Countries getById(String countryId);
    void createCountry(String countryId, String country, int regionId);
    void deleteCountry(String countryId);
    void setCountryById(String countryId, String country);
    void getProperties();
}
