public interface MyList <E> extends Iterable<E> {
    boolean isEmpty();
    void add(E el);
    void addIndexValue (E el, int i);
    void remove (int i);
    E get (int i);
    int size();
}
