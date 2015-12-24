/**
 * 
 */
import java.awt.*;

public class WeightScale extends javax.swing.JApplet{
    
    //instance variables
    float lbs = 0F;
    float ozs;
    float kgs;
    float metricTons;
    String name = "somebody";
    
    //initialisation
    public void init(){
        
        String lbsValue = getParameter("weight"); //getparameter from html
        if(lbsValue != null){
            lbs = Float.valueOf(lbsValue);
        }
        String personValue = getParameter("person");
        if(personValue != null){
            name = personValue;
        }
        
        ozs = (float) (lbs * 16);
        kgs = (float) (lbs / 2.204623);
        metricTons = (float) (lbs / 2204.623);
    } //init()
    
    public void paint(Graphics screen){
        Graphics2D screen2D = (Graphics2D) screen;
        screen2D.drawString("Studying the weight of " + name, 5, 30);
        screen2D.drawString("In pounds: " + lbs, 55,50);
        screen2D.drawString("In ounces: " + ozs, 55,70);
        screen2D.drawString("in kilograms: " + kgs, 55, 90);
        screen2D.drawString("in metric tons: " + metricTons, 55, 110);
    }
}