/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmruebung.beans;

import cmruebung.entities.Departments;
import cmruebung.entities.Employees;
import cmruebung.exceptions.KeyNotFoundException;
import cmruebung.exceptions.NoDetailsException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface CMRJavaUebungLocal {
    Departments a1(Integer empId);
    Double b1(int depId) throws NoDetailsException, KeyNotFoundException;
    List<String> c1(int empId);
}
