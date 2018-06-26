/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmruebung.beans;

import cmruebung.entities.Countries;
import cmruebung.entities.Departments;
import cmruebung.entities.Employees;
import cmruebung.entities.Locations;
import java.util.function.Consumer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stea1th
 */
@Stateless
public class CRMTest implements CRMTestLocal {

    @PersistenceContext(unitName = "CMRUebung-ejbPU")
    private EntityManager em;

    @Override
    public void a() {
        System.out.println("Alle Locations im United Kingdom:\n");
        em.createQuery("SELECT l "
                + "FROM Locations l "
                + "WHERE l.countries.countryName = 'United Kingdom'")
                .getResultList()
                .forEach(new Consumer<Locations>() {
                    @Override
                    public void accept(Locations x) {
                        System.out.printf("%-20s%-20s%4s", x.getCity(), x.getStateProvince(), x.getCountries().getCountryId());
                    }
                });
    }

    @Override
    public void b() {
        System.out.println("Alle Countries ohne Departments:\n");
        em.createQuery("SELECT c "
                + "FROM Countries c "
                + "WHERE c.locationsList IS EMPTY")
                .getResultList()
                .forEach(new Consumer<Countries>() {
                    @Override
                    public void accept(Countries x) {
                        System.out.printf("%-4s%20s", x.getCountryId(), x.getCountryName());
                    }
                });
    }

    @Override
    public void c() {
        System.out.println("Alle Countries mit Departments and City 'S':\n");
        em.createQuery("SELECT c "
                + "FROM Countries c JOIN c.locationsList l "
                + "WHERE l.city LIKE 'S%'")
                .getResultList()
                .forEach(new Consumer<Countries>() {
                    @Override
                    public void accept(Countries x) {
                        System.out.printf("%-4s%20s", x.getCountryId(), x.getCountryName());
                    }
                });
    }

    @Override
    public void d() {
        System.out.println("Alle Locations mit Id 'US':\n");
        em.createQuery("SELECT DISTINCT l "
                + "FROM Locations l "
                + "WHERE l.countries.countryId = 'US'")
                .getResultList()
                .forEach(new Consumer<Locations>() {
                    @Override
                    public void accept(Locations x) {
                        System.out.printf("%-20s%-20s%4s", x.getCity(), x.getStateProvince(), x.getCountries().getCountryId());
                    }
                });
    }

    @Override
    public void e(Integer managerId) {
        System.out.printf("Alle Employees mit %d ManagerId:\n", managerId);
        em.createQuery("SELECT e "
                + "FROM Employees e "
                + "WHERE e.departments.employees.employeeId = :mId ")
                .setParameter("mId", managerId)
                .getResultList()
                .forEach(new Consumer<Employees>() {
                    @Override
                    public void accept(Employees x) {
                        System.out.printf("%5d%20s%20s", x.getEmployeeId(), x.getFirstName(), x.getLastName());
                    }
                });
    }

    @Override
    public void f() {
        System.out.println("Alle Depatments mit Mitarbeiter mit 5-stelliges Gehalt:");
        em.createQuery("SELECT DISTINCT d "
                + "FROM Departments d, IN(d.employeesList) e "
                + "WHERE e.salary / 10000 BETWEEN 1 AND 9.99")
                .getResultList()
                .forEach(new Consumer<Departments>() {
                    @Override
                    public void accept(Departments x) {
                        System.out.printf("%5d%20s", x.getDepartmentId(), x.getDepartmentName());
                    }
                });
    }

    @Override
    public void g(String countryId) {
         System.out.printf("Alle Employees aus %s Country:\n",countryId);
        em.createQuery("SELECT e "
                + "FROM Employees e JOIN e.departments d "
                + "WHERE d.locations.countries.countryId = :countryId ")
                .setParameter("countryId", countryId)
                .getResultList()
                .forEach(new Consumer<Employees>() {
                    @Override
                    public void accept(Employees x) {
                        System.out.printf("%5d%20s%20s", x.getEmployeeId(), x.getFirstName(), x.getLastName());
                    }
                });
    }

    @Override
    public void h(String lastName) {
        System.out.printf("Country wo %s Mitarbeiter arbeitet:\n", lastName);
        em.createQuery("SELECT DISTINCT c "
                + "FROM Countries c JOIN c.locationsList l "
                + "JOIN l.departmentsList d "
                + "JOIN d.employeesList e "
                + "WHERE e.lastName = :lastName ")
                .setParameter("lastName", lastName)
                .getResultList()
                .forEach(new Consumer<Countries>() {
                    @Override
                    public void accept(Countries x) {
                        System.out.printf("%-4s%20s", x.getCountryId(), x.getCountryName());
                    }
                });
    }
}
