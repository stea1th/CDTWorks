/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcinsbclient;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import jdbcinsbdtos.DeptSalDTO;
import jdbcinsbserver.DBVermittlerRemote;

/**
 *
 * @author stea1th
 */
public class Beispiel1 {

    public static void main(String[] args) {
        try {
            InitialContext context = new InitialContext();
            DBVermittlerRemote remote = (DBVermittlerRemote) context.lookup("VermittlerBean");
            //System.out.println(remote.dbLesenUndAnzeigen());
            if (!remote.dbLesenUndAbliefern().isEmpty()) {
                for (DeptSalDTO d : remote.dbLesenUndAbliefern()) {
                    System.out.println(d.getDeptId() + " " + d.getDeptName() + " " + d.getDeptSalSum());
                }
            }

        } catch (NamingException e) {
            System.out.println("Probleme mit der Bean...\n"
                    + e.getMessage());
        }
    }

}
