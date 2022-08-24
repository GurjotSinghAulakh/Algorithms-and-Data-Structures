package src.ukeoppgaver.uke1.seksjon113;

import java.util.Arrays;

public class Oppgave5 {
    public static void main(String[] args) {
        
       // Creating an array with the values 5 and 3.
        int[] a = {5, 3};

        // It prints out the array.
        System.out.println(Arrays.toString(minmaks(a)));

    }

    public static int[] minmaks(int[] a){

        // It checks if the array is empty. If it is, it throws an exception.
        if(a.length < 1) throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int counter = 0;

        int m1 = 0;
        int m2 = 0;

        for (int i = 1; i < a.length; i++) { 

            // It checks if the value of the current element is smaller than the value of the element
            // at index `m`. If it is, it assigns the index of the current element to the variable `m`.

            if (a[i] < a[m1]) { 
                m1 = i;
                counter++;
            } 
            
            // It checks if the value of the current element is bigger than the value of the element
            // at index `m2`. If it is, it assigns the index of the current element to the variable
            // `m2`.

            else if (a[i] > a[m2]) { 
                m2 = i;
                counter++;
            }
        }

        // It prints out the number of times the loop has run.
        System.out.println("Antall ganger det ble sjekket: " + counter);
        
        // It returns an array with the values of `m1` and `m2`.
        return new int[]{m1, m2};
    }

}
