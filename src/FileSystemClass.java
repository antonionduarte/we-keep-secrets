import documents.*;
import users.*;
import iterators.*;
import clearance.*;

public class FileSystemClass implements FileSystem {

    User managerLol;

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
    	User user = new User(userKind, userID, clearance);
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
    	Document doc = new Document(docID, description, user, clearance);
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
    	doc.write(description)
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
    public boolean userHasDocument(String userId, String docID) {
    	User user = userCollection.getUserObject(String userID);
    	return user.hasDocument(docID);
    }

    /**
     * Determines if user has clearance.
     *
     * @param      userID  The user id
     * @param      docID   The document id
     *
     * @return     True if has clearance, False otherwise.
     */
 	public boolean hasClearance(String userID, String docID) {
 		User user = us.getUserObject(userID);
 		Document doc = documentCollection.getDocumentObject(docID);
 		return user.getClearance().toInt() >= doc.getClearance().toInt()
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
 		return documentCollection.getDocumentObject(docID).getClearance().toInt() == Clerance.CLERK.toInt();
 	}

    /**
     * Gets the user clearance.
     *
     * @param      userID  The user id
     *
     * @return     The user clearance.
     */
    public Clearance getUserClearance(String userID) {
    	userCollection.getUserObject(userID).getClerance();
    }

    /**
     * Gets the document clearance.
     *
     * @param      documentID  The document id
     *
     * @return     The document clearance.
     */
    public Clearance getDocumentClearance(String documentID) {
    	documentCollection.getDocumentObject(documentID).getClerance();
    }
}
