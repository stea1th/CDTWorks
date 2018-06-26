/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author stea1th
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try(Statement statement = DriverManager.getConnection("jdbc:sqlserver://10.140.130.16;databaseName=Firma21", "dba21", "dba21").createStatement()){
            ResultSet result = statement.executeQuery("select * from artikel");
            while(result.next()){
                System.out.println(result.getString(2));
            }
                
        }
    }
    
}
