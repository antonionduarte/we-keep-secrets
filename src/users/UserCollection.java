package users;

import iterators.*;
import clearance.Clearance;
import documents.Document;

/**
 * This inteface describes a user collection
 * @author Antonio Duarte 58278
 * @author Luis Tripa 57882
 */
public interface UserCollection {

	/**
	 * Adds a user to the collection.
     * Pre: user != NULL
	 * @param user to add to the collection.
	 */
	void addUser(User user);

	/**
	 * Checks if the user with the specified <code>userID</code> is in the collection.
     * Pre: userID != NULL
	 * @param userID of the User whose existence in the collection we wish to verify.
	 * @return true if there is a User in the collection with the specified <code>userID</code>.
	 */
	boolean hasUser(String userID);

	/**
	 * Returns an iterator of Users.
	 * @return an Iterator of the Users in the Collection.
	 */
	Iterator<User> userIterator();

    /**
     * Gets the user clearance.
     * Pre: userID != NULL
     * @param userID the user id.
     * @return the user clearance.
     */
    Clearance getUserClearance(String userID);

    /**
     * Gets the document clearance.
     * Pre: managerID != NULL && documentID != NULL
     * @param managerID the manager id.
     * @param documentID the document id.
     * @return the document clearance.
     */
    Clearance getDocumentClearance(String managerID, String documentID);

    /**
     * Checks if user is the manager of a given document.
     * Pre: userID != NULL && documentID != NULL
     * @param userID the user id.
     * @param documentID the document id.
     * @return true if is manager, false otherwise.
     */
    boolean userHasDocument(String userID, String documentID);

    /**
     * Checks if user with <code>userID</code> has a grant for the document with <code>documentID</code>.
     * Pre: managerID != NULL && documentID != NULL && userID != NULL
     * @param managerID the id of the manager.
     * @param documentID the id of the document.
     * @param userID the id of the user.
     * @return true if has grant, false otherwise.
     */
    boolean userHasGrant(String managerID, String documentID, String userID);

    /**
     * Checks if a specific user has been revoked from a document.
     * Pre: managerID != NULL && documentID != NULL && userID != NULL
     * @param managerID the user ID of the manager.
     * @param documentID the document ID.
     * @param userID the user ID of the user to be checked.
     * @return true if the user has been revoked from a document, false if otherwise.
     */
    boolean userIsRevoked(String managerID, String documentID, String userID);

    /**
     * Uploads a document to the user's document collection. The user will become the manager of this document.
     * Pre: managerID != NULL && documentID != NULL && description != NULL && clearance != NULL
     * @param managerID the user id.
     * @param documentID the document id.
     * @param description the document's description.
     * @param clearance the document's clearance.
     */
    void upload(String documentID, String managerID, String description, Clearance clearance);

    /**
     * Reads from a document.
     * PRE: managerID != NULL && userID != NULL && documentID != NULL
     * @param managerID ID of the Document manager.
     * @param userID ID of the user reading from the document.
     * @param documentID ID of the document that the user reads from.
     * @return the description of the document with the given documentID.
     */
    String read(String managerID, String userID, String documentID);

    /**
     * Writes <code>description</code> to document with id <code>documentID</code>.
     * Pre: userID != NULL && documentID != NULL && description != NULL
     * @param userID the id of the user.
     * @param documentID the id of the document.
     * @param description the new description to write on the document.
     */
    void write(String managerID, String userID, String documentID, String description);

    /**
     * Generates a user's document iterator.
     * Pre: userID != NULL && clearance != NULL
     * @param userID the user id.
     * @param clearance the clearance of the user.
     * @return an iterator object.
     */
    Iterator<Document> userDocs(String userID, Clearance clearance);

    /**
     * Returns an Iterator that iterates through the documents with most grants.
     * @return Iterator of the documents with more grants.
     */
    Iterator<Document> topLeaked();

    /**
     * Returns an Iterator with the users that granted more times.
     * @return iterator with the users that granted more times.
     */
    Iterator<User> topGranters();

    /**
     * Inserts a User in the collection.
     * Pre: user != NULL
     * @param user to insert.
     */
    void insertSort(User user);

    /**
     * Trims the user collection to a specific size.
     * Pre: trimSize != NULL
     * @param trimSize size to trim the collection to.
     */
    void trim(int trimSize);

    /**
     * Returns a user with the given userID.
     * Pre: userID != NULL
     * @param userID of the user to return.
     * @return user with the given <code>userID</code>.
     */
    User getUser(String userID);

    /**
     * Grants a user access to a document.
     * Pre: userID != NULL && documentID != NULL && managerID != NULL
     * @param userID ID of the user to grant access to.
     * @param documentID ID of the document.
     * @param managerID ID of the document's manager.
     */
    void grant(String userID, String documentID, String managerID);

    /**
     * Revokes a user access from a document.
     * Pre: userID != NULL && documentID != NULL && managerID != NULL
     * @param userID ID of the user to revoke access from.
     * @param documentID ID of the document to revoke access from.
     * @param managerID ID of the document's manager.
     */
    void revoke(String userID, String documentID, String managerID);
}
