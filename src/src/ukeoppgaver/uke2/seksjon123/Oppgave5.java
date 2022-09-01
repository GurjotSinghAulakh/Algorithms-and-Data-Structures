package src.ukeoppgaver.uke2.seksjon123;

public class Oppgave5 {

    /**
     * It prints out the elements of an array from index `fra` to index `til`
     * 
     * @param a The array to be printed
     * @param fra the index of the first element in the array to be printed
     * @param til the index of the last element to be printed
     */

    public static void skriv(int[] a, int fra, int til) {
        fratilKontroll(a.length,fra,til);

        for (int i = fra; i < til; i++) System.out.print(a[i] + " ");
    }

    /**
     * It prints out the elements of an array from index `fra` to index `til` (exclusive)
     * 
     * @param a The array to be printed
     * @param fra the index of the first element in the array to be printed
     * @param til the index of the last element in the array to be printed
     */

    public static void skrivln(int[] a, int fra, int til) {
        fratilKontroll(a.length,fra,til);

        for (int i = fra; i < til; i++) System.out.print(a[i] + " ");
        System.out.println();
    }

    /**
     * It prints out the elements of the array c from index fra to index til
     * 
     * @param c The array to be printed
     * @param fra the index of the first element to be printed
     * @param til The index of the last element in the array to be printed.
     */

    public static void skriv(char[] c, int fra, int til) {
        fratilKontroll(c.length,fra,til);

        for (int i = fra; i < til; i++) System.out.print(c[i] + " ");
    }

    /**
     * It prints out the elements of the array `c` from index `fra` to index `til` (exclusive)
     * 
     * @param c The array to be printed
     * @param fra the starting index of the array
     * @param til The index of the last element in the array to be printed.
     */

    public static void skrivln(char[] c, int fra, int til) {
        fratilKontroll(c.length,fra,til);

        for (int i = fra; i < til; i++) System.out.print(c[i] + " ");
        System.out.println();
    }

    /**
     * It checks that the interval [fra:til) is a valid subinterval of [0:tablengde)
     * 
     * @param tablengde The length of the array
     * @param fra the index of the first element in the range
     * @param til The index of the last element in the subarray.
     */
    
    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0) {  // fra er negativ
            throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") er negativ!");
        }

        if (til > tablengde) {   // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException("til(" + til + ") > tablengde(" + tablengde + ")");
        }

        if (fra > til) {  // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }
    }
    
}
