package sys;

import users.*;
import documents.Document;
import iterators.*;
import clearance.*;

public interface FileSystem {

	/**
	 * Registers a new user into the system.
	 * @param userKind the type of the user (Officer or Clerk).
	 * @param userID the ID of the user.
	 * @param clearance the clearance level of the user.
	 */
	void register(String userKind, String userID, Clearance clearance);
	
	/**
	 * Returns an iterator to list the users.
	 * @return an Iterator that lists the users.
	 */
	Iterator<User> listUsers();

	/**
	 * Uploads a new document into the system with <code>clearance</code> and <code>description</code>.
	 * @param documentID the ID of the document.
	 * @param managerID the ID of the document's manager.
	 * @param clearance the clearance of the document.
	 * @param description the description of the document.
	 */
	void upload(String documentID, String description, String managerID, Clearance clearance);

	/**
	 * Writes a new <code>description</code> into a specified document. The new description will be written by a specific 
	 * User with the given <code>userID</code>.
	 * @param documentID the ID of the document.
	 * @param managerID the ID of the manager.
	 * @param userID the ID of the user.
	 * @param description the description of the document.
	 */
	void write(String documentID, String managerID, String userID, String description);

	/**
	 * Reads from a document and register the action.
	 * @param managerID ID of the manager of the document to read from.
	 * @param userID ID of the user that reads from the document.
	 * @param documentID of the document to read from.
	 */
	void read(String managerID, String userID, String documentID);

	/**
	 * Creates iterator for user documents
	 *
	 * @param      userID  The user id
	 *
	 * @return     An interator object
	 */
	Iterator<Document> userDocs(String userID);

	/**
	 * Checks if a user with the given <code>userID</code> is in the system.
	 * @param userID the ID of the User.
	 * @return true if the User is in the system, false if otherwise.
	 */
	boolean hasUser(String userID);

	/**
	 * Checks if a user is the owner of a document.
	 * @param userID of the User to check.
	 * @param documentID of the Document to check.
	 * @return true if the User if the manager of a document, false if otherwise.
	 */
	boolean userHasDocument(String userID, String documentID);

	/**
	 * Checks if a user has a grant to access a specific document.
	 * @param userID of the User to check.
	 * @param documentID of the Document to check.
	 * @return true if the User has a grant, false if otherwise.
	 */
	boolean hasGrant(String managerID, String userID, String documentID);

	/**
	 * Checks if a given document is an official document.
	 * @param documentID of the Document to check.
	 * @return true if the Document is Official, false if it's Classified.
	 */
	boolean isOfficial(String managerID, String documentID);

	/**
	 * Returns the clearance of a specific user.
	 * @param userID of the User whose clearance we want to get.
	 * @return the Clearance of the User.
	 */
	Clearance getUserClearance(String userID);

	/**
	 * Returns the clearance of a specific document.
	 * @param documentID of the Document whose clearance we want to get.
	 * @return the Clearance of the Document.
	 */
	Clearance getDocumentClearance(String managerID, String documentID);

	/**
	 * Grants a user access to a document.
	 * @param userID ID of the user that the access will be granted to.
	 * @param documentID ID of the document that the user will have access to.
	 */
	void grant(String userID, String documentID);

	/**
	 * Revokes a user access to a document.
	 * @param userID ID of the user to revoke access from a document.
	 * @param documentID ID of the document that the user will lose access from.
	 */
	void revoke(String userID, String documentID);

	/**
	 * Returns an Iterator of the documents that were leaked most times.
	 * @return Iterator of documents to the ones that were leaked the most times.
	 */
	Iterator<Document> topLeaked();

	/**
	 * Returns an Iterator of the Users that granted access to documents the most times.
	 * @return Iterator of users to the ones that granted others access to documents the most times.
	 */
	Iterator<User> topGranters();
}
