/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbuebungneu.beans;

import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface DepartmentsTestLocal {
    
    void getAllData();
    void getDataWithParam();
    void getData(int locationId);
}
