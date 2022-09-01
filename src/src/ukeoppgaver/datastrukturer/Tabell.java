package src.ukeoppgaver.datastrukturer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Random;

import src.ukeoppgaver.eksempelklasser.Komparator;

public class Tabell {
    private Tabell() {
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randPerm(int n) {
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for (int k = n - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);
            bytt(a, k, i);
        }
        return a;
    }

    public static void randPerm(int[] a) {
        Random r = new Random();

        for (int k = a.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1); // tilfeldig tall fra [0,k]
            bytt(a, k, i);
        }
    }

    public static int maks(int[] a, int fra, int til) {

        fratilKontroll(a.length, fra, til);

        int m = fra;
        int maksverdi = a[fra];

        for (int i = fra + 1; i < til; i++) {
            if (a[i] > maksverdi) {
                m = i;
                maksverdi = a[m];
            }
        }
        return m;
    }

    public static int maks(int[] a) {
        return maks(a, 0, a.length);
    }

    public static int min(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall");
        }

        int m = fra;
        int minvedi = a[fra];

        for (int i = fra + 1; i < til; i++) {
            if (a[i] < minvedi) {
                m = i;
                minvedi = a[m];
            }
        }
        return m;

    }

    public static int min(int[] a) {
        return min(a, 0, a.length);
    }

    public static void bytt(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void skriv(int[] a, int fra, int til) {
        for (int i = fra; i <= til; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void skriv(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void skrivln(int[] a, int fra, int til) {
        skriv(a, fra, til);
        System.out.println();
    }

    public static void skrivln(int[] a) {
        skriv(a);
        System.out.println();
    }

    public static void sort(int[] liste) {
        for (int i = 0; i < liste.length; i++) {
            for (int j = i + 1; j < liste.length; j++) {
                if (liste[i] > liste[j]) {
                    int tmp = liste[i];
                    liste[i] = liste[j];
                    liste[j] = tmp;
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> void sort(T[] liste) {
        for (int i = 0; i < liste.length; i++) {
            for (int j = i + 1; j < liste.length; j++) {
                if (liste[i].compareTo(liste[j]) > 0) {
                    bytt(liste, i, j);
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> void bytt(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void fratilKontroll(int tabellengde, int fra, int til) {

        if (tabellengde == 0) {
            throw new IllegalArgumentException("Tabellengden er null");
        }

        if (fra < 0) {
            throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") er negativ!");
        }

        if (til > tabellengde) {
            throw new ArrayIndexOutOfBoundsException("til(" + til + ") > tablengde(" + tabellengde + ")");
        }

        if (fra > til) {
            throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }

        if (fra == til) {
            throw new NoSuchElementException("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
        }
    }

    public static void vhKontroll(int tablengde, int v, int h) {
        if (v < 0) {
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");
        }
        if (h >= tablengde) {
            throw new ArrayIndexOutOfBoundsException("h(" + h + ") >= tablengde(" + tablengde + ")");
        }

        if (v > h + 1) {
            throw new IllegalArgumentException("v = " + v + ", h = " + h);
        }
    }

    public static int nestmaks(int[] a) {
        int n = a.length;
        if (n < 2) throw new NoSuchElementException("a.length(" + n + ") < 2!");

        int m = a[0];
        int nm = a[1];

        if (m < nm) {
            m = a[1];
            nm = a[0];
        }

        for (int i = 2; i < a.length; i++) {
            if (a[i] > nm) {
                nm = m;
                m = a[i];
            } else {
                nm = a[i];
            }
        }
        return nm;
    }

    public static int[] nestMaks(int[] a) {
        int n = a.length;

        if (n < 2) throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);

        int nm;

        if (m == 0) {
            nm = maks(a, 1, n);
        } else if (m == n - 1) {
            nm = maks(a, 0, n - 1);
        } else {
            int mv = maks(a, 0, m);
            int mh = maks(a, m + 1, n);
            nm = a[mh] > a[mv] ? mh : mv;
        }
        return new int[]{m, nm};
    }

    public static int[] nestMaksSF(int[] a) {

        int n = a.length;

        if (n < 2) throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);

        bytt(a, 0, m);

        int nm = maks(a, 1, n);

        bytt(a, m, 0);

        return new int[]{m, nm};
    }

    public static int[] nestMaksSB(int[] a) {

        int n = a.length;

        if (n < 2) throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);

        bytt(a, m, n - 1);

        int nm = maks(a, 0, n - 2);

        bytt(a, m, n - 1);

        return new int[]{m, nm};
    }

    public static void sortering(int[] a) {

        int n = a.length;

        if (n < 2) throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        for (int i = n - 1; i > 0; i--) {

            int m = maks(a, 0, i);

            bytt(a, m, i);

            int nm = maks(a, 0, i);

            bytt(a, nm, i - 1);
        }
    }

    public static int[] nestMaksTR(int[] a) { //Turneringstre
        int n = a.length;

        if (n < 2) throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int[] b = new int[2 * n];
        //System.arraycopy(a,0,b,n,n);
        kopier(a, 0, b, n, n);

        for (int k = 2 * n - 2; k > 1; k -= 2) {
            b[k / 2] = Math.max(b[k], b[k + 1]);
        }

        int maksverdi = b[1];
        int nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2 * n - 1, k = 2; k < m; k *= 2) {
            int temp = b[k + 1];
            if (maksverdi != b[k]) {
                temp = b[k];
                k++;
            }
            if (temp > nestmaksverdi) {
                nestmaksverdi = temp;
            }
        }
        return new int[]{maksverdi, nestmaksverdi};
    }

    public static void kopier(int[] a, int i, int[] b, int j, int ant) {
        int aIndex = i;
        for (int k = j; k < ant * 2; k++) {
            if (aIndex < a.length) {
                b[k] = a[aIndex];
                aIndex++;
            }
        }
    }

    public static void snu(int[] a, int v, int h) {
        while (v < h) {
            bytt(a, v++, h--);
        }
    }

    public static void snu(int[] a, int v) {
        snu(a, v, a.length - 1);
    }

    public static void snu(int[] a) {
        snu(a, 0, a.length - 1);
    }

    public static boolean nestePermutasjon(int[] a) {
        int i = a.length - 2;
        while (i >= 0 && a[i] > a[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }

        int j = a.length - 1;
        while (a[j] < a[i]) {
            j--;
        }
        bytt(a, i, j);
        snu(a, i + 1);
        return true;
    }

    public static int binarySearch(int verdi, int[] a, int v, int h) {
        int pivot = (v + h) / 2;

        if (h - v == 0) {
            if (a[pivot] == verdi) {
                return pivot;
            } else {
                return -pivot;
            }
        }

        if (a[pivot] <= verdi) {
            if (a[pivot] == verdi) {
                return pivot;
            }
            return binarySearch(verdi, a, pivot + 1, h);
        } else {
            return binarySearch(verdi, a, v, pivot - 1);
        }
    }

    public static int inversjoner(int[] a) {
        int antall = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    antall++;
                }
            }
        }
        return antall;
    }

    public static void utvalgssortering(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            bytt(a, i, min(a, i, a.length));
        }
    }

    public static void utvalgssortering(int[] a, int fra, int til) {

        fratilKontroll(a.length, fra, til);

        for (int i = fra; i < a.length - 1; i++) {
            int index = i;
            for (int j = til + 1; j < a.length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            int smallerNumber = a[index];
            a[index] = a[i];
            a[i] = smallerNumber;
        }
    }

    //Hentet fra https://www.javatpoint.com/selection-sort-in-java
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j; //searching for lowest index
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    public static int usortertsok(int[] a, int verdi) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == verdi) {
                return i;
            }
        }
        return -1;
    }

    public static int linearsok(int[] a, int verdi) {
        if (a.length == 0 || verdi > a[a.length - 1]) {
            return -(a.length + 1);
        }
        int i = 0;
        for (; a[i] < verdi; i++) ;

        return verdi == a[i] ? i : -(i + 1);
    }

    public static int linearsokReturSisteVerdi(int[] a, int verdi) {
        if (a.length == 0 || verdi > a[a.length - 1]) {
            return -(a.length + 1);
        }
        int i = a.length - 1;
        for (; a[i] > verdi; i--) ;

        return verdi == a[i] ? i : -(i + 1);
    }

    public static int linearsok(int[] a, int k, int verdi) {
        if (a.length == 0 || verdi > a[a.length - 1]) {
            return -(a.length + 1);
        }
        if (k < 0) {
            throw new IllegalArgumentException("Hoppelengden kan ikke være negativ");
        }

        for (int i = 0; i < i + k && i < a.length; i += k) {
            if (verdi < a[i]) {
                for (int j = i - k; j < i + k; j++) {
                    if (a[j] == verdi) {
                        return j;
                    }
                }
            }
        }
        return -1;
    }

    public static int kvadratrotsok(int[] a, int verdi) {
        int k = (int) Math.sqrt(a.length);
        if (verdi < a[k]) {
            for (int i = 0; i < k; i++) {
                if (verdi == a[i]) {
                    return i;
                }
            }
        } else {
            for (int i = k; i < a.length; i++) {
                if (verdi == a[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    //Returnerer siste index
    public static int binaersokV1(int[] a, int fra, int til, int verdi) {
        fratilKontroll(a.length, fra, til);
        int v = fra;
        int h = til - 1;

        while (v <= h) {
            int m = (v + h) / 2;
            int midtverdi = a[m];

            if (verdi == midtverdi) {
                return m;
            } else if (verdi > midtverdi) {
                v = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -(v + 1);
    }

    //Returnerer siste index
    public static int binaersokV2(int[] a, int fra, int til, int verdi) {
        fratilKontroll(a.length, fra, til);
        int v = fra;
        int h = til - 1;

        while (v <= h) {
            int m = (v + h) / 2;
            int midtverdi = a[m];

            if (verdi > midtverdi) {
                v = m + 1;
            } else if (verdi < midtverdi) {
                h = m - 1;
            } else {
                return m;
            }
        }
        return -(v + 1);
    }

    //Returnerer første index
    public static int binaersokV3(int[] a, int fra, int til, int verdi) {
        fratilKontroll(a.length, fra, til);
        int v = fra;
        int h = til - 1;

        while (v < h) {
            int m = (v + h) / 2;

            if (verdi > a[m]) {
                v = m + 1;
            } else {
                h = m;
            }
        }

        if (h < v || verdi < a[v]) {
            return -(v + 1);
        } else if (verdi == a[v]) {
            return v;
        } else {
            return -(v + 2);
        }
    }

    public static int binaersokV1(int[] a, int verdi) {
        return binaersokV1(a, 0, a.length, verdi);
    }

    public static int binaersokV2(int[] a, int verdi) {
        return binaersokV2(a, 0, a.length, verdi);
    }

    public static int binaersokV3(int[] a, int verdi) {
        return binaersokV3(a, 0, a.length, verdi);
    }

    public static void innsettingssortering(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int verdi = a[i];
            int j = i - 1;
            for (; j >= 0 && verdi < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = verdi;
        }
    }

    public static void innsettingssortering(int[] a, int fra, int til) {
        for (int i = fra; i <= til; i++) {
            int verdi = a[i];
            int j = i - 1;
            for (; j >= fra && verdi < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = verdi;
        }
    }

    public static void innsettingssorteringV2(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            for (int j = i - 1; j >= 0 && temp < a[j]; j--) {
                Tabell.bytt(a, j, j + 1);
            }
        }
    }

    public static void shell(int[] a, int k) {
        for (int i = k; i < a.length; i++) {
            int temp = a[i];
            int j = i - k;
            for (; j >= 0 && temp < a[j]; j -= k) {
                a[j + k] = a[j];
                a[j + k] = temp;
            }
        }
    }

    public static boolean erSortert(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }

    public static int maks(double[] a) {
        int m = 0;
        double maksverdi = a[m];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > maksverdi) {
                maksverdi = a[m];
                m = i;
            }
        }
        return m;
    }

    public static int maks(String[] a) {
        int m = 0;
        String maksverdi = a[m];

        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(maksverdi) > 0) {
                maksverdi = a[m];
                m = i;
            }
        }
        return m;
    }

    public static int maks(char[] a) {
        int m = 0;
        char maksverdi = a[m];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > maksverdi) {
                maksverdi = a[m];
                m = i;
            }
        }
        return m;
    }

    public static int maks(Integer[] a) {
        int m = 0;
        Integer maksverdi = a[m];

        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(maksverdi) > 0) {
                maksverdi = a[m];
                m = i;
            }
        }
        return m;
    }

    //Generiske metoder (Start)

    public static <T extends Comparable<? super T>> int maks(T[] a) {
        int m = 0;
        T maksverdi = a[m];

        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(maksverdi) > 0) {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a) {
        for (int i = 1; i < a.length; i++) {
            T verdi = a[i];
            int j = i - 1;
            for (; j >= 0 && verdi.compareTo(a[j]) < 0; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = verdi;
        }
    }

    public static void skriv(Object[] a, int fra, int til) {
        for (int i = fra; i < til; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print(a[til]); //For å unngå mellomrom til slutt
    }

    public static void skriv(Object[] a) {
        skriv(a, 0, a.length - 1);
    }

    public static void skrivln(Object[] a) {
        skriv(a, 0, a.length - 1);
        System.out.println(); //For ny linje
    }

    public static void bytt(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static Integer[] randPermInteger(int n) {
        Integer[] a = new Integer[n];
        Arrays.setAll(a, i -> i + 1);

        Random r = new Random();

        for (int k = n - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);
            bytt(a, k, i);
        }
        return a;
    }

    public static void f(int a, Integer b) {
    }

    public static void f(Integer a, int b) {
    }

    public static <T> void innsettingssortering(T[] a, Komparator<? super T> c) {
        for (int i = 1; i < a.length; i++) {
            T verdi = a[i];
            int j = i - 1;

            for (; j >= 0 && c.compare(verdi, a[j]) < 0; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = verdi;
        }
    }

    public static <T> int maks(T[] a, Komparator<? super T> c) {
        int m = 0;
        T maksverdi = a[m];

        for (int i = 1; i < a.length; i++) {
            if (c.compare(a[i], maksverdi) > 0) {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static <T> int maks(T[] a, int fra, int til, Comparator<? super T> c) {
        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;
        T maksverdi = a[fra];

        for (int i = fra + 1; i < til; i++) {
            if (c.compare(a[i], maksverdi) > 0) {
                m = i;
                maksverdi = a[m];
            }
        }

        return m;
    }

    public static <T> void utvalgssortering(T[] a, Comparator<? super T> c) {
        for (int k = a.length; k > 1; k--) {
            bytt(a, maks(a, 0, k, c), k - 1);
        }
    }

    private static <T> void kvikksortering(T[] a, int v, int h, Comparator<? super T> c) {
        if (v >= h) {
            return;
        }

        int p = sParter(a, v, h, (v + h) / 2, c);
        kvikksortering(a, v, p - 1, c);
        kvikksortering(a, p + 1, h, c);
    }

    public static <T> void kvikksortering(T[] a, Comparator<? super T> c) {
        kvikksortering(a, 0, a.length - 1, c);
    }

    public static <T> int parter(T[] a, int v, int h, T skilleverdi, Comparator<? super T> c) {
        while (v <= h && c.compare(a[v], skilleverdi) < 0) {
            v++;
        }
        while (v <= h && c.compare(skilleverdi, a[h]) <= 0) {
            h--;
        }

        while (true) {
            if (v < h) {
                Tabell.bytt(a, v++, h--);
            } else {
                return v;
            }
            while (c.compare(a[v], skilleverdi) < 0) {
                v++;
            }
            while (c.compare(skilleverdi, a[h]) <= 0) {
                h--;
            }
        }
    }

    public static <T> int parter(T[] a, T skilleverdi, Comparator<? super T> c) {
        return parter(a, 0, a.length - 1, skilleverdi, c);
    }

    public static <T> int sParter(T[] a, int v, int h, int k, Comparator<? super T> c) {
        if (v < 0 || h >= a.length || k < v || k > h) {
            throw new IllegalArgumentException("Ulovlig parameterverdi");
        }

        bytt(a, k, h);
        int p = parter(a, v, h - 1, a[h], c);
        bytt(a, p, h);

        return p;
    }

    private static <T> void flett(T[] a, T[] b, int fra, int m, int til, Comparator<? super T> c) {
        int n = m - fra;
        System.arraycopy(a, fra, b, 0, n);

        int i = 0, j = m, k = fra;

        while (i < n && j < til) {
            a[k++] = c.compare(b[i], a[j]) < 0 ? b[i++] : a[j++];
        }

        while (i < n) {
            a[k++] = b[i++];
        }
    }

    private static <T> void flettesortering(T[] a, T[] b, int fra, int til, Comparator<? super T> c) {
        if (til - fra <= 1) {
            return;
        }

        int m = (fra + til) / 2;

        flettesortering(a, b, fra, m, c);
        flettesortering(a, b, m, til, c);

        flett(a, b, fra, m, til, c);
    }

    @SuppressWarnings("unchecked")
    public static <T> void flettesortering(T[] a, Comparator<? super T> c) {
        T[] b = (T[]) new Object[a.length / 2];
        flettesortering(a, b, 0, a.length, c);
    }
    /*
    public static <T, R extends Comparable<? super R>> int binarySearchBy(T[] list, R pivotKey, Funksjon<? super T, ? extends R> selector) {
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int ord = selector.anvend(list[mid]).compareTo(pivotKey);
            if (ord < 0) {
                low = mid + 1;
            } else if (ord > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return ~high;
    }
    public static <T, R extends Comparable<? super R>> int intervalBinarySearchBy(T[] list, R min, R max, Funksjon<? super T, ? extends R> selector) {
        int idx = binarySearchBy(list, max, selector);
        if (idx >= 0) return idx;
        idx = ~idx;
        return (idx < list.length && min.compareTo(selector.anvend(list[idx])) ? idx : -1;
    }
    public static <T, R extends Comparable<? super R> > Comparator<T> comparatorBy(Funksjon<? super T, ? extends R> selector) {
        return (a, b) -> selector.anvend(a).compareTo(selector.anvend(b));
    }
     */

    // Metoder med rekursjon/rekursive metoder

    public static int a(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        } else {
            return 2 * a(n - 1) + 3 * a(n - 2);
        }
    }

    public static int tverrsum(int n) {
        if (n < 10) {
            return n;
        } else {
            return tverrsum(n / 10) + (n % 10);
        }
    }

    public static int tverrsumURek(int n) {
        int tall1, tall2, tall3;

        tall1 = n / 100;        // --> 7,51 = 7
        tall2 = (n % 100) / 10; // --> (51) / 10 = 5,1 = 5
        tall3 = n % 10;         // --> 1

        return tall1 + tall2 + tall3;
    }

    public static int tverrsumUtskrift(int n) {
        System.out.println("tverrsum(" + n + ") starter!");
        int sum = (n < 10) ? n : tverrsumUtskrift(n / 10) + (n % 10);
        System.out.println("tverrsum(" + n + ") er ferdig!");
        return sum;
    }

    public static int sifferrot(int n) {
        if (n < 10) {
            return n;
        } else {
            return sifferrot(tverrsum(n / 10) + (n % 10));
        }
    }

    public static int euklid(int a, int b) {
        if (b == 0) {
            return a;
        }
        int r = a % b;
        return euklid(b, r);
    }

    public static int euklidUtskrift(int a, int b) {
        if (b == 0) {
            return a;
        }
        System.out.println("euklid(" + a + ", " + b + ") starter!");
        int r = a % b;
        int sum = euklidUtskrift(b, r);
        System.out.println("euklid(" + a + ", " + b + ") ferdig!");
        return sum;
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return sum(n - 1) + n;
    }

    public static int sum(int[] a, int n) {
        if (n == 1) {
            return a[0];
        }
        return sum(a, n - 1) + a[n - 1];
    }

    public static int sum(int[] a, int v, int h) {
        if (v == h) {
            return a[v];
        }
        int m = (v + h) / 2;
        return sum(a, v, m) + sum(a, m + 1, h);
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fibUtskrivt(int n) {
        System.out.println("fib(" + n + ") starter!");
        int fib = n > 1 ? fibUtskrivt(n - 1) + fibUtskrivt(n - 2) : n;
        System.out.println("fib(" + n + ") er ferdig!");
        return fib;
    }

    public static int sumkvadrattall(int n) {
        if (n == 0) {
            return 0;
        }
        return sumkvadrattall(n - 1) + (int) Math.pow(n, 2);
    }

    public static int sum(int k, int n) {
        if (k > n) {
            return -1;
        } else if (k == n) {
            return k;
        }
        int m = (k + n) / 2;
        return sum(k, m) + sum(m + 1, n);

    }

    public static int storst(int[] a, int index) {
        if (index > 0) {
            return Math.max(a[index], storst(a, index - 1));
        } else {
            return a[0];
        }
    }

    public static long fak(int a) {
        if (a <= 1) {
            return 1;
        }

        return a * fak(a - 1);
    }

    public static void kvikksortering0(int[] a, int v, int h) {
        if (v == h) {
            return;
        }
        System.out.println("Kallet med [" + v + ":" + h + "] starter!");
        int k = sParter0(a, v, h, (v + h) / 2);
        System.out.println("Kallet med [" + v + ":" + h + "] er ferdig!");
    }

    private static int parter0(int[] a, int v, int h, int skilleverdi) {
        while (true) {                                  // stopper når v >= h
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) {
                bytt(a, v++, h--);                        // bytter om a[v] og a[h]
            } else {
                return v;                               // partisjoneringen er ferdig
            }
        }
    }

    private static int sParter0(int[] a, int v, int h, int indeks) {
        bytt(a, indeks, h);         // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h ? 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }
}
