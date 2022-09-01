package src.ukeoppgaver.uke2.seksjon123;

import java.util.NoSuchElementException;

public class Oppgave3 {
    // Feilmeldinger:

    // ArrayIndexOutOfBoundsException: fra(-1) er negativ!
    // ArrayIndexOutOfBoundsException: til(11) > tablengde(10)
    // IllegalArgumentException: fra(10) > til(0) - illegalt intervall!
    // NoSuchElementException: fra(0) = til(0) - tomt tabellintervall!
    // NullPointerException

    /**
     * It returns the index of the largest value in the array
     * 
     * @param a The array to search through
     * @param fra the index of the first element in the array to be considered
     * @param til The index of the last element in the array.
     * @return The index of the largest value in the array.
     */

    public static int maks(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        if (fra == til) {
            throw new NoSuchElementException("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
        }

        int m = fra;             // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];  // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) {
            if (a[i] > maksverdi) {
                m = i;               // indeks til største verdi oppdateres
                maksverdi = a[m];    // største verdi oppdateres
            }
        }
        return m;  // posisjonen til største verdi i a[fra:til>
    }
    
}
