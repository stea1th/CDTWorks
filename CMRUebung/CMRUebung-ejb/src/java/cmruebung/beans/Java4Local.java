/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmruebung.beans;

import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface Java4Local {
    void JPQL1(int departmentsId);
    void JPQL2(int departmentsId);
    void JPQL3(String countryId);
    void JPQL4(int employeeId);
    void JPQL5(int departmentsId);
    
    void CMR1(int departmentsId);
    void CMR2(int departmentsId);
    void CMR3(String countryId);
    void CMR4(int employeeId);
    
    void CMR5(int departmentsId);
}
