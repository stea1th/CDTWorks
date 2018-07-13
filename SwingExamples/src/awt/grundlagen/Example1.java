/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt.grundlagen;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author stea1th
 */
public class Example1 extends Frame {

    private static MyMouseListener mouseListener;

    public Example1(WindowClosingAdapter windowClose, MyMouseListener mouseListener) {
        setTitle("My First Try");
        setBackground(Color.LIGHT_GRAY);
        setSize(500, 300);
        setVisible(true);
        addWindowListener(windowClose);
        addMouseListener(mouseListener);
        Example1.mouseListener = mouseListener;
    }

    public static void main(String[] args) {
        Example1 ex = new Example1(new WindowClosingAdapter(), new MyMouseListener());
        mouseListener.setExamp(ex);

    }

    public Graphics createGraphics(Point p) {
        //System.out.println(p.x+" "+p.y);
        int thisX = (int) Math.floor(p.getX()) - 35;
        int thisY = (int) Math.floor(p.getY()) - 20;

        Graphics g = getGraphics();
        g.setColor(Color.GREEN);
        g.fillOval(thisX, thisY, 70, 40);
        g.setColor(Color.RED);
        g.drawOval(thisX, thisY, 10, 10);

        g.drawOval(thisX + 70 - 10, thisY, 10, 10);
        g.setColor(Color.BLACK);
        g.drawLine(thisX + 20, thisY + 30, thisX + 50, thisY + 30);
        return g;
    }

}
