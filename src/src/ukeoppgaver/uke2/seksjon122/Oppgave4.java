package src.ukeoppgaver.uke2.seksjon122;

import src.ukeoppgaver.datastrukturer.Tabell;

public class Oppgave4 {
    /**
     * It prints the elements in the array a from index 3 to index 5
     */
    public static void main(String[] args) {
        int [] a = {3,4,1,3,2,6,4,2,6,9,7,5};
        Tabell.skriv(a, 3, 5);
        System.out.println();
        Tabell.skriv(a);
    }
}
