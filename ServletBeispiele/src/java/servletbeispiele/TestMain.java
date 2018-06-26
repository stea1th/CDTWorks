/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletbeispiele;

/**
 *
 * @author stea1th
 */
public class TestMain {
    public static void main(String[] args) {
        try{
        System.out.println( new GewichtZ().getAllData("191", "", "m" ));
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    
}
