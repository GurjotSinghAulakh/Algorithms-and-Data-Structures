package src.ukeoppgaver.uke1.seksjon1110;

import static src.ukeoppgaver.uke1.seksjon1110.Program.*;

public class Oppgave1 {
    public static void main(String[] args) {

        // Creating an array of random numbers.
        int n = 100_000, antall = 2_000;
        long tid = 0;
        int[] a = randPerm(n);

        // Calculating the time it takes to run the kostnader method.
        tid = System.currentTimeMillis();
        for (int i = 0; i < antall; i++) kostnader(a);
        tid = System.currentTimeMillis() - tid;
        System.out.println("Faste kostnader: " + tid + " millisek");

        // Calculating the time it takes to run the maks1 method.
        tid = System.currentTimeMillis();
        for (int i = 0; i < antall; i++) maks1(a);
        tid = System.currentTimeMillis() - tid;
        System.out.println("Maks1-metoden: " + tid + " millisek");

        // Calculating the time it takes to run the maks2 method.
        tid = System.currentTimeMillis();
        for (int i = 0; i < antall; i++) maks2(a);
        tid = System.currentTimeMillis() - tid;
        System.out.println("Maks2-metoden: " + tid + " millisek");

        // Calculating the time it takes to run the maks3 method.
        tid = System.currentTimeMillis();
        for (int i = 0; i < antall; i++) maks3(a);
        tid = System.currentTimeMillis() - tid;
        System.out.println("Maks3-metoden: " + tid + " millisek");
        
    }
}