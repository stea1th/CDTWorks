/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt.grundlagen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author stea1th
 */
public class Message1 extends Frame implements KeyListener {

    public Message1() {
        super("Nachrichttransfer");
        setBackground(Color.LIGHT_GRAY);
        setSize(500, 300);
        setVisible(true);
        addKeyListener(this);
        
        
    }
    
    public static void main(String[] args) {
        Message1 wnd = new Message1();
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            setVisible(false);
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void paint(Graphics g) {
        g.setFont(new Font("Italic", Font.PLAIN, 30));
        g.drawString("For Exit press ESC", 100, 100);
        
        
    }
    
    
    
}
