package src.ukeoppgaver.uke2.seksjon121;

import src.ukeoppgaver.datastrukturer.Tabell;

public class Oppgave1 {
/**
 * It returns the smallest value in the array a
 */
    public static void main(String[] args) {
        int [] a = {3,4,1,3,2,6,4,2,6,9,7,5};
        System.out.println(Tabell.min(a));
        System.out.println(Tabell.min(a, 3,8));
    }
}
