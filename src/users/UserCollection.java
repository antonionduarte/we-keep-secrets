package users;

import iterators.*;
import clearance.Clearance;
import documents.Document;

public interface UserCollection {
	
	/**
	 * Removes a user from the array.
	 * @param user to remove from the array.
	 */
	void removeUser(User user);

	/**
	 * Adds a user to the collection.
	 * @param user to add to the collection.
	 */
	void addUser(User user);

	/**
	 * Checks if the user with the specified <code>userID</code> is in the collection.
	 * @param userID of the User whose existance in the collection we wish to verify.
	 * @return true if there is a User in the colection with the specified <code>userID</code>.
	 */
	boolean hasUser(String userID);

	/**
	 * Returns an iterator of Users.
	 * @return an Iterator of the Users in the Collection.
	 */
	Iterator<User> userIterator();

	/**
	 * Gets the user id as it is stored in the array.
	 *
	 * @param      userID  The user id
	 *
	 * @return     The user id stored in the array.
	 */
	String getUserID(String userID);

	/**
	 * Gets the user kind.
	 *
	 * @param      userID  The user id
	 *
	 * @return     The user kind.
	 */
    String getUserKind(String userID);

    /**
     * Gets the user clearance.
     *
     * @param      userID  The user id
     *
     * @return     The user clearance.
     */
    Clearance getUserClearance(String userID);

    /**
     * Gets the document clearance.
     *
     * @param      managerID   The manager id
     * @param      documentID  The document id
     *
     * @return     The document clearance.
     */
    Clearance getDocumentClearance(String managerID, String documentID);

    /**
     * Checks if user is the manager of a given document.
     *
     * @param      userID      The user id
     * @param      documentID  The document id
     *
     * @return     True if is manager, False otherwise
     */
    boolean userHasDocument(String userID, String documentID);

    /**
     * Uploads a document to the user's document collection. The user will become the manager of this document.
     *
     * @param      documentID   The document id
     * @param      description  The description
     * @param      managerID    The manager id
     * @param      clearance    The clearance
     */
    void upload(String documentID, String description, String managerID, Clearance clearance);

    /**
     * Reads the <code>description</code> of a document owned by a user
     *
     * @param      managerID   The manager id
     * @param      documentID  The document id
     *
     * @return     { description_of_the_return_value }
     */
    String read(String managerID, String documentID);

    /**
     * Generates a user's document iterator
     *
     * @param      userID  The user id
     *
     * @return     an iterator object
     */
    Iterator<Document> userDocs(String userID);

    /**
     * Writes <code>description</code> to a specific document
     *
     * @param      managerID   The manager id
     * @param      userID      The user id requesting the write
     * @param      documentID  The document id
     * @param      decription  The new decription
     */
    void write(String managerID, String userID, String documentID, String decription);

    Iterator topleaked();

    Iterator topgranters();

    void insertSort(User user);

    void trim(int trimSize);

}
