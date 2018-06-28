/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmruebung.beans;

import cmruebung.entities.Countries;
import cmruebung.entities.Departments;
import cmruebung.entities.Employees;

import cmruebung.entities.Jobs;
import cmruebung.entities.Locations;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

/**
 *
 * @author stea1th
 */
@Stateless
public class Java4 implements Java4Local {

    @PersistenceContext(unitName = "CMRUebung-ejbPU")
    private EntityManager em;

    @Override
    public void JPQL1(int departmentsId) {
        System.out.printf("Finde alle Employees aus %d Department:", departmentsId);
        List<Employees> list = em.createQuery("SELECT e "
                + "FROM Employees e JOIN e.departments d "
                + "WHERE d.departmentId = :departmentsId ")
                .setParameter("departmentsId", (short) departmentsId)
                .getResultList();
        if (!list.isEmpty()) {
            list.forEach(e -> System.out.printf("%5d%20s%20s\n", e.getEmployeeId(), e.getFirstName(), e.getLastName()));
        }
    }

    @Override
    public void JPQL2(int departmentsId) {
        System.out.printf("Finde Location wo %d Department sich befindet:", departmentsId);
        Locations e = (Locations) em.createQuery("SELECT l "
                + "FROM Locations l JOIN l.departmentsList d "
                + "WHERE d.departmentId = :departmentsId ")
                .setParameter("departmentsId", (short) departmentsId)
                .getSingleResult();
        if (e != null) {
            System.out.printf("%20s%20s%4s\n", e.getCity(), e.getStateProvince(), e.getCountries().getCountryId());
        }
    }

    @Override
    public void JPQL3(String countryId) {
        System.out.printf("Finde alle Employees, die in %s Country arbeiten:", countryId);
        List<Employees> list = em.createQuery("SELECT e "
                + "FROM Employees e "
                + "WHERE e.departments.locations.countries.countryId = :countryId ")
                .setParameter("countryId", countryId)
                .getResultList();
        if (!list.isEmpty()) {
            list.forEach(e -> System.out.printf("%5d%20s%20s\n", e.getEmployeeId(), e.getFirstName(), e.getLastName()));
        }
    }

    @Override
    public void JPQL4(int employeeId) {
        System.out.printf("Finde das Country, in dem %d Employee arbeitet:", employeeId);
        Countries e = (Countries) em.createQuery("SELECT c "
                + "FROM Countries c "
                + "JOIN c.locationsList l "
                + "JOIN l.departmentsList d "
                + "JOIN d.employeesList e "
                + "WHERE e.employeeId = :employeeId ")
                .setParameter("employeeId", employeeId)
                .getSingleResult();
        if (e != null) {
            System.out.printf("%5s%20s\n", e.getCountryId(), e.getCountryName());
        }
    }

    @Override
    public void CMR1(int departmentsId) {
        System.out.printf("Finde alle Employees aus %d Department:", departmentsId);
        Departments d = em.find(Departments.class, (short) departmentsId);
        if (d != null) {
            for (Employees e : d.getEmployeesList()) {
                System.out.printf("%5d%20s%20s\n", e.getEmployeeId(), e.getFirstName(), e.getLastName());
            }
        }
    }

    @Override
    public void CMR2(int departmentsId) {
        System.out.printf("Finde Location wo %d Department sich befindet:", departmentsId);
        Departments d = em.find(Departments.class, (short) departmentsId);
        if (d != null) {
            Locations l = d.getLocations();
            System.out.printf("%20s%20s%4s\n", l.getCity(), l.getStateProvince(), l.getCountries().getCountryId());
        }
    }

    @Override
    public void CMR3(String countryId) {
        System.out.printf("Finde alle Employees, die in %s Country arbeiten:", countryId);
        Countries c = em.find(Countries.class, countryId);
        if (c != null) {
            List<Locations> locations = c.getLocationsList();
            if (!locations.isEmpty()) {
                for (Locations l : locations) {
                    List<Departments> departments = l.getDepartmentsList();
                    if (!departments.isEmpty()) {
                        for (Departments d : departments) {
                            List<Employees> employees = d.getEmployeesList();
                            if (!employees.isEmpty()) {
                                for (Employees e : employees) {
                                    System.out.printf("%5d%20s%20s\n", e.getEmployeeId(), e.getFirstName(), e.getLastName());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void CMR4(int employeeId) {
        System.out.printf("Finde das Country, in dem %d Employee arbeitet:", employeeId);
        Employees e = em.find(Employees.class, employeeId);
        if (e != null) {
            Departments d = e.getDepartments();
            if (d != null) {
                Locations l = d.getLocations();
                if (l != null) {
                    Countries c = l.getCountries();
                    if (c != null) {
                        System.out.printf("%5s%20s\n", c.getCountryId(), c.getCountryName());
                    }
                }
            }
        }
    }

    @Override
    public void CMR5(int departmentsId) {
        System.out.printf("Finde alle Jobs, die in einem %d Department ausgeübt werden:", departmentsId);
        Departments d = em.find(Departments.class, (short) departmentsId);
        if (d != null) {
            List<Employees> empl = d.getEmployeesList();
            if (!empl.isEmpty()) {
                for (Employees e : empl) {
                    Jobs job = e.getJobs();
                    System.out.printf("%35s%10d%10d\n", job.getJobTitle(), job.getMinSalary(), job.getMaxSalary());
                }
            }
        }
    }

    @Override
    public void JPQL5(int departmentsId) {
        System.out.printf("Finde alle Jobs, die in einem %d Department ausgeübt werden:", departmentsId);
        List<Jobs> list = em.createQuery("SELECT j "
                + "FROM Jobs j JOIN j.employeesList e "
                + "WHERE e.departments.departmentId = :departmentsId ")
                .setParameter("departmentsId", (short) departmentsId)
                .getResultList();
        list.forEach(e -> System.out.printf("%35s%10d%10d\n", e.getJobTitle(), e.getMinSalary(), e.getMaxSalary()));

    }
}
