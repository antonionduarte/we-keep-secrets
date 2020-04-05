package users;

import iterators.*;
import documents.*;

public class OfficerClass extends UserAbstractClass {

    private int grantCount;

    public OfficerClass(String userKind, String userID, int clearance) {
        super(userKind, userID, clearance);

        grantCount = 0;
    }

    /**
     * Writes a message to a classified document
     *
     * @param      document  The document object
     * @param      message   The message
     */
    public void write(Document document, String message) {
    	document.write(message);
    }

    /**
     * Grants a user access to a document
     *
     * @param      document  The document
     * @param      user      The user
     */
    public void grant(Document document, User user) {
    	document.grant(user);
        grantCount++;
    }

    /**
     * Revokes a user access to a document
     *
     * @param      document  The document
     * @param      user      The user
     */
    public void revoke(Document document, User user) {
    	document.revoke(user);
    }

    /**
     * Gets the ammount of grants a user as issued.
     *
     * @return     The grant count.
     */
    public int getGrantCount() {
        return grantCount;
    }
}