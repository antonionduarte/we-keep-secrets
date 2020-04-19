package documents;

import users.*;
import iterators.*;
import actions.Action;

public interface ClassifiedDocument extends Document {

    /**
     * Grants a User access to a Document.
     * @param relatedUser user to grant access to the document.
     */
    void grant(User relatedUser);

    /**
     * Revoked access to a Document from a User.
     * @param relatedUser user to revoke access from the document.
     */
    void revoke(User relatedUser);

    /**
     * Checks if the specified User has an active grant to the Document.
     * @param user to check.
     * @return true if the user has an active grant to the document.
     */
    boolean hasGrant(User user);

    /**
     * Returns the amount of times a document has been granted.
     * @return the grantCount of the document.
     */
    int getGrantCount();

    /**
     * Returns the amount of times a document has been revoked.
     * @return the revokeCount of the document.
     */
    int getRevokeCount();

    /**
     * Returns grants and revokes action iterator
     *
     * @return     An iterator object
     */
    Iterator<Action> documentGrantsRevokesIterator();
}