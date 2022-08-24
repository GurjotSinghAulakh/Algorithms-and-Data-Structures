package src.ukeoppgaver.uke1.seksjon112;

public class Oppgave3 {
    public static void main(String[] args) {
        
        // Creating an array of integers.
        int [] a = {4,6,8,1,2,3,5,7};

        // Calling the method `min` and assigning the return value to the variable `maks`.
        int maks = maks(a);

        // It prints the value of the variable `minste` to the console.
        System.out.println(maks);
    }
    
    /**
     * The function maks() takes an array of integers as input and returns the index of the largest
     * integer in the array
     * 
     * @param b The array we're searching through
     * @return The index of the largest value in the array.
     */

    public static int maks(int[] b){  

        // It checks if the array is empty. If it is, it throws an exception.
        if(b.length < 1) throw new java.util.NoSuchElementException("Tabellen a er tom!");

        
        int n = 0; 

        // It's iterating through the array and comparing the value of the current index with the value
        // of the index `n`. If the value of the current index is larger than the value of the index
        // `n`, it's setting the value of `n` to the current index.

        for (int i = 1; i < b.length; i++) {
            if (b[i] >= b[n])  {
                n = i;                
            }
        }

        // It's returning the value of the variable `n` to the function call.
        return n;   
    } 
    
}
