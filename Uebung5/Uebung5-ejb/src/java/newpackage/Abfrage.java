/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;

/**
 *
 * @author stea1th
 */
@Stateless
public class Abfrage implements AbfrageLocal {

    @Override
    public List<TestDataDTO> getData(int id) {
        List<TestDataDTO> list = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new EJBException("Fehler beim Laden des DB-Treibers - Abbruch");
        }

        String url = "jdbc:sqlserver://10.140.130.16:1433;database=hr21;user=dba21;password=dba21";

        String sql = "select e.employee_id, e.last_name, e.salary, d.department_name\n"
                + "from employees e join departments d on e.department_id=d.department_id\n"
                + "where d.department_id = " + id;

        try (Statement statement = DriverManager.getConnection(url).createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new TestDataDTO(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
            throw new EJBException("Probleme mit Datenbank - Abbruch");
        }
        return list;
    }

    @Override
    public List<TestDataDTO> getAllEmpl(int id) {
        List<TestDataDTO> list = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new EJBException("Fehler beim Laden des DB-Treibers - Abbruch");
        }

        String url = "jdbc:sqlserver://10.140.130.16:1433;database=hr21;user=dba21;password=dba21";

        String sql = "select  e.employee_id, e.last_name, e.salary, d.department_name, l.city\n"
                + "from locations l right join departments d on l.location_id=d.location_id\n"
                + "join employees e on e.department_id=d.department_id\n"
                + "where l.location_id = " + id;
        
        try (Statement statement = DriverManager.getConnection(url).createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new TestDataDTO(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            throw new EJBException("Probleme mit Datenbank - Abbruch");
        }
        return list;
        
    }

}
