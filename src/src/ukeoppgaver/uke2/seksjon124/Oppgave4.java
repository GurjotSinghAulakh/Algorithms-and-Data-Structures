package src.ukeoppgaver.uke2.seksjon124;

import src.ukeoppgaver.datastrukturer.Tabell;

public class Oppgave4 {
    /**
     * > The function takes an array of integers and sorts it in ascending order
     * 
     * @param a The array to be sorted
     */
    
    public static void sortering(int[] a) {
        for (int i = a.length; i > 1; i--) {
            int m = Tabell.maks(a,0,i);
            Tabell.bytt(a,i-1,m);
        }
    }
}
