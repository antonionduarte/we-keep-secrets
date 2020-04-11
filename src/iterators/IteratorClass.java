package iterators;

public class IteratorClass<E> implements Iterator<E> {

    private E[] vector[];
    private int counter;
    private int current;

    public IteratorClass(E[] vector, int counter) {
        this.vector = vector;
        this.counter = counter;
        this.current = 0;
    }

    public boolean hasNext() {
        return current != counter;
    }

    public E next() {
        return vector[current++];
    }
}
