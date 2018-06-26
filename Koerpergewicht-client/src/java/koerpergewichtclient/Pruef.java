/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koerpergewichtclient;

import exceptions.InvalidCharacterException;
import java.util.Arrays;


/**
 *
 * @author stea1th
 */
public class Pruef {

    public static StringBuilder pruef(Integer... arr) {
        StringBuilder builder = new StringBuilder();
        Arrays.asList(arr).stream().filter(i -> i < 0).forEach(i -> builder.append(i).append(" "));
        return builder;
    }

    public static boolean pruefChar(char c) throws InvalidCharacterException {
        return String.valueOf(c).toLowerCase().equals("m") || String.valueOf(c).toLowerCase().equals("w");
    }

}
