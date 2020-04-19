package users;

import documents.*;

public interface Officer extends User {

	/**
     * Writes to a document.
     * @param writer user that writes in the specific document.
     * @param document the document to write on.
     * @param description to write on the document.
     */
    void write(ClassifiedDocument document, User writer, String description);

	/**
	 * Grants a user access to a document.
	 * @param documentID ID of the document to grant access to.
	 * @param user who we the grant is gonna be given to.
	 */
	void grant(String documentID, User user);

	/**
	 * Revokes a grant from a user.
	 * @param documentID ID of the document to revoke access from.
	 * @param user to revoke the grant of.
	 */
	void revoke(String documentID, User user);

	/**
	 * Returns the grant count of the Officer.
	 * @return amount of times the officer has given someone a grant.
	 */
	int getGrantCount();
}
