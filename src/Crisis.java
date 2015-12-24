/**
 * GUI with five buttons
 * Using LayoutManger
 */

import java.awt.*;
import javax.swing.*;

public class Crisis extends  JFrame{
    JButton panicButton;
    JButton dontPanicButton;
    JButton blameButton;
    JButton mediaButton;
    JButton saveButton;
    
    public Crisis(){
        super("Crisis");
        setLookAndFeel();
        setSize(340,128);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        FlowLayout flo = new FlowLayout();
        setLayout(flo);
        
        panicButton = new JButton("Panic");
        dontPanicButton = new JButton("don't Panic");
        blameButton = new JButton("Blame Others");
        mediaButton = new JButton("Notify the Medio");
        saveButton = new JButton("Save Yourself");
        
        add(panicButton);
        add(dontPanicButton);
        add(blameButton);
        add(mediaButton);
        add(saveButton);
        setVisible(true);
        
    }
    
    private void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception exc){
            //ignore message
        }
    }
    
    public static void main(String[] args){
        Crisis cr = new Crisis();
    }
}