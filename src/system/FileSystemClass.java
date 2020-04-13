package system;

import documents.*;
import users.*;
import iterators.*;
import clearance.*;
import actions.*;

public class FileSystemClass implements FileSystem {

    DocumentCollection documentCollection;
    UserCollection userCollection;

    public FileSystemClass() {
        documentCollection = new DocumentCollectionClass();
        userCollection = new UserCollectionClass();
    }

    @Override
    public void register(String userKind, String userID, Clearance clearance) {
        User user;
        if (clearance == Clearance.CLERK)
            user = new ClerkClass(userKind, userID, clearance);
        else
            user = new OfficerClass(userKind, userID, clearance);
    	userCollection.addUser(user);
    }

    @Override
    public Iterator listUsers() {
    	return userCollection.userIterator();
    }

    @Override
    public void upload(String docID, String userID, Clearance clearance, String description) {
    	User user = userCollection.getUserObject(userID);
        Document doc;
        if (clearance == Clearance.CLERK)
            doc = new OfficialDocumentClass(docID, description, user, clearance);
        else
            doc = new ClassifiedDocumentClass(docID, description, user, clearance);
    	documentCollection.addDocument(doc);
    }

    @Override
    public void write(String docID, String managerID, String userID, String description) {
    	Document doc = documentCollection.getDocumentObject(docID);
    	doc.setDescription(description);
    	// TODO: Document has to log the operation
    }

    @Override
    public boolean hasUser(String userID) {
    	return userCollection.hasUser(userID);
    }

    @Override
    public boolean userHasDocument(String userID, String docID) {
    	User user = userCollection.getUserObject(userID);
    	return user.hasDocument(docID);
    }

    @Override
 	public boolean hasGrant(String userID, String docID) {
 		Document doc = documentCollection.getDocumentObject(docID);
 		return doc.hasGrant(userID);
 	}

    @Override
 	public boolean isOfficial(String docID) {
 		return documentCollection.getDocumentObject(docID).getClearance() == Clearance.CLERK;
 	}

    @Override
    public Clearance getUserClearance(String userID) {
    	return userCollection.getUserObject(userID).getClearance();
    }

    @Override
    public Clearance getDocumentClearance(String docID) {
    	return documentCollection.getDocumentObject(docID).getClearance();
    }
}
