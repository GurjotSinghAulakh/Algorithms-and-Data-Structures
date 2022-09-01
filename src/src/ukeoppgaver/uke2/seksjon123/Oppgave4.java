package src.ukeoppgaver.uke2.seksjon123;

import java.util.NoSuchElementException;

public class Oppgave4 {
    
    /**
     * "Find the index of the largest value in the array a, between the indices fra and til."
     * 
     * The function is written in Java, but it's easy to translate it to C++
     * 
     * @param a The array to search through
     * @param fra The index of the first element in the array to be considered.
     * @param til The index of the last element in the array.
     * @return The index of the largest value in the array.
     */

    public static int maks(int[] a, int fra, int til) {
        if (a == null) {
            throw new NullPointerException ("parametertabellen a er null!");
        }

        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        if (fra == til) {
            throw new NoSuchElementException("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
        }

        int m = fra;             // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];  // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) if (a[i] > maksverdi)
        {
            m = i;               // indeks til største verdi oppdateres
            maksverdi = a[m];    // største verdi oppdateres
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }
    
}
