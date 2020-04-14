package system;

import documents.*;
import users.*;
import iterators.*;
import clearance.*;
import actions.*;

public class FileSystemClass implements FileSystem {
    
    UserCollection userCollection;

    public FileSystemClass() {
        userCollection = new UserCollectionClass();
    }

    @Override
    public void register(String userKind, String userID, Clearance clearance) {
    	userCollection.addUser(userKind, userID, clearance);
    }

    @Override
    public Iterator<User> listUsers() {
    	return userCollection.userIterator();
    }

    @Override
    public void upload(String documentID, String userID, Clearance clearance, String description) {
    	userCollection.upload(userID, documentID, description, clearance);
    }

    @Override
    public void write(String documentID, String managerID, String userID, String description) {
        userCollection.write(managerID, userID, documentID, description); // TODO implement this is usercollection
    	// TODO: Document has to log the operation
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
 	public boolean hasGrant(String userID, String documentID) {
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
