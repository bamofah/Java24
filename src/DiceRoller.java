/**
 * presents a graphical user interface that can display dice-roll results
 * and begin a set of rolls
 */

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class DiceRoller extends JFrame implements ActionListener,
        PropertyChangeListener{
    
    //the table for the dice-roll results
    JTextField[] total = new JTextField[16];
    //the "Roll" button
    JButton roll;
    //the number of times to roll
    JTextField quantity;
    //the swing worker
    DiceWorker worker;
    
    public DiceRoller(){
        super("Dice Roller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(850,145);
        
        //set up top row
        JPanel topPane = new JPanel();
        GridLayout paneGrid = new GridLayout(1, 10);
        topPane.setLayout(paneGrid);
        for (int i = 0; i < 16; i++){
            //create a textfield and label
            total[i] = new JTextField("0",4);
            JLabel label = new JLabel((i + 3) + ": ");
            //create tje ce;;s om tje grod
            JPanel cell = new JPanel();
            cell.add(label);
            cell.add(total[i]);
            //add the cell to the top row
            topPane.add(cell);
        }
        
        //set up bottom row
        JPanel bottomPane = new JPanel();
        JLabel quantityLable = new JLabel("times to Rool: ");
        quantity = new JTextField("0",5);
        roll = new JButton("Roll");
        roll.addActionListener(this);
        bottomPane.add(quantityLable);
        bottomPane.add(quantity);
        bottomPane.add(roll);
        
        //set up frame
        GridLayout frameGrid = new GridLayout(2,1);
        setLayout(frameGrid);
        add(topPane);
        add(bottomPane);
        
        setVisible(true);
        
    }//constructor
    
    //respond when the "Roll" button is clicked
    public void actionPerformed(ActionEvent event){
        int timesToRoll;
        
        try{
            //turn off the button
            timesToRoll = Integer.parseInt(quantity.getText());
            roll.setEnabled(false);
            //set up the worker that will roll the dice
            worker = new DiceWorker(timesToRoll);
            //add a listener that monitors the worker
            worker.addPropertyChangeListener(this);
            //start the worker
            worker.execute();
        } catch(Exception exc){
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }//actionPerformed
    
    //respond when the worker's task is complete
    public void propertyChange(PropertyChangeEvent event){
        try{
            //get the worker's dice.roll results
            int[] result = (int[]) worker.get();
            //store the results in text fields
            for(int i = 0; i < result.length; i++){
                total[i].setText("" + result[i]);
            }
        }catch(Exception exc){
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }//propertyChange
    
    private static void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel( 
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        }catch(Exception exc){
            //ignore error
        }
    }//setLookAndFeel
    
    public static void main(String[] args){
        new DiceRoller();
    }
}