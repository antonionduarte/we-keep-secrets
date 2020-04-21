package users;

import documents.*;

/**
 * This interface describes an officer.
 * @author Antonio Duarte 58278
 * @author Luis Tripa 57882
 */
public interface Officer extends User {

	/**
     * Writes to a document.
	 * Pre: writer != NULL && document != NULL && description != NULL
     * @param writer user that writes in the specific document.
     * @param document the document to write on.
     * @param description to write on the document.
     */
    void write(ClassifiedDocument document, User writer, String description);

	/**
	 * Grants a user access to a document.
	 * Pre: documentID != NULL && user != NULL
	 * @param documentID ID of the document to grant access to.
	 * @param user who we the grant is gonna be given to.
	 */
	void grant(String documentID, User user);

	/**
	 * Revokes a grant from a user.
	 * PRE: documentID != NULL && user != NULL
	 * @param documentID ID of the document to revoke access from.
	 * @param user to revoke the grant of.
	 */
	void revoke(String documentID, User user);

	/**
	 * Returns the grant count of the Officer.
	 * @return amount of times the officer has given someone a grant.
	 */
	int getGrantCount();

	/**
	 * Returns the amount of times the user has issued a revoke.
	 * @return the revokeCount of the user.
	 */
	int getRevokeCount();
	
	/**
	* Checks if user has grant for document with id <code>documentID</code>.
	* Pre: documentID != NULL && user != NULL
	* @param documentID the document id.
	* @param user the user.
	* @return true if has grant, false otherwise.
	*/
   boolean hasGrant(String documentID, User user);

   /**
	* Checks if the specified user is revoked from the document.
	* Pre: documentID != NULL && user != NULL
	* @param documentID the document ID.
	* @param user the user.
	* @return true if is revoked, false otherwise.
	*/
   boolean isRevoked(String documentID, User user);
}
