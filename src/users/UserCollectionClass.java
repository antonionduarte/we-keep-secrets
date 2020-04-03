package users;

import iterators.*;

public class UserCollectionClass implements UserCollectionClass {

    // Generic Constants
    private static final int DEFAULT_VECTOR_SIZE = 50;
    private static final int GROWTH_FACTOR = 2;

    // Instance variables
    User users;
    int userCounter;

    /**
     * The UserCollectionClass constructor
     */
    public UserCollectionClass() {
        users = new User[DEFAULT_VECTOR_SIZE];
        userCounter = 0;
    }
}
