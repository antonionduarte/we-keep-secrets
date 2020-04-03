public class IteratorClass implements Iterator {

    Object vector[];
    int counter;
    int current;

    public IteratorClass(Object[] vector, int counter) {
        this.vector = vector;
        this.counter = counter;
        this.current = current;
    }

    public boolean hasNext() {
        return current != counter;
    }

    public Object next() {
        return vector[current++];
    }
}
