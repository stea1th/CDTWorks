/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warenkorbclient;

import controller.ArtikelDTO;
import controller.ControllerRemote;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author stea1th
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException, ClassNotFoundException {
        
        
        while(true){
            try {
                menu();
                execute();
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }
    
    public  static void menu(){
        System.out.println("Geben Sie folgendes ein: ");
        System.out.println("--------------------------");
        System.out.println("\t1. Artikeln auflisten");
        System.out.println("\t2. Artikel ins Warenkorb addieren");
        System.out.println("\t3. Artikel aus der Warenkorb entfernen");
        System.out.println("\t4. Warenkorb auflisten");
    }
    
    public static void execute() throws NamingException, SQLException, ClassNotFoundException{
        System.out.print("Bitte eingeben: ");
        Scanner scanner = new Scanner(System.in);
        InitialContext context = new InitialContext();
        ControllerRemote remote = (ControllerRemote) context.lookup("ControllerBean");
        switch(scanner.nextInt()){
            case 1 :
                
                for(ArtikelDTO i : remote.getAllArtikels()){
                    System.out.println(i.getId()+" "+i.getBezeichnung()+" "+i.getPreis()+" "+i.getMenge());
                }
                break;
            case 2 :
                System.out.println(remote.getArtikelById(2).getBezeichnung());
                break;
        }
    }
    
}
