/**
 * The Modem class can handle
 * one of the things that the CableModem and DslModem classes have in common.
 * By using the extends statement when you are creating the CableModem and
 * DslModem classes, you can make each of them a subclass of Modem
 */

public class CableModem extends Modem{
    
    String method = "cable connection";
    
    public void connect(){
        System.out.println("Connecting to the Internet...");
        System.out.println("Using a " + method);
    }
    
}