package users;

import documents.*;
import iterators.*;

public class UserCollectionClass implements UserCollection {

    // Generic Constants
    private static final int DEFAULT_VECTOR_SIZE = 100;
    private static final int GROWTH_FACTOR = 2;

    // Instance variables
    User[] users;
    int userCounter;

    /**
     * The UserCollectionClass constructor
     */
    public UserCollectionClass() {
        users = new User[DEFAULT_VECTOR_SIZE];
        userCounter = 0;
    }

    public void addUser(User user) {
        users[userCounter++] = user;
    }

    public User getUserObject(String userID) {
        return users[searchIndexOf(userID)];
    }

    public void upload(User user, Document document) {
        user.upload(document);
    }
    
    public boolean hasUser(String userID) {
        return searchIndexOf(user) != -1;
    }

    private int searchIndexOf(String userID) {
        int pos = -1;
        for (int i=0 ; i<userCounter&&pos==-1 ; i++) {
            if (users[i].getID().equals(userID))
                pos = i;
        }
        return pos;
    }

    private boolean isFull() {
        return userCounter == users.length;
    }

    private void resize() {
        User temp = new User[users.length * GROWTH_FACTOR];
        for (int i=0 ; i<userCounter ; i++) {
            users[i] = temp[i];
        }
        users = temp;
    }



    /* Private Methods */

}
