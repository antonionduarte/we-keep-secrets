package users;

import documents.*;
import iterators.*;

public class UserCollectionClass implements UserCollection {

    // Generic Constants
    private static final int DEFAULT_VECTOR_SIZE = 100;
    private static final int GROWTH_FACTOR = 2;

    // Instance variables
    private User[] users;
    private int userCounter;

    /**
     * The UserCollectionClass constructor
     */
    public UserCollectionClass() {
        users = new User[DEFAULT_VECTOR_SIZE];
        userCounter = 0;
    }

    /**
     * Adds an user to the collection.
     *
     * @param user  The user object
     */
    public void addUser(User user) {
        users[userCounter++] = user;
    }

    @Override
    public void removeUser(User user) {
        int index = searchIndexOf(user.getID());
        for (int i = index + 1; i <= userCounter - 1; i++)
            users[index++] = users[i++];
    }

    /**
     * Gets the user object from the collection
     *
     * @param      userID  The user id
     *
     * @return     The user object.
     */
    public User getUserObject(String userID) {
        return users[searchIndexOf(userID)];
    }

    /**
     * Determines if colelction has user.
     *
     * @param      userID  The user id
     *
     * @return     True if user, False otherwise.
     */
    public boolean hasUser(String userID) {
        return searchIndexOf(userID) != -1;
    }

    /**
     * Sets up the user iterator
     *
     * @return     An iterator object
     */
    public Iterator userIterator() {
        return new IteratorClass(users, userCounter);
    }


    /* Private Methods */


    /**
     * Searches for the index of user in the array
     *
     * @param      userID  The user id
     *
     * @return     The user's object position in the array
     */
    private int searchIndexOf(String userID) {
        int pos = -1;
        for (int i = 0; i < userCounter && pos == -1; i++) {
            if (users[i].getID().equals(userID))
                pos = i;
        }
        return pos;
    }

    /**
     * Determines if array is full.
     *
     * @return     True if full, False otherwise.
     */
    private boolean isFull() {
        return userCounter == users.length;
    }

    /**
     * Resizes the array. The new array will always have two times the length of the previous array.
     */
    private void resize() {
        User[] temp = new User[users.length * GROWTH_FACTOR];
        for (int i = 0; i < userCounter; i++) {
            users[i] = temp[i];
        }
        users = temp;
    }


}
