/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometrieclient;

import exceptions.MinusWerteException;
import geom.GeoDataDTO;
import geom.KreisRemote;
import geom.QuaderRemote;
import geom.ZylinderRemote;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author stea1th
 */
public class Rechne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        try {
            InitialContext context = new InitialContext();
            KreisRemote remote = (KreisRemote) context.lookup("KreisBean");
            System.out.println(remote.getUmfang(3));
            QuaderRemote qremote = (QuaderRemote) context.lookup("QuaderBean");
            System.out.println(qremote.getVolume(-3, -5, 6));
            ZylinderRemote zRemote = (ZylinderRemote) context.lookup("ZylinderBean");
            System.out.println("Fläche: " + zRemote.getFlaeche(3, 5) + " Volumen: " + zRemote.getVolumen(3, 5));
            GeoDataDTO geo = zRemote.getData(10, 40);
            System.out.println("Fläche: " + geo.getFlaeche() + " Volumen: " + geo.getVolumen());
        } catch (MinusWerteException e) {
            System.err.println(e.getCause().getMessage()+" "+e.getMessage());
        }
    }
}
