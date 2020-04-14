package users;

import iterators.*;
import clearance.Clearance;
import documents.Document;

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

    @Override
    public void addUser(String userKind, String userID, Clearance clearance) {
        if (isFull()) resize();
        if (clearance == Clearance.CLERK)
            users[userCounter++] = new ClerkClass(userKind, userID, Clearance.CLERK);
        else
            users[userCounter++] = new OfficerClass(userKind, userID, clearance);
    }

    @Override
    public void removeUser(User user) {
        int index = searchIndexOf(user.getID());
        for (int i = index + 1; i <= userCounter - 1; i++)
            users[index++] = users[i++];
    }

    @Override
    public boolean hasUser(String userID) {
        return searchIndexOf(userID) != -1;
    }

    @Override
    public Iterator<User> userIterator() {
        return new IteratorClass<User>(users, userCounter);
    }

    @Override
    public String getUserID(String userID) {
        return users[searchIndexOf(userID)].getID();
    }

    @Override
    public String getUserKind(String userID) {
        return users[searchIndexOf(userID)].getKind();
    }
    
    @Override
    public Clearance getUserClearance(String userID) {
        return users[searchIndexOf(userID)].getClearance();
    }

    @Override
    public boolean userHasDocument(String userID, String documentID) {
        return users[searchIndexOf(userID)].hasDocument(documentID);
    }

    @Override
    public void upload(String userID, String documentID, String description, Clearance clearance) {
        users[searchIndexOf(userID)].upload(documentID, description, clearance);
    }

    @Override
    public String read(String managerID, String documentID) {
        return users[searchIndexOf(managerID)].read(documentID);
    }

    @Override
    public Iterator<Document> userDocs(String userID) {
        return users[searchIndexOf(userID)].userDocs();
    }



    /* Private Methods */


    /**
     * Searches for the index of a user in the array.
     * @param userID  The ID of the User.
     * @return The user's object position in the array.
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
     * @return true if full, false if otherwise.
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
