/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbuebungneu.beans;

import dbuebungneu.dtos.TransportDtO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author stea1th
 */
@Stateless
public class UebungNeu implements UebungNeuLocal {

    @Resource(name = "ueDB")
    private DataSource ueDB;

    @Override
    public List<TransportDtO> getData() {
        List<TransportDtO> list = new ArrayList<>();
        String sql = "select d.department_name, sum(e.salary)/count(e.employee_id)\n"
                + "from departments d join employees e on d.department_id = e.department_id \n"
                + "group by d.department_name\n"
                + "order by 2 desc";

        try (ResultSet result = ueDB.getConnection().createStatement().executeQuery(sql)) {
            while (result.next()) {
                list.add(new TransportDtO(result.getString(1), result.getDouble(2)));
            }

        } catch (SQLException e) {
            throw new EJBException("SQL-Problemen!!!");
        }
        return list;
    }

    @Override
    public List<TransportDtO> getSalary() {
        List<TransportDtO> list = new ArrayList<>();
        String sql = "select  d.department_name, s.last_name, s.salary\n"
                + "from employees s join departments d on s.department_id = d.department_id\n"
                + "WHERE s.salary = (SELECT min(e.salary) FROM employees e WHERE e.department_id = s.department_id)\n"
                + "order by 1 desc";
        
        try (ResultSet result = ueDB.getConnection().createStatement().executeQuery(sql)) {
            while (result.next()) {
                list.add(new TransportDtO(result.getString(1), result.getString(2), result.getDouble(3)));
            }

        } catch (SQLException e) {
            throw new EJBException("SQL-Problemen!!!");
        }
        return list;
    }

}
