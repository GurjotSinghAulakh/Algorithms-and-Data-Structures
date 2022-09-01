package src.ukeoppgaver.uke2.seksjon124;

import src.ukeoppgaver.datastrukturer.Tabell;

public class Oppgave1 {
    /**
     * It returns an array of two integers, the first of which is the index of the largest element in the
     * array, and the second of which is the index of the second largest element in the array
     */
    
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(20);
        int[] b = Tabell.nestMaks(a);

        int m = b[0];
        int nm = b[1];

        Tabell.skrivln(a);
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);
    }
}
