package src.ukeoppgaver.eksempelklasser;

@FunctionalInterface
public interface Komparator<T> {
    int compare(T x, T y);

    static <T extends Comparable<? super T>> Komparator<T> naturligOrden(){
        return (x,y) -> x.compareTo(y);
    }

    static <T extends Comparable<? super T>> Komparator<T> anvendtOrden(){
        return (x,y) -> y.compareTo(x);
    }

    // static <T, R extends  Comparable<? super R>> Komparator<T> orden(Funksjon<? super T, ? extends R> velger){
    //     return ((x, y) -> velger.anvend(x).compareTo(velger.anvend(y)));
    // }

    // static <T, R> Komparator<T> orden(Funksjon<? super T, ? extends R> velger, Komparator<? super R> c) {
    //     return (x, y) -> c.compare(velger.anvend(x), velger.anvend(y));
    // }

    default Komparator<T> deretter(Komparator<? super T> c){
        return (x, y) -> {
            int k = compare(x,y);
            return k != 0 ? k : c.compare(x,y);
        };
    }

    // default <R extends Comparable<? super R>> Komparator<T> deretter(Funksjon<? super T, ? extends R> velger) {
    //     return (x, y) -> {
    //         int k = compare(x, y);
    //         return k != 0 ? k : velger.anvend(x).compareTo(velger.anvend(y));
    //     };
    // }

    // default <R> Komparator<T> deretter(Funksjon<? super T, ? extends R> velger, Komparator<? super R> c) {
    //     return (x, y) -> {
    //         int k = compare(x, y);
    //         return k != 0 ? k : c.compare(velger.anvend(x), velger.anvend(y)); };
    // }

    default Komparator<T> omvendt() {
        return (x, y) -> compare(y, x); // bytter x og y
    }
}
