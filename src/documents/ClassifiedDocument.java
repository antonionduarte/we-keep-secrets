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
}