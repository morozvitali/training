import com.sun.source.tree.NewArrayTree;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyArrayList <E> implements MyList <E> {
    private E[] array;
    private int size;

    public MyArrayList() {

         array = createArray(10);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(E el) {
        if (size == array.length) {
            grow();
        }
        array[size++] = el;
    }

    @Override
    public void addIndexValue(E el, int i) {
        if (size == array.length) {
            grow();
        }
        size++;
        for (int a = size; a>i; a--) {
            array[a] = array [a-1];
        }
        array[i] = el;
    }

    @Override
    public void remove(int i) {

        for (int a = i; a<array.length-1; a++) {
            array[a] = array[a+1];
        }
        array[size] = null;

    }

    @Override
    public E get(int i) {

        if (i>=size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return array[i];
    }

    @Override
    public int size() {
        return size;
    }

    private E [] createEmptyArray(E ... args) {
        return args;
    }

    private E [] createArray (int lenght) {
        Class <?> componentType = createEmptyArray().getClass().getComponentType();
        return (E[]) Array.newInstance(componentType, lenght);
    }

    private void grow() {
        int newLength = (int)(array.length * 1.5);
        array = Arrays.copyOf(array, newLength);

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        MyList.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return MyList.super.spliterator();
    }

    private class MyListIterator implements Iterator<E>{
        private int cursor;
        @Override
        public boolean hasNext() {
            return cursor  < size;
        }

        @Override
        public E next() {
            return array[cursor++];
        }
    }
}
