package src.ukeoppgaver.uke1.seksjon113;

public class Oppgave6 {
    public static void main(String[] args) {

        // Calling the method `fak` with the argument `6`.
        System.out.println(fak(6));
    }

    public static long fak(int n) {

        // Checking if the input is negative, and if it is, it throws an exception.
        if(n < 0) throw new IllegalArgumentException("n < 0");

        // Initializing the variable `fak` to 1.
        long fak = 1;

        // Multiplying the value of `fak` with the value of `i` and then assigning the result to `fak`.
        for (int i = 2; i <= n; i++) {
            fak *= i;
        }

        // It returns the value of `fak` to the caller.
        return fak;
    }
}
