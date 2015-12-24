/**
 * a Java application that draws the most recently pressed
 * key in a label by using the getKeyChar() method. The application implements
 * the KeyListener interface, so there are keyTyped(), keyPressed(),
 * and keyReleased() methods in the class. The only one of these that does
 * anything is keyTyped()
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KeyViewer extends JFrame implements KeyListener{
    
    JTextField keyText= new JTextField(80);
    JLabel keyLabel = new JLabel("Press any key in the text field.");
    
    KeyViewer(){
        super("KeyViewr");
        setLookAndFeel();
        setSize(350,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        keyText.addKeyListener(this);
        BorderLayout bord = new BorderLayout();
        setLayout(bord);
        add(keyLabel,BorderLayout.NORTH);
        add(keyText,BorderLayout.CENTER);
        setVisible(true);
    }
    
    public void keyTyped(KeyEvent input){
        char key = input.getKeyChar();
        keyLabel.setText("You Pressed: " + key);
    }
    
    public void keyPressed(KeyEvent txt){
        //do nothing
    }
    
    public void keyReleased(KeyEvent txt){
        //do nothing
    }
    
    private void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel(
             "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception exc){
            //iggonre eerr
        }
    }
    
    public static void main(String[] args){
        KeyViewer frame = new KeyViewer();
    }
    
}