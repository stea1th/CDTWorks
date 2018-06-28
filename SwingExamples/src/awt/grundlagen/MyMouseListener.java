/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt.grundlagen;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author stea1th
 */
public class MyMouseListener implements MouseListener {
    private Example1 examp;

    public Example1 getExamp() {
        return examp;
    }

    public void setExamp(Example1 examp) {
        this.examp = examp;
    }
    
    
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point point = e.getLocationOnScreen();
        examp.paint(examp.createGraphics((int) Math.floor(point.getX()), (int) Math.floor(point.getY())));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
