/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmruebung.beans;

import cmruebung.entities.Departments;
import cmruebung.entities.Employees;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CMRJava3 implements CMRJava3Local {
    @PersistenceContext(unitName = "CMRUebung-ejbPU")
    private EntityManager em;

    @Override
    public Employees a3(int employeesId) {
        Employees e = em.find(Employees.class, employeesId);
        if(e!=null){
            System.out.printf("Die NachName: %s, Department: %s\n", e.getLastName(), e.getDepartments());
            return e;
        }else{
            System.err.println("ID existiert nicht");
        }
        return null;
    }

    @Override
    public Departments b3(int departmentId) {
        Departments d = em.find(Departments.class, (short)departmentId);
        if(d!=null){
            System.out.printf("Department: %s\n",d.getDepartmentName());
            for(Employees e : d.getEmployeesList()){
                System.out.printf("\t%s\n", e.getLastName());
            }
            return d;
        }else{
            System.err.println("ID existiert nicht");
        }
        return null;
    }

    @Override
    public void a4(int employeesId, int neuesDepartmentId) {
        System.out.println("Altes Zustand:");
        Employees e = a3(employeesId);
        Departments d = b3(neuesDepartmentId);
        System.out.println("---------------");
        if(e!=null){
            e.setDepartments(d);
        }
        //System.out.println("Neues Zustand:");
        //a3(employeesId);
        //b3(neuesDepartmentId);
        //System.out.println("---------------");
    }

    @Override
    public void b4(int altDepId, int neuDepId) {
        System.out.println("Altes Zustand:");
        Departments alt = b3(altDepId);
        Departments neu = b3(neuDepId);
        System.out.println("---------------");
        if(alt!=null && neu!=null){
            alt.setEmployeesList(neu.getEmployeesList());
        }
        //System.out.println("Neues Zustand:");
        //b3(altDepId);
        //System.out.println("---------------");
    }

    @Override
    public void c4(int departmentsId, int employeesId) {
        System.out.println("Altes Zustand:");
        Departments d = b3(departmentsId);
        Employees e = a3(employeesId);
        System.out.println("---------------");
        if(d!=null && e!=null){
            d.getEmployeesList().remove(e);
        }
        //System.out.println("Neues Zustand:");
        //b3(departmentsId);
        //System.out.println("---------------");
    }
    
    

    

    
}
