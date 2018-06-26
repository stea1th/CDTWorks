/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rechnenclient;

import demo.AddiererRemote;
import java.util.Scanner;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author stea1th
 */
public class Rechne {

    public static void main(String[] args) throws NamingException {
        Scanner scanner = new Scanner(System.in);
        InitialContext context = new InitialContext();
        int x;
        AddiererRemote remote = (AddiererRemote) context.lookup("AddiererBean");
        System.out.print("Geben Sie ein Zahl ein: ");
        while ((x = scanner.nextInt()) != 0) {
            System.out.print("Geben Sie ein Zahl ein: ");
            remote.add(x);
        }
        System.out.println("Schnitt: " + remote.getSchnitt());
        System.out.println("Summe: " + remote.getSumme());
    }

}
