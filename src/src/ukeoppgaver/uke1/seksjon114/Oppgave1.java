package src.ukeoppgaver.uke1.seksjon114;

// Deloppgave i og ii
public class Oppgave1 {
    public static void main(String[] args) {
        // i) 10, 5, 7, 2, 9, 1, 3, 8, 4, 6
        // ii) 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    }
     
    public static int maks(int [] a) { 

        int m = 0; //indeks til største verdi  // Tellende operasjoner - 1
        int maksverdi = a[0]; // Største verdi // Tellende operasjoner - 2

        for (int i = 1; i < a.length; i++) {  // Tellende operasjoner - 1 + n + (n-1)
            if (a[i] > maksverdi) {  // Tellende operasjoner - 2(n-1)
                maksverdi = a[i]; // Største verdi oppdateres // Tellende operasjoner - 3X
                m = i; // indeks til største verdi oppdaters  // Tellende operasjoner - 1
            }
        }
        return m; // retunerer indeks/posisjonen til største verdi
    } 

    /********* Forklaring *********/

    // Tellende Operasjoner: 1 + 2 + 1 + n + (n - 1) + 2(n-1) + 3X + 1
    // som blir 4n + 2 + 3X

    /********* Deloppgave i *******/

    // n = 10 (Lengde i arrayet)
    // x = 0

    // 4n + 2 + 3X
    // 4 * 10 + 2 * 3 * 0 = 42

    /********* Deloppgave ii *******/

    // n = 10 (Lengde i arrayet)
    // x = 9

    // 4n + 2 + 3X
    // 4 * 10 + 2 * 3 * 9 = 69
    
}
