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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stea1th
 */
@Stateless
public class CMRJavaUebung implements CMRJavaUebungLocal {

    @PersistenceContext(unitName = "CMRUebung-ejbPU")
    private EntityManager em;

    @Override
    public Departments a1(Integer empId) {
        Employees e = em.find(Employees.class, empId);
        if (e != null) {
            return e.getDepartments();
        }
        return null;
    }

    @Override
    public Double b1(int depId) throws NoDetailsException, KeyNotFoundException{
        Departments d = em.find(Departments.class, (short) depId);
        if (d != null) {
            List<Employees> list = d.getEmployeesList();
            if (!list.isEmpty()) {
                double erg = 0.0;
                int count = 0;
                for (Employees e : list) {
                    erg += e.getSalary();
                    count++;
                }
                return erg / count;
            } else {
                throw new NoDetailsException("Die Liste ist leer!");
            }
        } else {
            throw new KeyNotFoundException("ID existiert leider nicht!");
        }
    }

    @Override
    public List<String> c1(int empId) {
        
        /*if (e != null) {
            Departments d = e.getDepartments();
            if (d != null) {
                List<Employees> list = d.getEmployeesList();
                Employees emp = null;
                for (Employees x : list) {
                    if (x.getEmployeeId() == empId) {
                        emp = x;
                    }
                }
                list.remove(emp);
                return list;
            }
        } else {

        }*/
        Employees e = em.find(Employees.class, empId);
        if(e!=null){
            Departments d = e.getDepartments();
            if(d!=null){
                List<String>names = new ArrayList<>();
                List<Employees> list = d.getEmployeesList();
               for(Employees x : list){
                   if(x.getEmployeeId()!=empId){
                       names.add(x.getLastName());
                   }
               }
               return names;
            }
        }
        return null;
    }

}
