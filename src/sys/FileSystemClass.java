package sys;

import users.*;
import iterators.*;
import clearance.*;

public class FileSystemClass implements FileSystem {
    
    UserCollection userCollection;

    public FileSystemClass() {
        userCollection = new UserCollectionClass();
    }

    @Override
    public void register(String userKind, String userID, Clearance clearance) {
        User user;
        if (clearance == Clearance.CLERK)
            user = new ClerkClass(userKind, userID, Clearance.CLERK);
        else
            user = new OfficerClass(userKind, userID, clearance);
    	userCollection.addUser(user);
    }

    @Override
    public Iterator<User> listUsers() {
    	return userCollection.userIterator();
    }

    @Override
    public void upload(String documentID, String description, String managerID, Clearance clearance) {
    	userCollection.upload(documentID, description, managerID, clearance);
    }

    @Override
    public void write(String documentID, String managerID, String userID, String description) {
        userCollection.write(managerID, userID, documentID, description);
    }

    @Override
    public void read(String managerID, String userID, String documentID) {
        userCollection.read(managerID, userID, documentID);
    }

    @Override
    public boolean hasUser(String userID) {
    	return userCollection.hasUser(userID);
    }

    @Override
    public boolean userHasDocument(String userID, String documentID) {
    	return userCollection.userHasDocument(userID, documentID);
    }

    @Override
 	public boolean hasGrant(String managerID, String userID, String documentID) {
 		return userCollection.userHasGrant(managerID, documentID, userID);
 	}

    @Override
 	public boolean isOfficial(String managerID, String documentID) {
 		return userCollection.getDocumentClearance(managerID, documentID) == Clearance.CLERK;
 	}

    @Override
    public Clearance getUserClearance(String userID) {
    	return userCollection.getUserClearance(userID);
    }

    @Override
    public Clearance getDocumentClearance(String managerID, String documentID) {
    	return userCollection.getDocumentClearance(managerID, documentID);
    }
}