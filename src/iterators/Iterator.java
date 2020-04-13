package iterators;

public interface Iterator<E> {

    /**
     * Verifies if there is a next element in the array.
     * @return true if there is a next element in the array, false if otherwise.
     */
    boolean hasNext();

    /**
     * Returns the current element in the array and moves the counter forward.
     * @return the current element in the array.
     */
    E next();
}
