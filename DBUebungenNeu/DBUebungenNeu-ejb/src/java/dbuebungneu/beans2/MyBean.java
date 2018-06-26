/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbuebungneu.beans2;

import dbuebungneu.dtos.EmployeesDTO;
import dbuebungneu.entities.Departments;
import dbuebungneu.entities.Employees;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stea1th
 */
@Stateless
public class MyBean implements MyBeanLocal {

    @PersistenceContext(unitName = "DBUebungenNeu-ejbPU")
    private EntityManager em;

    @Override
    public void a() {
        List<Departments> list = em.createQuery("SELECT d FROM Departments d")
                .getResultList();
        System.out.println("Alle Departments: ");
        printIt(list);

    }

    @Override
    public void b(int departmentId) {
        List<Employees> list = em.createQuery("SELECT e "
                + "FROM Employees e "
                + "WHERE e.departmentId = :department")
                .setParameter("department", departmentId)
                .getResultList();
        System.out.printf("Liefere alle Employees aus %d Department:\n", departmentId);
        printIt(list);

    }

    @Override
    public void c(String countryId) {
        List<Departments> list = em.createQuery("SELECT d "
                + "FROM Departments d JOIN Locations l "
                + "ON d.locationId = l.locationId "
                + "WHERE l.countryId = :country ")
                .setParameter("country", countryId)
                .getResultList();
        System.out.printf("Alle Departments aus %s Coutry: \n", countryId);
        printIt(list);
    }

    @Override
    public void d(String city) {
//        List<Employees> list = em.createQuery("SELECT e "
//                + "FROM Employees e "
//                + "WHERE e.departmentId IN (SELECT d.departmentId "
//                + "                         FROM Departments d "
//                + "                         WHERE d.locationId IN (SELECT l.locationId "
//                + "                                                 FROM Locations l "
//                + "                                                 WHERE l.city = '" + city + "'))").getResultList();
        List<Employees> list = em.createQuery("SELECT e "
                + "FROM Employees e JOIN Departments d "
                + "ON e.departmentId = d.departmentId "
                + "JOIN Locations l "
                + "ON d.locationId = l.locationId "
                + "WHERE l.city = :city ")
                .setParameter("city", city)
                .getResultList();
        System.out.printf("Liefere alle Employees aus %s City:\n", city);
        printIt(list);
    }

    @Override
    public void e(String departmentName) {
        List<Object[]> list = em.createQuery("SELECT e.firstName, e.lastName, e.salary "
                + "FROM Employees e JOIN Departments d "
                + "ON e.departmentId = d.departmentId "
                + "WHERE d.departmentName = :department ")
                .setParameter("department", departmentName)
                .getResultList();
        System.out.printf("Liefere Vornamen, Nachnamen und Gehälter aller Employees aus %s Department:\n", departmentName);
        printIt(list);
    }

    @Override
    public void f(int minSalary, int maxSalary) {
        List<EmployeesDTO> list = em.createQuery("SELECT new dbuebungneu.dtos.EmployeesDTO(e.firstName, e.lastName, e.salary) "
                + "FROM Employees e "
                + "WHERE e.salary BETWEEN :min AND :max ")
                .setParameter("min", minSalary)
                .setParameter("max", maxSalary)
                .getResultList();
        System.out.printf("Liefere alle Employees die Gehalt zwischen %d und %d haben:\n", minSalary, maxSalary);
        printIt(list);
    }

    @Override
    public List<EmployeesDTO> g(String minSalary, String maxSalary) {

        if (minSalary == null || minSalary.equals("")) {
            minSalary = "0.0";
        }
        if (maxSalary == null || maxSalary.equals("")) {
            maxSalary = "0.0";
        }
        return em.createQuery("SELECT new dbuebungneu.dtos.EmployeesDTO(e.firstName, e.lastName, e.salary) "
                + "FROM Employees e "
                + "WHERE e.salary BETWEEN :min AND :max ")
                .setParameter("min", Double.parseDouble(minSalary))
                .setParameter("max", Double.parseDouble(maxSalary))
                .getResultList();
    }

    public static void printIt(List list) {
        switch (list.get(0).getClass().getSimpleName()) {
            case "Departments":
                List<Departments> erg = list;
                erg.forEach(x -> System.out.printf("%-5d%-30s%5d%7d", x.getDepartmentId(), x.getDepartmentName(), x.getManagerId(), x.getLocationId()));
                break;
            case "Employees":
                List<Employees> erg1 = list;
                erg1.forEach(y -> System.out.printf("%-5d%-30s%-30s%.2f%5d", y.getEmployeeId(), y.getFirstName(), y.getLastName(), y.getSalary(), y.getDepartmentId()));
                break;
            case "EmployeesDTO":
                List<EmployeesDTO> erg2 = list;
                erg2.forEach(y -> System.out.printf("%-30s%-30s%.2f", y.getFirstName(), y.getLastName(), y.getSalary()));
                break;
            case "Object":
                List<Object[]> erg3 = list;
                erg3.forEach(y -> System.out.printf("%-30s%-30s%.2f", y[0], y[1], (double) y[2]));
                break;
        }
    }

    @Override
    public double a2() {
        return (Double) em.createQuery("SELECT AVG(e.salary) "
                + "FROM Employees e ")
                .getSingleResult();
    }

    @Override
    public Object[] b2() {
        return (Object[]) em.createQuery("SELECT MIN(e.salary), MAX(e.salary) "
                + "FROM Employees e ")
                .getSingleResult();
    }

    @Override
    public List<Object[]> c2a() {
        return (List<Object[]>) em.createQuery("SELECT  d.departmentName, "
                + "(SELECT COUNT(e.employeeId) FROM Employees e WHERE e.departmentId = d.departmentId), "
                + "(SELECT AVG(e.salary) FROM Employees e WHERE e.departmentId = d.departmentId) "
                + "FROM Departments d ")
                .getResultList();
    }

    @Override
    public List<Object[]> c2b() {
        return (List<Object[]>) em.createQuery("SELECT d.departmentId, d.departmentName, COUNT(e.employeeId), AVG(e.salary) "
                + "FROM Departments d LEFT JOIN Employees e "
                + "ON e.departmentId = d.departmentId "
                + "GROUP BY d.departmentId, d.departmentName")
                .getResultList();
    }
}
