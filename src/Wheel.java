/**
 * Counting Characters
 */

class Wheel{
    public static void main(String[] args){
        String[] phrase = {"A STITCH IN TIME SAVES NINE",
            "DON’T EAT YELLOW SNOW",
            "JUST DO IT",
            "EVERY GOOD BOY DOES FINE"};
        
        int[] letterCount = new int[26];
        for (int count = 0; count < phrase.length; count++){
            String current = phrase[count];
            char[] letters = current.toCharArray();
            
            for (int count2 = 0; count2 < letters.length; count2++){
                char lett = letters[count2];
                if( (lett >= 'A') & (lett <= 'Z')){
                    letterCount[lett - 'A']++;
                }
            }
        } //for count
        
        for (char count = 'A'; count <= 'Z'; count++){
            System.out.print(count + ": " +
                    letterCount[count - 'A'] +
                    " ");
        }
        System.out.println();
    }
}