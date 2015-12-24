/**
 * 
 */
public class Calculator{
    
    public static void main(String[] args){
        float sum = 0;
        for (int i = 0; i < args.length; i++){
            sum = sum + Float.parseFloat(args[i]);
        }
        System.out.println("Those numbers add up to " + sum);
    }
}