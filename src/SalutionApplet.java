/**
 * 
 */

import java.awt.*;

public class SalutionApplet extends javax.swing.JApplet{
    
    String greeting;
    
    public void init(){
        greeting = "Saluton mondo!";
    }//initialise
    
    public void paint(Graphics screen){
        Graphics2D screen2D = (Graphics2D) screen;
        screen2D.drawString(greeting, 25, 50); //to dispaly text
    }
}