/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ArtikelDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author stea1th
 */

@Stateless
public class Model implements ModelLocal{

    private Statement getStatement() throws ClassNotFoundException, SQLException {
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://10.140.130.16;databaseName=Firma21", "dba21", "dba21");
        return conn.createStatement();
    }

    
    @Override
    public List<ArtikelDTO> getAllArtikels() throws SQLException, ClassNotFoundException {
        List<ArtikelDTO> list = new ArrayList<>();
        ResultSet result = getStatement().executeQuery("select * from artikel");
        while(result.next()){
            list.add(new ArtikelDTO(result.getInt(1), result.getString(2), result.getInt(3), result.getDouble(4)));
        }
        return list;
    }
    
    
    @Override
    public void saveToDb(int id, int menge) throws ClassNotFoundException, SQLException{
        Statement statement = getStatement();
        statement.executeUpdate(String.format("update artikel set menge = %d where id = %d", id, menge));
        
    }

}
