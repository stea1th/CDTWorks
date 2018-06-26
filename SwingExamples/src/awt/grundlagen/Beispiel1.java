/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt.grundlagen;

import java.awt.Frame;
import java.awt.event.*;

/**
 *
 * @author stea1th
 */
public class Beispiel1 {
    public static void main(String[] args) {
        Frame wnd = new Frame("Einfaches Fenster");
        wnd.addWindowListener(new WindowClosingAdapter(true));
        wnd.setSize(1000, 800);
        wnd.setVisible(true);
        
        
    }
}
