package src.ukeoppgaver.uke2.seksjon1213;

import java.util.Arrays;

import src.ukeoppgaver.datastrukturer.Tabell;

public class Oppgave1 {
    /**
     * It returns an array of two integers, where the first integer is the index of the largest element in
     * the array, and the second integer is the index of the second largest element in the array
     */
    public static void main(String[] args) {
        int[] a = {3,4,5,7,4,3,5,4,2,6,8,1,9,6};
        System.out.println(Arrays.toString(Tabell.nestMaksTR(a)));
    }
    
}
