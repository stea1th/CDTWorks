/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbeispieleneu.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author stea1th
 */
@Stateless(mappedName = "DataSourceDemoBean")
public class DataSouceDemo implements DataSouceDemoLocal {

    @Resource(name = "hr")
    private DataSource hr;

    @Override
    public Set<String> leseRegions() {
        Set<String> list = new HashSet<>();
        String sql = "select r.region_name\n"
                + "from departments d join locations l on d.location_id=l.location_id\n"
                + "join countries c on l.country_id=c.country_id\n"
                + "join regions r on c.region_id= r.region_id";
        try (ResultSet result = hr.getConnection().createStatement().executeQuery(sql)) {
            while(result.next()){
                list.add(result.getString(1));
            }
        } catch (SQLException e) {
            

        }
        return list;
    }

}
