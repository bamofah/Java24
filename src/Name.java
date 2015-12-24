/**
 * An array of variables that is sorted by the Arrays class are rearranged into 
 * ascending numerical order. Characters and strings are arranged in alphabetical 
 * order.
 */

import java.util.*;
class Name{
    
    public static void main(String[] args){
        String[] names = {"Lauren", "Audrina","Heidi",
        "Whitney","Stephanie","Spencer","Lisa","Brody","Frankie","Holly",
        "Jordan","Brian","Jason"};
        System.out.println("The original order: ");
        
        for (int dex = 0; dex < names.length; dex++ ){
            System.out.print(dex + ": " + names[dex] + " ");
        }
        
        Arrays.sort(names);
        System.out.println("\nThe new order: ");
        for (int dex = 0; dex < names.length; dex++){
            System.out.print(dex + ": " + names[dex] + " ");
        }
        System.out.println();
        
    }
    
}