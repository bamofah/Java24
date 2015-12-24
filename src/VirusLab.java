/**
 * The VirusLab class is a simple application that creates Virus objects and
 * then counts the number of objects that have been created with the
 * getVirusCount() class method of the Virus class.
 */

public class VirusLab{
    
    public static void main(String[] args){
        
        int numViruses = Integer.parseInt(args[0]);
        
        if (numViruses > 0){
            Virus[] virii = new Virus[numViruses];
            
            for (int i = 0; i < numViruses; i++){
                virii[i] = new Virus();
            } //for
        } //if
        
        System.out.println("there are " + Virus.getVirusCount()
            + " viruses");
    }
}