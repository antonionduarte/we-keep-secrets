package documents;

import users.*;

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
}