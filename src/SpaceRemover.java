/**
 * Storing information in an array
 */

class SpaceRemover{
    public static void main(String[] args){
        String mostFamous = "Rudelph the Red-Nose Raindeer";
        char[] mfl = mostFamous.toCharArray();
        
        for (int dex = 0; dex < mfl.length; dex++){
            char current = mfl[dex];
            if(current != ' '){
                System.out.print(current);
            } else{
                System.out.print('.');
            }
        }
        System.out.println();
    }
}