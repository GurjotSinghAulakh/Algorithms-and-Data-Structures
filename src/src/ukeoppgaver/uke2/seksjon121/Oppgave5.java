package src.ukeoppgaver.uke2.seksjon121;

import java.util.Arrays;

public class Oppgave5 {
/**
 * Arrays.copyOfRange(c,4,8) returns a new array that is a copy of the range c[4:8>.
 */
    public static void main(String[] args) {
        char[] c = {'A','B','C','D','E','F','G','H','I','J'};
        char[] d = Arrays.copyOfRange(c,4,8); // en kopi av c[4:8>
        for (char k : d){
            System.out.print(k + " ");
        }
    }
}
