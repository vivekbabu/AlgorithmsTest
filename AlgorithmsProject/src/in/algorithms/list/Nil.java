package in.algorithms.list;

import java.util.NoSuchElementException;

public class Nil<T> implements List<T> {
    @Override public boolean isEmpty() { return true; }
    @Override public T head() { throw new NoSuchElementException("Nil.head"); }
    @Override public List<T> tail() { throw new NoSuchElementException("Nil.tail"); }
}
