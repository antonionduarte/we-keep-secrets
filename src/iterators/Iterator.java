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

    /**
     * Returns the amount of items in the iterator's array.
     * @return the number of items in the iterator's array.
     */
    int itemCount();

    E nextBackwards();

    boolean hasNextBackwards();
}
