/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpql.beans;

import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface JpqlLocal {
    void leseAlleJobs();
    void leseBestimmteJobs();
    void leseJobTitles();
    void leseIdsUndTitles();
    void beispiel4();
    void beispiel5a();
//    void beispiel5b();
    void beispiel6();
    void parameterDemo(Double minZahl, Double maxZahl);
    void getSingleDemoA();
    void getSingleDemoB();
    void getAntiSingleDemo();
}
