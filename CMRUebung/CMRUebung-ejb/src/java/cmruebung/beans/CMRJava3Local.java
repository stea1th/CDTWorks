/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmruebung.beans;

import cmruebung.entities.Departments;
import cmruebung.entities.Employees;
import javax.ejb.Local;

/**
 *
 * @author stea1th
 */
@Local
public interface CMRJava3Local {
    Employees a3(int employeesId);
    Departments b3(int departmentId);
    void a4(int employeesId, int neuesDepartmentId);
    void b4(int altDepId, int neuDepId);
    void c4(int departmentsId, int employeesId);
}
