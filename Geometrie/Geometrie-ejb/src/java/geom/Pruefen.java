/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geom;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author stea1th
 */
public class Pruefen {

    public static StringBuilder pruef(int... arr) {
        StringBuilder builder = new StringBuilder();
        for (int i : arr) {
            if (i < 0) {
                builder.append(i).append(" ");
            }
        }
        return builder;
    }

}
