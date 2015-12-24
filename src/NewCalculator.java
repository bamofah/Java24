/**
 * using try-catch
 */

public class NewCalculator{
    public static void main(String[] args){
        float sum = 0;
        for (int i = 0; i < args.length; i++){
            try{
                sum = sum + Float.parseFloat(args[i]);
            } catch (NumberFormatException e){
                System.out.println(args[i] + " is not a number");
            }
        }
        System.out.println("Those numbers add up to " + sum);
    }
}