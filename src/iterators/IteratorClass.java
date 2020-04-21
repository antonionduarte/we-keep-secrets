package iterators;

public class IteratorClass<E> implements Iterator<E> {

    private E[] vector;
    private int counter;
    private int current;

    public IteratorClass(E[] vector, int counter) {
        this.vector = vector;
        this.counter = counter;
        this.current = 0;
    }

    @Override
    public boolean hasNext() {
        return current != counter;
    }

    @Override
    public E next() {
        return vector[current++];
    }

    @Override
    public int itemCount() {
        return counter;
    }

    @Override
    public void goToEnd() {
        current = counter-1;
    }

    @Override
    public E previous() {
        return vector[current--];
    }

    @Override
    public boolean hasPrevious() {
        return current != -1;
    }
}
