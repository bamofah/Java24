import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;



public class LinkRotator extends JApplet implements Runnable, ActionListener{
    
    String[] pageTitle = new String[4];
    URL[] pageLink = new URL[6];
    Color butterscoth = new Color(255,204,158);
    int current = 0;
    Thread runner;
    
    public void init(){
        pageTitle = new String[]{
            "Sun's Java Site",
            "Cafe au Lait",
            "JAvaWorld",
            "Java in 24 Hours",
            "WorkBench"
        };
        
        pageLink[0] = getURL("http://java.sun.com");
        pageLink[1] = getURL("http://www.ibiblio.org/javafaq");
        pageLink[2] = getURL("http://www.javaworld.com");
        pageLink[3] = getURL("http://java24hours.com");
        pageLink[4] = getURL("http://www.samspublishing.com");
        pageLink[5] = getURL("http://workbench.codenhead.org");
        
        Button goButton = new Button("Go");
        goButton.addActionListener(this);
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        add(goButton);
    } //init
    
    URL getURL(String urlText){
        URL pageURL = null;
        try{
            pageURL = new URL(getDocumentBase(), urlText);
        } catch (MalformedURLException m){
            //do nothing
        }
        return pageURL;
    } //getURL
    
    public void paint(Graphics screen){
        
        Graphics2D screen2D = (Graphics2D) screen;
        screen2D.setColor(butterscoth);
        screen2D.fillRect(0,0, getSize().width, getSize().height);
        screen2D.setColor(Color.black);
        screen2D.drawString(pageTitle[current], 5, 60);
        screen2D.drawString("" + pageLink[current],5,80);
    }//paint()
    
    public void start(){
        if (runner == null){
            runner = new Thread(this);
            runner.start();
        }
    } //start()
    
    //Running the Thread
    public void run(){
        Thread thisThread = Thread.currentThread();
        while (runner == thisThread){
            current++;
            if (current > 5){
                current = 5;
            }
            repaint();
            try{
                Thread.sleep(10000);
            }catch(InterruptedException e){
                //do Nothing
            }
        }
    } //run()
    
    //Stoping the Thread
    public void stop(){
        if (runner != null){
            runner = null;
        }
    }
    
    //Handling Mouse Clicks
    public void actionPerformed(ActionEvent event){
        if (runner != null){
            runner = null;
        }
        
        AppletContext browser = getAppletContext();
        if(pageLink[current] != null){
            browser.showDocument(pageLink[current]);
        }
    }
    
}
