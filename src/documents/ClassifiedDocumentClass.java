package documents;

import clearance.*;
import users.*;

public class ClassifiedDocumentClass extends AbstractDocument implements ClassifiedDocument {
    
    /**
     * Constructor of the Classified Documents.
     * @param ID that identifies the document.
     * @param description or content that the document has.
     * @param manager is the user that created the document.
     */
    public ClassifiedDocumentClass(String ID, String description, User manager, Clearance clearance) {
        super(ID, description, manager, clearance);
    }

    // TODO: Refactor how grant system works.

    // @Override
    // public void grant(String userKind, String userID, Clearance clearance) {
    //     grants.addUser(userKind, userID, clearance);
    // }

    // @Override
    // public void revoke(User user) {
    //     grants.removeUser(user);
    // }

    // @Override
    // public boolean hasGrant(User user) {
    //     return grants.hasUser(user.getID());
    // }
    
}
