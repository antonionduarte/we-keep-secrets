package iterators;

/**
 * This interface describes an iterator.
 * @author Antonio Duarte 58278
 * @author Luis Tripa 57882
 */
public interface Iterator<E> {

    /**
     * Verifies if there is a next element in the array.
     * @return true if there is a next element in the array, false if otherwise.
     */
    boolean hasNext();

    /**
     * Returns the current element in the array and moves the counter forward.
     * @return the current element in the array.
     * PRE: hasNext()
     */
    E next();

    /**
     * Returns the amount of items in the iterator's array.
     * @return the number of items in the iterator's array.
     */
    int itemCount();

    /**
     * Goes to the end of the iterator array
     */
    void goToEnd();

    /**
     * Gets the item in the previous position relative to <code>current</code>
     * @return     The previous element relative to current
     * PRE: hasPrevious()
     */
    E previous();

    /**
     * Verifies if there is a previous element in the array
     * @return     True if previous, False otherwise.
     */
    boolean hasPrevious();
}
