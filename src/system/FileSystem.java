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
	 * TODO: Can't this be made a method call?
	 */
	Iterator<User> listUsers();

	/**
	 * Uploads a new document into the system with <code>clearance</code> and <code>description</code>.
	 * @param documentID the ID of the document.
	 * @param userID the ID of the document.
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
	 * @param userID of the User whose clerance we want to get.
	 * @return the Clearance of the User.
	 */
	Clearance getUserClearance(String userID);

	/**
	 * Returns the clearance of a specific document.
	 * @param documentID of the Document whose clearance we want to get.
	 * @return the Clearance of the Document.
	 */
	Clearance getDocumentClearance(String managerID, String documentID);
}
