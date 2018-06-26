/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democlient;

import demoserver.BeanDemo1Remote;
import java.util.Scanner;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author stea1th
 */
public class BeanDemo1Test {
    
    public static void main(String[] args) throws NamingException {
        InitialContext context = new InitialContext();
        Scanner scanner = new Scanner(System.in);
        String stadt = "";
        BeanDemo1Remote remote = (BeanDemo1Remote) context.lookup("BeanDemo1Bean");
        while(true){
            System.out.println("Gib ein Stadt ein:");
            if((stadt = scanner.nextLine()).equals(""))
                break;
            remote.erweitereAlleStaedte(stadt);
        }
        
        remote.getAlleStaedte().forEach(System.out::println);
        
    }
    
}
