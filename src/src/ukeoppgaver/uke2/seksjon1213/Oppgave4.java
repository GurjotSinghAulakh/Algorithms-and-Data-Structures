package src.ukeoppgaver.uke2.seksjon1213;

import src.ukeoppgaver.datastrukturer.Tabell;

public class Oppgave4 {
    public static void kopier2(int[] a, int[] b, int ant) throws IllegalArgumentException {
        
        //kopierer i midten
        System.out.println("1");
        Tabell.kopier(a, b.length/2 - a.length/2,  b, b.length + a.length/2, a.length);

        //kopierer på slutten
        System.out.println("2");
        Tabell.kopier(a, b.length - ant, b, b.length, ant);
        
        //kopierer på starten
        System.out.println("3");
        Tabell.kopier(a, 0, b, a.length, a.length);
    }
}
