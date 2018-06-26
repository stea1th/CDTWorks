/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbuebungneu.beans;

import dbuebungneu.entities.Departments;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stea1th
 */
@Stateless
public class DepartmentsTest implements DepartmentsTestLocal {

    @PersistenceContext(unitName = "DBUebungenNeu-ejbPU")
    private EntityManager em;

    @Override
    public void getAllData() {

        List<Departments> list = em.createQuery("SELECT d FROM Departments d").getResultList();
        System.out.println("All Data from Departments\n");

        list.stream().forEach((d) -> {
            printIt(d);
        });

    }

    @Override
    public void getDataWithParam() {
        Short locationId = 1700;
        List<Departments> list = em.createQuery("SELECT d FROM Departments d "
                + "WHERE d.locationId = " + locationId).getResultList();
        System.out.println("All Data from Departments with Location Id = 1700\n");
        if (!list.isEmpty()) {
            list.stream().forEach((d) -> {
                printIt(d);
            });
        } else {
            System.out.println("**Kein Department gefunden**");
        }

    }

    @Override
    public void getData(int locationId) {
        List<Departments> list = em.createQuery("SELECT d FROM Departments d "
                + "WHERE d.locationId = " + locationId).getResultList();
        System.out.println("All Data from Departments with Location Id\n");
        if (!list.isEmpty()) {
            list.stream().forEach((d) -> {
                printIt(d);
            });
        } else {
            System.out.println("**Kein Department gefunden**");
        }

    }

    public static void printIt(Departments d) {
        System.out.printf("%-5d%-32s%5s%6s\n",
                d.getDepartmentId(), d.getDepartmentName(),
                d.getManagerId() == null ? "N.N." : d.getManagerId(),
                d.getLocationId() == null ? "N.N." : d.getLocationId());
    }
}
