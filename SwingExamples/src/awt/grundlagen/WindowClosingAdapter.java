/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt.grundlagen;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author stea1th
 */
public class WindowClosingAdapter extends WindowAdapter{

    private boolean exitSystem;

    public WindowClosingAdapter(boolean exitSystem) {
        this.exitSystem = exitSystem;
    }

    public WindowClosingAdapter() {
        this(false);
    }
    
    
    @Override
    public void windowClosing(WindowEvent e) {
        e.getWindow().setVisible(false);
        e.getWindow().dispose();
        if(exitSystem){
            System.exit(0);
        }
    }
    
}
