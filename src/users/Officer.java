package users;

import documents.*;

public interface Officer extends User {

	/**
     * Writes to a document.
     * @param relatedUser user that writes in the specific document.
     * @param documentID ID of the document to write on.
     * @param description to write on the document.
     */
    void write(User relatedUser, String documentID, String description);

	/**
	 * Grants a user access to a document.
	 * @param document to grant access to.
	 * @param user who we the grant is gonna be given to.
	 */
	void grant(ClassifiedDocument document, User user);

	/**
	 * Revokes a grant from a user.
	 * @param document that has the grant to revoke.
	 * @param user to revoke the grant of.
	 */
	void revoke(ClassifiedDocument document, User user);
}
