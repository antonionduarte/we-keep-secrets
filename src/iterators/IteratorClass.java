package iterators;

public class IteratorClass<E> implements Iterator<E> {

    private E[] vector;
    private int counter;
    private int current;
    private int currentLast;

    public IteratorClass(E[] vector, int counter) {
        this.vector = vector;
        this.counter = counter;
        this.current = 0;
        this.currentLast = counter-1;
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
    public E nextBackwards() {
        return vector[currentLast--];
    }

    @Override
    public boolean hasNextBackwards() {
        return currentLast != 0;
    }
}
