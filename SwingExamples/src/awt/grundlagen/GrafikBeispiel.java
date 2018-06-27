/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt.grundlagen;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

/**
 *
 * @author stea1th
 */
public class GrafikBeispiel extends Frame {
    public static void main(String[] args) {
        GrafikBeispiel wnd = new GrafikBeispiel();
    }

    public GrafikBeispiel() {
        super("GrafikBeispiel");
        addWindowListener(new WindowClosingAdapter(true));
        setBackground(Color.LIGHT_GRAY);
        setSize(1000,800);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawLine(100, 100, 500, 1000);
    }
    
    
}
