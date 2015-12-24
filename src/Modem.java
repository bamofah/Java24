/**
 * To see a working example of classes and inheritance, in the next project
 * you create classes that represent two types of objects: cable modems, which
 * are implemented as the CableModem class, and DSL modems, which are
 * implemented as the DslModem class. The workshop focuses on simple
 * attributes and behavior for these objects:
 * . Each object should have a speed that it can display.
 * . Each object should be able to connect to the Internet.
 * One thing that cable modems and DSL modems have in common is that
 * they both have a speed. Because this is something they share, it can be put
 * into a class that is the superclass of both the CableModem and DslModem
 * classes.
* 
 */

public class Modem{
    int speed;
    
    public void displaySpeed(){
        System.out.println("Speed: " + speed);
    }
}