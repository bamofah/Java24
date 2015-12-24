/**
 * 
 */

import javax.swing.*;
import java.awt.event.*;

public class LottoEvent implements ItemListener, ActionListener, Runnable{
    
    //instance varaible
    LottoMadness gui;
    Thread playing;
    
    public LottoEvent(LottoMadness in){
        gui = in;
    } //constructor
    
    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();
        if(command.equals("Play")){
            startPlaying();
        }
        if(command.equals("Stop")){
            stopPlaying();
        }
        if(command.equals("Reset")){
            clearAllFields();
        }
    }//actionPerformed();
    
    /* -methods- */
    void startPlaying(){
        playing = new Thread(this);
        playing.start();
        gui.play.setEnabled(false);
        gui.stop.setEnabled(true);
        gui.reset.setEnabled(false);
        gui.quickpick.setEnabled(false);
        gui.personal.setEnabled(false);
    }//startPlaying()
    
    void stopPlaying(){
       gui.stop.setEnabled(false);
       gui.play.setEnabled(true);
       gui.reset.setEnabled(true);
       gui.quickpick.setEnabled(true);
       gui.personal.setEnabled(true);
       playing = null;
    }
    
    /**
     * causes all text fields in the application to be emtptied out
     * when Reset button is clicked
     */
    void clearAllFields(){
        for(int i = 0; i < 6; i++){
            gui.numbers[i].setText(null);
            gui.winners[i].setText(null);
        }
        gui.got3.setText("0");
        gui.got4.setText("0");
        gui.got5.setText("0");
        gui.got6.setText("0");
        gui.drawings.setText("0");
        gui.years.setText("0");
    }//clearAllFields()
    
    public void itemStateChanged(ItemEvent event){
        Object item = event.getItem();
        if(item == gui.quickpick){
            for(int i = 0; i < 6; i++){
                int pick;
                do{ //pick random number
                    pick = (int) Math.floor(Math.random() * 50 + 1);
                } while (numberGone(pick, gui.numbers,i));
                gui.numbers[i].setText("" + pick);
            }//for loop
        }//ifStatment
        else{
            for(int i = 0; i < 6; i++){
                gui.numbers[i].setText(null);
            }//for
        } //else
    }//itmeStatechanged
    
    /**
     * converts a text field to an integer, increments it by one,
     * and converts it back into a text field
     * @param field 
     */
    void addOneToField(JTextField field){
        int num = Integer.parseInt("" + field.getText());
        num++;
        field.setText("" + num);
    }// addOneToField()
    
    
    /**
     * Arguments: single number form a lotto drawing,
     * and array that holds several JTextField objects,
     * and a count intger.This method makes sure that each number
     * in a drawing hasn't been selected already in the ssame drawong
     * @param num
     * @param pastNums
     * @param count
     * @return 
     */
    boolean numberGone(int num, JTextField[] pastNums, int count){
        for(int i = 0; i < count; i++){
            if(Integer.parseInt(pastNums[i].getText()) == num){
                return true;
            }
        }//for
        return false;
    }// numberGone
    
    
    /**
     * takes 2 arguments - a JeTextfield object and an array of six
     * JTextField objects
     * This methods checks to see whether one of the user's numbers matching 
     * the numbers form the current lotto drawing
     * @param win
     * @param allPicks
     * @return 
     */
    boolean matchedOne(JTextField win,JTextField[] allPicks){
        for(int i = 0; i < 6; i++){
            String winText = win.getText();
            if(winText.equals(allPicks[i].getText())){
                return true;
            }
        }//for
        return false;
    }//matchedONe
    
    public void run(){
        
        Thread thisThread = Thread.currentThread();
        while(playing == thisThread){
            addOneToField(gui.drawings);
            int draw = Integer.parseInt(gui.drawings.getText());
            float numYears = (float)draw /104;
            gui.years.setText("" + numYears);
            
            int matches = 0;
            for (int i =0; i < 6; i++){
                int ball;
                do{
                    ball = (int) Math.floor(Math.random() * 50 + 1);
                }while(numberGone(ball,gui.winners, i));
                gui.winners[i].setText("" + ball);
                
                if (matchedOne(gui.winners[i], gui.numbers)){
                    matches++;
                }
            }//for
            
            switch(matches){
                case 3:
                    addOneToField(gui.got3);
                    break;
                case 4:
                    addOneToField(gui.got4);
                    break;
                case 5:
                    addOneToField(gui.got5);
                    break;
                case 6:
                    addOneToField(gui.got6);
                    gui.stop.setEnabled(false);
                    gui.play.setEnabled(true);
                    playing = null;
            }//switch matches
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                //do nothing
            }
        }
    }//run()
    
}
