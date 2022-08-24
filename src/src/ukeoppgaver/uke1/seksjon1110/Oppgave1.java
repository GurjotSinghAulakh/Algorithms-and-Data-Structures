package src.ukeoppgaver.uke1.seksjon1110;

import static src.ukeoppgaver.uke1.seksjon1110.Program.*;

public class Oppgave1 {
    public static void main(String[] args) {
        
        int n = 100_000;
        int antall = 2_000;     // tabellstørrelse og gjentagelser
        long tid = 0;           // for tidsmåling
        int a[] = randPerm(n);  // en permutasjon av 1, . .  n

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) kostnader(a);
        tid = System.currentTimeMillis() - tid;    // medgått tid
        System.out.println("Faste kostnader: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks1(a);  // Programkode 1.1.2
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks1-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks2(a);  // Programkode 1.1.4
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks2-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks3(a);  // Programkode 1.1.5
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks3-metoden: " + tid + " millisek");
        
        // maks 2 og 3 er de raskeste men bytter vanligvis mellom hverandre
        // der noen kompileringer er maks 2 raskere enn 3 og andre 3 raskere enn 2
    }
}
