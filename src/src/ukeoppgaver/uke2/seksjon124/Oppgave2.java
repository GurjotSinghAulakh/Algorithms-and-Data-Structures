package src.ukeoppgaver.uke2.seksjon124;

import src.ukeoppgaver.datastrukturer.Tabell;

public class Oppgave2 {
    /**
     * It finds the two largest elements in an array
     */
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(20);
        int[] b = Tabell.nestMaksSF(a);

        int m = b[0];
        int nm = b[1];

        Tabell.skrivln(a);
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);
    }
    
}
