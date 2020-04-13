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

    /**
     * Registers a user in the database
     *
     * @param      userKind   The user kind
     * @param      userID     The user id
     * @param      clearance  The clearance
     */
    public void register(String userKind, String userID, Clearance clearance) {
        User user;
        if (clearance == Clearance.CLERK)
            user = new ClerkClass(userKind, userID, clearance);
        else
            user = new OfficerClass(userKind, userID, clearance);
    	userCollection.addUser(user);
    }

    /**
     * Initiates an user iterator
     *
     * @return     Iterator object
     */
    public Iterator listUsers() {
    	return userCollection.userIterator();
    }

    /**
     * Uploads a document with <code>clerance</code> and <code>description</code>.
     *
     * @param      docID        The document id
     * @param      userID       The user id
     * @param      clearance    The clearance
     * @param      description  The description
     */
    public void upload(String docID, String userID, Clearance clearance, String description) {
    	User user = userCollection.getUserObject(userID);
        Document doc;
        if (clearance == Clearance.CLERK)
            doc = new OfficialDocumentClass(docID, description, user, clearance);
        else
            doc = new ClassifiedDocumentClass(docID, description, user, clearance);
    	documentCollection.addDocument(doc);
    }

    /**
     * Writes <code>description</code> to a specific document. The <code>userID</code> must point to a user with privelleges equal or higher than the document.
     *
     * @param      docID        The document id
     * @param      managerID    The manager id
     * @param      userID       The user id
     * @param      description  The description
     */
    public void write(String docID, String managerID, String userID, String description) {
    	Document doc = documentCollection.getDocumentObject(docID);
    	doc.setDescription(description);
    	// TODO: Document has to log the operation
    }

    /**
     * Determines if user exists.
     *
     * @param      userID  The user id
     *
     * @return     True if user exists, False otherwise.
     */
    public boolean userExists(String userID) {
    	userCollection.hasUser(userID);
    }

    /**
     * Determines if user is owner of document
     *
     * @param      userId  The user identifier
     * @param      docID   The document id
     *
     * @return     True if user has document, False otherwise
     */
    public boolean userHasDocument(String userID, String docID) {
    	User user = userCollection.getUserObject(userID);
    	return user.hasDocument(docID);
    }

    /**
     * Determines if user has a grant to a specific document.
     *
     * @param      userID  The user id
     * @param      docID   The document id
     *
     * @return     True if has grant, False otherwise.
     */
 	public boolean hasGrant(String userID, String docID) {
 		Document doc = documentCollection.getDocumentObject(docID);
 		return doc.hasGrant(userID);
 	}

    /**
     * Determines whether the specified document is official.
     *
     * @param      docID  The document id
     *
     * @return     True if the specified document is official, False otherwise.
     */
 	public boolean isOfficial(String docID) {
 		return documentCollection.getDocumentObject(docID).getClearance() == Clearance.CLERK;
 	}

    /**
     * Gets the user clearance.
     *
     * @param      userID  The user id
     *
     * @return     The user clearance.
     */
    public Clearance getUserClearance(String userID) {
    	return userCollection.getUserObject(userID).getClearance();
    }

    /**
     * Gets the document clearance.
     *
     * @param      docID  The document id
     *
     * @return     The document clearance.
     */
    public Clearance getDocumentClearance(String docID) {
    	documentCollection.getDocumentObject(docID).getClearance();
    }
}
