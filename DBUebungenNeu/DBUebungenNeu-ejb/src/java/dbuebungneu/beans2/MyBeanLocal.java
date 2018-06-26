/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbuebungneu.beans2;

import dbuebungneu.dtos.EmployeesDTO;
import dbuebungneu.entities.Departments;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface MyBeanLocal {
    void a();
    void b(int departmentId);
    void c(String countryId);
    void d(String city);
    void e(String departmentName);
    void f(int minSalary, int maxSalary);
    List<EmployeesDTO> g(String minSalary, String maxSalary);
    double a2();
    Object[] b2();
    List<Object[]> c2a();
    List<Object[]> c2b();
}
