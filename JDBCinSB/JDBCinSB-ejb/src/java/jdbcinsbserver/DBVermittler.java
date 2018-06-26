/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcinsbserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import jdbcinsbdtos.DeptSalDTO;

/**
 *
 * @author stea1th
 */
@Stateless(mappedName = "VermittlerBean")
public class DBVermittler implements DBVermittlerRemote, DBVermittlerLocal {

    @Override
    public String dbLesenUndAnzeigen() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            return "Fehler beim Laden des DB-Treibers - Abbruch";
        }

        String url = "jdbc:sqlserver://10.140.130.16:1433;database=hr21;user=dba21;password=dba21";

        String sql = "select l.city, c.country_name, count(d.location_id)\n"
                + "from departments d right join locations l on d.location_id = l.location_id\n"
                + "join countries c on l.country_id=c.country_id\n"
                + "group by l.city,  c.country_name\n"
                + "order by 1";

        try (Statement statement = DriverManager.getConnection(url).createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Anzahl Departments pro City");
            System.out.printf("%-5s%-25s%11s\n", "City", "Country", "Anzahl");

            while (rs.next()) {
                System.out.printf("%-20s%-25s%11d\n", rs.getString(1), rs.getString(2), rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBVermittler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Alles gut";
    }

    @Override
    public List<DeptSalDTO> dbLesenUndAbliefern() {

        List<DeptSalDTO> list = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new EJBException("Fehler beim Laden des DB-Treibers - Abbruch");
        }

        String url = "jdbc:sqlserver://10.140.130.16:1433;database=hr21;user=dba21;password=dba21";
        String sql = "select d.department_id, d.department_name, sum(e.salary)\n"
                + "from employees e right join departments d on e.department_id=d.department_id\n"
                + "group by d.department_id, d.department_name";

        try (Statement statement = DriverManager.getConnection(url).createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new DeptSalDTO(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
            }
        } catch (SQLException ex) {
            throw new EJBException("Probleme mit Datenbank- Abbruch");
        }

        return list;
    }
}
