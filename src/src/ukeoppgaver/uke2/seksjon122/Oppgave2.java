package src.ukeoppgaver.uke2.seksjon122;

import src.ukeoppgaver.datastrukturer.Tabell;

public class Oppgave2 {
  /**
   * It prints out a random permutation of the numbers 0-19.
   */
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(20);

        for (int k : a){
            System.out.print(k + " ");
        }

        int m = Tabell.maks(a);
        System.out.println("\nDen Største verdien ligger på plass " + m);
    }
}
