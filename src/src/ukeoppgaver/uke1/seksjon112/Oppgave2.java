package src.ukeoppgaver.uke1.seksjon112;

public class Oppgave2 {
    public static void main(String[] args) {

        // Creating an array of integers.
        int [] a = {4,6,8,1,2,3,5,7};

        // Calling the method `min` and assigning the return value to the variable `minste`.
        int minste = min(a);

        // It prints the value of the variable `minste` to the console.
        System.out.println(minste);
    }


    /**
     * The function takes an array of integers as input and returns the index of the smallest element
     * in the array.
     * 
     * @param a The array to be searched
     * @return The index of the smallest element in the array.
     */
    
    public static int min(int[] a) {    

        // It checks if the array is empty. If it is, it throws an exception.
        if(a.length < 1) throw new java.util.NoSuchElementException("Tabellen a er tom!");

        // Assigning the value 0 to the variable `m`.
        int m = 0; 

        // Iterating through the array and comparing the value of the current element with the value of
        // the element at index `m`. If the value of the current element is smaller than the value of
        // the element at index `m`, it assigns the index of the current element to the variable `m`.
        for (int i = 1; i < a.length; i++) {  
            if (a[i] < a[m]){
                m = i;
            }
        }

        // It returns the value of the variable `m` to the caller.
        return m; 
    } 
    
}
