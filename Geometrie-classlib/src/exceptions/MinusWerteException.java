/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author stea1th
 */
public class MinusWerteException extends Exception {

    public MinusWerteException(String message) {
        super("Keine negative Werte: " + message);
    }

    public MinusWerteException(String message, Throwable cause) {
        super(message, cause);
    }
    
    

}
