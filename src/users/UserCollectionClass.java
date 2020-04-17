package users;

import iterators.*;
import clearance.Clearance;
import documents.*;

public class UserCollectionClass implements UserCollection {

    // Generic Constants
    private static final int DEFAULT_VECTOR_SIZE            = 100;
    private static final int GROWTH_FACTOR                  = 2;
    private static final int TOP_LEAKED_MAX_ITERATOR_SIZE   = 10;
    private static final int TOP_GRANTERS_MAX_ITERATOR_SIZE = 10;

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
    public void addUser(User user) {
        if (isFull()) resize();
        users[userCounter++] = user;
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
    public Clearance getDocumentClearance(String managerID, String documentID) {
        return users[searchIndexOf(managerID)].getDocumentClearance(documentID);
    }

    @Override
    public boolean userHasDocument(String userID, String documentID) {
        return users[searchIndexOf(userID)].hasDocument(documentID);
    }

    @Override
    public boolean userHasGrant(String managerID, String documentID, String userID) {
        return users[searchIndexOf(managerID)].hasGrant(documentID, getUser(userID));
    }

    @Override
    public void upload(String documentID, String description, String managerID, Clearance clearance) {
        Document document;
        User user = users[searchIndexOf(managerID)];
        if (clearance == Clearance.CLERK)
            document = new OfficialDocumentClass(documentID, description, clearance);
        else
            document = new ClassifiedDocumentClass(documentID, description, clearance);
        user.upload(document);
    }    
    
    @Override
    public String read(String managerID, String userID, String documentID) {
        return users[searchIndexOf(managerID)].read(documentID, getUser(userID));
    }

    @Override
    public void write(String managerID, String userID, String documentID, String description) {
        Officer user = (Officer) users[searchIndexOf(managerID)];
        ClassifiedDocument document = (ClassifiedDocument) user.getDocument(documentID);
        user.write(document ,getUser(userID), description);
    }

    @Override
    public Iterator<Document> userDocs(String userID) {
        return users[searchIndexOf(userID)].userDocs();
    }

    @Override
    public Iterator<Document> topLeaked() {
        DocumentCollection topLeaked = new DocumentCollectionClass();
        for (int i = 0; i < userCounter; i++) {
            Iterator<Document> iter = users[i].userDocs();
            while (iter.hasNext())
                topLeaked.addDocument((Document) iter.next());
        }
        topLeaked.bubbleSort(); // Sort by number of grants and alphabetically if tie
        topLeaked.trim(TOP_LEAKED_MAX_ITERATOR_SIZE);
        return topLeaked.documentIterator();
    }

    @Override
    public Iterator<User> topGranters() {
        UserCollection topGranters;
        int grantCount;
        topGranters = new UserCollectionClass();
        for (int i = 0; i < userCounter; i++)
            topGranters.insertSort(users[i]);
        topGranters.trim(TOP_GRANTERS_MAX_ITERATOR_SIZE);
        return topGranters.userIterator();
    }

    @Override
    public void insertSort(User user) {
        if (isFull())
            resize();
        for (int i=userCounter-1 ; i>0 ; i--) {
            if (users[i].getGrantCount() > user.getGrantCount())
                users[i+1] = user;
            else if (users[i].getGrantCount() < user.getGrantCount())
                users[i+1] = users[i];
            else {
                if (users[i].idGreaterThan(user.getID()))
                    users[i+1] = user;
                else
                    users[i+1] = users[i];
            }
        }
        userCounter++;
    }

    @Override
    public void trim(int trimSize) {
        User[] aux = new User[trimSize];
        for (int i=0 ; i<trimSize ; i++)
            aux[i] = users[i];
        users = aux;
        userCounter = trimSize;
    }

    @Override
    public User getUser(String userID) {
        return users[searchIndexOf(userID)];
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
     * Resize the array. The new array will always have two times the length of the previous array.
     */
    private void resize() {
        User[] temp = new User[users.length * GROWTH_FACTOR];
        for (int i = 0; i < userCounter; i++)
            users[i] = temp[i];
        users = temp;
    }
}
