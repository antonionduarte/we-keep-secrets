package documents;

import clearance.*;
import users.*;

public class ClassifiedDocumentClass extends AbstractDocument implements ClassifiedDocument {

    /**
     * User collection that stores the users that have permission to access a specific document
     * out of their default permission range.
     */
    UserCollection grants = new UserCollectionClass();
    
    /**
     * Constructor of the Classified Documents.
     * @param ID that identifies the document.
     * @param description or content that the document has.
     * @param manager is the user that created the document.
     */
    public ClassifiedDocumentClass(String ID, String description, User manager, Clearance clearance) {
        super(ID, description, manager, clearance);
    }

    @Override
    public void grant(User user) {
        grants.addUser(user);
    }

    public boolean hasGrant(User user) {
        return searchIndexOfGrant(user);
    }

    private int searchIndexOfGrant(String userID) {
        int pos = -1;
        for (int i=0 ; i<userCounter&&pos==-1 ; i++) {
            if (grants[i].getID().equals(userID))
                pos = i;
        }
        return pos;
    }
    
}
