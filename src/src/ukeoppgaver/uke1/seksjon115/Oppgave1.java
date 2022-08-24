package src.ukeoppgaver.uke1.seksjon115;

public class Oppgave1 {
    public static void main(String[] args) {
        int[] a = {7,3,4,7,3,2,6,8};
        int[] b = {3};
        int[] c = {};

        System.out.println(maks(a));
        System.out.println(maks(b));
        System.out.println(maks(c)); 
        
    }

    public static int maks(int[] a) { 

        // Checking if the array is empty. If it is empty, it will return -1.
        if (a.length == 0){
            return -1;
        }

        // Setting the last index of the array to the variable sist.
        int sist = a.length - 1; 

        int m = 0; 

        int maksverdi = a[0];

        int temp = a[sist]; 

        // Put the number 2147483647 last
        a[sist] = 0xffffffff;

        // A for loop that is running until the end of the array.
        for (int i = 0; ; i++) { 

            // Checking if the last index of the array is the biggest number.
            if (a[i] >= maksverdi) { 
                if(i == sist) { 

                    // Setting the last index of the array to the variable temp.
                    a[sist] = temp; 

                    return temp >= maksverdi ? sist : m; 
                }

                // Setting the value of the index to the variable maksverdi.
                else {
                    maksverdi = a[i]; 
                    m = i; 
                }
            }
        }
    } 
}
