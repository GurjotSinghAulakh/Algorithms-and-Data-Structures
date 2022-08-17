package src.ukeoppgaver.uke1.seksjon1110;

import java.util.Arrays;
import java.util.Random;

public class Program {

    /**
     * It swaps the values of the two elements in the array a at positions i and j
     * 
     * @param a The array to be sorted
     * @param i the index of the first element to be swapped
     * @param j the index of the first element in the subarray
     */

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * It creates an array of integers from 1 to n, and then shuffles the array
     * 
     * @param n the number of elements in the array
     * @return An array of integers.
     */

    public static int[] randPerm(int n){
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for (int k = n - 1; k > 0; k--){
            int i = r.nextInt(k +1);
            bytt(a,k,i);
        }
        return a;
    }

    /**
     * It counts the number of times the largest value in the array changes
     * 
     * @param a The array to be searched
     * @return The number of times the largest value in the array is changed.
     */

    public static int antallMaks(int[] a){
        int antall = 0;
        int maksverdi = a[0];

        for (int i = 1; i < a.length; i++){
            if (a[i] > maksverdi){
                antall++;
                maksverdi = a[i];
            }
        }
        return antall;
    }

    /**
     * It takes an array of integers and returns the sum of the differences between each element and the
     * next
     * 
     * @param a Array of integers
     * @return The number of steps it takes to sort the array.
     */

    public static int kostnader(int[] a){
        int m = 0;
        for (int i = 1; i < a.length; i++){} //Tom blokk
        return m;
    }

    /**
     * It finds the index of the largest element in an array
     * 
     * @param a The array we're searching through
     * @return The index of the largest value in the array.
     */

    public static int maks1(int[] a) {
        if (a.length < 1) throw new java.util.NoSuchElementException("Tabellen a er tom!");
        int m = 0;
        for (int i=1;i<a.length;i++) {
            if (a[i] > a[m]){
                m = i;
            }
        }
        return m;
    }

    /**
     * The function returns the index of the largest value in the array
     * 
     * @param a The array we're searching through
     * @return The index of the largest value in the array.
     */

    public static int maks2(int[] a) {
        int m = 0;
        int maksverdi = a[0];
        for (int i = 1; i < a.length; i++){
            if (a[i] > maksverdi) {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    /**
     * It finds the index of the largest element in the array
     * 
     * @param a The array to be searched
     * @return The index of the largest number in the array.
     */
    
    public static int maks3(int[] a) {
        if (a.length == 0) {
            return -1;
        }

        int sist = a.length - 1;
        int m = 0;
        int maksverdi = a[0];
        int temp = a[sist];
        a[sist] = 0x7fffffff; // Number: 2 147 483 647

        for (int i = 0; ; i++) {
            if (a[i] >= maksverdi) {
                if (i == sist) {
                    a[sist] = temp;
                    return temp >= maksverdi ? sist : m;
                } else {
                    maksverdi = a[i];
                    m = i;
                }
            }
        }
    }
}
