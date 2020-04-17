package documents;

import clearance.*;
import users.*;
import actions.*;

public class ClassifiedDocumentClass extends AbstractDocument implements ClassifiedDocument {
    
    // Variables

    /**
     * ActionCollection that stores the grants and revokes.
     */
    private ActionCollection grantsRevokes;

    /**
     * Constructor of the Classified Documents.
     * @param ID that identifies the document.
     * @param description or content that the document has.
     * @param manager is the user that created the document.
     */
    public ClassifiedDocumentClass(String ID, String description, User manager, Clearance clearance) {
        super(ID, description, manager, clearance);
        grantsRevokes = new ActionCollectionClass(this);
    }

    @Override
    public void grant(User relatedUser) {
        grantsRevokes.addAction(relatedUser, Actions.GRANT);
    }

    @Override
    public void revoke(User relatedUser) {
        grantsRevokes.addAction(relatedUser, Actions.REVOKE);
    }
}
