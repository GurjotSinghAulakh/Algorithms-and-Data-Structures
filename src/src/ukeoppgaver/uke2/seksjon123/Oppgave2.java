package src.ukeoppgaver.uke2.seksjon123;

public class Oppgave2 {
/**
 * If the fromIndex is greater than the toIndex, or if the fromIndex is less than zero, or if the
 * toIndex is greater than the array length, then throw an exception.
 * 
 * @param arrayLength The length of the array
 * @param fromIndex The index of the first element (inclusive) to be filled with the specified value.
 * @param toIndex The index of the last element, exclusive, in the range to be sorted.
 */

    static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }

        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }

        if (toIndex > arrayLength) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }
    }
}
