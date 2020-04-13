package documents;

import users.*;

public interface ClassifiedDocument extends Document {
    
    /**
     * Grants a user access to a document above their access level.
     * (Adds the User to the array <code>grants</code>).
     * PRE: user != NULL
     * @param user to grant access to the document.
     */
    void grant(User user);

    boolean hasGrant(User user);

}