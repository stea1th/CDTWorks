/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emdemo1.beans;

import emdemo1.entities.Departments;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stea1th
 */
@Stateless
public class EMDemo1 implements EMDemo1Local {

    @PersistenceContext(unitName = "DBBeispieleNeu-ejbPU")
    private EntityManager em;

    @Override
    public void holeDatenSatz() {
        Departments d = em.find(Departments.class, (short) 90);
        if (d != null) {
            System.out.println(d.getDepartmentId() + ": " + d.getDepartmentName());
        } else {
            System.out.println("Department ist nicht vorhanden!");
        }

    }

    @Override
    public void schreibeDatenSatz() {
        Departments neu = new Departments((short) 444, "NochIrgendwas");
        em.persist(neu);

    }

    @Override
    public void loescheDatenSatz() {
        Departments neu = em.find(Departments.class, (short) 2500);
        if (neu != null) {
            em.remove(neu);
        }else{
            System.out.println("Department nicht vorhanden");
        }
    }

    @Override
    public void aendernDatenSatz() {
        Departments d = em.find(Departments.class, (short)444);
        d.setDepartmentName("Feierabendclub");
        d.setManagerId(100);
        //em.persist(d);
    }

}
