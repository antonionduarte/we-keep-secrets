package users;

import documents.*;

public interface Officer extends User {

	/**
	 * Writes a message to a Document.
	 * @param document to write to.
	 * @param message to write in the Document.
	 */
	void write(Document document, String message);

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

