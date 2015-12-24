/**
 * 
 */

public class ModemTester{
    
    public static void main(String[] args){
        
        CableModem surfBoard = new CableModem();
        DSLModem gateWay = new DSLModem();
        
        surfBoard.speed = 500000;
        gateWay.speed = 400000;
        
        System.out.print("Trying the cable modem: ");
        surfBoard.displaySpeed();
        surfBoard.connect();
        
        System.out.println("Trying the DSL modem: ");
        gateWay.displaySpeed();
        gateWay.connect();
        
    }
}