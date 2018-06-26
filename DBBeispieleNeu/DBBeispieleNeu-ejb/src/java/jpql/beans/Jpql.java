/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpql.beans;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpql.dtos.Beispiel4DTO;
import jpql.entities.Jobs;

/**
 *
 * @author stea1th
 */
@Stateless
public class Jpql implements JpqlLocal {

    @PersistenceContext(unitName = "DBBeispieleNeu-ejbPU")
    private EntityManager em;

    @Override
    public void leseAlleJobs() {
        Query q = em.createQuery("select j from Jobs j");
        List<Jobs> list = q.getResultList();

        for (Jobs j : list) {
            System.out.println(j.getJobId() + " " + j.getJobTitle());
        }
    }

    @Override
    public void leseBestimmteJobs() {
        Query q = em.createQuery("SELECT j FROM Jobs j "
                + "WHERE j.jobTitle LIKE '%Manager%' "
                + "ORDER BY j.minSalary DESC");
        List<Jobs> list = q.getResultList();

        System.out.println("Datesätze zu \"Managern\" aus Jobs");
        list.stream().forEach((j) -> {
            System.out.printf("%-12s%-37s%10d%10d\n", j.getJobId(), j.getJobTitle(), j.getMinSalary(), j.getMaxSalary());
        });
    }

    @Override
    public void leseJobTitles() {

        System.out.println("Aus allen Datensätzen aus Jobs nur Jobs_Titles:");
        em.createQuery("select j.jobTitle from Jobs j")
                .getResultList()
                .forEach(System.out::println);

    }

    @Override
    public void leseIdsUndTitles() {
        List<Object[]> list = em.createQuery("SELECT j.jobId, j.jobTitle, j.minSalary FROM Jobs j").getResultList();
        System.out.println("Aus allen Datensätzen aus JOBS die JOB_ID und JOB_TITLE ");
        int sum = 0;

        for (Object[] x : list) {
            sum += (int) x[2];
            System.out.printf("%-20s%-40s%7d\n", x[0], x[1], x[2]);
        }
        System.out.println("--------------------------------------");
        System.out.printf("Die Summe: %57d", sum);

//        list.stream().map(x-> sum+=(int)x[2]).forEach((s) -> {
//            System.out.println(s[0]+"\t "+s[1]+"\t "+s[2]);
//            
//        });
    }

    @Override
    public void beispiel4() {
        List<Beispiel4DTO> list = em.createQuery("SELECT new jpql.dtos.Beispiel4DTO(j.jobId, j.jobTitle, j.minSalary) FROM Jobs j").getResultList();
        //List<Beispiel4DTO> list = em.createNativeQuery("SELECT j.jobId, j.jobTitle, j.minSalary FROM Jobs j", Beispiel4DTO.class).getResultList();

        System.out.println("Aus allen Datensätzen aus JOBS die JOB_ID und JOB_TITLE ");
        int sum = 0;

        sum = list.stream().map((x) -> {
            System.out.printf("%-20s%-40s%7d\n", x.getJobId(), x.getJobTitle(), x.getMinSalary());
            return x;
        }).map((x) -> x.getMinSalary()).reduce(sum, Integer::sum);
        System.out.println("--------------------------------------");
        System.out.printf("Die Summe: %57d", sum);
    }

    @Override
    public void beispiel5a() {
        List<Object[]> list = em.createQuery("SELECT j.jobId, j.jobTitle, h.jobHistoryPK.employeeId "
                + "FROM Jobs j JOIN JobHistory h "
                + "ON j.jobId = h.jobId").getResultList();

        System.out.println("Job History: ");
        list.forEach(x -> {
            System.out.printf("%-12s%-37s%d\n", x[0], x[1], (int) x[2]);
        });
    }

//    @Override
//    public void beispiel5b() {
//        List<Object[]> list = em.createQuery("SELECT j.jobId, j.jobTitle, (SELECT COUNT(h.jobHistoryPK.employeeId) "
//                                                + "FROM JobHistory h "
//                                                + "WHERE h.jobId = j.jobId )"
//                + "FROM Jobs j  "
//                + "WHERE j.jobId IN (SELECT DISTINCT h.jobId "
//                + "FROM JobHistory h )").getResultList();
//        
//        System.out.println("Job History2: ");
//        list.forEach(x-> {System.out.printf("%-12s%-37s%d\n", x[0], x[1], (int) x[2]);});
//    }
    @Override
    public void beispiel6() {
        List<Object[]> list = em.createQuery("SELECT j.jobId, j.jobTitle, COUNT(j) "
                + "FROM Jobs j LEFT JOIN JobHistory h "
                + "ON j.jobId = h.jobId "
                + "GROUP BY j.jobId, j.jobTitle ").getResultList();

        System.out.println("Job History Auswertung: ");
        list.forEach(x -> {
            System.out.printf("%-12s%-37s%d\n", x[0], x[1], (long) x[2]);
        });
    }

    @Override
    public void parameterDemo(Double minSal, Double maxSal) {
//        List<Object[]> list = em.createQuery("SELECT j.jobId, j.jobTitle "
//                + "FROM Jobs j "
//                + "WHERE :von <= j.maxSalary AND :bis >= j.minSalary ")
//                .setParameter("von", minSal)
//                .setParameter("bis", maxSal)
//                .getResultList();

        List<Object[]> list = em.createQuery("SELECT j.jobId, j.jobTitle "
                + "FROM Jobs j "
                + "WHERE ?1 <= j.maxSalary AND ?2 >= j.minSalary ")
                .setParameter(1, minSal)
                .setParameter(2, maxSal)
                .getResultList();

        System.out.println("ParameterDemo: ");
        list.forEach(x -> {
            System.out.printf("%-12s%-37s\n", x[0], x[1]);
        });
    }

    @Override
    public void getSingleDemoA() {
        System.out.println("Anzahl verfügbarer Jobs: " + em.createQuery("SELECT COUNT(j) "
                + "FROM Jobs j ").getSingleResult());
    }

    @Override
    public void getSingleDemoB() {
        Object[] erg = (Object[]) em.createQuery("SELECT MIN(j.minSalary), MAX(j.maxSalary), AVG((j.minSalary + j.maxSalary)/2) "
                + "FROM Jobs j ").getSingleResult();
        System.out.printf("Niedrigstes Minimales Gehalt: %,10d\n"
                    + "Höchstes Maximales Gehalt: %,10d\n"
                    + "Durchschnittliches Gehalt: %,10.2f\n",erg[0], erg[1], erg[2]);
       }

    @Override
    public void getAntiSingleDemo() {
        Object obj = em.createQuery("SELECT j.jobTitle "
                + "FROM Jobs j "
                /*+ "WHERE j.jobId = 'abc' "*/).getSingleResult();
    }

}
