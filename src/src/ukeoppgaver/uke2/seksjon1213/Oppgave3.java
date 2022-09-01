package src.ukeoppgaver.uke2.seksjon1213;

import java.util.Arrays;

import src.ukeoppgaver.datastrukturer.Tabell;

public class Oppgave3 {
    /**
     * It copies the elements from the array a, starting at index 0, to the array b, starting at index
     * a.length, and copies a.length elements
     */
    public static void main(String[] args) {
        int[] a = {3,4,5,7,4,3,5,4,2,6,8,1,9,6};
        int[] b = new int[2*a.length];
        
        Tabell.kopier(a,0,b,a.length,a.length);
        System.out.println(Arrays.toString(b));
    }  
}
