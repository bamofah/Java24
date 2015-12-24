/**
 * creating your own user interface component is to decide
 * the existing component from which to inherit. The ClockPanel component
 * is a subclass of JPanel
 * 
 * This class represents panel
 * components that include a label displaying the current date and time
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

/* -ClockPanel is a subclass of JPanel because of extends keyworkd - */
public class ClockPanel extends JPanel{
    
    public ClockPanel(){
        String currentTime = getTime();
        JLabel time = new JLabel("time: ");
        JLabel current = new JLabel(currentTime);
        add(time);
        add(current);
    }
    
    //using the final keyward prevents the mothod from being overridden in a subclass
    final String getTime(){
        String time;
       //get current time and date
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
        int year = now.get(Calendar.YEAR);
        
        String monthName = "";
        
        switch(month){
            case(1):
                monthName = "January";
                break;
            case(2):
                monthName = "February";
                break;
            case(3):
                monthName = "March";
                break;
            case(4):
                monthName = "April";
                break;
            case(5):
                monthName = "May";
                break;
            case(6):
                monthName = "June";
                break;
            case(7):
                monthName = "July";
                break;
            case(8):
                monthName = "August";
                break;
            case(9):
                monthName = "September";
                break;
            case(10):
                monthName = "October";
                break;
            case(11):
                monthName = "November";
                break;
            case(12):
                monthName = "December";
                break;
        }
        time = monthName + " " + day + ", " + year + " "
                + hour + ":" + minute;
        
        return time;        
    } //ggetTime()
    
}