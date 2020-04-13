package system;

import documents.*;
import users.*;
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
	Iterator listUsers();

	/**
	 * Uploads a new document into the system with <code>clearance</code> and <code>description</code>.
	 * @param docID the ID of the document.
	 * @param userID the ID of the document.
	 * @param clearance the clearance of the document.
	 * @param description the description of the document.
	 */
	void upload(String docID, String userID, Clearance clearance, String description);

	/**
	 * Writes a new <code>description</code> into a specified document. The new description will be written by a specific 
	 * User with the given <code>userID</code>.
	 * @param docID the ID of the document.
	 * @param managerID the ID of the manager.
	 * @param userID the ID of the user.
	 * @param description the description of the document.
	 */
	void write(String docID, String managerID, String userID, String description);

	/**
	 * Checks if a user with the given <code>userID</code> is in the system.
	 * @param userID the ID of the User.
	 * @return true if the User is in the system, false if otherwise.
	 */
	boolean hasUser(String userID);

	/**
	 * Checks if a user is the owner of a document.
	 * @param userID of the User to check.
	 * @param docID of the Document to check.
	 * @return true if the User if the manager of a document, false if otherwise.
	 */
	boolean userHasDocument(String userID, String docID);

	/**
	 * Checks if a user has a grant to access a specific document.
	 * @param userID of the User to check.
	 * @param docID of the Document to check.
	 * @return true if the User has a grant, false if otherwise.
	 */
	boolean hasGrant(String userID, String docID);

	/**
	 * Checks if a given document is an official document.
	 * @param docID of the Document to check.
	 * @return true if the Document is Official, false if it's Classified.
	 */
	boolean isOfficial(String docID);

	/**
	 * Returns the clearance of a specific user.
	 * @param userID of the User whose clerance we want to get.
	 * @return the Clearance of the User.
	 */
	Clearance getUserClearance(String userID);

	/**
	 * Returns the clearance of a specific document.
	 * @param docID of the Document whose clearance we want to get.
	 * @return the Clearance of the Document.
	 */
	Clearance getDocumentClearance(String docID);
}
