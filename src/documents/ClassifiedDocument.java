package documents;

import users.*;
import clearance.*;

public interface ClassifiedDocument extends Document {
    
    // TODO: Refactor how grant system works.

    // /**
    //  * Grants a user access to a document above their access level.
    //  * (Adds the User to the array <code>grants</code>).
    //  * PRE: user != NULL
    //  * @param user to grant access to the document.
    //  */
    // void grant(String userKind, String userID, Clearance clearance);

    // /**
    //  * Revokes a user permission to access a Document.
    //  * PRE: user != NULL
    //  * @param user to revoke permission from.
    //  */
    // void revoke(String userKind, String userID, Clearance clearance);

    // /**
    //  * Checks if the <code>user</code> has a grant to the document.
    //  * PRE: user != NULL
    //  * @param user to check for a grant.
    //  * @return true if the user is in the grants.
    //  */
    // boolean hasGrant(String userKind, String userID, Clearance clearance);

}